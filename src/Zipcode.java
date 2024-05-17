import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Zipcode {
    public static void main (String[] args) throws IOException, InterruptedException{

        Scanner scanner = new Scanner(System.in);
        System.out.printf("Inform your postal code: ");
        int zipcode = scanner.nextInt();
        try {
            String address = "https://viacep.com.br/ws/" + zipcode + "/json/";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(address))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            FileWriter writer = new FileWriter("zipcode.json");
            writer.write(json);
            writer.close();
        }catch (IllegalArgumentException e) {
            System.out.println("Error: ");
            System.out.println(e.getMessage());
        }catch (IOException e) {
            System.out.println("Error: ");
            System.out.println(e.getMessage());
        }catch (InterruptedException e) {
            System.out.println("Error: ");
            System.out.println(e.getMessage());
        }
    }
}