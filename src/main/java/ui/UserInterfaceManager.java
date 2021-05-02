package ui;

import java.util.List;
import java.util.Scanner;

import domain.Car;
import domain.GameManager;
import wrapper.RepetitionCarName;
import wrapper.RepetitionNumber;
import wrapper.RepetitionRoundNumber;

public class UserInterfaceManager implements UserInterfaceConstants {

	GameManager gameManager = new GameManager();

	private void reset() {
		gameManager = new GameManager();
		System.out.println(WRITE_NEW_RACE_CAR_NAMES_COMMA_PART_MESSAGE);
	}

	public void start(Scanner scan) throws InterruptedException {
		this.reset();
		outputUser(inputUser(scan));
	}

	private void outputUser(int count) throws InterruptedException {
		RepetitionRoundNumber repetitionRoundNumber = new RepetitionRoundNumber();
		do {
			outputAction();
			repetitionRoundNumber.increase();
			Thread.sleep(RACING_WAIT_SPEED_MILLIS);
		} while (repetitionRoundNumber.isRepeat(count));

		System.out.println(gameManager.getWinners() + FINAL_WINNER_MESSAGE);
	}

	private void outputAction() {
		gameManager.action();
		System.out.println(ACTION_RESULT_MESSAGE);
		this.movePrint(gameManager.getCarList());
	}

	private int inputUser(Scanner scan) {
		gameManager.setName(checkInputNames(scan));
		System.out.println(RACE_REPEAT_MESSAGE);
		gameManager.setUpNames();
		return getRepetitionNumberUserInput(scan);
	}

	private int getRepetitionNumberUserInput(Scanner scan) {
		RepetitionNumber repetitionNumber = new RepetitionNumber(scan.next());

		while (repetitionNumber.isRepeat()) {
			System.out.println(REPEAT_REQUEST_NUMBER_MESSAGE);
			repetitionNumber.setValue(scan.next());
		}
		return repetitionNumber.intValue();
	}

	private String checkInputNames(Scanner scan) {
		RepetitionCarName repetitionCarName = new RepetitionCarName(scan.next());

		while (repetitionCarName.isRepeat()) {
			System.out.println(CAR_NAME_LIMIT_MESSAGE);
			repetitionCarName.setValue(scan.next());
		}
		return repetitionCarName.toString();
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
