package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.util.RacingCarParser;
import racingcar.validator.RacingCarValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public Cars prepareCars() {
        outputView.printCarNameRequestMessage();
        String carNames = inputView.readCarNames();

        List<String> names = RacingCarParser.parseNames(carNames);
        RacingCarValidator.validate(names);

        return new Cars(names);
    }
}
