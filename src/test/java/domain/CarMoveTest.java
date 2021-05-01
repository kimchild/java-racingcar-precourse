package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarMoveTest {
	@Test
		// @checkstyle:off
	void 자동차_전진유무판단_이동() {
		// @checkstyle:on
		/* given */

		for (int i = 0; i < 100; i++) {
			/* when */
			Car car = new Car("pobi");
			car.random();
			car.move();

			/* then */
			assertThat(car.getMove() > 0).isEqualTo(car.isRule());
		}
	}

}
