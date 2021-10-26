package Shape;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortedShapeTest {

  SortedShape sortedShape;
  List<Shape> shapesNotSorted;
  List<Shape> listSortedShape;

  @BeforeEach
  void setup() {
    Shape sphere1 = new Sphere(8.0);
    Shape sphere2 = new Sphere(4.0);
    Shape sphere3 = new Sphere(3.0);
    Shape cube1 = new Cube(5.0);
    Shape cube2 = new Cube(7.0);
    Shape cube3 = new Cube(2.0);
    Shape cylinder1 = new Cylinder(2.0, 8.0);
    Shape cylinder2 = new Cylinder(2.0, 4.0);
    shapesNotSorted = Arrays.asList(sphere1, sphere2, sphere3, cube1, cube2, cube3, cylinder1, cylinder2);
    listSortedShape = Arrays.asList(sphere1, cube2, sphere2, cube1, sphere3, cylinder1, cylinder2, cube3);
    sortedShape = new SortedShape();
  }

  @AfterEach
  void clear() {
    shapesNotSorted = null;
    listSortedShape = null;
  }

  @Test
  void sortedShapeByVolume() {
    List<Shape> shapes = sortedShape.sortedShapeByVolume(shapesNotSorted);
    assertEquals(listSortedShape,shapes);
  }
}