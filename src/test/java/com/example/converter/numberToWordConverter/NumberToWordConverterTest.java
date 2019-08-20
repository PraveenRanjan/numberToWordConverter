package com.example.converter.numberToWordConverter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.converter.numberToWordConverter.NumberToWordConverter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NumberToWordConverterTest {
	@Autowired
	private NumberToWordConverter NumberToWordConverter;

	@Test
	public void testConvertNumberToWordInput_4() {
		String output = NumberToWordConverter.convertNumberToWord(4);
		assertEquals("four", output);

	}
	
	@Test
	public void testConvertNumberToWordInput_10() {
		String output = NumberToWordConverter.convertNumberToWord(10);
		assertEquals("ten", output);

	}

	@Test
	public void testConvertNumberToWordInput_13() {
		String output = NumberToWordConverter.convertNumberToWord(13);
		assertEquals("thirteen", output);

	}
	
	@Test
	public void testConvertNumberToWordInput_113() {
		String output = NumberToWordConverter.convertNumberToWord(113);
		assertEquals("one hundred and thirteen", output);

	}

	@Test
	public void testConvertNumberToWordLargeInput() {
		String output = NumberToWordConverter.convertNumberToWord(56945781);
		assertEquals("fifty six million nine hundred and forty five thousand seven hundred and eighty one", output);

	}
	
	@Test
	public void testConvertNumberToWordInputInvalid() {
		String output = NumberToWordConverter.convertNumberToWord(-10);
		assertEquals("Invalid input", output);

	}

}
