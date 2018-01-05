package com.codekaiser.cipher;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class WordTest {

	
	@Test
	public void testWordEquals() {
		Word originalWord = new Word();
		Word expectedWord = new Word();
		
		List<String> string1 = new ArrayList<>();
		string1.add("a");
		string1.add("b");
		string1.add("c");
		
		List<String> string2 = new ArrayList<>();
		string2.add("a");
		string2.add("b");
		string2.add("c");

		originalWord.setLetters("abc");
		expectedWord.setLetters("abc");
		
		assertThat(originalWord, equalTo(expectedWord));
	}
	
	@Test
	public void testAddingRedundantWords() {
		
		Dictionary dictionary = new Dictionary();
		
		List<String> string1 = new ArrayList<>();
		string1.add("a");
		string1.add("b");
		string1.add("c");
		
		List<String> string2 = new ArrayList<>();
		string2.add("a");
		string2.add("b");
		string2.add("c");
		
		List<String> string3 = new ArrayList<>();
		string3.add("a");
		string3.add("b");
		string3.add("c");
		string3.add("c");
		
		Word firstWord = new Word();
		firstWord.setLetters("abc");
		Word secondWord = new Word();
		secondWord.setLetters("abc");
		Word thirdWord = new Word();
		thirdWord.setLetters("abcc");
		
		dictionary.addWord(firstWord);
		dictionary.addWord(secondWord);
		dictionary.addWord(thirdWord);
		
		assertThat(2, equalTo(dictionary.allWords.size()));
		
		
	}
	
	@Test
	public void testFindWords() {
		Dictionary dictionary = new Dictionary();
		
			
		Word firstWord = new Word();
		firstWord.setLetters("abc");
		Word secondWord = new Word();
		secondWord.setLetters("abc");
		Word thirdWord = new Word();
		thirdWord.setLetters("abcc");
		
		dictionary.addWord(firstWord);
		dictionary.addWord(secondWord);
		dictionary.addWord(thirdWord);
		
		assertThat(dictionary.wordExist("abc"), equalTo(true));
		assertThat(dictionary.wordExist("nothere"), equalTo(false));
		
	}

}
