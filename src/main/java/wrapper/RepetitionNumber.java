package wrapper;

import java.util.regex.Pattern;

public class RepetitionNumber {
	public static String REGEX_REPEAT_REQUEST_NUMBER = "[1-9][0-9]?$|{%d}$";

	private String value;

	public RepetitionNumber(String value) {
		this.validate(value);
	}

	public void setValue(String value) {
		this.validate(value);
	}

	private void validate(String value) {
		this.value = value.trim();
	}

	public int intValue() {
		return Integer.parseInt(this.value);
	}

	public boolean isRepeat() {
		return this.value.length() == Repetition.USER_INPUT_CHECK_SIZE
			|| !Pattern.compile(String.format(REGEX_REPEAT_REQUEST_NUMBER, Repetition.MAX_TRY_NUMBER))
			.matcher(this.value).find();
	}

}
