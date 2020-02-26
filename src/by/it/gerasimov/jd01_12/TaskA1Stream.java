package by.it.gerasimov.jd01_12;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class TaskA1Stream {

    public static void main(String[] args) {
        Random random = new Random(System.nanoTime());
        List<Integer> marks = Stream.generate(() -> random.nextInt(10) + 1).limit(30)
            .collect(Collectors.toList());
        System.out.println(marks);
        System.out.println(marks.stream().filter(grade -> grade > 3).collect(Collectors.toList()));
    }
}
