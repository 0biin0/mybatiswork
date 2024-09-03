<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <jsp:include page="../common/menubar.jsp"/>
   <h2>회원가입</h2>
   <form action="" method="post" id="enrollForm"></form>
   <table>
      <tr>
         <td>* ID</td>
         <td>
            <input name="userId" required>
            <div id="checkResult" style="font-size: 0.8em; display: none;"></div>
         </td>
      </tr>
      <tr>
         <td>* PWD</td>
         <td><input type="password" required> </td>
      </tr>
      <tr>
         <td>* NAME</td>
         <td><input name="name" required></td>
      </tr>
      <tr>
         <td>* BIRTHDAY</td>
         <td><input name="birthday" placeholder="생년월일(6자리)"></td>
      </tr>
      <tr>
         <td>* GENDER</td>
         <td><input type="radio" name="gender" value="M">남&emsp;</td>
         <td><input type="radio" name="gender" value="F">여</td>
      </tr>
      <tr>
         <td>* PHONE</td>
         <td><input name="phone"></td>
      </tr>
      <tr>
         <td>* ADDRESS</td>
         <td><input name="address" required></td>
      </tr>
      <tr>
         <td colspan="2">
            <input type="reset" value="초기화">
            <input type="reset" value="초기화">   
         </td>
      </tr>
   </table>

</body>
</html>