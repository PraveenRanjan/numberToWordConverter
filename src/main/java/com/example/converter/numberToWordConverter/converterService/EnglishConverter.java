package com.example.converter.numberToWordConverter.converterService;

import java.text.DecimalFormat;

import org.springframework.stereotype.Service;

@Service
public class EnglishConverter implements Converter {

	private static final String[] tensNames = { "", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy",
			"eighty", "ninety" };

	private static final String[] numNames = { "", "one", "two", "three", "four", "five", "six", "seven", "eight",
			"nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"nineteen" };

	/**
	 * This method convert numbers bigger number to tens and hundreds.
	 * 
	 * @param number
	 * @return String - number in words
	 */
	private String convertToLessThanThousand(int number) {
		String inWord = "";

		if (number % 100 < 20) {
			inWord = numNames[number % 100];
			number /= 100;
		} else {
			inWord = numNames[number % 10];
			number /= 10;

			inWord = tensNames[number % 10] + " " + inWord;
			number /= 10;
		}
		if (number == 0) {
			return inWord;
		}
		return numNames[number] + " hundred and " + inWord;
	}


	/**
	 * This method takes number and converts into words
	 * 
	 * @param input - input number
	 * @return String - Number in word
	 * 
	 */
	public String convertToWord(long input) {

		if (input == 0) {
			return "zero";
		}

		String snumber = Long.toString(input);

		// pad with "0"
		String mask = "000000000000";
		DecimalFormat df = new DecimalFormat(mask);
		snumber = df.format(input);

		// XXXnnnnnnnnn
		int billions = Integer.parseInt(snumber.substring(0, 3));
		// nnnXXXnnnnnn
		int millions = Integer.parseInt(snumber.substring(3, 6));
		// nnnnnnXXXnnn
		int hundredThousands = Integer.parseInt(snumber.substring(6, 9));
		// nnnnnnnnnXXX
		int thousands = Integer.parseInt(snumber.substring(9, 12));

		String tradBillions;
		switch (billions) {
		case 0:
			tradBillions = "";
			break;
		default:
			tradBillions = convertToLessThanThousand(billions) + " billion ";
		}
		String result = tradBillions;

		String tradMillions;
		switch (millions) {
		case 0:
			tradMillions = "";
			break;
		default:
			tradMillions = convertToLessThanThousand(millions) + " million ";
		}
		result = result + tradMillions;

		String tradHundredThousands;
		switch (hundredThousands) {
		case 0:
			tradHundredThousands = "";
			break;
		case 1:
			tradHundredThousands = "one thousand ";
			break;
		default:
			tradHundredThousands = convertToLessThanThousand(hundredThousands) + " thousand ";
		}
		result = result + tradHundredThousands;

		String tradThousand;
		tradThousand = convertToLessThanThousand(thousands);
		result = result + tradThousand;

		return result;
	}

}
