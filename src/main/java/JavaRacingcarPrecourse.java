import java.util.Scanner;

import ui.UserInterfaceManager;

public class JavaRacingcarPrecourse {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			new UserInterfaceManager().start(scan);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
