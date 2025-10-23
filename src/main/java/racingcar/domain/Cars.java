package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.RandomNumberGenerator;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> names) {
        this.cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveAll(RandomNumberGenerator generator) {
        cars.forEach(car -> car.move(generator.generate()));
    }

    public int findMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }

    public Winners findWinners() {
        int maxDistance = findMaxDistance();

        List<Car> winnerCars = cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .collect(Collectors.toList());

        return new Winners(winnerCars);
    }
}
