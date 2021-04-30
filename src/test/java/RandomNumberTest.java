import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RandomNumberTest {
	@Test
		// @checkstyle:off
	void 랜덤값구하기_0_9() {
		// @checkstyle:on
		/* given */
		RandomNumber random = new RandomNumber();

		/* when */
		int sum = 0;
		for (int j = 0; j < 100; j++) {
			random.random();
			sum += random.intValue();
		}

		/* then */
		assertThat(sum).isGreaterThan(0);
		for (int j = 0; j < 1000; j++) {
			random.random();
			assertThat(random.intValue()).isLessThan(RandomNumber.MAX_VALUE + 1);
			assertThat(random.intValue()).isGreaterThan(RandomNumber.MIN_VALUE - 1);
		}
	}
}
