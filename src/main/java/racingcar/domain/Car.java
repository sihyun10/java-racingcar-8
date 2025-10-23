package racingcar.domain;

public class Car {

    private static final int MOVE_CONDITION = 4;

    private final String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_CONDITION) {
            distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
