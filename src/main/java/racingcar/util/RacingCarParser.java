package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarParser {

    public static List<String> parseNames(String input) {
        return Arrays.stream(input.split(","))
                .map(String::strip)
                .collect(Collectors.toList());
    }
}
