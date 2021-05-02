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
		GameManager gameManager = new GameManager();
		gameManager.setName(name);

		/* when */
		gameManager.setUpNames();
		int index = 0;
		do {
			gameManager.action();
			index++;
		} while (count > index);
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

	@Test
		// @checkstyle:off
	void 자동차_우승자검증() {
		// @checkstyle:on
		/* given */
		final String name = "pobi,crong,heari";
		final int count = 5;
		GameManager gameManager = new GameManager();
		gameManager.setName(name);

		/* when */
		gameManager.setUpNames();
		int index = 0;
		do {
			gameManager.action();
			index++;
		} while (count > index);
		gameManager.getWinners();
		List<Car> cars = gameManager.getCarList();

		/* then */
		assertThat(cars.get(0).getRound()).isGreaterThan(cars.get(1).getRound() - 1);
	}

	private String getTie(Car topWinner, Car car) {
		if (topWinner.getRound() == car.getRound()) {
			return GameManager.TIES_CAR_COMMA + car.getName();
		}
		return "";
	}
}
