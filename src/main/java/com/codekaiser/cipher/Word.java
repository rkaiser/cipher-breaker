package com.codekaiser.cipher;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Word {

//	List<String> letters;
	
	String letters;
	
	int uses;
	
	int numberLetters;
	
	boolean attempted;
	
//	public List<String> getLetters() {
//		return letters;
//	}
//
//	public void setLetters(List<String> letters) {
//		this.letters = letters;
//	}

	public String getLetters() {
	return letters;
}

public void setLetters(String letters) {
	this.letters = letters;
}

	public int getUses() {
		return uses;
	}

	public void setUses(int uses) {
		this.uses = uses;
	}

	public int getNumberLetters() {
		return numberLetters;
	}

	public void setNumberLetters(int numberLetters) {
		this.numberLetters = numberLetters;
	}

	public boolean isAttempted() {
		return attempted;
	}

	public void setAttempted(boolean attempted) {
		this.attempted = attempted;
	}

	public static Word of(String wordString) {
		Word word = new Word();
//		word.setLetters(Arrays.asList(wordString.toCharArray()).stream().map(c->String.valueOf(c)).collect(Collectors.toList()));
		word.setLetters(wordString);
		return word;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((letters == null) ? 0 : letters.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (letters == null) {
			if (other.letters != null)
				return false;
		} else if (!letters.equals(other.letters))
			return false;
		return true;
	}
	
	
}
