import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CarNameTest {

	@Test
		// @checkstyle:off
	void 자동차_이름부여() {
		// @checkstyle:on
		/* given */
		Car carName = new Car("pobi");

		/* when */

		/* then */
		assertThat(carName.isName()).isTrue();
	}

	@Test
		// @checkstyle:off
	void 자동차_리스트에_이름부여() {
		// @checkstyle:on
		/* given */
		List<Car> carList = Arrays.asList(new Car("pobi"), new Car("crong"), new Car("heari"));

		/* when */

		/* then */
		assertThat(carList.get(0).isName()).isTrue();
		assertThat(carList.get(1).isName()).isTrue();
		assertThat(carList.get(2).isName()).isTrue();
	}
}
