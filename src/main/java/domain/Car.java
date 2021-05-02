package domain;

import wrapper.IncreaseActionCount;
import wrapper.IncreaseCarRound;

public class Car implements Comparable<Car> {
	public static final int RACE_ROUND_STANDARD = 4;
	public static final int COMPARE_RESULT_NUMBER = 1;
	public static final int NAME_ASC_INDEX = 0;
	private final String name;

	private IncreaseCarRound increaseCarRound;
	private RandomNumber randomNumber;
	private IncreaseActionCount increaseActionCount;

	public Car(String name) {
		this.name = name;
		increaseCarRound = new IncreaseCarRound();
		randomNumber = new RandomNumber();
		increaseActionCount = new IncreaseActionCount();
	}

	public boolean isName() {
		return null != name && !"".equals(name);
	}

	public void round() {
		if (!this.isRound()) {
			return;
		}
		this.increaseCarRound.increase();
	}

	public int getRound() {
		return this.increaseCarRound.intValue();
	}

	public void random() {
		randomNumber.random();
	}

	protected int getRandomNumber() {
		return randomNumber.intValue();
	}

	public boolean isRound() {
		return this.getRandomNumber() >= RACE_ROUND_STANDARD;
	}

	public void action() {
		this.random();
		this.round();
		this.increaseActionCount.increase();
	}

	public int getIncreaseActionCount() {
		return this.increaseActionCount.intValue();
	}

	public String getName() {
		return this.name;
	}

	@Override
	public int compareTo(Car car) {
		if (this.increaseCarRound.intValue() == car.getRound() && isNameAsc(car)) {
			return COMPARE_RESULT_NUMBER;
		}
		if (this.increaseCarRound.intValue() < car.getRound()) {
			return COMPARE_RESULT_NUMBER;
		}
		return -1;
	}

	private boolean isNameAsc(Car car) {
		return this.getName().charAt(NAME_ASC_INDEX) > car.getName().charAt(NAME_ASC_INDEX);
	}
}
