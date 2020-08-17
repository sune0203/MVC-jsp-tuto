<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="top.jsp" %>

<% if (dto == null){ %>
<script> alert("로그인을 하면 이용 가능 합니다.");
location.href="login.nhn";</script>
<% }  %>


<div class="container">
<div class="card bg-light">
<article class="card-body mx-auto" style="max-width: 400px;">
	<h4 class="card-title mt-3 text-center">영화 검색</h4>
	<p class="text-center">검색창에 입력 하세요</p>
	
    <div class="form-group input-group">
        <input id="search" name="search" class="form-control" placeholder="영화 검색" type="text" value="">
        
    </div> <!-- form-group// -->                                   
    <div class="form-group">
        <button type="submit" id="searchBtn" class="btn btn-primary btn-block"> 검색 ㄱㄱ  </button>
    </div> <!-- form-group// -->      
                                                                    
</article>
</div>

<h3>검색 결과 출력</h3>
<div id="result"></div>

</div> 
<script>
$(document).ready(function(){
  $("#searchBtn").click(function(){
	var search = $("#search").val();
	$("#result").html("여기에 찍히나: " + search);
	console.log(search);
    $.post("movieok.nhn",
    {
    	search: search
    },
    function(data, status){
    	var html = "";
    	console.log(data['total']);
    	console.log(data.items);
    	$.each(data.items, function(key, field){
    		html += "<a href='" + field.link + "' target='_blank'>"
    		html += field.title + "</a><br>";
//             $("div").append(field + " ");
//     		console.log("Data: " + field.title);  // field['title']
          });
		$("#result").html(html);
    });
  });
});
</script>
</body>
</html>