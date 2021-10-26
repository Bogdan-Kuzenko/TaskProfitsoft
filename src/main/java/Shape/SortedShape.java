package Shape;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SortedShape {

  public List<Shape> sortedShapeByVolume(List<Shape> shapes) {
    return shapes.stream()
        .sorted(Comparator.comparingDouble(Shape::calcVolume).reversed())
        .collect(Collectors.toCollection(LinkedList::new));
  }
}
