package eindtoets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Opdracht_510 {

  public static final String PAD_INPUT_BESTAND = "Opdrachten/eindtoets/src/personen.txt";

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(PAD_INPUT_BESTAND));
    String regel = reader.readLine();

    OptellenRaporteren optellenRaporteren = new OptellenRaporteren();

    while (regel != null) {
      optellenRaporteren.schrijfGeboortejaar(getGeboortejaar(regel));
      optellenRaporteren.resetTellingen();
      int hulpjaar = getGeboortejaar(regel);

      while (regel != null && getGeboortejaar(regel) == hulpjaar) {
        optellenRaporteren.tellingPerJaar(getGeslacht(regel));
        regel = reader.readLine();
      }
      optellenRaporteren.schrijfTellingenGeboortejaar();
    }
    optellenRaporteren.schrijfTellingenTotaal(reader);
  }

  public static int getGeboortejaar(String regel) {
    String[] splitsregel = regel.split(";");
    return Integer.parseInt(splitsregel[0].substring(6));
  }

  public static String getGeslacht(String regel) {
    String[] splitsregel = regel.split(";");
    return splitsregel[1].toUpperCase();
  }
}