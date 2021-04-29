public class Car {
	private final String name;

	public Car(String name) {
		this.name = name;
	}

	public boolean isName() {
		return isaBoolean();
	}

	private boolean isaBoolean() {
		return null != name && !"".equals(name);
	}
}
