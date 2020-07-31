<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="top.jsp" %>

<div class="container">
<div class="card bg-light">
<article class="card-body mx-auto" style="max-width: 400px;">
	<h4 class="card-title mt-3 text-center">날씨 검색</h4>
	<p class="text-center">검색창에 입력 하세요</p>
	
    <div class="form-group input-group">
        <input id="search" name="search" class="form-control" placeholder="날씨 검색" type="text" value="">
        
    </div> <!-- form-group// -->                                   
    <div class="form-group">
        <button type="submit" id="searchBtn" class="btn btn-primary btn-block"> 검색 ㄱㄱ  </button>
    </div> <!-- form-group// -->      
                                                                    
</article>
</div>
</div> 
<script>
$(document).ready(function(){
  $("#searchBtn").click(function(){
	var search = $("#search").val();
	console.log(search);
//     $.post("searchok.nhn",
//     {
//     	search: search
//     },
//     function(data, status){
//     	$.each(data, function(i, field){
// //             $("div").append(field + " ");
//     		console.log("Data: " + field + "\nindex: " + i);
//           });
//     });
  });
});
</script>
</body>
</html>