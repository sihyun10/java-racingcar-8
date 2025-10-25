package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnersTest {

    private Car pobi;
    private Car woni;
    private Car jun;

    @BeforeEach
    void SetUp() {
        pobi = new Car("pobi");
        woni = new Car("woni");
        jun = new Car("jun");
    }

    @Test
    @DisplayName("단독 우승자의 이름 반환")
    void 단독_우승자이름_반환() {
        Winners winners = new Winners(List.of(pobi));

        assertWinnerNames(winners, "pobi");
    }

    @Test
    @DisplayName("공동 우승자의 이름을 쉼표로 구분하여 반환")
    void 공동_우승자이름_반환() {
        Winners winners = new Winners(List.of(pobi, woni, jun));

        assertWinnerNames(winners, "pobi, woni, jun");
    }

    private void assertWinnerNames(Winners winners, String expectedFormatted) {
        assertThat(winners.formatNames()).isEqualTo(expectedFormatted);
    }
}
