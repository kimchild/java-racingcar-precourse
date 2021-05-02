package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class GameManager {
	public static final String NAME_SPLIT = ",";
	public static final String TIES_CAR_COMMA = ", ";
	public static final int SUBSTRING_ADD_NUMBER = 1;
	public static final int FIRST_WINNER_INDEX = 0;
	private String name;

	private List<Car> carList = new ArrayList<>();

	public GameManager() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUpNames() {
		for (String s : new HashSet<>(Arrays.asList(name.split(NAME_SPLIT)))) {
			this.carList.add(new Car(s));
		}
	}

	public void action() {
		this.carActions();
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
		Car topWinner = this.getCarList().get(FIRST_WINNER_INDEX);
		StringBuilder names = new StringBuilder();

		for (Car car : this.getCarList()) {
			names.append(this.getTie(topWinner, car));
		}

		return getAllWinner(names);
	}

	private String getAllWinner(StringBuilder names) {
		return names.substring(names.indexOf(TIES_CAR_COMMA) + SUBSTRING_ADD_NUMBER);
	}

	private String getTie(Car topWinner, Car car) {
		if (topWinner.getMove() == car.getMove()) {
			return TIES_CAR_COMMA + car.getName();
		}
		return "";
	}
}
