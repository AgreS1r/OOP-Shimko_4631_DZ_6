import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);

        // Удаление четных чисел
        numbers.removeIf(n -> n % 2 == 0);

        // Поиск минимального значения
        int min = numbers.stream().mapToInt(Integer::intValue).min().orElse(0);

        // Поиск максимального значения
        int max = numbers.stream().mapToInt(Integer::intValue).max().orElse(0);

        // Поиск среднего значения
        double average = numbers.stream().mapToInt(Integer::intValue).average().orElse(0);

        System.out.println("Список после удаления четных чисел: " + numbers);
        System.out.println("Минимальное значение: " + min);
        System.out.println("Максимальное значение: " + max);
        System.out.println("Среднее значение: " + average);
    }
}
