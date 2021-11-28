package makeTea2.input;

import java.util.Scanner;

public class Input {
  private Scanner scanner;

  public Input() {
    scanner = new Scanner(System.in);
  }

  public void close() {
    this.scanner.close();
  }

  public double prompt(String message) {
    double n = Double.NaN;
    while(n == Double.NaN) {
      System.out.print(message + " ");
      n = scanner.nextDouble();
      scanner.nextLine();
    }
    return n;
  }
}
