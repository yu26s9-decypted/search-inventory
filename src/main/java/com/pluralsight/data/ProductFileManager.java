package com.pluralsight.data;

import com.pluralsight.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ProductFileManager {

    private String productsFilename;

    public ProductFileManager(String productsFilename) {
        this.productsFilename = productsFilename;
    }

    public String getProductsFilename() {
        return productsFilename;
    }

    public void setProductsFilename(String productsFilename) {
        this.productsFilename = productsFilename;
    }

    public ArrayList<Product> loadProduct() throws IOException {
        //String fileName = "src/main/java/com/pluralsight/data/product.txt";
        FileReader fileReader = new FileReader(this.productsFilename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<Product> products = new ArrayList<>();

        String product;

        while((product = bufferedReader.readLine()) != null ) {
            String[] productData = product.split("\\|");
            int productId = Integer.parseInt(productData[0]);
            String productName = productData[1];
            double productPrice = Double.parseDouble(productData[2]);
            Product p = new Product(productId, productName, productPrice);
            products.add(p);
        }

        bufferedReader.close();
        return products;
    }


    public void writeProduct(Product product) throws IOException {
       // String fileName = "src/main/java/com/pluralsight/data/product.txt";
        FileWriter fileWriter = new FileWriter(this.productsFilename, true);

        String formattedLine = product.getProductId() + "|" +
                product.getProductName() + "|" +
                product.getProductPrice() + "\n";

        fileWriter.write(formattedLine);
        fileWriter.close();
    }

}
