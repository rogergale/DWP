package com.dwp.gis.search.service.exceptions;

/**
 * 
 * Technical Failure Exception
 * 
 * @author Roger.Gale
 * 
 **/
public class TechnicalFailureException extends Exception {
	private static final long serialVersionUID = 1L;

	public TechnicalFailureException() {
		super();
	}

	public TechnicalFailureException(final String arg0, final Throwable arg1, final boolean arg2, final boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public TechnicalFailureException(final String arg0, final Throwable arg1) {
		super(arg0, arg1);
	}

	public TechnicalFailureException(final String arg0) {
		super(arg0);
	}

	public TechnicalFailureException(final Throwable arg0) {
		super(arg0);
	}	
}
