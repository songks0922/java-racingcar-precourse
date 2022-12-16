package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void forward(int number) {
        if (canForward(number)) {
            position++;
        }
    }

    private boolean canForward(int number) {
        if (number >= 4) {
            return true;
        }
        return false;
    }
}
