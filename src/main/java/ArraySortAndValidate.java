import java.util.Arrays;
import java.util.Collections;

public class ArraySortAndValidate {
  public Integer[] validateAndSortedArray(Integer[] array) {
    if (array == null) {
      return new Integer[0];
    }

    return Arrays.stream(array)
        .filter(number -> number >= 0)
        .sorted(Collections.reverseOrder())
        .toArray(Integer[]::new);
  }
}

