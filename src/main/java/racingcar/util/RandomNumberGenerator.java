package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private static final int startInclusive = 0;
    private static final int endInclusive = 9;

    public int generate() {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
