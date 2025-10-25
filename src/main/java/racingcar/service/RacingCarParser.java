package racingcar.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarParser {

    private static final String COMMA = ",";

    public static List<String> parseNames(String input) {
        return Arrays.stream(input.split(COMMA))
                .map(String::strip)
                .collect(Collectors.toList());
    }
}
