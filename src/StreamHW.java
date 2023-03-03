import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamHW {

    public static void main(String[] args) {

        //Задание 1
        Stream<Integer> stream = new ArrayList<>(Arrays.asList(5, 8, 10, 12, 15, 25, 31)).stream();

        findMinMax(
                stream,
                (x, y) -> x.compareTo(y),
                (x, y) -> System.out.println(String.format("min: %s, max: %s", x, y))
        );

        stream.close();

        //Задание 2
        evenNumberStream();
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> items = stream.sorted(order).collect(Collectors.toList());
        if (!items.isEmpty()) {
            minMaxConsumer.accept(items.get(0), items.get(items.size() - 1));

        } else {
            minMaxConsumer.accept(null, null);
        }
    }

    public static void evenNumberStream() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        int number;
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            number = random.nextInt() % 100;
            numbers.add(number);
        }

        Stream<Integer> numberStream = numbers.stream();

        Predicate<Integer> function;

        function = (n) -> (n % 2) == 0;

        Stream<Integer> evenNumberStream = numberStream.filter(function);

        System.out.println("Количество четных чисел в массиве - " + evenNumberStream.count());

    }
}
