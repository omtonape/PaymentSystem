package com.ingenico.payment.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ingenico.payment.dao.jpa.AccountRepository;
import com.ingenico.payment.domain.Account;
import com.ingenico.payment.domain.dto.AccountDTO;
import com.ingenico.payment.domain.dto.TransfterInfoDTO;
import com.ingenico.payment.exception.DataFormatException;
import com.ingenico.payment.service.validator.IBusinessValidator;

/**
 * @author Mahendra
 * AccountService access Database and provide CRUD operations
 * on account table depends upon BusinessValidators for 
 * business validations
 *
 */
@Service
public class AccountService implements IAccountService{
	private static final Logger log = LoggerFactory.getLogger(AccountService.class);
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired 
	private IBusinessValidator businessValidator;
	
	public AccountService() {
	}
	
	@Override
	public Account createAccount(AccountDTO accountDTO) {
		log.info("Saving account : {} to database.", accountDTO);
		Account account = new Account();
		BeanUtils.copyProperties(accountDTO,account);
		return accountRepository.save(account);
	}

	@Override
	public List<AccountDTO> getAllAccounts() {
		log.info("Fetching all accounts from database ");
		Iterable<Account> accounts = accountRepository.findAll();
		List<AccountDTO> accountDTOs = new ArrayList<AccountDTO>();
		for(Account account : accounts) {
			accountDTOs.add(new AccountDTO(account.getName(), account.getBalance()));
		}
		log.info("All accounts present in database are : {} ",accounts);
		return accountDTOs;
	}

	@Override
	public void transferAmount(TransfterInfoDTO transferInfo) throws DataFormatException {
		Account sourceAccount = accountRepository.findByname(transferInfo.getSrcName());
		log.debug("Souce Account is : {} ", sourceAccount);
		double sourceBalance = sourceAccount.getBalance();
		double transferBalance = transferInfo.getAmount();
		if(businessValidator.hasEnoughBalance(sourceBalance, transferBalance)) {
			Account destAccount  = accountRepository.findByname(transferInfo.getDestName());
			accountRepository.delete(sourceAccount.getId());
			accountRepository.delete(destAccount.getId());
			destAccount.setBalance(destAccount.getBalance() + transferBalance);
			sourceAccount.setBalance(sourceBalance - transferBalance);
			accountRepository.save(sourceAccount);
			accountRepository.save(destAccount);
			log.info("Successfully Transfered balance from account : {} to account : {} ", 
					sourceAccount, destAccount);
		}else {
			throw new DataFormatException("Insufficient Balance can't perform transaction");
		}
	}
}
