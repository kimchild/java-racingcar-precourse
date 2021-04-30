public final class RandomNumber extends Number {
	public static final int MIN_VALUE = 0;
	public static final int MAX_VALUE = 9;

	private int value;

	@Override
	public int intValue() {
		return value;
	}

	public void random() {
		this.value = (int)(Math.random() * MAX_VALUE + MIN_VALUE);
	}
}
