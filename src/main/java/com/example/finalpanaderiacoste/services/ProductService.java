package com.example.finalpanaderiacoste.services;

import com.example.finalpanaderiacoste.exceptions.ProductException;
import com.example.finalpanaderiacoste.model.Product;

import java.security.cert.PolicyNode;
import java.util.ArrayList;

public interface ProductService {

    void addProduct(String name, int amount, double price, String id, String urlImage) throws ProductException;
    void startProducts ();
     ArrayList<Product> getProductArrayList();
     void editProduct(Product product,  int amount, double price, String urlImage);

     Product searchProductById(String id) throws ProductException;

     void deleteProduct(String id) throws ProductException;

     void restAmounts(ArrayList<Product> arrayListProducts);






}
