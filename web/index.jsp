<%--
  Created by IntelliJ IDEA.
  User: ak
  Date: 2018/11/18
  Time: 下午5:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
      <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
      <script type="text/javascript">
          $(document).ready(function () {
              $("#testJson").click(function () {
                  //通过Ajax请求springmvc
                  $.post(
                      "SpringMVCHandler/testJson",
                      // {"name":"zs"},
                      function (result) {
                        for(var i=0;i<result.length;i++){
                            alert(result[i].id+"-"+result[i].name+"-"+result[i].age)
                        }
                      }
                  );
              })
          })
      </script>
  </head>
  <body>

  <input type="button" value="testJson" id="testJson" />
    <a href="SpringMVCHandler/welcome">springMVC - welcome</a>
    <hr>
    <form action="${pageContext.request.contextPath}/SpringMVCHandler/welcome" method="post">
      name:<input type="text" name="name"><br>
      age:<input type="text" name="age"><br>

      <input type="submit" value="post">
    </form>
    <hr>
    <span>ant风格请求路径：</span><br>
    <a href="/SpringMVCHandler/antStyle2/abc/test">？ 单个字符</a><br>
    <a href="/SpringMVCHandler/antStyle1/abc/def/test">** 任意目录</a><br>
    <a href="/SpringMVCHandler/antStyle/abcdef/test">* 任意字符</a><br>
    <hr>
    <a href="/SpringMVCHandler/pathVar/zs">路径传递参数</a>
    <hr>
    <form action="/SpringMVCHandler/testRest/1234" method="post">
      <input type="submit" value="增">
    </form>
    <form action="/SpringMVCHandler/testRest/1234">
      <input type="submit" value="查">
    </form>
    <form action="/SpringMVCHandler/testRest/1234" method="post">
      <input type="hidden" name="_method" value="DELETE">
      <input type="submit" value="删">
    </form>
    <form action="/SpringMVCHandler/testRest/1234" method="post">
      <input type="hidden" name="_method" value="PUT">
      <input type="submit" value="改">
    </form>
    <hr>
    <form action="/SpringMVCHandler/testParam" method="get">
      <input type="text" name="username" >
      <input type="submit" value="查">
    </form>
    <hr>
    <a href="/SpringMVCHandler/testRequestHeader">获取请求头信息</a><br>
    <a href="/SpringMVCHandler/testCookieValue">获取SessionID</a>
    <hr>
    <form action="/SpringMVCHandler/testObjectProperties" method="post">
      id:<input type="text" name="id"><br>
      name:<input type="text" name="name"><br>
      age:<input type="text" name="age"><br>
      birthday:<input type="text" name="birthday"><br>
        email:<input type="text" name="email"><br>
      homeAddress:<input type="text" name="address.homeAddress"><br>
      schoolAddress:<input type="text" name="address.schoolAddress"><br>
      <input type="submit" value="提交">
    </form>
    <hr>
    <a href="${pageContext.request.contextPath}/SpringMVCHandler/testServletAPI">使用原生ServletAPI</a>
    <hr>
    <a href="/SpringMVCHandler/testModelAndView">测试ModelAndView</a><br>
    <a href="/SpringMVCHandler/testModelMap">测试ModelMap</a><br>
    <a href="/SpringMVCHandler/testMap">测试Map</a><br>
    <a href="/SpringMVCHandler/testModel">测Model</a><br>
    <hr>
    <form action="/SpringMVCHandler/testModelAttribute" method="post">
      id:<input type="hidden" name="id" value="3"><br>
      name:<input type="text" name="name"><br>
      <input type="submit" value="修改">
    </form>
    <hr>
    <a href="/SpringMVCHandler/testMVCViewController">跳过控制器直接跳转</a>
    <hr>
    <form action="SpringMVCHandler/testConverter" method="post">
      学生信息：<input type="text" name="studentInfo">
      <input type="submit" value="转换">
    </form>
    <hr>
  <form action="/SpringMVCHandler/testUpload" method="post" enctype="multipart/form-data">
      <input type="file" name="file">
      描述：<input type="text" name="desc">
      <input type="submit" value="上传">
  </form>
  <a href="/SpringMVCHandler/testInterceptor">拦截测试</a>
  </body>
</html>
