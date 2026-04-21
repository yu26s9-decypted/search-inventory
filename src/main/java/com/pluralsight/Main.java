import com.pluralsight.Product;

import static com.pluralsight.ui.Console.scanner;

public static void main(String[] arg) throws IOException {
    String fileName = "src/main/java/com/pluralsight/data/product.txt";
    FileReader fileReader = new FileReader(fileName);
    BufferedReader bufferedReader = new BufferedReader(fileReader);

    String product;
    while((product = bufferedReader.readLine()) != null ){
        String[] productData = product.split("\\|");
        int productId = Integer.parseInt(productData[0]);
        String productName = productData[1];
        double productPrice = Double.parseDouble(productData[2]);
        Product p = new Product(productId, productName, productPrice);



        int userInput = productMenuSystem();

        while (userInput != 5){
            switch (userInput) {
                case 1:
                    break;
                case 2:
                //TODO
                    break;
                case 3:
                //TODO
                    break;
                case 4:
                    break;
                //TODO
                case 5:
                    System.out.println("Thank you have a nice day!");
                    break;

            }
        }
    }



}

//   Product Menu System

public static int productMenuSystem() {
    boolean validInput = false;
    int input = 0;
    while (!validInput) {
        try {
            System.out.println("What do you want to do?\n" +
                    "1 - List all product\n" +
                    "2 - Lookup product by Id\n" +
                    "3 - Find all product within a price range" +
                    "4 - Add a new product\n" +
                    "5 - Quit application\n" +
                    "Enter your command:"

            );

            input = scanner.nextInt();
            scanner.nextLine();
            validInput = true;

        } catch (InputMismatchException e) {
            System.out.println("Sorry that is not a valid input. Please try again");
            scanner.nextLine();


        }
    }
    return input;
}

