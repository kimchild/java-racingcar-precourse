package wrapper;

public class RepetitionRoundNumber {
	public static final int INCREASE_VALUE = 1;
	private int value;

	public RepetitionRoundNumber() {
	}

	public void increase() {
		this.value += INCREASE_VALUE;
	}

	public boolean isRepeat(int count) {
		return count > this.value;
	}
}
