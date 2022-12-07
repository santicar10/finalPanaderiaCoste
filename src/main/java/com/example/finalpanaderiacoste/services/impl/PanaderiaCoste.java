package com.example.finalpanaderiacoste.services.impl;

import com.example.finalpanaderiacoste.services.LoginService;
import com.example.finalpanaderiacoste.services.ProductService;

public class PanaderiaCoste {

    private  final LoginService loginService;
    private  final ProductService productService;


    public PanaderiaCoste() {
        loginService = new LoginImpl();
        productService = new ProductoImpl();
    }

    public LoginService getLoginService() {
        return loginService;
    }

    public ProductService getProductService() {
        return productService;
    }
}
