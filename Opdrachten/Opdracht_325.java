import java.io.*;

public class Opdracht_325 {

  public static void main(String[] args) throws IOException {

    BufferedReader reader;
    reader = new BufferedReader(new FileReader("Opdrachten/src/input.txt"));
    BufferedWriter writer = new BufferedWriter(new FileWriter("Opdrachten/src/output.txt"));
    String regel = reader.readLine();

    int totaalMannen = 0;
    int totaalVrouwen = 0;
    int totaalRest = 0;

    while (regel != null) {
      int geboortejaar = Integer.parseInt(getGeboortejaar(regel));
      writer.write("Het geboortejaar is: " + geboortejaar);
      writer.newLine();

      int hulpjaar = geboortejaar;
      int aantalMannen = 0;
      int aantalVrouwen = 0;
      int rest = 0;

      while (regel != null && Integer.parseInt(getGeboortejaar(regel)) == hulpjaar) {
        switch (getGeslacht(regel)) {
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
        regel = reader.readLine();
      }
      writer.write("Aantal mannen: " + aantalMannen);
      writer.newLine();
      writer.write("Aantal vrouwen: " + aantalVrouwen);
      writer.newLine();
      writer.write("Aantal onbekend: " + rest);
      writer.newLine();
    }
    int totaalPersonen = totaalMannen + totaalVrouwen + totaalRest;
    writer.write("--- Totalen ---");
    writer.newLine();
    writer.write("Totaal aantal mannen: " + totaalMannen);
    writer.newLine();
    writer.write("Totaal aantal vrouwen: " + totaalVrouwen);
    writer.newLine();
    writer.write("Totaal aantal onbekend: " + totaalRest);
    writer.newLine();
    writer.write("---------------");
    writer.newLine();
    writer.write("Totaal aantal personen: " + totaalPersonen);

    reader.close();
    writer.close();
  }

  public static String getGeboortejaar(String regel) {
    String[] splitsregel = regel.split(";");
    return splitsregel[0].substring(6);
  }

  public static String getGeslacht(String regel) {
    String[] splitsregel = regel.split(";");
    return splitsregel[1].toUpperCase();
  }
}
