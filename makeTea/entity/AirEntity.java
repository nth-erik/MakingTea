package makeTea.entity;

public final class AirEntity extends FluidEntity {
  private static final String NAME = "Air";

  // Simple setters
  @Override
  public void setTemperature(double temperature) {
    //System.out.print(this.getName() + ": " + this.getTemperature() + " C\t");
  }

  // Constructors
  public AirEntity(double temperature, double unitDissipation) {
    super(AirEntity.NAME, temperature, unitDissipation);
  }
}
