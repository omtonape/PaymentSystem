package com.ingenico.payment.dao.jpa;

import org.springframework.data.repository.CrudRepository;

import com.ingenico.payment.domain.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

	public Account findByname(String name);
}
