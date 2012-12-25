package com.operativus.senacrs.audit.extractors;

import com.operativus.senacrs.audit.model.Form;


public interface DataExtractor {
	
	Form extract(DataInput source);
}
