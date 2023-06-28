<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<script>
function Attach_action(){
	// 파일 추가 버튼
	$('#addFileBtn').on('click', function(){
		if($('input[name="uploadFile"]').length >= 5){
			alert("파일 추가는 최대 5개 입니다.");
			return;
		}
		let input = $('<input>').attr({
										"type" : "file",
										"name" : "uploadFile"
										}).css("display", "inline");			
		let div = $('<div>').addClass("inputRow");
		div.append(input).append("<button style='border:0; outline:0;' class='badge bg-red' type='button' id='cancelAddBtn'>X</button>")
		div.appendTo('.fileInput');
		
	});
	// 파일 삭제 버튼
	$('.fileInput').on('click','#cancelAddBtn', function(){
		$(this).parent('.inputRow').remove();
	});
	
	// 파일 용량 체크
	$('.fileInput').on('change', 'input[type="file"]', function(){
		if(this.files[0].size > 1024*1024*40){
			alert("파일 용량이 40MB를 초과하였습니다.");
			this.value = "";
			$(this).focus();
			return;
		};
	});
}
</script>