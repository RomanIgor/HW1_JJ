/**
 * 1. Создать список из 1_000 рандомных чисел от 1 до 1_000_000
 * 1.1 Найти максимальное
 * 2.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
 * 2.3 Найти количество чисел, квадрат которых меньше, чем 100_000
 */

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class Task1 {
    public static void main(String[] args) {

        List<Integer> numbers = Stream.generate(() -> ThreadLocalRandom.current().nextInt(1, 1_000_000))
                .limit(1_000)
                .toList();
        System.out.println(numbers);

        //1.1 Найти максимальное
        System.out.println("The max number is: " + numbers.stream().max(Integer::compareTo));

        //2.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать

        int sum = numbers.stream()
                .filter(num -> num > 500_000)
                .mapToInt(num -> num * 5 - 150)
                .sum();
        System.out.println("The amount is: " + sum);

        //2.3 Найти количество чисел, квадрат которых меньше, чем 100_000
        long count = numbers.stream()
                .filter(num -> Math.pow(num, 2) < 100_000)
                .count();
        System.out.println("The count of numbers is : " + count);

    }

}
