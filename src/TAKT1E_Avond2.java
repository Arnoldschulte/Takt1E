public class TAKT1E_Avond2 {

  public static void main(String[] args) {

    int[] geboortejaar = {1954, 1958, 1958, 1963, 1963, 1963, 1964, 1970, 1970, 1970};
    String[] geslacht = {"V", "M", "V", "m", "v", "V", "?", "v", "v", "m"};
    int loopteller = 0;
    int mannenPerJaar = 0;
    int vrouwenPerJaar = 0;
    int onbekendGeslacht = 0;
    int totaalMannen = 0;
    int totaalVrouwen = 0;

    while (loopteller < geboortejaar.length) {
      System.out.println("Het geboortejaar is: " + geboortejaar[loopteller]);
      int hulpjaar = geboortejaar[loopteller];

      for (int i = 0; i < geboortejaar.length; i++) {
        if (hulpjaar == geboortejaar[i]) {
          if (geslacht[i].equalsIgnoreCase("M")) {
            mannenPerJaar++;
            totaalMannen++;
          } else if (geslacht[i].equalsIgnoreCase("V")) {
            vrouwenPerJaar++;
            totaalVrouwen++;
          } else {
            onbekendGeslacht++;
          }
          if (onbekendGeslacht > 0) {
            System.out.println("Onbekend geslacht: ?");
            onbekendGeslacht = 0;
          }
          loopteller++;

        } else {
//            Doe niks
        }
      }
      System.out.println("Aantal mannen: " + mannenPerJaar);
      System.out.println("Aantal vrouwen: " + vrouwenPerJaar);
      mannenPerJaar = 0;
      vrouwenPerJaar = 0;
    }
    System.out.println("--- Totalen ---");
    System.out.println("Totaal aantal mannen: " + totaalMannen);
    System.out.println("Totaal aantal vrouwen: " + totaalVrouwen);
  }
}