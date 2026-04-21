import com.pluralsight.Product;
import com.pluralsight.data.ProductLoader;
import com.pluralsight.ui.Console;

import static com.pluralsight.ui.Console.askForDouble;
import static com.pluralsight.ui.Console.scanner;
import java.io.*;

public static void main(String[] arg) throws IOException {
        ArrayList<Product> products = ProductLoader.loadProduct();

        int userInput = productMenuSystem();

        while (true){
            switch (userInput) {
                case 1:
                    listAllProduct(products);
                    break;
                case 2:
                    findProductById(products);

                    break;
                case 3:
                    findProductByWithinPriceRange(products);
                    break;
                case 4:
                    break;
                //TODO
                case 5:
                    System.out.println("Thank you have a nice day!");
                    return;
                default:
                    System.out.printf("Invalid option, please try again. \n");

            }
                userInput = productMenuSystem();
        }

    }





//   Product Menu System

public static int productMenuSystem() {
    System.out.println("What do you want to do?\n" +
        "1 - List all product\n" +
        "2 - Lookup product by Id\n" +
        "3 - Find all product within a price range \n" +
        "4 - Add a new product \n" +
        "5 - Quit application \n");

    return Console.askForInt("Please enter a command:");



}

public static void listAllProduct(ArrayList<Product> products){
    displayProduct(products);

}

public static void displayProduct(ArrayList<Product> products){
    for(int i = 0; i < products.size(); i++){
        Product p = products.get(i);
        System.out.printf("%d %s $%.2f\n", p.getProductId(), p.getProductName(), p.getProductPrice());
    }
}

public static void findProductById(ArrayList<Product> products){
    int askId = Console.askForInt("What is the product id?");

    for (Product p : products) {
        if (p.getProductId() == askId) {
            System.out.printf("Found: [ID: %d] [PRODUCT: %s] [RETAIL PRICE: $%.2f]\n", p.getProductId(), p.getProductName(), p.getProductPrice());
            return;
        }

    }
    System.out.printf("Cannot find a product with this id. \n");

}

public static ArrayList<Product> findProductByWithinPriceRange(ArrayList<Product> products) {
    double askMinPrice = askForDouble("What's the minimum price");
    double askMaxPrice = askForDouble("What's the maximum price");

    ArrayList<Product> matchingItems = new ArrayList<>();

    for(Product p : products) {

        if (askMaxPrice > (p.getProductPrice()) && askMinPrice < (p.getProductPrice())){
            matchingItems.add(p);
        }

    }

    if(matchingItems.isEmpty()) {
        System.out.printf("No item found within your price range");
    }
    System.out.println("Found " + matchingItems.size() + (matchingItems.size() == 1 ? " result." : " results." ));
    displayProduct(matchingItems);
    return matchingItems;
}
