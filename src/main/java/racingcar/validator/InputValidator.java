package racingcar.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.exception.ErrorMessage;
import racingcar.exception.InvalidInputException;

public class InputValidator {

    private static final String VALID_INPUT_PATTERN = "^[가-힣a-zA-Z, \\s]+$";
    private static final String DELIMITER = ",";

    private final String input;

    public InputValidator(String input) {
        this.input = input;
    }

    public String validate() {
        validateOriginalNotEmpty();
        validateAllowedCharacters();

        String sanitized = sanitizeNames();
        validateHasAnyName(sanitized);

        return sanitized;
    }

    private void validateOriginalNotEmpty() {
        if (input == null || input.trim().isEmpty()) {
            throw new InvalidInputException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    private void validateAllowedCharacters() {
        if (!input.matches(VALID_INPUT_PATTERN)) {
            throw new InvalidInputException(ErrorMessage.INVALID_CHARACTER.getMessage());
        }
    }

    private String sanitizeNames() {
        List<String> names = Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .filter(name -> !name.isEmpty())
                .collect(Collectors.toList());

        return String.join(DELIMITER, names);
    }

    private void validateHasAnyName(String sanitized) {
        if (sanitized.isEmpty()) {
            throw new InvalidInputException(ErrorMessage.NO_VALID_NAMES.getMessage());
        }
    }
}
