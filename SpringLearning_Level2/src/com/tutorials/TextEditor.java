package com.tutorials;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {
    private SpellChecker spellChecker;

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}
@Autowired
	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}
	
	public void spellChecking(){
		spellChecker.checkingSpells();
	}
	
}
