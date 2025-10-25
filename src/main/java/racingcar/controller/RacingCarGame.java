package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Winners;
import racingcar.service.GameInitializer;
import racingcar.service.RaceService;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RandomNumberGenerator generator = new RandomNumberGenerator();

    private final GameInitializer initializer = new GameInitializer(inputView, outputView);
    private final RaceService raceService = new RaceService(generator, outputView);

    public void start() {
        Cars cars = initializer.createCars();
        int tryCount = initializer.createTryCount();

        Winners winners = raceService.play(cars, tryCount);
        outputView.printWinners(winners);
    }
}
