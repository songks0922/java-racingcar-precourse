package racingcar.view;public class OutputView {    private static final String RESULT_MESSAGE = "\n실행 결과";    private static final String WINNER_MESSAGE = "최종 우승자 : ";    public void printError(String message) {        System.out.println(message);    }    public void printResultMessage() {        System.out.println(RESULT_MESSAGE);    }    public void printEachResult(String eachResult) {        System.out.println(eachResult);    }    public void printFinalResult(String result) {        System.out.print(WINNER_MESSAGE + result);    }}