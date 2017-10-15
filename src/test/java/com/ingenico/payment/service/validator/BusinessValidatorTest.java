package com.ingenico.payment.service.validator;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RunWith(MockitoJUnitRunner.class)
public class BusinessValidatorTest {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@InjectMocks
	private BusinessValidator validator;
	
	@Test
	public void testHasEnoughBalanceMethod() {
		log.info("Test for enough balance  ");//
		Assert.assertTrue("Balance should be transfered successfully", validator.hasEnoughBalance(2000, 1000));
	}
	
	@Test
	public void testHasEnoughBalanceMethod_False() {
		log.info("Test for unefficient  balance ");//
		Assert.assertTrue("Balance should be transfered successfully", !validator.hasEnoughBalance(2000, 2001));
	}
	
	@Test
	public void testHasEnoughBalanceMethod_Zero() {
		log.info("Test for unefficient  balance ");//
		Assert.assertTrue("Balance should be transfered successfully", validator.hasEnoughBalance(2000, 2000));
	}


}
