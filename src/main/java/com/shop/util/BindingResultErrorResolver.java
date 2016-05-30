package com.shop.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * Created by yuan on 16-5-28.
 */
public class BindingResultErrorResolver {

    public static String getErrorFromBindingResult(BindingResult bindingResult){
        String error="";
        List<ObjectError> errors=bindingResult.getAllErrors();
        if(errors.isEmpty())
            return error;
        ObjectError objectError=errors.get(0);
        error=objectError.getDefaultMessage();
        return error;
    }
}
