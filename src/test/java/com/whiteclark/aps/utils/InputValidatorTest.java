package com.whiteclark.aps.utils;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.whiteclark.aps.enums.Status;

/**
 * Tests InputValidator class
 */
public class InputValidatorTest {

	@Test
	public void testValidateWithNull() {
		Assert.assertEquals(InputValidator.validate(null),Status.FAILED);
	}

	@Test
	public void testValidateWithEmptyString() {
		Assert.assertEquals(InputValidator.validate(""),Status.FAILED);
	}
	
	@Test
	public void testValidateWithInvalidInput() {
		Assert.assertEquals(InputValidator.validate("jdhflusfh"),Status.FAILED);
	}
	
	@Test
	public void testValidateWithHalfLocation() {
		Assert.assertEquals(InputValidator.validate("3:LFR"),Status.FAILED);
	}
	
	@Test
	public void testValidateWithLocationButNoCommand() {
		Assert.assertEquals(InputValidator.validate("4,3:"),Status.FAILED);
	}
	
	@Test
	public void testValidateWithOnlyColon() {
		Assert.assertEquals(InputValidator.validate(":"),Status.FAILED);
	}

	@Test
	public void testValidateWithLocationAsAlphabets() {
		Assert.assertEquals(InputValidator.validate("x,y:LLFFRR"),Status.FAILED);
	}
	
	@Test
	public void testValidCommand() {
		Assert.assertEquals(InputValidator.validate("1,2:LLFFRR"),Status.SUCCESS);
	}
}
