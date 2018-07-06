package lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Vacy");
        list.add("Pety");
        list.add("Koly");

      Set<String> set = list.stream()
              .filter(x -> (x.equals("Vacy")|| x.equals("Koly")))
              .map(x -> x.toUpperCase())
              .collect(Collectors.toSet());
        System.out.println(set);

      int max = Stream.of(1,2,3).max(Comparator.comparing(x -> x)).get();
        System.out.println("max "+max);

       int count = Stream.of(1,2,3).reduce(0, (rez, elem) -> rez + elem);
        System.out.println("count "+count);

        System.out.println("************");

        B a = new B();

         a.doIt();
        a.print();
    }
}

interface A {

    default void print(){
        System.out.println("Print!");
    }
}

class B implements A {
    void doIt() {
        System.out.println("do it");
    }
}