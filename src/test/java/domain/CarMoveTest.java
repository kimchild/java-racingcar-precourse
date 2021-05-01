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

	@Test
		// @checkstyle:off
	void 자동차_주어진횟수만큼_수행테스트() {
		// @checkstyle:on
		/* given */
		final String names = "pobi";
		final int count = 5;
		GameManager gameManager = new GameManager();
		gameManager.setName(names);
		gameManager.setCount(count);


		/* when */
		gameManager.setUp();
		int index = 0;
		do {
			gameManager.action();
			index++;
		} while (count > index);

		/* then */
		for (Car car : gameManager.getCarList()) {
			assertThat(car.getActionCount()).isEqualTo(count);
		}
	}

}
