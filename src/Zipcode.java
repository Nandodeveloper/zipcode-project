import java.util.Scanner;

public class Zipcode {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        CheckZipCode checkZipCode = new CheckZipCode();
        System.out.println("Welcome to the zip code consultation");
        System.out.println();
        System.out.printf("Inform your postal code: ");
        int zipcode = scanner.nextInt();
        try {
            Endereco address = checkZipCode.findZipCode(zipcode);
            System.out.println(address.toString());
            ArchiveGenerator generator = new ArchiveGenerator();
            generator.generator(address);
        }catch (RuntimeException e){
            System.out.println("Error: ");
            System.out.println(e.getMessage());
        }

    }
}