package racingcar.domain;

import racingcar.exception.ExceptionMessage;

public class Car {

    private static final String path = "-";
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateNameLength(name);
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

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public boolean isWinner(int position) {
        if (this.position == position) {
            return true;
        }
        return false;
    }

    public void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_CAR_NAME_ERROR.getErrorMessage());
        }
    }
    @Override
    public String toString() {
        String fullPath = "";
        for (int i = 0; i < position; i++) {
            fullPath += path;
        }
        return fullPath;
    }
}
