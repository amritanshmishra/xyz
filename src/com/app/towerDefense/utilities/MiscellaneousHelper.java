package com.app.towerDefense.utilities;

import org.apache.commons.codec.binary.Base64;

public class MiscellaneousHelper {

	public String RemoveCharacterFromStrartorLeft(String InputString,
			String Characters) {
		return InputString.replaceAll("^\\" + Characters + "+", "");
	}

	public String RemoveCharacterFromEndorRight(String InputString,
			String Characters) {
		return InputString.replaceAll("\\" + Characters + "+$", "");
	}

	public String RemoveCharacterFromBothEnd(String InputString,
			String Characters) {
		return InputString.replaceAll("^\\" + Characters + "+|\\" + Characters
				+ "+$", "");
	}
	
	public String EncodeBase64(String input) {
		byte[] bytesEncoded = Base64.encodeBase64(input.getBytes());
		return new String(bytesEncoded);

	}

	public String DecodeBase64(String input) {
		// Decrypt data on other side, by processing encoded data
		byte[] valueDecoded = Base64.decodeBase64(input.getBytes());
		return new String(valueDecoded);

	}
}
