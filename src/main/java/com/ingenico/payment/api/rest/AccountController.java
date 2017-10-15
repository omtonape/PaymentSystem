package com.ingenico.payment.api.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.ingenico.payment.domain.Account;
import com.ingenico.payment.domain.dto.AccountDTO;
import com.ingenico.payment.domain.dto.TransfterInfoDTO;
import com.ingenico.payment.service.IAccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value ="/ingenico/v1/account")
@Api(tags = {"accounts"})
public class AccountController extends AbstractRestHandler{

	
	@Autowired
	private IAccountService accountService;
	
	@RequestMapping(value="", method = RequestMethod.POST,
			consumes= {"application/json", "application/xml"},
			produces = {"application/json", "application/xml"})
	@ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a Account.", notes = "Returns account id "
    		+ " in account header")
	public void createAccount(@RequestBody AccountDTO account, HttpServletRequest request,
			HttpServletResponse response) {
		log.info("Rest request to create account : {} ", account);
		Account savedAccount = accountService.createAccount(account);
		//response.setHeader("AccountID ", Long.valueOf(savedAccount.getId()).toString());
	}
	@RequestMapping(value = "/transferAmount",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Transfer amount", 
    notes = "If unsufficient balance is there in source account then exception will be thrown, "
    		+ "if successfull message will be returned in transferStatus Header")
	public void transferBalance(@RequestBody TransfterInfoDTO transferInfo, HttpServletRequest request,
			HttpServletResponse response) {
		log.info("Rest request to transfer balance within accounts : {} ", transferInfo);
		accountService.transferAmount(transferInfo);
		response.setHeader("transferStatus", "Successfully transferred amount : "+transferInfo.getAmount()+
				" from account : "+transferInfo.getSrcName()+" to account : "
				+transferInfo.getDestName());
	}
	
	@RequestMapping(value="", method = RequestMethod.GET,
			produces = {"application/json", "application/xml"})
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Get list of all accounts present in database")
	public @ResponseBody List<AccountDTO> getAccounts(HttpServletRequest request,
			HttpServletResponse response){
		log.info("Rest request to get all accounts.");
		return accountService.getAllAccounts();
	}
	
	
}
