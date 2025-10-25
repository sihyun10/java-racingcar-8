package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Winners;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.service.GameInitializer;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final MoveStrategy strategy = new RandomMoveStrategy();

    private final GameInitializer initializer = new GameInitializer(inputView, outputView);
    private final RaceService raceService = new RaceService(strategy, outputView);

    public void start() {
        Cars cars = initializer.createCars();
        int tryCount = initializer.createTryCount();

        Winners winners = raceService.play(cars, tryCount);
        outputView.printWinners(winners);
    }
}
