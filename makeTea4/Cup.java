package makeTea4;

public class Cup extends Teapot {
  TeaFilter filter;
  boolean hasWater = false;

  public Cup(TeaFilter newFilter) {
    super();
    filter = newFilter;
  }

  public void addWater(double waterHeat) {
    hasWater = true;
    heat = waterHeat;

    System.out.println("Adding water to " + this.getClass().getName() + "...");
    filter.flavorContent(this);
  }
}
