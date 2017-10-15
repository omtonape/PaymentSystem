package com.ingenico.payment.api.rest;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.ingenico.payment.domain.RestErrorInfo;
import com.ingenico.payment.exception.DataFormatException;
import com.ingenico.payment.exception.ResourceNotFoundException;

/**
 * @author Mahendra
 * This class should be extended by All REST Controllers.
 * It contains exception mapping and other common REST API functionality.
 *
 */
public class AbstractRestHandler implements ApplicationEventPublisherAware {
	
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private ApplicationEventPublisher eventPublisher;
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(DataFormatException.class)
	public @ResponseBody RestErrorInfo handleDataStoreException(DataFormatException ex,
			WebRequest wb, HttpServletResponse response) {
		log.error("Converting exception occured during data storage to RestResponse : ",
				ex.getMessage());
		return new RestErrorInfo(ex, "Error!! occured while storingData");
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ResourceNotFoundException.class)
	public @ResponseBody RestErrorInfo handleResourceNotFoundException(ResourceNotFoundException ex,
			WebRequest wb,HttpServletResponse response){
		log.error("Exception occured while searching for account details : ", ex.getMessage());
		return new RestErrorInfo(ex, "Requested Resource not found.");
		
	}
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.eventPublisher = applicationEventPublisher;
	}

}
