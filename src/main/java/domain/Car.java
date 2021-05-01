package domain;

public class Car {
	private final String name;
	private int move;
	private int randomValue;

	public Car(String name) {
		this.name = name;
	}

	public boolean isName() {
		return isaBoolean();
	}

	private boolean isaBoolean() {
		return null != name && !"".equals(name);
	}

	public void move() {
		this.move += 1;
	}

	public int getMove() {
		return move;
	}

	public void random() {
		RandomNumber randomNumber = new RandomNumber();
		randomNumber.random();
		this.randomValue = randomNumber.intValue();
	}

	public int getRandomNumber() {
		return randomValue;
	}
}
