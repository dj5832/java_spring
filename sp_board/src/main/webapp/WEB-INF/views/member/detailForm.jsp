<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="content-wrapper">
	
	<section class="content register-page">
		<div class="register-box">
			<!-- 콘텐츠 헤더 -->
			
			<!-- 콘텐츠 -->
			<div class="card">
				<div class="register-card-body">
					<form role="form" class="form-horizontal" action="regist.do" method="post">
						<input type="hidden" name="picture">
						<!-- 프로필 사진 선택 부분 -->
						<div class="input-group mb-3">
							<div class="mailbox-attachments clearfix" style="text-align: center;">
								<div class="mailbox-attachment-icon has-img" id="pictureView" style="border: 1px solid green; height: 200px; width: 140px; margin: 0 auto;">
								</div>
								<div class="mailbox-attachment-info">
									<div class="input-group input-group-sm">
										<label for="inputFile" class="btn btn-warning btn-sm btn-flat input-group-addon">파일선택</label>
										<input id="inputFileName" class="form-control" type="text" disabled>
										<span class="input-group-append-sm">
											<button type="button" class="btn btn-info btn-sm btn-append" onclick="upload_go();">업로드</button>
										</span>
									</div>
								</div>
							</div>
							<br>
						</div>
						<div class="form-group row">
							<label for="id" class="col-sm-3" style="font-size: 0.9em;">
								아이디
							</label>
								<input value=${member.id } >
						</div>
						<div class="form-group row">
							<label for="pwd" class="col-sm-3" style="font-size: 0.9em;">
								비밀번호
							</label>
							<div class="col-sm-9 input-group-sm">
								<input value="${member.pwd }" >
							</div>
						</div>
						<div class="form-group row">
							<label for="name" class="col-sm-3" style="font-size: 0.9em;">
								이 름
							</label>
							<div class="col-sm-9 input-group-sm">
								<input value="${member.name }" >
							</div>
						</div>
						<div class="form-group row">
							<label for="authority" class="col-sm-3" style="font-size: 0.9em;">등록날짜</label>
							<div class="col-sm-9 input-group-sm">
								<fmt:formatDate value="${member.regdate }" pattern="yyyy-MM-dd"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="email" class="col-sm-3" style="font-size: 0.9em;">이메일</label>
							<div class="col-sm-9 input-group-sm">
								<input value="${member.email }" >
							</div>
						</div>
						<div class="form-group row">
							<label for="phone" class="col-sm-3" style="font-size: 0.9em;">전화번호</label>
							<div class="col-sm-9 input-group-sm">
								<input value="${member.phone }">
							</div>
						</div>
						
						<div class="card-footer">
							<div class="row">
								<div class="col-sm-3">
									<button type="button" id="modifyBtn" class="btn btn-info" onclick="submit_go();">수정</button>
								</div>
								<div class="col-sm-3">
									<button type="button" id="removeBtn" class="btn btn-danger float-right" onclick="CloseWindow();">삭제</button>
								</div>
								<div class="col-sm-3">
									<button type="button" id="stopBtn" class="btn btn-danger float-right" onclick="CloseWindow();">정지</button>
								</div>
								<div class="col-sm-3">
									<button type="button" id="cancelBtn" class="btn btn-danger float-right" onclick="CloseWindow();">취소</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
</div>

<%@ include file="regist_js.jsp" %>


