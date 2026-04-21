package com.pluralsight.data;

import com.pluralsight.Product;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProductLoader {
   public static ArrayList<Product> loadProduct() throws IOException {
       String fileName = "src/main/java/com/pluralsight/data/product.txt";
       FileReader fileReader = new FileReader(fileName);
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
}

