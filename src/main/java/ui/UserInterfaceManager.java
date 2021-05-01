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
		gameManager.setName(scan.next());
	}
}
