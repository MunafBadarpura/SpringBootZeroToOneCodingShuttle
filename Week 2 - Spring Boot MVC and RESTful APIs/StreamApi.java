import java.nio.file.Watchable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi {


    // Lambda Expression, Lambda Method Inference, Stream API, Sorting, Filtering, Mapping, Collecting
    public static void main(String[] args) {
//        Older Way
//        WalkAble walkAble = new WalkFast();
//        System.out.println(walkAble.walk(10));

//        WalkAble walkAble = new WalkAble() {
//            @Override
//            public int walk(int steps) {
//                return 0;
//            }
//        }

//        // New Way
//        WalkAble walkAble = (steps, isEnabled) -> {
//            System.out.println("Walking " + steps + " steps and function is enabled: " + isEnabled);
//            return 2 * steps;
//        };
//
//        WalkAble walkAble2 = (steps, isEnabled) -> 2*steps;
//
//        walkAble.walk(4, true);
//        System.out.println();
//        System.out.println(walkAble2.walk(3, true));

        // Stream API
        List<String> fruits = List.of("Apple", "Banana", "Orange", "Grapes", "Mango", "Pineapple", "Guava", "Papaya");

        Stream<String> fruitStream = fruits.stream();
        Stream<String> fruitStream2 = fruits.stream();
        Stream<String> fruitStream3 = fruits.stream();
        Stream<String> fruitStream4 = fruits.stream();
        Stream<String> fruitStream5 = fruits.stream();

        fruitStream.forEach(fruit -> System.out.println(fruit));
        fruitStream
                .filter(fruit -> fruit.startsWith("P"))
                .map(fruit -> fruit.toUpperCase())
                .forEach(System.out::println);

       fruitStream2
               .sorted()
               .forEach(fruit -> System.out.println(fruit));

       fruitStream3
               .sorted()
               .map(fruit -> fruit.length())
               .map(length -> length * 2)
               .forEach(fruit -> System.out.println(fruit));

       fruitStream4
               .filter(fruit -> fruit.length() > 5)
               .forEach(fruit -> System.out.println(fruit));

        Map<String, Integer> fruitListInt = fruitStream5
//                .map(fruit -> fruit.length())
                .collect(Collectors.toMap(
                        fruit -> fruit,
                        String::length
                ));

        System.out.println(fruitListInt);
    }
}


interface WalkAble {
    int walk(int steps, boolean isEnabled);
}

class WalkFast implements WalkAble {

   @Override
   public int walk(int steps) {
       System.out.println("Walking " + steps + " steps");
       return 2 * steps;
   }
}