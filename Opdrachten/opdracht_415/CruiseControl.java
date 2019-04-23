package opdracht_415;

public class CruiseControl {
  public static void main(String[] args) {
    Auto mijnAuto = new Auto();
    mijnAuto.setGewensteSnelheid(100);

    while (mijnAuto.getActueleSnelheid() > mijnAuto.getGewensteSnelheid()) {
      mijnAuto.verlaagActueleSnelheid(1);
    }
  }
}
