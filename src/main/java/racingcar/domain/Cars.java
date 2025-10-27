package racingcar.domain;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import racingcar.domain.strategy.MoveStrategy;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> names) {
        this.cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void raceOnce(MoveStrategy strategy) {
        cars.forEach(car -> car.move(strategy));
    }

    public Winners findWinners() {
        int maxDistance = findMaxDistance();
        return new Winners(findCarsAt(maxDistance));
    }

    private int findMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }

    private List<Car> findCarsAt(int distance) {
        return cars.stream()
                .filter(car -> car.getDistance() == distance)
                .collect(Collectors.toList());
    }

    public void forEachCar(Consumer<Car> action) {
        cars.forEach(action);
    }
}
