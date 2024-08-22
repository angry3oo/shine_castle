package com.shine.castle.config;

import java.util.HashMap;

@SuppressWarnings({ "rawtypes", "serial" })
public class CamelMap extends HashMap {
	
	
	@SuppressWarnings("unchecked")
	public Object put(Object key, Object value) {
		return super.put(this.camelCase(key), value);
	}
	
	/**
	 * Camel Case 치환
	 * 
	 * @param key
	 * @return
	 */
	public String camelCase(Object key) {
		String str = (String) key;
		if(str.indexOf('_') < 0 && Character.isLowerCase(str.charAt(0))) {
			return str;
		}else {
			StringBuilder result = new StringBuilder();
			boolean nextUpper = false;
			int len = str.length();
			char currentChar;
			for(int i = 0; i < len; i++) {
				currentChar = str.charAt(i);
				if(currentChar == '_') {
					nextUpper = true;
				} else {
					if(nextUpper) {
						result.append(Character.toUpperCase(currentChar));
						nextUpper = false;
					}else {
						result.append(Character.toLowerCase(currentChar));
					}
				}
			}
			return result.toString();
		}
	}
}
