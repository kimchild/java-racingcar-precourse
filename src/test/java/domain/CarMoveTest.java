package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarMoveTest {
	private Car car;

	@BeforeEach
	void setUp() {
		this.car = new Car("pobi");
	}

	@Test
		// @checkstyle:off
	void 자동차_전진유무판단_이동() {
		// @checkstyle:on
		/* given */

		for (int i = 0; i < 100; i++) {
			/* when */
			car.random();
			boolean isMove = car.getRandomNumber() >= Car.RULE_VALUE;
			car.move();

			/* then */
			if (isMove) {
				assertThat(car.getMove() > 0).isTrue();
				return;
			}
			assertThat(car.getMove() > 0).isFalse();
		}
	}

}
