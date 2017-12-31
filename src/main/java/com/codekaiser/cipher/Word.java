package com.codekaiser.cipher;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Word {

	List<String> letters;
	
	int uses;
	
	boolean attempted;
	
	public List<String> getLetters() {
		return letters;
	}

	public void setLetters(List<String> letters) {
		this.letters = letters;
	}

	public int getUses() {
		return uses;
	}

	public void setUses(int uses) {
		this.uses = uses;
	}

	public boolean isAttempted() {
		return attempted;
	}

	public void setAttempted(boolean attempted) {
		this.attempted = attempted;
	}

	public static Word of(String wordString) {
		Word word = new Word();
		word.setLetters(Arrays.asList(wordString.toCharArray()).stream().map(c->String.valueOf(c)).collect(Collectors.toList()));
		return word;
	}
}
