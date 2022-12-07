package com.example.finalpanaderiacoste.services.impl;
import com.example.finalpanaderiacoste.exceptions.ProductException;
import com.example.finalpanaderiacoste.model.Product;
import com.example.finalpanaderiacoste.persistence.Persistence;
import com.example.finalpanaderiacoste.services.ProductService;
import com.example.finalpanaderiacoste.validations.CreateProductValidation;
import java.io.IOException;
import java.util.ArrayList;

public class ProductoImpl implements ProductService {
    ArrayList<Product> productArrayList;
    @Override
    public void addProduct(String name, int amount, double price, String id, String urlImage) throws ProductException {
        CreateProductValidation.verifyId(id,productArrayList);
        productArrayList.add(new Product(name,amount,price,id,urlImage));
        saveProducts();
    }
    @Override
    public void startProducts (){
        try{
            productArrayList= Persistence.loadProducts();

        }catch (IOException err){
            System.out.println(err.getCause());
        }

    }
    public void saveProducts(){
        try{
            Persistence.saveUsers(productArrayList);
        }catch (IOException e){
            System.out.println(e.getCause());
        }

    }
    @Override
    public ArrayList<Product> getProductArrayList() {
        return productArrayList;
    }

    @Override
    public void editProduct(Product product, int amount, double price, String urlImage) {

        product.setAmount(amount);
        product.setPrice(price);
        product.setUrlImage(urlImage);
        saveProducts();

    }

    @Override
    public Product searchProductById(String id) throws ProductException {
        return productArrayList
                .stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElseThrow( ()->new ProductException("No se encontro el producto"));
    }

    @Override
    public void deleteProduct(String id) throws ProductException {
        productArrayList.remove(searchProductById(id));
        saveProducts();
    }

    @Override
    public void restAmounts(ArrayList<Product> arrayListProducts) {
        System.out.println(arrayListProducts.size());

        arrayListProducts.stream().forEach(product -> {
            product.setAmount(product.getAmount()-1);
            System.out.println("***"+ product.getName());
        });
        saveProducts();

    }


}
