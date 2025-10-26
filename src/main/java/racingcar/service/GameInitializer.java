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
        String carNames = requestCarNames();
        List<String> parsedCarNames = parseCarNames(carNames);
        validateCarNames(parsedCarNames);
        return new Cars(parsedCarNames);
    }

    public int createTryCount() {
        String count = requestTryCount();
        return validateTryCount(count);
    }

    private String requestCarNames() {
        outputView.printCarNameRequestMessage();
        return inputView.readCarNames();
    }

    private String requestTryCount() {
        outputView.printRacingCountRequestMessage();
        return inputView.readRacingCount();
    }

    private List<String> parseCarNames(String carNames) {
        String refinedCarNames = validateInput(carNames);
        return RacingCarParser.parseNames(refinedCarNames);
    }

    private String validateInput(String carNames) {
        InputValidator inputValidator = new InputValidator(carNames);
        return inputValidator.validate();
    }

    private void validateCarNames(List<String> parsedNames) {
        RacingCarValidator racingCarValidator = new RacingCarValidator(parsedNames);
        racingCarValidator.validate();
    }

    private int validateTryCount(String count) {
        RacingCountValidator racingCountValidator = new RacingCountValidator(count);
        return racingCountValidator.validate();
    }
}
