import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Map;
import java.util.Scanner;

public class FilHandler {

    public static void writeToFile(TelefonListe liste) throws IOException {
        BufferedWriter out =new BufferedWriter(new FileWriter("src/telefonListe"));

        for (Map.Entry<String, String> m : liste.entrySet()) {
            out.write(liste.toPrint(m.getKey(), m.getValue()));
        }
        out.close(); // Ensure proper closing
    }

    public static TelefonListe readFromFile()throws IOException {
        TelefonListe liste = new TelefonListe();
        File telefonListe = new File("src/telefonListe");
        Scanner scan = new Scanner(telefonListe);
        while (scan.hasNextLine()) {
            String[] telefonData = scan.nextLine().split(":");
            String name = telefonData[0];
            String telefonNb = telefonData[1];
            liste.addPerson(name, telefonNb);
        }
        return liste;
    }//end of TelefonListe

}
