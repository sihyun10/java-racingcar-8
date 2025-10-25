package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.ErrorMessage;
import racingcar.exception.InvalidInputException;

class InputValidatorTest {

    @Nested
    @DisplayName("사용자의 입력값 검증")
    class InputValidationTest {

        @ParameterizedTest
        @ValueSource(strings = {"", "  ", "\t"})
        @DisplayName("입력값이 비어있거나 공백만 있는 경우 예외 발생")
        void 입력값_비어있음_예외_발생(String input) {
            assertThatThrownBy(() -> InputValidator.validate(input))
                    .isInstanceOf(InvalidInputException.class)
                    .hasMessage(ErrorMessage.EMPTY_INPUT.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"pobi.k", "123", "!!", "car🚗", "@"})
        @DisplayName("허용되지 않은 문자가 포함된 경우 예외 발생")
        void 허용되지_않은_문자_포함_예외_발생(String input) {
            assertThatThrownBy(() -> InputValidator.validate(input))
                    .isInstanceOf(InvalidInputException.class)
                    .hasMessage(ErrorMessage.INVALID_CHARACTER.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {",,,", ", , ,", " , , "})
        @DisplayName("빈 항목만 남아서 유효한 이름이 없는 경우 예외 발생")
        void 빈_항목만_남음_예외_발생(String input) {
            assertThatThrownBy(() -> InputValidator.validate(input))
                    .isInstanceOf(InvalidInputException.class)
                    .hasMessage(ErrorMessage.NO_VALID_NAMES.getMessage());
        }

        @Test
        @DisplayName("쉼표 사이 빈 항목이 있는 경우 정제 후 유효한 이름 반환")
        void 빈_항목_제거_후_정제_성공() {
            String input = "pobi,, woni , , jun";
            String sanitized = InputValidator.validate(input);

            assertThat(sanitized).isEqualTo("pobi,woni,jun");
        }

        @Test
        @DisplayName("공백 포함 이름은 공백 제거 후 반환")
        void 공백_제거_후_정제_성공() {
            String input = "  pobi , woni ";
            String sanitized = InputValidator.validate(input);

            assertThat(sanitized).isEqualTo("pobi,woni");
        }
    }
}
