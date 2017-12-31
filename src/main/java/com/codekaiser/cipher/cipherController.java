package com.codekaiser.cipher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class cipherController {
	
	@Autowired
	DictionaryService dictionaryService;
	
	@PostMapping("/read-file")
	public void postDictionary() {
		
		dictionaryService.readFile();
	}
	
	@GetMapping("/provide-word")
	public String getWord() {
	  
		return dictionaryService.provideWord();
		
	
	}

}
