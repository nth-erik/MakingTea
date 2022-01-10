package makeTea4;

public class Teapot {
  double heat = 22.0;
  double flavor = 0.0;
  boolean hasWater = true;

  public double getHeat() {
    return heat;
  }

  public void addHeat(double addedHeat) {
    System.out.println("Heating " + this.getClass().getName() + ": " + addedHeat);
    heat += addedHeat;
  }

  public void removeHeat(double removedHeat) {
    System.out.println("Cooling "  + this.getClass().getName() + ": " + removedHeat);
    heat -= removedHeat;
  }

  public double getFlavor() {
    return flavor;
  }

  public void addFlavor(double addedFlavor) {
    System.out.println("Adding flavor to " + this.getClass().getName() + ": " + addedFlavor);
    flavor += addedFlavor;
  }
}
