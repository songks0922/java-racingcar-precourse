package racingcar.domain;import java.util.ArrayList;import java.util.Arrays;import java.util.Comparator;import java.util.List;import java.util.NoSuchElementException;import java.util.stream.Collectors;import racingcar.exception.ExceptionMessage;public class CarGameManager {    private final List<Car> cars = new ArrayList<>();    private CarGameManager() {    }    public static CarGameManager initCarGame(String carNames) {        CarGameManager carGame = new CarGameManager();        carGame.addCar(carNames);        return carGame;    }    private void addCar(String inputCarNames) {        validateInputFormat(inputCarNames);        List<String> carNames = carNameSeparator(inputCarNames);        carNames.stream().forEach(name -> cars.add(new Car(name)));    }    private List<String> carNameSeparator(String carNames) {        List<String> convert = Arrays.stream(carNames.split(","))            .collect(Collectors.toCollection(ArrayList::new));        return convert;    }    private void validateInputFormat(String inputCarNames) {        inputCarNames.replaceAll(",", "");        if (!inputCarNames.matches("^[a-zA-Z]*$")) {            throw new IllegalArgumentException(ExceptionMessage.ERROR_MESSAGE_PREFIX.getErrorMessage());        }    }    private List<String> winnerResult() {        int position = winnerPosition();        List<String> winners = new ArrayList<>();        cars.forEach(car -> {            if (car.isWinner(position)) {                winners.add(car.getName());            }        });        return winners;    }    private int winnerPosition() {        Comparator<Car> comparatorByAge = Comparator.comparingInt(Car::getPosition);        Car winner = cars.stream().max(comparatorByAge).orElseThrow(NoSuchElementException::new);        return winner.getPosition();    }    public String gameResult() {        List<String> result = winnerResult();        return String.join(",", result);    }}