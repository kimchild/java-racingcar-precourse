package wrapper;

import java.util.regex.Pattern;

public class RepetitionCarName {
	public static String REGEX_CAR_NAME_LIMIT = "[a-z가-힣]{%d}(?:,|$)";

	private String value;

	public RepetitionCarName(String value) {
		this.validate(value);
	}

	public void setValue(String value) {
		this.validate(value);
	}

	private void validate(String value) {
		this.value = value.trim();
	}

	public boolean isRepeat() {
		return this.value.length() == Repetition.USER_INPUT_CHECK_SIZE
			|| Pattern.compile(String.format(REGEX_CAR_NAME_LIMIT, Repetition.MAX_NAME_OVER_SIZE))
			.matcher(this.value).find();
	}

	@Override
	public String toString() {
		return this.value;
	}
}
