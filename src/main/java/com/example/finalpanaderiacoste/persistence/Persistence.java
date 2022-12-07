package com.example.finalpanaderiacoste.persistence;

import com.example.finalpanaderiacoste.model.Product;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Persistence {

    public static final String RUTA_ARCHIVO_PRODUCTOS= "src/main/java/com/example/finalpanaderiacoste/persistence/data/products.txt";

    public static void saveUsers(ArrayList<Product> productArrayList) throws IOException {

        String content = "";

        for(Product product : productArrayList) {

            content+= product.getName() + "@" +
                    product.getAmount() + "@" + product.getPrice()
                    + "@" + product.getId() + "@" + product.getUrlImage()
            + "\n"
            ;

        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_PRODUCTOS , content, false);
    }

    public static ArrayList<Product> loadProducts() throws FileNotFoundException, IOException {

        ArrayList<Product> productArrayList = new ArrayList<>();

        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_PRODUCTOS);
        String linea = "";

        for (int i = 0;i<contenido.size(); i++) {
            Product myProduct = new Product();
            linea = contenido.get(i);
            myProduct.setName(linea.split("@")[0]);
            myProduct.setAmount( Integer.parseInt(linea.split("@")[1]));
            myProduct.setPrice(Double.parseDouble(linea.split("@")[2]));
            myProduct.setId(linea.split("@")[3]);
            myProduct.setUrlImage(linea.split("@")[4]);

            productArrayList.add(myProduct);
        }

        return productArrayList;
    }
}
