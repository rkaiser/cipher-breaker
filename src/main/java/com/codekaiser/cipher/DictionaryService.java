package com.codekaiser.cipher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService {
	
@Autowired
Dictionary dictionary;
	
	
public String provideWord() {
	
	Random random = new Random();
	random.nextInt(dictionary.allWords.size());
	return dictionary.allWords.get(random.nextInt(dictionary.allWords.size()) - 1).getLetters().toString();
}
	
	public void readFile() {
		InputStream is = getClass().getClassLoader()
	            .getResourceAsStream("book.txt");

	BufferedReader br = new BufferedReader(new InputStreamReader(is));
	String inputLine;
	dictionary.setAllWords(new ArrayList<Word>());
	
	int i=0;
	try {
		while((inputLine = br.readLine()) != null) {
			String[] wordsInLine = inputLine.split("\\W+");
			Arrays.asList(wordsInLine).forEach(w->dictionary.allWords.add(Word.of(w)));
		   i++;
			if(i%1000 ==0) {
				System.out.println("word count:" + i);
			}
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
		
	}
}
