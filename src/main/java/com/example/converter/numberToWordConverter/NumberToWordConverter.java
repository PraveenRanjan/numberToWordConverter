package com.example.converter.numberToWordConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.converter.numberToWordConverter.converterService.Converter;

/**
 * This class converts number into words
 * @author Praveen R
 *
 */

@Component
public class NumberToWordConverter {

	@Autowired
	private Converter englishConverter;

	/**
	 * This method converts number into words.
	 * @param input
	 * @return String - number in word
	 */
	public String convertNumberToWord(long input) {
		String output = "";
	
		if(input > 0 && input < 99999999) {
		
		output = englishConverter.convertToWord(input);
		return output;
		}else {
			return "Invalid input";
		}
		

	}

}
