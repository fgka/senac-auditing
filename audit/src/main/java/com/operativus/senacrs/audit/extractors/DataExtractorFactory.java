package com.operativus.senacrs.audit.extractors;

import java.io.File;
import java.net.URL;

public final class DataExtractorFactory {

	private static final DataExtractorFactory instance = new DataExtractorFactory();

	public static DataExtractorFactory getInstance() {

		return instance;
	}

	private DataExtractorFactory() {

		super();
	}

	public DataExtractor createExtractorForPropertiesFile(final File file) {

		DataExtractor result = null;

		// TODO

		return result;
	}

	public DataExtractor createExtractorForUrl(final URL url) {

		DataExtractor result = null;

		// TODO

		return result;
	}
}
