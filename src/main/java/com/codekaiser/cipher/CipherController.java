package com.codekaiser.cipher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CipherController {
	
	@Autowired
	DictionaryService dictionaryService;
	
	@Autowired
	CipherService cipherService;
	
	@PostMapping("/read-file")
	public void postDictionary() {
		
		dictionaryService.readFile();
	}
	
	@GetMapping("/provide-word")
	public String getWord() {
	  
		return dictionaryService.provideRandomWord();
	}

	@GetMapping("/provide-word/{wordSize}")
	public String getWordBySize( @PathVariable("wordSize") int wordSize) {
	  
		return dictionaryService.provideWordBySize(wordSize);
	}

	@GetMapping("/word-exist/{word}")
	public boolean doesWordExist( @PathVariable("word") String word) {
	  
		return dictionaryService.doesWordExist(word);
	}

	@PostMapping(path="/load-cipher", consumes = "application/json")
	public void loadCipher(@RequestBody CipherSentence cipherSentence ) {
		
		cipherService.deCipher(cipherSentence);
	}

}
