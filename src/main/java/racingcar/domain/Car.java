package racingcar.domain;

public class Car {

    private static final String path = "-";
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

    @Override
    public String toString() {
        String fullPath = "";
        for (int i = 0; i <= position; i++) {
            fullPath += path;
        }
        return fullPath;
    }
}
