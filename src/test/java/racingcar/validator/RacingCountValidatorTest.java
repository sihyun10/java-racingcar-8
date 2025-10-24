package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.ErrorMessage;
import racingcar.exception.InvalidInputException;

class RacingCountValidatorTest {

    @Nested
    @DisplayName("정상 시도 횟수 검증")
    class ValidCountTest {

        @ParameterizedTest
        @ValueSource(strings = {"1", "5", "20"})
        @DisplayName("1에서 20 사이 입력일 경우 통과")
        void 횟수_1에서_20_사이_입력_통과(String input) {
            RacingCountValidator.validate(input);
        }
    }

    @Nested
    @DisplayName("시도 횟수 숫자 검증")
    class NumberValidationTest {

        @ParameterizedTest
        @ValueSource(strings = {"테스트", "a", "3.5", "!", "##", "-1", " "})
        @DisplayName("숫자가 아닌 입력일 경우 예외 발생")
        void 숫자가_아닌_입력_예외_발생(String input) {
            assertThatThrownBy(() -> RacingCountValidator.validate(input))
                    .isInstanceOf(InvalidInputException.class)
                    .hasMessage(ErrorMessage.INVALID_NUMBER.getMessage());
        }
    }

    @Test
    @DisplayName("시도 횟수가 0일 경우 예외 발생")
    void 시도_횟수_0_예외_발생() {
        String input = "0";

        assertThatThrownBy(() -> RacingCountValidator.validate(input))
                .isInstanceOf(InvalidInputException.class)
                .hasMessage(ErrorMessage.ZERO_NUMBER.getMessage());
    }

    @Test
    @DisplayName("시도 횟수 최대값 검증")
    void 최대_횟수_초과_예외_발생() {
        String input = "21";

        assertThatThrownBy(() -> RacingCountValidator.validate(input))
                .isInstanceOf(InvalidInputException.class)
                .hasMessage(ErrorMessage.EXCEED_MAX_COUNT.getMessage());
    }
}
