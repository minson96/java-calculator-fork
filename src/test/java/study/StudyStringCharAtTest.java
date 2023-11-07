package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StudyStringCharAtTest {
	@Test
	@DisplayName("문제 발생 문제 발생")
	void test1() throws IndexOutOfBoundsException{
		StudyStringCharAt studyStringCharAt = new StudyStringCharAt();
		String string = "abc";

		assertThatThrownBy(() -> string.charAt(string.length()))
			.isInstanceOf(IndexOutOfBoundsException.class)
			.hasMessageContaining("String index out of range")
			.hasMessageContaining(String.valueOf(string.length()));
	}
}
