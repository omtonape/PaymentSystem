package com.ingenico.payment.domain;

public class RestErrorInfo {
	public final String detail;
	public final String message;
	
	public RestErrorInfo(final Exception ex, final String detail) {
		this.detail = ex.getLocalizedMessage();
		this.message = detail;
	}
}
