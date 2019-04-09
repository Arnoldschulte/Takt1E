public class TAKT1E_Avond2 {

  public static void main(String[] args) {

    int[] geboortejaar = {1954, 1958, 1958, 1963, 1963, 1963, 1964, 1970, 1970, 1970};
    String[] geslacht = {"V", "M", "V", "m", "v", "V", "?", "v", "v", "m"};

    int loopTeller = 0;
    int totaalMannen = 0;
    int totaalVrouwen = 0;

    while (loopTeller < geboortejaar.length) {
      System.out.println("Het geboortejaar is: " + geboortejaar[loopTeller]);
      int hulpjaar = geboortejaar[loopTeller];

      int mannenPerJaar = 0;
      int vrouwenPerJaar = 0;

      while (loopTeller < geboortejaar.length && geboortejaar[loopTeller] == hulpjaar) {
        if (geslacht[loopTeller].equalsIgnoreCase("M")) {
          mannenPerJaar++;
          totaalMannen++;
        } else if (geslacht[loopTeller].equalsIgnoreCase("V")) {
          vrouwenPerJaar++;
          totaalVrouwen++;
        } else {
          System.out.println("Onbekend geslacht: " + geboortejaar[loopTeller]);
        }
        loopTeller++;
      }
      System.out.println("Aantal mannen: " + mannenPerJaar);
      System.out.println("Aantal vrouwen: " + vrouwenPerJaar);
    }
    System.out.println("--- Totalen ---");
    System.out.println("Totaal aantal mannen: " + totaalMannen);
    System.out.println("Totaal aantal vrouwen: " + totaalVrouwen);
  }
}