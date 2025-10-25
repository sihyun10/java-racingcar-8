package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.ErrorMessage;
import racingcar.exception.InvalidInputException;

class RacingCarValidatorTest {

    @Nested
    @DisplayName("자동차 이름 입력 검증")
    class NameValidationTest {

        @ParameterizedTest
        @ValueSource(strings = {"", "      "})
        @DisplayName("빈 문자열일 경우 예외 발생")
        void 빈_문자열_예외_발생(String input) {
            List<String> names = List.of(input);

            assertThatThrownBy(() -> RacingCarValidator.validate(names))
                    .isInstanceOf(InvalidInputException.class)
                    .hasMessage(ErrorMessage.INVALID_NAME_LENGTH.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"p", "pobii"})
        @DisplayName("5자 이하일 경우 통과")
        void 이름_5자_이하_통과(String input) {
            List<String> names = List.of(input, "woni");
            RacingCarValidator.validate(names);
        }

        @Test
        @DisplayName("5자를 초과할 경우 예외 발생")
        void 이름_5자_초과_예외_발생() {
            List<String> names = List.of("pobi", "pobiwoni");

            assertThatThrownBy(() -> RacingCarValidator.validate(names))
                    .isInstanceOf(InvalidInputException.class)
                    .hasMessage(ErrorMessage.INVALID_NAME_LENGTH.getMessage());
        }

        @Test
        @DisplayName("중복된 이름이 존재할 경우 예외 발생")
        void 중복_이름_예외_발생() {
            List<String> names = List.of("pobi", "crong", "pobi");

            assertThatThrownBy(() -> RacingCarValidator.validate(names))
                    .isInstanceOf(InvalidInputException.class)
                    .hasMessage(ErrorMessage.DUPLICATE_NAMES.getMessage());
        }
    }

    @Nested
    @DisplayName("자동차 개수 검증")
    class CarCountValidationTest {

        @Test
        @DisplayName("자동차가 1대 이하일 경우 예외 발생")
        void 자동차_1대_이하_예외_발생() {
            List<String> names = List.of("pobi");

            assertThatThrownBy(() -> RacingCarValidator.validate(names))
                    .isInstanceOf(InvalidInputException.class)
                    .hasMessage(ErrorMessage.TOO_FEW_CARS.getMessage());
        }

        @Test
        @DisplayName("자동차 11대 이상일 경우 예외 발생")
        void 자동차_11대_이상_예외_발생() {
            List<String> names = List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k");

            assertThatThrownBy(() -> RacingCarValidator.validate(names))
                    .isInstanceOf(InvalidInputException.class)
                    .hasMessage(ErrorMessage.TOO_MANY_CARS.getMessage());
        }
    }
}
