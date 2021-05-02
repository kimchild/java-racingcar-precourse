package domain;

public class Car implements Comparable<Car> {
	public static final int RULE_VALUE = 4;
	public static final int ACTION_COUNT = 1;
	public static final int COMPARE_RESULT_NUMBER = 1;
	public static final int MOVE_NUMBER = 1;
	public static final int NAME_ASC_INDEX = 0;
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
		this.move += MOVE_NUMBER;
	}

	public int getMove() {
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

	public String getName() {
		return this.name;
	}

	@Override
	public int compareTo(Car car) {
		if (this.move == car.getMove() && isNameAsc(car)) {
			return COMPARE_RESULT_NUMBER;
		}
		if (this.move < car.getMove()) {
			return COMPARE_RESULT_NUMBER;
		}
		return -1;
	}

	private boolean isNameAsc(Car car) {
		return this.getName().charAt(NAME_ASC_INDEX) > car.getName().charAt(NAME_ASC_INDEX);
	}
}
