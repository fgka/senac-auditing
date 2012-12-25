package com.operativus.senacrs.audit.extractors;

import java.io.File;
import java.net.URL;

public class DataExtractorFactory {

	private static final DataExtractorFactory instance = new DataExtractorFactory();

	private DataExtractorFactory() {

		super();
	}

	public DataExtractor createExtractorForPropertiesFile(File file) {

		DataExtractor result = null;

		// TODO

		return result;
	}

	public DataExtractor createExtractorForUrl(URL url) {

		DataExtractor result = null;

		// TODO

		return result;
	}

	public static DataExtractorFactory getInstance() {

		return instance;
	}
}
