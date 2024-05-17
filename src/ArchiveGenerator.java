import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class ArchiveGenerator {
    public void generator(Endereco endereco) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileWriter writer = new FileWriter("zipcode.json");
            writer.write(gson.toJson(endereco));
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: ");
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
        }
    }
}
