public class Opdracht_316 {

  public static void main(String[] args) {

    String[] persoon = new String[10];
    persoon[0] = "24-08-1954;V; Dijk, van;Maria";
    persoon[1] = "02-03-1958;M; Groot, de;Jacob";
    persoon[2] = "17-06-1958;V; Winters;Felicia";
    persoon[3] = "12-01-1963;m; Swinkels;Mark";
    persoon[4] = "31-07-1963;v;Deutekom, van ;Lilian";
    persoon[5] = "05-11-1963;V; Jacht, van der ;Jolanda";
    persoon[6] = "19-08-1964;?; Puffelen,van;";
    persoon[7] = "22-05-1970;v; Dietvorst;Wilma";
    persoon[8] = "01-06-1970;v; Boogerts,den;Ester";
    persoon[9] = "19-09-1970;m; Konincks;Sven";

    int totaalMannen = 0;
    int totaalVrouwen = 0;
    int totaalRest = 0;
    int counter = 0;
    int maximum = persoon.length;

    while (counter < maximum) {
      int geboortejaar = Integer.parseInt(leesVeld(persoon, counter, "Geboortejaar"));
      System.out.println("Het geboortejaar is: " + geboortejaar);
      int hulpjaar = geboortejaar;

      int aantalMannen = 0;
      int aantalVrouwen = 0;
      int rest = 0;

      while (counter < maximum && Integer.parseInt(leesVeld(persoon, counter, "Geboortejaar")) == hulpjaar) {
        switch (leesVeld(persoon, counter, "Geslacht")) {
          case "M":
            aantalMannen++;
            totaalMannen++;
            break;
          case "V":
            aantalVrouwen++;
            totaalVrouwen++;
            break;
          default:
            rest++;
            totaalRest++;
            break;
        }
        counter++;
      }
      System.out.println("Aantal mannen: " + aantalMannen);
      System.out.println("Aantal vrouwen: " + aantalVrouwen);
      System.out.println("Aantal onbekend: " + rest);
    }
    int totaalPersonen = totaalMannen + totaalVrouwen + totaalRest;
    System.out.println("--- Totalen ---");
    System.out.println("Totaal aantal mannen: " + totaalMannen);
    System.out.println("Totaal aantal vrouwen: " + totaalVrouwen);
    System.out.println("Totaal aantal onbekend: " + totaalRest);
    System.out.println("---------------");
    System.out.println("Totaal aantal personen: " + totaalPersonen);
  }

  public static String leesVeld(String[] persoon, int index, String persoonsData) {
    String[] splitsRegel = persoon[index].split(";", -1);

    String geboortejaar = splitsRegel[0].substring(6);
    String geslacht = splitsRegel[1].toUpperCase();

    switch (persoonsData) {
      case "Geboortejaar":
        return geboortejaar;
      case "Geslacht":
        return geslacht;
      default:
        throw new IllegalStateException("Geen geldige persoonsdata gekozen");
    }
  }
}
