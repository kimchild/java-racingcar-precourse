package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarAddRandomTest {

	@Test
		// @checkstyle:off
	void 자동차_랜덤값부여() {
		// @checkstyle:on
		/* given */
		Car car = new Car("pobi");
		car.random();

		/* when */

		/* then */
		assertThat(car.getRandomNumber()).isGreaterThan(0);
	}
}
