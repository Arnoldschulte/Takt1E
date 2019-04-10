public class TAKT1E_Avond3 {

  public static void main(String[] args) throws Exception {

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

    String test = leesVeld(persoon[0],"Geboortejaar");
    System.out.println(test);
    System.out.println(leesVeld(persoon[1],"Test"));
  }

  public static String leesVeld(String persoon, String persoonsData) throws Exception {
    String[] splitsRegel = persoon.split(";");
    switch (persoonsData) {
      case "Geboortejaar":
        return splitsRegel[0].substring(6);
      case "Geslacht":
        return splitsRegel[1].toUpperCase();
      default:
        throw new Exception("Geen geldige persoonsdata gekozen");
    }
  }
}