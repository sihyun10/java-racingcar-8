package racingcar.exception;

public enum ErrorMessage {

    TOO_FEW_CARS("[ERROR] 경주에 참여할 자동차는 최소 2대 이상이어야 합니다."),
    TOO_MANY_CARS("[ERROR] 최대 10대까지만 출전 가능합니다."),
    INVALID_NAME_LENGTH("[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능합니다."),
    INVALID_CHARACTER("[ERROR] 자동차 이름은 한글 또는 영문만 입력 가능합니다."),
    DUPLICATE_NAMES("[ERROR] 자동차 이름이 중복되었습니다."),

    INVALID_NUMBER("[ERROR] 시도 횟수는 숫자여야 합니다."),
    ZERO_NUMBER("[ERROR] 시도 횟수는 1회 이상이어야 합니다."),
    EXCEED_MAX_COUNT("[ERROR] 최대 20회까지만 시도할 수 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
