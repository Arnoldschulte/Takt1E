public class Opdracht316 {
  //
// Het programma moet hetzelfde resultaat geven als het programma uit de vorige opgave.
//
// In het kort:
// 1) op het beeldscherm per regel tonen van het geboortejaar
// met het bijbehorend aantal mannen en aantal vrouwen
// 2) vervolgens afsluiten met een regel waarin
// het totaal aantal personen, totaal aantal mannen en totaal aantal vrouwen staat vermeld.
//
// Maak gebruik van de array persoon en initieer deze met de opgegeven waarden
// zoals die zijn vermeld in eerder vermelde tabel.
//
// Zoek uit wat de functie split voor je kan doen
//
// In het select-instructieblok mogen naast de else-tak
// slechts twee case-takken worden opgenomen
// waarbij elke case slechts gebruik maakt van één constante waarde.
//
//  Voor het initiëren van de variabelen geboortejaar en geslacht
//  wordt de functie leesVeld gebruikt.
//
//  Inputvariabelen van deze functie zijn ondermeer de array persoon en de index.
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

      int aantalMannen = 0;
      int aantalVrouwen = 0;
      int rest = 0;

      while (counter < maximum && geboortejaar == hulpjaar) {
        switch (geslacht.toUpperCase()) {
          case "M":
            aantalMannen++;
            totaalMannen++;
            counter++;
            break;
          case "V":
            aantalVrouwen++;
            totaalVrouwen++;
            counter++;
            break;
          default:
            rest++;
            totaalRest++;
            counter++;
            break;
        }
      }
      System.out.println("testmannen" + aantalVrouwen);
    }
  }

  public static String[] leesVeld(String[] persoon, int index) {
    //      splits regel, bepaal jaar en geslacht
    String[] splitsRegel = persoon[index].split(";");
    String geboortedatumRegel = splitsRegel[0];
    String geboortejaar = geboortedatumRegel.substring(6);
    String geslacht = splitsRegel[1];
    String[] geboortejaarGeslacht = {geboortejaar, geslacht};
    return geboortejaarGeslacht;
  }
}
