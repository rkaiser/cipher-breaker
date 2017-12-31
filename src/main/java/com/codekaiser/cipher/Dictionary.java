package com.codekaiser.cipher;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Dictionary {
	
	List<Word> allWords;

	public List<Word> getAllWords() {
		return allWords;
	}

	public void setAllWords(List<Word> allWords) {
		this.allWords = allWords;
	}
	
	

}
