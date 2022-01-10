package makeTea4;

public class TeaFilter extends Thread {
  final double FLAVOR_FRAME = 0.001;
  final long TIME_FRAME = 100;
  Teapot cup = null;

  @Override
  public void run() {
    super.run();
    while (cup.getFlavor() < 1.0) {
      cup.addFlavor(FLAVOR_FRAME * cup.getHeat() / 100);
      System.out.println(this.getClass().getName() + " flavor: " + cup.getFlavor());

      try {
        sleep(TIME_FRAME);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    System.out.println(this.getClass().getName() + " fully flavored! " + cup.getFlavor());
  }

  public void flavorContent(Teapot newCup) {
    cup = newCup;
    setDaemon(true);
    start();
  }
}
