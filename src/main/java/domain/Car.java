package domain;

import wrapper.IncreaseActionCount;
import wrapper.IncreaseCarMove;

public class Car implements Comparable<Car> {
	public static final int RULE_VALUE = 4;
	public static final int COMPARE_RESULT_NUMBER = 1;
	public static final int NAME_ASC_INDEX = 0;
	private final String name;

	private IncreaseCarMove increaseCarMove;
	private RandomNumber randomNumber;
	private IncreaseActionCount increaseActionCount;

	public Car(String name) {
		this.name = name;
		increaseCarMove = new IncreaseCarMove();
		randomNumber = new RandomNumber();
		increaseActionCount = new IncreaseActionCount();
	}

	public boolean isName() {
		return null != name && !"".equals(name);
	}

	public void move() {
		if (!this.isRule()) {
			return;
		}
		this.increaseCarMove.increase();
	}

	public int getMove() {
		return this.increaseCarMove.intValue();
	}

	public void random() {
		randomNumber.random();
	}

	protected int getRandomNumber() {
		return randomNumber.intValue();
	}

	public boolean isRule() {
		return this.getRandomNumber() >= RULE_VALUE;
	}

	public void action() {
		this.random();
		this.move();
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
		if (this.increaseCarMove.intValue() == car.getMove() && isNameAsc(car)) {
			return COMPARE_RESULT_NUMBER;
		}
		if (this.increaseCarMove.intValue() < car.getMove()) {
			return COMPARE_RESULT_NUMBER;
		}
		return -1;
	}

	private boolean isNameAsc(Car car) {
		return this.getName().charAt(NAME_ASC_INDEX) > car.getName().charAt(NAME_ASC_INDEX);
	}
}
