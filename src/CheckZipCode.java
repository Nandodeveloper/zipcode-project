import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.*;

public class CheckZipCode{

    public Endereco findZipCode(int zipcode) {
            String address = "https://viacep.com.br/ws/" + zipcode + "/json/";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(address))
                    .build();
            HttpResponse<String> response = null;
            try{
                    response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            FileWriter writer = new FileWriter("zipcode.json");
            writer.write(json);
            writer.close();
        }catch(IOException | InterruptedException e) {
            System.out.println("Error: ");
            System.out.println(e.getMessage());
        }
        return new Gson().fromJson(response.body(), Endereco.class);
    }
}
