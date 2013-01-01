package com.operativus.senacrs.audit.properties.xpath;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.operativus.senacrs.audit.exceptions.RuntimeExceptionFactory;
import com.operativus.senacrs.audit.properties.PropertyKey;
import com.operativus.senacrs.audit.properties.ResourceCentral;

public final class XPathCentral {

	private static final ResourceCentral central = new ResourceCentral();
	private static final String[] LIST_FILES = new String[] {
			"xpath.properties",
	};

	private static class ModifiablePropertyKey
			implements PropertyKey {

		public String key = null;

		@Override
		public String getKey() {

			return this.key;
		}

	}

	static {
		central.populateCentral(LIST_FILES);
	}

	public static void addXPathFile(final String filename) throws IOException {

		central.populateCentral(filename);
	}

	public static String getXPath(final PropertyKey key, final Object... arguments) {

		return central.getMessage(key, arguments);
	}

	public static String[] getXPathByPrefix(final XPathKeyPrefix prefix) {

		String[] result = null;
		List<String> keyList = null;

		if ((prefix == null) || (prefix.getKeyPrefix() == null)) {
			throw RuntimeExceptionFactory.getInstance().getNullArgumentException("prefix");
		}
		keyList = getAllKeysWithPrefix(prefix.getKeyPrefix().trim());
		result = getValuesForKeys(keyList);

		return result;
	}

	private static List<String> getAllKeysWithPrefix(final String prefix) {

		List<String> result = null;
		List<String> keys = null;

		keys = central.getAvailableKeys();
		result = new LinkedList<String>();
		for (String k : keys) {
			if (k.startsWith(prefix)) {
				result.add(k);
			}
		}

		return result;
	}

	private static String[] getValuesForKeys(final List<String> keyList) {

		String[] result = null;
		int ndx = 0;
		ModifiablePropertyKey key = null;

		key = new ModifiablePropertyKey();
		result = new String[keyList.size()];
		for (String k : keyList) {
			key.key = k;
			result[ndx++] = central.getMessage(key);
		}

		return result;
	}

	public static boolean hasKey(final PropertyKey key) {

		return central.hasKey(key);
	}

	private XPathCentral() {

		super();
	}
}
