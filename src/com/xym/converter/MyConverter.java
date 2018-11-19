package com.xym.converter;

import com.xym.entities.Student;
import org.springframework.core.convert.converter.Converter;

/**
 * @ClassName MyConverter
 * @Description TODO
 * @Author ak
 * @Date 2018/11/19 上午10:11
 * @Version 1.0
 **/
public class MyConverter implements Converter<String,Student> {
    @Override
    public Student convert(String source) {
        Student student = new Student();
        String[] stuArr = source.split("-");
        student.setId(Integer.parseInt(stuArr[0]));
        student.setName(stuArr[1]);
        student.setAge(Integer.parseInt(stuArr[2]));
        return student;
    }
}