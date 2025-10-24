package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.exception.InvalidInputException;

public class RacingCarValidator {

    private static final int MIN_CARS = 2;
    private static final int MAX_CARS = 10;
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private static final String VALID_NAME_PATTERN = "^[가-힣a-zA-Z]+$";

    public static void validate(List<String> names) {
        validateEmpty(names);
        validateCarCount(names);
        validateNameRules(names);
        validateDuplicate(names);
    }

    private static void validateEmpty(List<String> names) {
        if (names.isEmpty()) {
            throw new InvalidInputException("[ERROR] 자동차 이름을 입력해야 합니다.");
        }
    }

    private static void validateCarCount(List<String> names) {
        if (names.size() < MIN_CARS) {
            throw new InvalidInputException("[ERROR] 경주에 참여할 자동차는 최소 2대 이상이어야 합니다.");
        }
        if (names.size() > MAX_CARS) {
            throw new InvalidInputException("[ERROR] 최대 10대까지만 출전 가능합니다.");
        }
    }

    private static void validateNameRules(List<String> names) {
        for (String name : names) {
            validateNameLength(name);
            validateCharacterSet(name);
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new InvalidInputException("[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }

    private static void validateCharacterSet(String name) {
        if (!name.matches(VALID_NAME_PATTERN)) {
            throw new InvalidInputException("[ERROR] 자동차 이름은 한글 또는 영문만 입력 가능합니다.");
        }
    }

    private static void validateDuplicate(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);
        if (uniqueNames.size() != names.size()) {
            throw new InvalidInputException("[ERROR] 자동차 이름이 중복되었습니다.");
        }
    }
}
