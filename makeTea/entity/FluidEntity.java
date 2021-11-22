package makeTea.entity;

public abstract class FluidEntity extends MaterialEntity {
  // Simple getters
  @Override
  public double getArea() {
    // creates area by wrapping around solid objects
    return Double.MAX_VALUE;
  }
  @Override
  public double getArea(MaterialSideEnum side) {
    // creates area by wrapping around solid objects
    return Double.MAX_VALUE;
  }

  public FluidEntity(String name, double temperature, double unitDissipation) {
    super(name, temperature, unitDissipation);
  }
}
