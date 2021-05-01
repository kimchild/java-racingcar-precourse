package domain;

public class Car {
	public static final int RULE_VALUE = 4;
	public static final int ACTION_COUNT = 1;
	private final String name;
	private int move;
	private int randomValue;
	private int actionCount = 0;

	public Car(String name) {
		this.name = name;
	}

	public boolean isName() {
		return null != name && !"".equals(name);
	}

	public void move() {
		if (!this.isRule()) {
			return;
		}
		this.move += 1;
	}

	protected int getMove() {
		return move;
	}

	public void random() {
		RandomNumber randomNumber = new RandomNumber();
		randomNumber.random();
		this.randomValue = randomNumber.intValue();
	}

	protected int getRandomNumber() {
		return randomValue;
	}

	public boolean isRule() {
		return this.getRandomNumber() >= RULE_VALUE;
	}

	public void action() {
		this.random();
		this.move();
		this.actionCount += ACTION_COUNT;
	}

	public int getActionCount() {
		return this.actionCount;
	}
}
