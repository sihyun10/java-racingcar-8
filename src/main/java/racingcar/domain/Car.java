package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

public class Car {

    private static final int MOVE_DISTANCE = 1;
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
    }

    public void move(MoveStrategy strategy) {
        if (strategy.movable()) {
            distance += MOVE_DISTANCE;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
