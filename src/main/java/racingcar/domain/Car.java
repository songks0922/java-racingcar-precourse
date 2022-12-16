package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    private boolean canForward() {
        int number = ForwardGenerator.generateNumber();
        if (number >= 4) {
            return true;
        }
        return false;
    }
}
