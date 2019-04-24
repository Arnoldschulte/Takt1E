package opdracht_415;

public class Auto {

  private int actueleSnelheid = 130;
  private int gewensteSnelheid = 0;

  public Auto() {
    //    default constructor
  }

  public Auto(int actueleSnelheid) {
    this.actueleSnelheid = actueleSnelheid;
  }

  public Auto(int actueleSnelheid, int gewensteSnelheid) {
    this.actueleSnelheid = actueleSnelheid;
    this.gewensteSnelheid = gewensteSnelheid;
  }

  public int getActueleSnelheid() {
    return actueleSnelheid;
  }

  public void setActueleSnelheid(int actueleSnelheid) {
    this.actueleSnelheid = actueleSnelheid;
  }

  public int getGewensteSnelheid() {
    return gewensteSnelheid;
  }

  public void setGewensteSnelheid(int gewensteSnelheid) {
    this.gewensteSnelheid = gewensteSnelheid;
  }

  public void verlaagActueleSnelheid(int waarde) {
    this.actueleSnelheid = this.actueleSnelheid - waarde;
    System.out.println("De actuele snelheid is verlaagd naar " + this.actueleSnelheid + " km/h");
  }
}
