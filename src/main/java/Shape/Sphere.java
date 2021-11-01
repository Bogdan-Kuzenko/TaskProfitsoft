package Shape;

public class Sphere extends Shape {

  public static final Double PIE = 3.14285714286;

  private Double radius;

  public Sphere(Double radius) {
    if (radius <= 0) {
      throw new RuntimeException("Radius must be positive");
    }
    this.radius = radius;

  }

  @Override
  public String toString() {
    return "Sphere{" +
        "radius= " + radius +
        ", volume= " + calcVolume() +
        '}';
  }

  @Override
  public Double calcVolume() {
    return (4.0 / 3.0) * PIE * (radius * radius * radius);
  }
}
