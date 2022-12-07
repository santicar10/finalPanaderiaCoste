package com.example.finalpanaderiacoste.validations;

import com.example.finalpanaderiacoste.exceptions.ProductException;
import com.example.finalpanaderiacoste.model.Product;

import java.util.ArrayList;

public class CreateProductValidation {

    public static void verifyId(String id, ArrayList<Product> arrayList) throws ProductException {
        for(Product product : arrayList){
            if(product.getId().equals(id)) throw new ProductException("Ya existe un producto con ese id");
        }
    }
}
