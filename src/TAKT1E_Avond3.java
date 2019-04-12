public class TAKT1E_Avond3 {

  public static final String VOORNAAM = "Voornaam";
  public static final String VOORVOEGSEL = "Voorvoegsel";
  public static final String ACHTERNAAM = "Achternaam";
  public static final String GEBOORTEDATUM = "Geboortedatum";
  public static final String GEBOORTEJAAR = "Geboortejaar";
  public static final String GESLACHT = "Geslacht";
  public static final String MAN = "M";
  public static final String VROUW = "V";

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

    printPersonenOverzicht(persoon);

    while (counter < maximum) {
      int geboortejaar = Integer.parseInt(leesVeld(persoon, counter, GEBOORTEJAAR));
      System.out.println("Het geboortejaar is: " + geboortejaar);
      int hulpjaar = geboortejaar;

      int aantalMannen = 0;
      int aantalVrouwen = 0;
      int rest = 0;

      while (counter < maximum && Integer.parseInt(leesVeld(persoon, counter, GEBOORTEJAAR)) == hulpjaar) {
        switch (leesVeld(persoon, counter, GESLACHT)) {
          case MAN:
            aantalMannen++;
            totaalMannen++;
            break;
          case VROUW:
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
      printRondeOverzicht(aantalMannen, aantalVrouwen, rest);
    }
    printTotaaloverzicht(totaalMannen, totaalVrouwen, totaalRest);
  }

  private static void printPersonenOverzicht(String[] persoon) {
    System.out.println("--- Personenoverzicht ---");
    for (int i = 0; i < persoon.length; i++) {
      String persoonsnummer = String.valueOf(i + 1);
      String naam = aanhefKeuze(persoon, i) + " " + leesVeld(persoon, i, VOORNAAM) + " " + leesVeld(persoon, i, VOORVOEGSEL) + " " + leesVeld(persoon, i, ACHTERNAAM);

      System.out.println("Persoon " + persoonsnummer + " :");
      System.out.println(naam);
      System.out.println("Geboren op: " + leesVeld(persoon, i, GEBOORTEDATUM));
      System.out.println("---------------");
    }
  }

  public static String aanhefKeuze(String[] persoon, int i) {
    String aanhef;
    switch (leesVeld(persoon, i, GESLACHT)) {
      case MAN:
        return aanhef = "Dhr.";
      case VROUW:
        return aanhef = "Mevr.";
      default:
        return aanhef = "";
    }
  }

  public static String leesVeld(String[] persoon, int index, String persoonsData) {
    String[] splitsRegel = persoon[index].split(";", -1);
    String[] achternaamVoorvoegsel = splitsRegel[2].split(",", -1);

    String geboortedatum = splitsRegel[0];
    String geboortejaar = splitsRegel[0].substring(6);
    String geslacht = splitsRegel[1].toUpperCase();
    String voornaam = splitsRegel[3];
    String achternaam;
    String voorvoegsel;

    if (achternaamVoorvoegsel.length < 2) {
      achternaam = achternaamVoorvoegsel[0].trim();
      voorvoegsel = "";
    } else {
      achternaam = achternaamVoorvoegsel[0].trim();
      voorvoegsel = achternaamVoorvoegsel[1].trim();
    }

    switch (persoonsData) {
      case GEBOORTEDATUM:
        return geboortedatum;
      case GEBOORTEJAAR:
        return geboortejaar;
      case GESLACHT:
        return geslacht;
      case VOORNAAM:
        return voornaam;
      case VOORVOEGSEL:
        return voorvoegsel;
      case ACHTERNAAM:
        return achternaam;
      default:
        throw new IllegalStateException("Geen geldige persoonsdata gekozen");
    }
    }

  private static void printRondeOverzicht(int aantalMannen, int aantalVrouwen, int rest) {
    System.out.println("Aantal mannen: " + aantalMannen);
    System.out.println("Aantal vrouwen: " + aantalVrouwen);
    System.out.println("Aantal onbekend: " + rest);
  }

  private static void printTotaaloverzicht(int totaalMannen, int totaalVrouwen, int totaalRest) {
    int totaalPersonen = totaalMannen + totaalVrouwen + totaalRest;
    System.out.println("--- Totalen ---");
    System.out.println("Totaal aantal mannen: " + totaalMannen);
    System.out.println("Totaal aantal vrouwen: " + totaalVrouwen);
    System.out.println("Totaal aantal onbekend: " + totaalRest);
    System.out.println("---------------");
    System.out.println("Totaal aantal personen: " + totaalPersonen);
  }
}