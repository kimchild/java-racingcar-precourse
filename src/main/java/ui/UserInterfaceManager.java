package ui;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import domain.Car;
import domain.GameManager;

public class UserInterfaceManager implements UserInterfaceConstants {

	GameManager gameManager = new GameManager();

	private void reset() {
		gameManager = new GameManager();
		System.out.println(WRITE_NEW_RACE_CAR_NAMES_COMMA_PART_MESSAGE);
	}

	public void start(Scanner scan) throws InterruptedException {
		this.reset();
		final int count = userInput(scan);
		userOutput(count);
	}

	private void userOutput(int count) throws InterruptedException {
		int index = 0;
		do {
			gameManager.action();
			System.out.println(ACTION_RESULT_MESSAGE);

			this.movePrint(gameManager.getCarList());
			index++;
			Thread.sleep(RACING_WAIT_SPEED_MILLIS);
		} while (count > index);

		System.out.println(gameManager.getWinners() + FINAL_WINNER_MESSAGE);
	}

	private int userInput(Scanner scan) {
		gameManager.setName(checkInputNames(scan));
		System.out.println(RACE_REPEAT_MESSAGE);
		gameManager.setUpNames();
		return getRepetitionNumberUserInput(scan);
	}

	private int getRepetitionNumberUserInput(Scanner scan) {
		final int max = GameManager.MAX_TRY_NUMBER;
		String input = scan.next().trim();

		while (input.length() == USER_INPUT_CHECK_SIZE
			|| !Pattern.compile(String.format(REGEX_REPEAT_REQUEST_NUMBER, max)).matcher(input).find()) {
			System.out.println(REPEAT_REQUEST_NUMBER_MESSAGE);
			input = scan.next().trim();
		}
		return Integer.parseInt(input);
	}

	private String checkInputNames(Scanner scan) {
		String input = scan.next().trim();

		while (input.length() == USER_INPUT_CHECK_SIZE
			|| Pattern.compile(String.format(REGEX_CAR_NAME_LIMIT, GameManager.MAX_NAME_OVER_SIZE))
						.matcher(input).find()) {
			System.out.println(CAR_NAME_LIMIT_MESSAGE);
			input = scan.next().trim();
		}
		return input;
	}

	private void movePrint(List<Car> carList) {
		StringBuilder sb;
		for (Car car : carList) {
			sb = new StringBuilder();
			sb.append(car.getName());
			sb.append(CAR_START_LINE_OUTPUT_MESSAGE);
			sb.append(this.getMovement(car.getMove()));
			System.out.println(sb);
		}
	}

	private String getMovement(int move) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < move; i++) {
			sb.append(ONE_ROUND_MESSAGE);
		}
		return sb.toString();
	}
}
