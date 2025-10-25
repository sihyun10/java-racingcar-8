package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.Winners;
import racingcar.util.RacingCarParser;
import racingcar.util.RandomNumberGenerator;
import racingcar.validator.InputValidator;
import racingcar.validator.RacingCarValidator;
import racingcar.validator.RacingCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RandomNumberGenerator generator = new RandomNumberGenerator();

    public void start() {
        outputView.printCarNameRequestMessage();
        String carNames = inputView.readCarNames();
        String refinedCarNames = InputValidator.validate(carNames);
        
        List<String> parsedCarNames = RacingCarParser.parseNames(refinedCarNames);
        RacingCarValidator.validate(parsedCarNames);

        Cars cars = new Cars(parsedCarNames);

        outputView.printRacingCountRequestMessage();
        String count = inputView.readRacingCount();
        RacingCountValidator.validate(count);
        int tryCount = Integer.parseInt(count);

        race(cars, tryCount);
    }

    private void race(Cars cars, int tryCount) {
        outputView.printPlayResultMessage();

        for (int i = 0; i < tryCount; i++) {
            cars.moveAll(generator);
            outputView.printRoundResult(cars);
        }

        Winners winners = cars.findWinners();
        outputView.printWinners(winners);
    }
}
