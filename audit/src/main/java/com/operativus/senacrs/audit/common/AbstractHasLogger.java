package com.operativus.senacrs.audit.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractHasLogger
		implements HasLogger {

	private final Logger logger = LogManager.getLogger(this.getClass());

	protected AbstractHasLogger() {

		super();
	}
	
	@Override
	public Logger getLogger() {

		return this.logger;
	}
}
