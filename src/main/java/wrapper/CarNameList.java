package wrapper;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CarNameList {
	public static final String NAME_SPLIT = ",";
	private String value;

	public CarNameList() {
	}

	public void setValue(String value) {
		this.validate(value);
	}

	private void validate(String value) {
		this.value = value.trim();
	}

	public Set<String> toArray() {
		return new HashSet<>(Arrays.asList(this.value.split(NAME_SPLIT)));
	}
}
