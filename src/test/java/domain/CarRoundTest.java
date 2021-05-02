package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarRoundTest {

	@Test
		// @checkstyle:off
	void 자동차_전진유무판단_이동() {
		// @checkstyle:on
		/* given */

		for (int i = 0; i < 100; i++) {
			/* when */
			Car car = new Car("pobi");
			car.random();
			car.round();

			/* then */
			assertThat(car.getRound() > 0).isEqualTo(car.isRound());
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

		/* when */
		gameManager.setUpNames();
		int index = 0;
		do {
			gameManager.action();
			index++;
		} while (count > index);

		/* then */
		for (Car car : gameManager.getCarList()) {
			assertThat(car.getIncreaseActionCount()).isEqualTo(count);
		}
	}

}
