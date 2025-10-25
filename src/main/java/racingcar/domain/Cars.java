package racingcar.domain;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.view.OutputView;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> names) {
        this.cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public Winners race(int tryCount, MoveStrategy strategy, OutputView outputView) {
        for (int i = 0; i < tryCount; i++) {
            moveAll(strategy);
            outputView.printRoundResult(this);
        }
        return findWinners();
    }

    private void moveAll(MoveStrategy strategy) {
        cars.forEach(car -> car.move(strategy));
    }

    private Winners findWinners() {
        int maxDistance = findMaxDistance();

        List<Car> winnerCars = cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .collect(Collectors.toList());

        return new Winners(winnerCars);
    }

    private int findMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }

    public void forEachCar(Consumer<Car> action) {
        cars.forEach(action);
    }
}
