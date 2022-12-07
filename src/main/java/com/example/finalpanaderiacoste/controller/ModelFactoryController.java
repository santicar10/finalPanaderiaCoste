package com.example.finalpanaderiacoste.controller;

import com.example.finalpanaderiacoste.services.impl.ModelFactoryControllerService;
import com.example.finalpanaderiacoste.services.impl.PanaderiaCoste;

public class ModelFactoryController extends ModelFactoryControllerService {

    public PanaderiaCoste panaderiaCoste;
    private static class SingletonHolder{
        private final static  ModelFactoryController eINSTANCE  = new ModelFactoryController();
    }
    public static ModelFactoryController getInstance(){
        return SingletonHolder.eINSTANCE;
    }
    public ModelFactoryController(){
        panaderiaCoste = new PanaderiaCoste();
    }
}
