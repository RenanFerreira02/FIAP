import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main_Outro {
    public static void main(String[] args) {
        Integer[] x = {2, 3, 6, 1};

        List<Integer> a = Arrays.asList(x);

        Stream<Integer> s = Stream.of(x);

    }
}
