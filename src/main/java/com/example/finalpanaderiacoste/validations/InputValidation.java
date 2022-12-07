package com.example.finalpanaderiacoste.validations;

import com.example.finalpanaderiacoste.exceptions.InputException;

public class InputValidation {

    static  public  void isInputFilled(String input) throws InputException {
        if(input.trim().equals("")) throw new InputException("Campos vacios");
    }

    static public void verifyInputNumerical (String input) throws  InputException{
        try {
            Integer.parseInt(input);
        }catch (NumberFormatException err){
            throw new InputException("Campo numerico no valido");
        }
    }
}
