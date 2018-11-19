package com.xym.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName MyExceptionHandler
 * @Description TODO
 * @Author ak
 * @Date 2018/11/19 下午6:00
 * @Version 1.0
 **/

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ModelAndView handlerArithmeticException2(Exception e) {
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("e", e);
        return mv;
    }
}