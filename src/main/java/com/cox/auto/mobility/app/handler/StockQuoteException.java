package com.cox.auto.mobility.app.handler;

import lombok.Builder;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Builder
public class StockQuoteException extends RuntimeException {

	private static final long serialVersionUID = -1798018706017183341L;

	public StockQuoteException() {
		super();
	}

	public StockQuoteException(final String message) {
		super(message);
	}

	public StockQuoteException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public StockQuoteException(final String message, final Throwable cause, final boolean enableSuppression,
			final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public StockQuoteException(final Throwable cause) {
		super(cause);
	}

}
