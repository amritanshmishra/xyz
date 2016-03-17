package com.app.towerDefense.utilities;

import org.apache.commons.codec.binary.Base64;

/**
 * this class is a miscellaneous helper class. It contains some extra frequently
 * used Function which is mostly used indepentently
 * 
 * @author Sajjad Ashraf
 * 
 */
public class MiscellaneousHelper {

	/**
	 * 
	 * Retrun ture when string value is double
	 * 
	 * @param new_value
	 *            a String
	 * @return booleran
	 */
	public boolean isDouble(String new_value) {
		try {
			Double.parseDouble(new_value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * this method removes character from start to left
	 * 
	 * @param new_inputString
	 *            input string
	 * @param new_characters
	 *            characters to be removed
	 * @return string the result
	 */
	public String RemoveCharacterFromStrartorLeft(String new_inputString,
			String new_characters) {
		return new_inputString.replaceAll("^" + new_characters + "+", "");
		// return InputString.replaceAll("^0+(?!$)", "");
	}

	/**
	 * the method removes character from end or right
	 * 
	 * @param new_inputString
	 *            input string
	 * @param new_characters
	 *            characters to be removed
	 * @return string the result
	 */
	public String RemoveCharacterFromEndorRight(String new_inputString,
			String new_characters) {
		return new_inputString.replaceAll("\\" + new_characters + "+$", "");
	}

	/**
	 * this method removes character from both end
	 * 
	 * @param new_inputString
	 *            input string
	 * @param new_characters
	 *            characters to be removed
	 * @return string the result
	 */
	public String RemoveCharacterFromBothEnd(String new_inputString,
			String new_characters) {
		return new_inputString.replaceAll("^\\" + new_characters + "+|\\"
				+ new_characters + "+$", "");
	}

	/**
	 * this method encodes the input to base64
	 * 
	 * @param new_input
	 *            string
	 * @return returns encoded string
	 */
	public String EncodeBase64(String new_input) {
		byte[] bytesEncoded = Base64.encodeBase64(new_input.getBytes());
		return new String(bytesEncoded);

	}

	/**
	 * this method decodes the string from base64 encoding
	 * 
	 * @param new_input
	 *            string base64
	 * @return string the result
	 */
	public String DecodeBase64(String new_input) {
		// Decrypt data on other side, by processing encoded data
		byte[] valueDecoded = Base64.decodeBase64(new_input.getBytes());
		return new String(valueDecoded);

	}
}
