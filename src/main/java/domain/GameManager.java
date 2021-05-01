package domain;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
	public static final String NAME_SPLIT = ",";
	private final String name;
	private final int count;

	private List<Car> carList = new ArrayList<>();

	public GameManager(String name, int count) {
		this.name = name;
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
		for (Car car : this.carList) {
			car.action();
		}
	}

	public List<Car> getCarList() {
		return this.carList;
	}
}
