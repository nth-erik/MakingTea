package makeTea4;

public class Air extends Thread {
  final double ROOM_HEAT = 22.0;
  final double HEAT_FRAME_POT = 0.001;
  final double HEAT_FRAME_CUP = 0.002;
  final long TIME_FRAME = 100;
  Teapot teapot = null;
  Teapot cup = null;

  public Air (Teapot newTeapot, Teapot newCup) {
    super();
    teapot = newTeapot;
    cup = newCup;
    setDaemon(true);
    start();
  }

  @Override
  public void run() {
    super.run();
    while (true) {
      if (teapot != null && teapot.getHeat() > ROOM_HEAT) {
        teapot.removeHeat(HEAT_FRAME_POT);
      }

      if (cup != null && cup.getHeat() > ROOM_HEAT) {
        cup.removeHeat(HEAT_FRAME_CUP);
      }

      try {
        sleep(TIME_FRAME);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void setContent(Teapot newKettle) {
    teapot = newKettle;
  }
}
