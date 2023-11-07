package study;

public class StringParser {
	public String[] parseString(String input) {
		if (input == null || input.isEmpty()) {
			return new String[0];
		}

		return input.substring(1, input.length() - 1).split(",");
	}
}
