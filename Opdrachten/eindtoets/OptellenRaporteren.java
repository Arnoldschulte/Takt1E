package eindtoets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OptellenRaporteren {

  public static final String PAD_OUTPUT_BESTAND = "Opdrachten/eindtoets/src/output.txt";
  private int aantalMannen;
  private int aantalVrouwen;
  private int aantalRest;
  private int totaalMannen;
  private int totaalVrouwen;
  private int totaalRest;
  private BufferedWriter writer;


  public OptellenRaporteren() throws IOException {
    this.writer = new BufferedWriter(new FileWriter(PAD_OUTPUT_BESTAND));
  }

  public void schrijfGeboortejaar(int geboortejaar) throws IOException {
    writer.write("Het geboortejaar is: " + geboortejaar);
    writer.newLine();
  }

  public void resetTellingen() {
    this.aantalMannen = 0;
    this.aantalVrouwen = 0;
    this.aantalRest = 0;
  }

  public void tellingPerJaar(String geslacht) throws IOException {
    switch (geslacht) {
      case "M":
        this.aantalMannen++;
        this.totaalMannen++;
        break;

      case "V":
        this.aantalVrouwen++;
        this.totaalVrouwen++;
        break;

      default:
        this.aantalRest++;
        this.totaalRest++;
        break;
    }
  }

  public void schrijfTellingenGeboortejaar() throws IOException {
    writer.write("Aantal mannen: " + aantalMannen);
    writer.newLine();
    writer.write("Aantal vrouwen: " + aantalVrouwen);
    writer.newLine();
    writer.write("Aantal onbekend: " + aantalRest);
    writer.newLine();
  }

  public void schrijfTellingenTotaal(BufferedReader reader) throws IOException {
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
}
