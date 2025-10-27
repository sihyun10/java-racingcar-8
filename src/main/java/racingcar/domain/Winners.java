package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private static final String NAME_DELIMITER = ", ";
    private final List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = winners;
    }

    public String formatNames() {
        return String.join(NAME_DELIMITER, getWinnerNames());
    }

    private List<String> getWinnerNames() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
