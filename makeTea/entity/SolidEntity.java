package makeTea.entity;

public abstract class SolidEntity extends MaterialEntity {
  private double width = 0;
  private double length = 0;
  private double height = 0;

  // Simple setters
  protected void setWidth(double width) {
    this.width = Math.abs(width);
  }
  protected void setLength(double length) {
    this.length = Math.abs(length);
  }
  protected void setHeight(double height) {
    this.height = Math.abs(height);
  }
  @Override
  public void setTemperature(double temperature) {
    //System.out.print(this.getName() + ": " + temperature + " C\t");
    this.temperature = temperature;
  }

  // Simple getters
  protected double getWidth() {
    return this.width;
  }
  protected double getLength() {
    return this.length;
  }
  protected double getHeight() {
    return this.height;
  }

  // Derived getters
  @Override
  public double getArea() {
    return (
      this.width * this.length +
      this.width * this.height +
      this.length * this.height
    ) * 2;
  }
  @Override
  public double getArea(MaterialSideEnum side) {
    switch (side) {
      case RIGHT:
      case LEFT:
        return this.length * this.height;
      case FRONT:
      case REAR:
        return this.width * this.height;
      case TOP:
      case BOTTOM:
        return this.width * this.length;
      default:
        return this.getArea();
    }
  }

  // Constructors
  public SolidEntity(String name, double temperature, double unitDissipation) {
    super(name, temperature, unitDissipation);
  }
  public SolidEntity(String name, double temperature, double unitDissipation, double edgeLength) {
    super(name, temperature, unitDissipation);
    this.setWidth(edgeLength);
    this.setLength(edgeLength);
    this.setHeight(edgeLength);
  }
  public SolidEntity(String name, double temperature, double unitDissipation, double sideLength, double height) {
    super(name, temperature, unitDissipation);
    this.setWidth(sideLength);
    this.setLength(sideLength);
    this.setHeight(height);
  }
}
