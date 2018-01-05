package com.codekaiser.cipher;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CipherSentence {

	List<String> original;
	
	List<String> substitution;
	
	Map<String,String> alphabet;
	
	
	public List<String> getOriginal() {
		return original;
	}
	public void setOriginal(List<String> original) {
		this.original = original;
	}
	public List<String> getSubstitution() {
		return substitution;
	}
	public void setSubstitution(List<String> substitution) {
		this.substitution = substitution;
	}
	public Map<String, String> getAlphabet() {
		return alphabet;
	}
	public void setAlphabet(Map<String, String> alphabet) {
		this.alphabet = alphabet;
	}
	
}
