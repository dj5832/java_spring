<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>

window.onload = function(){
	
	// 프로필 이미지 불러오기
	let imageURL = "getPicture.do?picture=${member.picture}";	// 이미지명 가지고 와서 셋팅
	$('div#pictureView').css({
								'background-image' : 'url(' + imageURL + ')',
								'background-position' : 'center',
								'background-size' : 'cover',
								'background-repeat' : 'no-repeat'
							});
	
	// 수정 버튼 클릭
	$('button#modifyBtn').on('click', function(){
		location.href="modifyForm.do?id=${member.id}";
	});
	// 삭제 버튼 클릭
	$('button#removeBtn').on('click', function(){
		if(confirm("정말로 삭제하시겠습니까?")){
		location.href="remove.do?id=${member.id}";
		}
	});
	// 정지 버튼 클릭
	$('button#stopBtn').on('click', function(){
		let enabled = ${member.enabled};
		let urlStr = "stop.do";
		if(enabled == 0){
			urlStr = "rerole.do"
		};
		location.href = urlStr + "?id=${member.id}";
	});
}


	
</script>