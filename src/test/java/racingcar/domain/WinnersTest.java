package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnersTest {

    @Test
    @DisplayName("단독 우승자의 이름 반환")
    void 단독_우승자이름_반환() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");

        Winners winners = new Winners(List.of(pobi));

        assertThat(winners.getWinnerNames()).containsExactly("pobi");
        assertThat(winners.formatNames()).contains("pobi");
    }

    @Test
    @DisplayName("공동 우승자의 이름을 쉼표로 구분하여 반환")
    void 공동_우승자이름_반환() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");

        Winners winners = new Winners(List.of(pobi, woni, jun));

        assertThat(winners.getWinnerNames()).containsExactly("pobi", "woni", "jun");
        assertThat(winners.formatNames()).contains("pobi, woni, jun");
    }
}
