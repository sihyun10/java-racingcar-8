package racingcar.service;

import racingcar.domain.Cars;
import racingcar.domain.Winners;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.view.OutputView;

public class RaceService {

    private final MoveStrategy strategy;
    private final OutputView outputView;

    public RaceService(MoveStrategy strategy, OutputView outputView) {
        this.strategy = strategy;
        this.outputView = outputView;
    }

    public Winners play(Cars cars, int tryCount) {
        outputView.printPlayResultMessage();
        
        for (int i = 0; i < tryCount; i++) {
            cars.raceOnce(strategy);
            outputView.printRoundResult(cars);
        }

        return cars.findWinners();
    }
}
