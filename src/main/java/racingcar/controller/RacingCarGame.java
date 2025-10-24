package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.util.RacingCarParser;
import racingcar.util.RandomNumberGenerator;
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
        List<String> names = RacingCarParser.parseNames(inputView.readCarNames());
        RacingCarValidator.validate(names);

        Cars cars = new Cars(names);

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
    }
}
