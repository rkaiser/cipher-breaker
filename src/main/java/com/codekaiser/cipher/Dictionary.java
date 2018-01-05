package com.codekaiser.cipher;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class Dictionary {

	List<Word> allWords = new ArrayList<>();

	public void addWord(Word word) {

		Optional<Word> optWord;

		word.setNumberLetters(word.getLetters().length());
		if (!allWords.isEmpty()) {

			optWord = allWords.stream().filter(w -> w.equals(word)).findFirst();
			if (optWord.isPresent()) {
				optWord.get().setUses(optWord.get().getUses() + 1);
			}
			else {
				
				allWords.add(word);
			}
		} else {
			allWords.add(word);
		}
	}

	public List<Word> getAllWords() {
		return allWords;
	}

	public void setAllWords(List<Word> allWords) {
		this.allWords = allWords;
	}
	
	public boolean wordExist(String wordToFind) {
		
		return allWords.stream().anyMatch(w -> w.getLetters().equals(wordToFind));
	}

}
