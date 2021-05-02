package wrapper;

public class IncreaseActionCount extends Increase {
	private int value;

	public IncreaseActionCount() {
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
