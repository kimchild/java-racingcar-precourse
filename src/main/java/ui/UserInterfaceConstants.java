package ui;

public interface UserInterfaceConstants {
	int RACING_WAIT_SPEED_MILLIS = 2000;
	int USER_INPUT_CHECK_SIZE = 0;
	String CAR_START_LINE_OUTPUT_MESSAGE = " : ";
	String ONE_ROUND_MESSAGE = "-";
	String WRITE_NEW_RACE_CAR_NAMES_COMMA_PART_MESSAGE = "경주할 자동차 이름을입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	String ACTION_RESULT_MESSAGE = "실행 결과";
	String FINAL_WINNER_MESSAGE = "가 최종 우승했습니다.";
	String RACE_REPEAT_MESSAGE = "시도할 횟수는 몇회인가요?";
	String REPEAT_REQUEST_NUMBER_MESSAGE = "시도할 횟수는 1~99까지의 숫자만 가능합니다";
	String CAR_NAME_LIMIT_MESSAGE = "이름은 5자리 까지만 가능합니다";
	String REGEX_REPEAT_REQUEST_NUMBER = "[1-9][0-9]?$|{%d}$";
	String REGEX_CAR_NAME_LIMIT = "[a-z가-힣]{%d}(?:,|$)";
}
