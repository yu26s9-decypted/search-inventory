package com.pluralsight.data;

import com.pluralsight.Product;

import java.io.FileWriter;
import java.io.IOException;

public class ProductWriter {
    public static void writeProduct(Product product) throws IOException {
        String fileName = "src/main/java/com/pluralsight/data/product.txt";
        FileWriter fileWriter = new FileWriter(fileName, true);

        String formattedLine = product.getProductId() + "|" +
                product.getProductName() + "|" +
                product.getProductPrice() + "\n";

        fileWriter.write(formattedLine);
        fileWriter.close();
    }
}
