import com.pluralsight.Product;
import com.pluralsight.data.ProductLoader;
import com.pluralsight.data.ProductWriter;
import com.pluralsight.ui.Console;

import java.io.*;

import static com.pluralsight.ui.Console.*;

public static void main(String[] arg) throws IOException {
        ArrayList<Product> products = ProductLoader.loadProduct();

        String productSystemMenuMsg = """
            What do you want to do?
            1 - List all product
            2 - Lookup product by Id
            3 - Find all product within a price range
            4 - Add a new product
            5 - Quit application
            """;

        while (true){
            System.out.println(productSystemMenuMsg);
            int userInput = productMenuSystem();

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
                    addNewProduct(products);
                    break;
                case 5:
                    System.out.println("Thank you have a nice day!");
                    return;
                default:
                    System.out.printf("Invalid option, please try again. \n");

            }

        }

    }





//   Product Menu System

public static int productMenuSystem() {
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

        if (askMaxPrice >= (p.getProductPrice()) && askMinPrice <= (p.getProductPrice())){
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

public static void addNewProduct(ArrayList<Product> products) {
    int addNewProductId = askForInt("What's the product id: ");
    String addNewProductName = askForString("What's the product name: ");
    double addNewProductPrice = askForDouble("What's the price of this product: ");
    Product addNewProduct = new Product(addNewProductId, addNewProductName, addNewProductPrice);
    products.add(addNewProduct);
    try {
        ProductWriter.writeProduct(addNewProduct);
    } catch (IOException e){
        System.out.println("An error occured while trying to update the product dateset." + e.getMessage() + e.getCause());

    }
    System.out.println("Product was added to the dateset.");

}
