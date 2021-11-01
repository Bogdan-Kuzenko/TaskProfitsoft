package Shape;

public class Cylinder extends Shape {

  private Double radius;
  private Double height;

  public Cylinder(Double radius, Double height) {
    if (radius <= 0) {
      throw new RuntimeException("Radius must be positive");
    }
    if (height <= 0) {
      throw new RuntimeException("Height must be positive");
    }
    this.radius = radius;
    this.height = height;
  }

  @Override
  public String toString() {
    return "Cylinder{" +
        "radius= " + radius +
        ", height= " + height +
        ", volume= " + calcVolume() +
        '}';
  }

  @Override
  public Double calcVolume() {
    return ((22 * radius * radius * height) / 7);
  }
}
