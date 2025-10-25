package racingcar.domain.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int startInclusive = 0;
    private static final int endInclusive = 9;
    private static final int MOVE_CONDITION = 4;

    @Override
    public boolean movable() {
        int randomNumber = Randoms.pickNumberInRange(startInclusive, endInclusive);
        return randomNumber >= MOVE_CONDITION;
    }
}
