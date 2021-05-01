package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CarWinnerTest {

	@Test
		// @checkstyle:off
	void 자동차_우승자찾기() {
		// @checkstyle:on
		/* given */
		final String name = "pobi,crong,heari";
		final int count = 5;
		GameManager gameManager = new GameManager(name, count);

		/* when */
		gameManager.setUp();
		gameManager.action();
		String winners = gameManager.getWinners();

		List<Car> carList = gameManager.getCarList();
		Collections.sort(carList);
		Car topWinner = carList.get(0);
		StringBuilder names = new StringBuilder();
		for (Car car : carList) {
			names.append(this.getTie(topWinner, car));
		}

		/* then */
		System.out.println("winners : " + winners);
		System.out.println("test names : " + names.substring(names.indexOf(GameManager.TIES_CAR_COMMA) + 1));
		assertThat(winners).isEqualTo(names.substring(names.indexOf(GameManager.TIES_CAR_COMMA) + 1));
	}

	private String getTie(Car topWinner, Car car) {
		if (topWinner.getMove() == car.getMove()) {
			return GameManager.TIES_CAR_COMMA + car.getName();
		}
		return "";
	}
}
