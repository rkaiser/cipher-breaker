package com.codekaiser.cipher;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CipherSentenceTest {

	@Test
	public void test() throws Exception{
		
		CipherSentence cipherSentence = new CipherSentence();
		
		cipherSentence.original = new ArrayList<String>();
		//SIAA ZQ LKBA. VA ZOA RFPBLUAOAR
		cipherSentence.original.add("SIAA");
		cipherSentence.original.add("ZQ");
		cipherSentence.original.add("LKBA");
		cipherSentence.original.add("VA");
		cipherSentence.original.add("ZOA");
		cipherSentence.original.add("RFPBLUAOAR");
		
		ObjectMapper objectMapper = new ObjectMapper();
		String cipherJson = objectMapper.writeValueAsString(cipherSentence);
		
		System.out.println(cipherJson);
	}

}
