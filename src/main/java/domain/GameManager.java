package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameManager {
	public static final String NAME_SPLIT = ",";
	public static final String TIES_CAR_COMMA = ", ";
	private String name;
	private int count;

	private List<Car> carList = new ArrayList<>();

	public GameManager() {}

	public void setName(String name) {
		this.name = name;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setUp() {
		for (String s : name.split(NAME_SPLIT)) {
			this.carList.add(new Car(s));
		}
	}

	public void action() {
		int index = 0;
		do {
			this.carActions();
			index++;
		} while (this.count > index);
	}

	private void carActions() {
		for (Car car : this.getCarList()) {
			car.action();
		}
	}

	public List<Car> getCarList() {
		return this.carList;
	}

	public String getWinners() {
		Collections.sort(this.getCarList());
		Car topWinner = this.getCarList().get(0);
		StringBuilder names = new StringBuilder();

		for (Car car : this.getCarList()) {
			names.append(this.getTie(topWinner, car));
		}

		return names.substring(names.indexOf(TIES_CAR_COMMA) + 1);
	}

	private String getTie(Car topWinner, Car car) {
		if (topWinner.getMove() == car.getMove()) {
			return TIES_CAR_COMMA + car.getName();
		}
		return "";
	}
}
