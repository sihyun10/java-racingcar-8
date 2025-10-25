package racingcar.validator;

import java.util.Arrays;
import java.util.stream.Collectors;
import racingcar.exception.ErrorMessage;
import racingcar.exception.InvalidInputException;

public class InputValidator {

    private static final String VALID_INPUT_PATTERN = "^[가-힣a-zA-Z, \\s]+$";
    private static final String DELIMITER = ",";

    private InputValidator() {
    }

    public static String validate(String input) {
        validateOriginalNotEmpty(input);
        validateAllowedCharacters(input);

        String sanitized = removeEmptyNames(input);
        validateHasAnyName(sanitized);

        return sanitized;
    }

    private static void validateOriginalNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new InvalidInputException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    private static void validateAllowedCharacters(String input) {
        if (!input.matches(VALID_INPUT_PATTERN)) {
            throw new InvalidInputException(ErrorMessage.INVALID_CHARACTER.getMessage());
        }
    }

    private static String removeEmptyNames(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .filter(name -> !name.isEmpty())
                .collect(Collectors.joining(DELIMITER));
    }

    private static void validateHasAnyName(String sanitized) {
        if (sanitized.trim().isEmpty()) {
            throw new InvalidInputException(ErrorMessage.NO_VALID_NAMES.getMessage());
        }
    }
}
