package com.ingenico.payment.service.validator;

import org.springframework.stereotype.Service;

/**
 * @author Mahendra
 * Implements business rules specified by contract IBusinessValidator.
 *
 */
@Service
public class BusinessValidator implements IBusinessValidator {

	@Override
	public boolean hasEnoughBalance(double currentBalance, double amountToTransfer) {
		return currentBalance - amountToTransfer >= 0;
	}

}
