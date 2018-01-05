package com.codekaiser.cipher;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CipherService {

	public void deCipher(CipherSentence cipherSentence) {
		

		//Make sure that all characters are in lower case.
		cipherSentence.setOriginal(cipherSentence.getOriginal().stream().map(w->w.toLowerCase()).collect(Collectors.toList()));
		
		Map<String,String> alphabet = new HashMap<>();
		
		String allWords = cipherSentence.getOriginal().stream().collect(Collectors.joining());

		//Creates a hashmap of all the letters in the sentence.
		alphabet = allWords.chars().mapToObj(c -> (char) c).collect(Collectors.toList()).stream()
				.collect(Collectors.toMap(c -> String.valueOf(c), c -> String.valueOf(c), (c1, c2) -> {
					return c1;
				}));

		cipherSentence.setAlphabet(alphabet);
		
		
	}
	
	
	public void substituteWord() {
		
	}
	
	public Map<String, String> produceNewAlphabet() {
		
		return null;
	}
	
	public void percentSuccess() {
		
		//Loop through each word
		
		//Does the word exist in dictionary?
		//If yes assume could be correct.
		
	}
	
}
