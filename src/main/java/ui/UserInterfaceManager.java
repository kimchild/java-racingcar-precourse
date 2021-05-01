package ui;

import java.util.List;
import java.util.Scanner;

import domain.Car;
import domain.GameManager;

public class UserInterfaceManager {

	GameManager gameManager = new GameManager();

	private void reset() {
		gameManager = new GameManager();
		System.out.println("경주할 자동차 이름을입력하세요.(이름은 쉼표(,) 기준으로 구분)");
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
			System.out.println("실행 결과");

			this.movePrint(gameManager.getCarList());
			index++;
			Thread.sleep(2000);
		} while (count > index);

		System.out.println(gameManager.getWinners() + "가 최종 우승했습니다.");
	}

	private int userInput(Scanner scan) {
		gameManager.setName(scan.next());
		System.out.println("시도할 횟수는 몇회인가요?");
		final int count = scan.nextInt();
		gameManager.setCount(count);
		gameManager.setUp();
		return count;
	}

	private void movePrint(List<Car> carList) {
		StringBuilder sb;
		for (Car car : carList) {
			sb = new StringBuilder();
			sb.append(car.getName());
			sb.append(" : ");
			sb.append(this.getMovement(car.getMove()));
			System.out.println(sb);
		}
	}

	private String getMovement(int move) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < move; i++) {
			sb.append("-");
		}
		return sb.toString();
	}
}
