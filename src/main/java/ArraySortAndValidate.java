import java.util.Arrays;
import java.util.Collections;

public class ArraySortAndValidate {
  public Integer[] validateAndSortedArray(Integer[] array) {
    Integer[] newArray = array;
    Integer sizeCounter = 0;
    Arrays.sort(newArray, Collections.reverseOrder());
    for (Integer e : newArray) {
      if (e >= 0) {
        sizeCounter++;
      }
    }
    Integer[] validatedArray = new Integer[sizeCounter];
    for (int i = 0; i < validatedArray.length; i++) {
      validatedArray[i] = array[i];
    }
    return validatedArray;
  }
}

