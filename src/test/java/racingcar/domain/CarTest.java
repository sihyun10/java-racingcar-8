package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("랜덤값이 4 이상일 경우 자동차 전진")
    void 랜던값_4_이상일경우_자동차_전진() {
        // given
        Car car = new Car("pobi");

        // when
        car.move(4);

        // then
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜던값이 3 이하일 경우 자동차 전진 못함")
    void 랜던값_3_이하일경우_자동차_전진_못함() {
        // given
        Car car = new Car("jun");

        // when
        car.move(3);

        // then
        assertThat(car.getDistance()).isEqualTo(0);
    }
}
