package makeTea.entity;

public class WaterEntity extends FluidEntity {
  private static final String NAME = "Water";

  // Simple setters
  @Override
  public void setTemperature(double temperature) {
    //System.out.print(this.getName() + ": " + temperature + " C\t");
    this.temperature = temperature;
  }

  // Constructors
  public WaterEntity(double temperature, double unitDissipation) {
    super(WaterEntity.NAME, temperature, unitDissipation);
  }
}
