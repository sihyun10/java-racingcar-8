package racingcar.view;

import racingcar.domain.Cars;

public class OutputView {

    public void printCarNameRequestMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printRacingCountRequestMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printPlayResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRoundResult(Cars cars) {
        cars.forEachCar(car ->
                System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()))
        );
        System.out.println();
    }
}
