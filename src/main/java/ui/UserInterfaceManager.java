package ui;

import java.util.Scanner;

import domain.GameManager;

public class UserInterfaceManager {

	GameManager gameManager = new GameManager();

	private void reset() {
		gameManager = new GameManager();
		System.out.println("경주할 자동차 이름을입력하세요.(이름은 쉼표(,) 기준으로 구분)");
	}

	public void start(Scanner scan) {
		this.reset();
		final int count = userInput(scan);
	}

	private int userInput(Scanner scan) {
		gameManager.setName(scan.next());
		System.out.println("시도할 횟수는 몇회인가요?");
		final int count = scan.nextInt();
		gameManager.setCount(count);
		gameManager.setUp();
		return count;
	}
}
