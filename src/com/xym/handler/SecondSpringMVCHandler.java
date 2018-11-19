package com.xym.handler;

import com.xym.exception.MyArrayIndexOutofBoundsException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @ClassName SecondSpringMVCHandler
 * @Description TODO
 * @Author ak
 * @Date 2018/11/19 下午5:05
 * @Version 1.0
 **/

@Controller
@RequestMapping("second")
public class SecondSpringMVCHandler {

    @RequestMapping("testExceptionHandler")
    public String testExceptionHandler(){
        System.out.println(1/0);
        return "success";
    }

    @RequestMapping("testExceptionHandler2")
    public String testExceptionHandler2(){
        int[] nums = new int[2];
        System.out.println(nums[3]);
        return "success";
    }

    @ExceptionHandler({ArithmeticException.class, ArrayIndexOutOfBoundsException.class})
    public ModelAndView handlerArithmeticException(Exception e) {
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("e", e);
        return mv;
    }

//    @ExceptionHandler({Exception.class})
//    public ModelAndView handlerArithmeticException2(Exception e) {
//        ModelAndView mv = new ModelAndView("error");
//        mv.addObject("e", e);
//        return mv;
//    }

    @RequestMapping("testMyException")
    public String testMyException(@RequestParam("i") Integer i) throws MyArrayIndexOutofBoundsException {
        if (i == 3) {
            throw new MyArrayIndexOutofBoundsException();
        }
        return "success";
    }

    @RequestMapping("testMyException2")
    public String testMyException2(@RequestParam("i") Integer i) {
        if (i == 3) {
            return "redirect:testResponseStatus";
        }
        return "success";
    }

    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "测试用")
    @RequestMapping("testResponseStatus")
    public String testResponseStatus(){
        return "success";
    }

}