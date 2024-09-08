import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TelefonListe {
    Map<String, String> telefonBook = new HashMap<>();

    public void addPerson (String name, String telefonNb){
        telefonBook.put(name, telefonNb);
    }

    public Set<Map.Entry<String, String>> entrySet() {
        return telefonBook.entrySet();
    }

    public String toPrint(String key, String value) {
        return (key + ":" + value + "\n");
    }

    public void deletePerson(String name) {
        telefonBook.remove(name);
    }

    public String getTelefonNb (String name){
        return telefonBook.get(name);
    }

}

