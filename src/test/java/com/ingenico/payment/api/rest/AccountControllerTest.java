package com.ingenico.payment.api.rest;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ingenico.payment.PaymentSystemApplication;
import com.ingenico.payment.domain.dto.AccountDTO;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PaymentSystemApplication.class)
@ActiveProfiles("test")
public class AccountControllerTest {

	@InjectMocks
	private AccountController controller;

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void initTests() {
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
    public void shouldCreateRetrieve() throws Exception {
		AccountDTO acc = mockAccount("shouldCreateRetrieve");
		byte [] json = toJson(acc);
		
		//CREATE
		 mvc.perform(post("/ingenico/v1/account")
							.content(json)
							.contentType(MediaType.APPLICATION_JSON)
			                .accept(MediaType.APPLICATION_JSON))
			                .andExpect(status().isCreated())
			                .andReturn();
		// GET all Accounts
		mvc.perform(get("/ingenico/v1/account")).andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(1)));
	}

	private byte[] toJson(Object obj) throws JsonProcessingException {
		ObjectMapper map = new ObjectMapper();
        return map.writeValueAsString(obj).getBytes();
	}

	private AccountDTO mockAccount(String string) {
		return new AccountDTO("Mahendra", 7000);
	}



}
