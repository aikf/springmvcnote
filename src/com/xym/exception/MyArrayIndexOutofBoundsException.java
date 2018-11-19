package com.xym.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @ClassName MyArrayIndexOutofBoundsException
 * @Description TODO
 * @Author ak
 * @Date 2018/11/19 下午6:15
 * @Version 1.0
 **/

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "数组越界")
public class MyArrayIndexOutofBoundsException extends Exception{
}