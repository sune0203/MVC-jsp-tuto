<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="com.naver.dto.MovieDto" 
    import ="java.util.ArrayList" %>
    
<%@ include file="top.jsp" %>

<% if (dto == null){ %>
<script> alert("로그인을 하면 이용 가능 합니다.");
location.href="login.nhn";</script>
<% }  %>

<%
	ArrayList<MovieDto> list = (ArrayList<MovieDto>)request.getAttribute("movielist");

%>

<div class="container">


<h3>영화 랭킹 출력</h3>
<% for (MovieDto mv : list) { %>

<img alt=""  src="<%=mv.getImg()%>"> <br>
<button type="button" class="btn btn-success" onclick ="send('<%=mv.getTitle()%>')">후기작성</button><br>

<% } %>

</div> 
<script>
function send(title){
	
		alert(title);
		alert(" <%=dto.getName()%> ");
}
</script>
</body>
</html>