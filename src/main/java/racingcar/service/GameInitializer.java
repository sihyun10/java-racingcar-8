package racingcar.service;

import java.util.List;
import racingcar.domain.Cars;
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
        InputValidator inputValidator = new InputValidator(carNames);
        String refinedCarNames = inputValidator.validate();

        List<String> parsedNames = RacingCarParser.parseNames(refinedCarNames);
        RacingCarValidator racingCarValidator = new RacingCarValidator(parsedNames);
        racingCarValidator.validate();

        return new Cars(parsedNames);
    }

    public int createTryCount() {
        outputView.printRacingCountRequestMessage();
        String count = inputView.readRacingCount();

        RacingCountValidator racingCountValidator = new RacingCountValidator(count);
        return racingCountValidator.validate();
    }
}
