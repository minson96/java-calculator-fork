package study;

public class StudyStringCharAt {
	public int charLocation(String string, char c) {
		int length = string.length();
		for (int i = 0; i< length; i++) {
			if (string.charAt(i) == c) {
				return i + 1;
			}
		}
		throw new IndexOutOfBoundsException("String index out of range");
	}
}
