package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

	@Test
	@DisplayName("잘못된 입력 타입 예외 테스트")
	void testInvalidInputTypeException() {
		String string = "abc,2,3"; // 잘못된 입력 타입
		assertThatThrownBy(() -> StringCalculator.main(new String[]{string}))
			.isInstanceOf(RuntimeException.class)
			.hasMessage("잘못된 타입입니다.");

		System.out.println("테스트 완료");
	}

	@Test
	@DisplayName("음수 입력 예외 테스트")
	void testNegativeNumberException() {
		String string = "1,-2,3"; // 음수 입력
		assertThatThrownBy(() -> StringCalculator.main(new String[]{string}))
			.isInstanceOf(RuntimeException.class)
			.hasMessage("음수 타입입니다.");

		System.out.println("테스트 완료");

	}

	@Test
	@DisplayName("커스텀 구분자 테스트")
	void testCustomDelimiter() {
		String string = "//;\n1;2;3"; // 커스텀 구분자 지정
		StringCalculator.main(new String[]{string});
		int result = StringCalculator.sum;
		assertThat(result).isEqualTo("6");

		System.out.println("테스트 완료");

	}

	@Test
	@DisplayName("기본 구분자 테스트")
	void testDefaultDelimiter() {
		String string = "1,2,3"; // 기본 구분자 사용
		StringCalculator.main(new String[]{string});
		int result = StringCalculator.sum;
		assertThat(result).isEqualTo(6);

		System.out.println("테스트 완료");
	}
}