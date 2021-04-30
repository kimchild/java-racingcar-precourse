import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarMove {
	private Car car;

	@BeforeEach
	void setUp() {
		this.car = new Car("pobi");
	}

	@Test
		// @checkstyle:off
	void 자동차_전진() {
		// @checkstyle:on
		/* given */

		/* when */
		car.move();

		/* then */
		assertThat(car.getMove()).isEqualTo(1);
	}
	@Test
		// @checkstyle:off
	void 자동차_전진2() {
		// @checkstyle:on
		/* given */

		/* when */
		car.move();
		car.move();

		/* then */
		assertThat(car.getMove()).isEqualTo(2);
	}

}
