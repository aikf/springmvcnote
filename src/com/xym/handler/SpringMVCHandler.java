package com.xym.handler;

import com.xym.entities.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName SpringMVCHandler
 * @Description TODO
 * @Author ak
 * @Date 2018/11/18 下午5:42
 * @Version 1.0
 **/
//@SessionAttributes("student4") //在request域中存放student4同时放入session域
//@SessionAttributes(types = Student.class) //类型对象同时放入session域
@Controller
@RequestMapping("SpringMVCHandler")
public class SpringMVCHandler {

    @RequestMapping(value = "welcome", method = RequestMethod.POST, params = {"name=zs", "age!=23", "!height"})
    public String welcome(){
        return "success";
    }

    @RequestMapping(value = "head", headers = {"Accept=text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8", "Accept-Encoding=gzip, deflate, br"})
    public String head(){
        return "success";
    }

    @RequestMapping(value = "antStyle/*/test")
    public String antStyle(){
        return "success";
    }

    @RequestMapping(value = "antStyle1/**/test")
    public String antStyle1(){
        return "success";
    }

    @RequestMapping(value = "antStyle2/a?c/test")
    public String antStyle2(){
        return "success";
    }

    @RequestMapping(value = "pathVar/{name}")
    public String pathVar(@PathVariable("name") String name){
        System.out.println(name);
        return "success";
    }

    @RequestMapping(value = "testRest/{id}", method = RequestMethod.POST)
    public String testPost(@PathVariable("id") int id) {
        System.out.println("POST：增" + id);
        return "success";
    }

    @RequestMapping(value = "testRest/{id}", method = RequestMethod.GET)
    public String testGet(@PathVariable("id") int id) {
        System.out.println("GET：查" + id);
        return "success";
    }

    @RequestMapping(value = "testRest/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String testDelete(@PathVariable("id") int id) {
        System.out.println("Delete：删" + id);
        return "success";
    }

    @RequestMapping(value = "testRest/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String testPut(@PathVariable("id") int id) {
        System.out.println("PUT：改" + id);
        return "success";
    }

    @RequestMapping(value = "testParam")
    public String testParam(@RequestParam("username") String username, @RequestParam(value = "age", required = false, defaultValue = "23") Integer age) {
        System.out.println(username);
        System.out.println(age);
        return "success";
    }

    @RequestMapping("testRequestHeader")
    public String testRequestHeader(@RequestHeader("Accept-Language") String al){
        System.out.println(al);
        return "success";
    }

    @RequestMapping("testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String sessionID){
        System.out.println(sessionID);
        return "success";
    }

    @RequestMapping("testObjectProperties")
    public String testObjectProperties(@Valid Student student, BindingResult result, Map<String,Object> map) {
        if (result.getErrorCount() > 0) {
            map.put("errors", result.getFieldErrors());
        }
        System.out.println(student);
        return "success";
    }

    @RequestMapping("testServletAPI")
    public String testServletAPI(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request);
        System.out.println(response);
        return "success";
    }

    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView mv = new ModelAndView("success");
        Student student = new Student();
        student.setId(1);
        student.setName("zs");
        mv.addObject("student", student);
        return mv;
    }

    @RequestMapping("testModelMap")
    public String testModelMap(ModelMap mm){
        Student student2 = new Student();
        student2.setId(2);
        student2.setName("ls");
        mm.put("student2", student2);
        return "success";
    }

    @RequestMapping("testMap")
    public String testMap(Map m){
        Student student3 = new Student();
        student3.setId(3);
        student3.setName("ww");
        m.put("student3", student3);
        return "success";
    }

    @RequestMapping("testModel")
    public String testModel(Model m){
        Student student4 = new Student();
        student4.setId(4);
        student4.setName("zl");
        m.addAttribute("student4", student4);
//        return "forward:/views/success.jsp";
        return "redirect:/views/success.jsp";
    }

    //在任何一次请求前，都会执行@ModelAttribute修饰的方法
    @ModelAttribute
    public void queryStudentById(Map<String, Object> map){
        //模拟调用三层查询数据库学生的操作
        Student student = new Student();
        student.setId(3);
        student.setName("zs");
        student.setAge(23);
        map.put("stu", student); //约定：map的key就是方法参数类型的首字母小写
    }

    @RequestMapping("testModelAttribute")
    public String testModelAttribute(@ModelAttribute("stu") Student student) {
        student.setName(student.getName());
        System.out.println(student);
        return "success";
    }

    @RequestMapping("testI18n")
    public String testI18n(){
        return "success";
    }

    @RequestMapping("testConverter")
    public String testConverter(@RequestParam("studentInfo") Student student) {
        System.out.println(student);
        return "success";
    }

    @ResponseBody
    @RequestMapping("testJson")
    public List<Student> testJson(){
        //模拟调用Service查询操作
        List<Student> students = new ArrayList<>();
        Student st1 = new Student(1, "zs", 23);
        Student st2 = new Student(2, "ls", 24);
        Student st3 = new Student(3, "ww", 24);
        students.add(st1);
        students.add(st2);
        students.add(st3);
        return students;
    }

    @RequestMapping("testUpload")
    public String testUpload(@RequestParam("desc") String desc, @RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("文件描述信息"+desc);
        InputStream in = file.getInputStream();
        String fileName = file.getOriginalFilename();
        OutputStream out = new FileOutputStream("/Users/ak/"+fileName);
        byte[] b = new byte[1024];
        int len = 0;
        while((len=in.read(b))!=-1){
            out.write(b, 0, len);
        }
        out.close();
        in.close();
        System.out.println("上传成功");
        return "success";
    }

    @RequestMapping("testInterceptor")
    public String testInterceptor(){
        System.out.println("处理请求的方法。。。");
        return "success";
    }

    @RequestMapping("testError")
    public String testError(){
        System.out.println(1/0);
        return "success";
    }

    @RequestMapping("testSimpleMappingExceptionResolver")
    public String testSimpleMappingExceptionResolver(){
        System.out.println(1/0);
        return "success";
    }
}