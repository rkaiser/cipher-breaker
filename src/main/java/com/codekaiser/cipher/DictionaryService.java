package com.codekaiser.cipher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService {

	@Autowired
	Dictionary dictionary;

	
	public String provideRandomWord() {

		Random random = new Random();
		random.nextInt(dictionary.allWords.size());
		return dictionary.allWords.get(random.nextInt(dictionary.allWords.size()) - 1).getLetters().toString();
	}

	public String provideWordBySize(int wordSize) {

		Comparator<Word> wordByUse = (w1, w2) -> Integer.compare(w2.getUses(), w1.getUses());
		return dictionary.allWords.stream().filter(w -> w.getNumberLetters() == wordSize && !w.isAttempted()).sorted(wordByUse).findFirst()
				.get().getLetters().toString();

	}
	
	public boolean doesWordExist(String wordToFind) {
		
		return dictionary.wordExist(wordToFind);
	}

	public void readFile() {
		InputStream is = getClass().getClassLoader().getResourceAsStream("book.txt");

		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String inputLine;
		dictionary.setAllWords(new ArrayList<Word>());

		int i = 0;
		try {
			while ((inputLine = br.readLine()) != null) {

				String[] wordsInLine = inputLine.trim().replaceAll(" +", " ").toLowerCase().split("\\W+");
				Arrays.asList(wordsInLine).forEach(w -> dictionary.addWord(Word.of(w)));
				i++;
				if (i % 1000 == 0) {
					int numberOfWords = dictionary.getAllWords().size();
					System.out.println("word count:" + i);
					System.out.println("Word is :"+ dictionary.getAllWords().get(numberOfWords-1).getLetters().toString());
					System.out.println("Word size is :"+ dictionary.getAllWords().get(numberOfWords-1).getNumberLetters());
				}
			}
			System.out.println("Total Words:" + dictionary.allWords.size());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
