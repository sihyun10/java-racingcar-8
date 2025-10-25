package racingcar.service;

import racingcar.domain.Cars;
import racingcar.domain.Winners;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.OutputView;

public class RaceService {

    private final RandomNumberGenerator generator;
    private final OutputView outputView;

    public RaceService(RandomNumberGenerator generator, OutputView outputView) {
        this.generator = generator;
        this.outputView = outputView;
    }

    public Winners play(Cars cars, int tryCount) {
        outputView.printPlayResultMessage();
        return cars.race(tryCount, generator, outputView);
    }
}
