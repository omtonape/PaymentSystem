package com.ingenico.payment.service.validator;

/**
 * @author Mahendra
 *This interface will have all business validations
 *
 */
public interface IBusinessValidator {

	/**
	 * @param currentBalance
	 * @param amountToTransfer
	 * @return
	 * Returns true if balance is greater than 0 else false.
	 */
	public boolean hasEnoughBalance(double currentBalance, double amountToTransfer);
}
