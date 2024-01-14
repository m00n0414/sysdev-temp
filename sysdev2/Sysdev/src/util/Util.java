package util;

public class Util {

	//ユーザIDのチェック
	public static boolean validateId(String param) {
		if (validateRequired(param) && validateNumeric(param)) {
			return true;
		} else {
			return false;
		}

	}

	//パスワードのチェック
	public static boolean validatePassword(String param) {
		if (validateRequired(param)) {
			return true;
		} else {
			return false;
		}
	}

	//必須チェック
	private static boolean validateRequired(String param) {
		if (param == null || param.length() == 0) {
			return false;
		} else {
			return true;
		}
	}

	//数値チェック
	private static boolean validateNumeric(String param) {
		if (param.matches("[0-9].*")) {
			return true;
		} else {
			return false;
		}
	}

	//文字数チェック
	private static boolean validateLength(String text, int length) {
		if (text.length() <= length) {
			return true;

		} else {
			return false;
		}
	}

}