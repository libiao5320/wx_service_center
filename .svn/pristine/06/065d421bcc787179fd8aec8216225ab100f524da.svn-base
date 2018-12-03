package com.royao.util;

public class StringUtil {
	/**
	 * 判断是否是字母和数字的结合
	 * @Description
	 * @author jk
	 * @param str
	 * @return
	 * @return boolean
	 * @date   2016年2月19日
	 */
	public static boolean isAsciiOrDigit(String str) {
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (!isAscii(ch))
				return false;
		}
		return true;
	}

	/**
	 * 判断是否是数字
	 * @Description
	 * @author jk
	 * @param str
	 * @return
	 * @return boolean
	 * @date   2016年2月19日
	 */
	public static boolean isDigit(String str) {
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (!isDigit(ch))
				return false;
		}
		return true;
	}
	
	public static boolean isAscii(char ch) {
		return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')
				|| (ch >= '0' && ch <= '9');
	}
	
	public static boolean isDigit(char ch) {
		return (ch >= '0' && ch <= '9');
	}

}
