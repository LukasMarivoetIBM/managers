/*
 * Licensed Materials - Property of IBM
 * 
 * (c) Copyright IBM Corp. 2020.
 */
package dev.galasa.kubernetes;

import dev.galasa.ManagerException;

public class KubernetesManagerException extends ManagerException {
	private static final long serialVersionUID = 1L;

	public KubernetesManagerException() {
	}

	public KubernetesManagerException(String message) {
		super(message);
	}

	public KubernetesManagerException(Throwable cause) {
		super(cause);
	}

	public KubernetesManagerException(String message, Throwable cause) {
		super(message, cause);
	}

	public KubernetesManagerException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}