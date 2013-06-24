package bootcamp.thoughtworks.roman.test;

import junit.framework.Assert;

import org.junit.Test;

import bootcamp.thoughtworks.roman.RomanNumeralString;

public class TestRomanNumerals {

	@Test
	public void testRomanNumeralInvalidNumerals(){
		RomanNumeralString romanNumeralString = new RomanNumeralString("Hello");
		Assert.assertEquals(0, romanNumeralString.parseIntegerValue());
	}

	@Test
	public void testRomanNumeralInvalidNumeralOrder(){
		RomanNumeralString romanNumeralString = new RomanNumeralString("CXIII");
		Assert.assertEquals(true, romanNumeralString.isValidNumerals());
	}

	@Test
	public void testRomanNumeralInvalidNumberOccurances(){
		RomanNumeralString romanNumeralString = new RomanNumeralString("IIII");
		Assert.assertEquals(false, romanNumeralString.isValidNumerals());
	}

	@Test
	public void testRomanNumeralValidNumeralString(){
		RomanNumeralString romanNumeralString = new RomanNumeralString("CXIII");
		Assert.assertEquals(113, romanNumeralString.parseIntegerValue());
	}
}