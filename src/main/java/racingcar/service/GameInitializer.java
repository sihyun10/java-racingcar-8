package racingcar.service;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.util.RacingCarParser;
import racingcar.validator.InputValidator;
import racingcar.validator.RacingCarValidator;
import racingcar.validator.RacingCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameInitializer {

    private final InputView inputView;
    private final OutputView outputView;

    public GameInitializer(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public Cars createCars() {
        outputView.printCarNameRequestMessage();
        String carNames = inputView.readCarNames();
        String refinedCarNames = InputValidator.validate(carNames);

        List<String> parsedNames = RacingCarParser.parseNames(refinedCarNames);
        RacingCarValidator.validate(parsedNames);

        return new Cars(parsedNames);
    }

    public int createTryCount() {
        outputView.printRacingCountRequestMessage();
        String count = inputView.readRacingCount();
        RacingCountValidator.validate(count);

        return Integer.parseInt(count);
    }
}
