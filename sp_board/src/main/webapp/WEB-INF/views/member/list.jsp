<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<div class="content-wrapper">
    	<jsp:include page="../content_header.jsp">
			<jsp:param value="회원목록" name="subject"/>
			<jsp:param value="목록" name="item"/>
		</jsp:include>
	    <!-- Main content -->
    	<section class="content">
    	  <div class="card">    		
    	  	<div class="card-header with-border">
    	  		<div id="keyword" class="card-tools" style="width:550px;">
				  <div class="input-group row">	
				  <!-- sort num -->
				 	<select class="form-control col-md-3" name="perPageNum" id="perPageNum">
				 		<option value="10">정렬개수</option>
				 		<option value="2">2개씩</option>
				 		<option value="3">3개씩</option>
				 		<option value="5">5개씩</option>
				 	</select>
				 <!-- search bar -->
				 	<select class="form-control col-md-3" name="searchType" id="searchType">
				 		<option value="">검색구분</option>
				 		<option value="i">아이디</option>
				 		<option value="p">전화번호</option>
				 		<option value="e">이메일</option>
				 	</select>
				 	<input class="form-control" type="text" name="keyword" placeholder="검색어를 입력하세요." value="" />
				 	<span class="input-group-append">
				 		<button class="btn btn-primary" type="button" id="searchBtn" data--card-widget="search" onclick="">
				 			<i class="fa fa-fw fa-search"></i>
				 		</button>
				 	
				 	</span>
					<!-- end : search bar -->
					
				  </div>
				 </div>    	  		
    	  	</div>	  
    		<div class="card-body" style="text-align:center;">
    		  <div class="row">
	             <div class="col-sm-12">	
		    		<table class="table table-bordered">
		    			<tr>
		                	<th>아이디</th>
		                	<th>패스워드</th>
		                	<th>이메일</th>
		                	<th>전화번호</th>
		                	<th>등록날짜</th> <!-- yyyy-MM-dd  -->
		               	</tr>
		               	<c:forEach items="${memberList }" var="member">
			               	<tr>
			               		<td>
			               			<a href="">${member.id }</a>
			               		</td>
			               		<td>
			               			${member.pwd }
			               		</td>
			               		<td>
			               			${member.email }
			               		</td>
			               		<td>
			               			<a href="tel:${member.phone }">${member.phone}</a>
			               		</td>
			               		<td>
			               			<fmt:formatDate value="${member.regdate }" pattern="yyyy-MM-dd"/>
			               		</td>
			               	</tr>
		               	</c:forEach>
		    		</table>
    		   </div> <!-- col-sm-12 -->
    		 </div> <!-- row -->
    		</div> <!-- card-body -->
    		<div class="card-footer">

          </div> <!-- cardfooter  -->
          </div> <!-- card  -->
    	</section>	
   </div>
<script>

</script>
