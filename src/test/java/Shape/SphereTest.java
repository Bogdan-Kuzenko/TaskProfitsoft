package Shape;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SphereTest {

  @Test
  void negativeRadius() {
    Assertions.assertThrows(RuntimeException.class, () -> new Sphere(-1.0));
  }

  @Test
  void zeroRadius() {
    Assertions.assertThrows(RuntimeException.class, () -> new Sphere(0.0));
  }

  @Test
  void calcVolume() {
    Sphere s = new Sphere(2.0);
    Double sVolume = s.calcVolume();
    Double expect = (4.0 / 3.0) * 3.14285714286 * (2.0 * 2.0 * 2.0);
    Assertions.assertEquals(expect, sVolume);
  }


}