package wrapper;

public class IncreaseCarMove extends Increase {
	public static final int INCREASE_VALUE = 1;
	private int value;

	public IncreaseCarMove() {
	}

	@Override
	public int intValue() {
		return this.value;
	}

	@Override
	public void increase() {
		this.value += INCREASE_VALUE;
	}
}
