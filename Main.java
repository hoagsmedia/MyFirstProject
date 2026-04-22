import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        File myFile = new File("products.txt");

        Scanner reader = new Scanner(myFile);
        Scanner in = new Scanner(System.in);

        int totalProducts= 0;

        while (reader.hasNextLine()){
            String product = reader.next();
            totalProducts++;
            System.out.println("Product: " + product);
        }

        reader.close();

        System.out.println("Total Products: " + totalProducts);

        System.out.println("Enter a letter to search for your product:");
        String searchInput= in.nextLine().toLowerCase().trim();

        // ---- Filter Feature
        System.out.println("Your Searching for : " + searchInput);

        Scanner searchReader = new Scanner(myFile);
        boolean found = false;

        while(searchReader.hasNextLine()){
            String currentProduct = searchReader.next();
           if(currentProduct.toLowerCase().contains(searchInput)) {
               System.out.println("Found: " + currentProduct);
               found = true;
           }
        }

        if (!found) System.out.println( "Product not found" );

        searchReader.close();
        in.close();

    }
}
