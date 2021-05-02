package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarRuleTest {

	@Test
		// @checkstyle:off
	void 자동차_숫자값4_판단() {
		// @checkstyle:on
		/* given */
		Car car = new Car("pobi");

		/* when */
		car.random();
		boolean isRound = car.getRandomNumber() >= Car.RACE_ROUND_STANDARD;

		/* then */
		assertThat(car.isRound()).isEqualTo(isRound);
	}
}
