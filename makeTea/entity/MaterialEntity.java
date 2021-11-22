package makeTea.entity;

public abstract class MaterialEntity implements MaterialInterface {
  protected String name = "Unnamed";
  protected double temperature = Double.NaN;
  private double unitDissipation = Double.NaN;

  // Simple setters
  protected void setUnitDissipation(double unitDissipation) {
    this.unitDissipation = unitDissipation;
  }

  // Simple getters
  public String getName() {
    return this.name;
  }
  public double getTemperature() {
    return this.temperature;
  }
  public double getUnitDissipation() {
    return this.unitDissipation;
  }

  // Constructors
  public MaterialEntity(String name, double temperature, double unitDissipation) {
    this.name = name;
    this.temperature = temperature;
    this.setUnitDissipation(unitDissipation);
    System.out.println(name + " created with " + temperature + " C, " + unitDissipation + " C/m2/s");
  };
}
