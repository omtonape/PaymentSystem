package com.ingenico.payment.service;

import java.util.List;

import com.ingenico.payment.domain.Account;
import com.ingenico.payment.domain.dto.AccountDTO;
import com.ingenico.payment.domain.dto.TransfterInfoDTO;
import com.ingenico.payment.exception.DataFormatException;

/** Interface for providing CRUD operations on AccountService
 * @author Mahendra
 *
 */
public interface IAccountService {

	/**Creates new Account from input information
	 * @param account
	 * @return
	 */
	Account createAccount(AccountDTO account);

	/** returns list of all accounts present in system
	 * @return
	 */
	List<AccountDTO> getAllAccounts();

	/**Transfer amount from source account to destination account
	 * if balance is not enough it throws runtimeException DataFormatException
	 * @param transferInfo
	 * @throws DataFormatException
	 */
	void transferAmount(TransfterInfoDTO transferInfo) throws DataFormatException;

}
