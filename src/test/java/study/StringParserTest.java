package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class StringParserTest {
	@Test
	public void testParseString() {
		StringParser parser = new StringParser();
		String input = "(1,2)";

		String[] result = parser.parseString(input);

		assertThat(result).contains("1", "2");
	}
}
