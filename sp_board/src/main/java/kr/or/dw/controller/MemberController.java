package kr.or.dw.controller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.or.dw.command.MemberRegistCommand;
import kr.or.dw.service.MemberService;
import kr.or.dw.vo.MemberVO;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/main")
	public String main() {
		String url = "/member/main.open";
		return url;
	}
	
	@RequestMapping("/list")
	public ModelAndView list(ModelAndView mnv) {
		String url = "/member/list.open";
		List<MemberVO> memberList = null;
		
		try {
			memberList = memberService.selectMemberList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		mnv.addObject("memberList", memberList);
		mnv.setViewName(url);
		
		return mnv;
	}
	
	// 회원등록
	@RequestMapping("/registForm")
	public String registForm() {
		String url = "member/regist.open";
		
		return url;
	}
	// 회원등록 양식
	@RequestMapping("/regist")
	public void regist(MemberRegistCommand memberReq, HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException {
		MemberVO member = memberReq.toMemberVO();
		memberService.regist(member);
		
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<script>");
		out.println("alert('회원등록이 정상적으로 되었습니다.')");
		out.println("window.opener.location.href='" + req.getContextPath() + "/member/list.do';");
		out.println("window.close();");
		out.println("</script>");
	}
	
	// 아이디 중복확인
	@RequestMapping("/idCheck")
	public ResponseEntity<String> idCheck(String id, HttpServletRequest req){
		
		ResponseEntity<String> entity = null;
		
		try {
			MemberVO member = memberService.selectMemberById(id);
			entity = new ResponseEntity<String>(member == null ? id : "", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return entity;
	}
	
	@RequestMapping("/picture")
	public ResponseEntity<String> picture(@RequestParam("pictureFile") MultipartFile multi, String oldPicture) throws Exception{
		ResponseEntity<String> entity = null;
		
		String result = "";
		HttpStatus status = null;
		
		if((result = savePicture(multi, oldPicture)) == null) {
			result = "업로드에 실패했습니다!";
			status = HttpStatus.BAD_REQUEST;
		}else {
			status = HttpStatus.OK;
		}
		
		entity = new ResponseEntity<String>(result, status);
		return entity;
	}
	
	@Resource(name = "picturePath")
	private String picturePath;
	
	/*
	 *  @Resource는 @AutoWired와 같이 property injection 을 위한 어노테이션이다.
	 *  차이점은
	 *  @AutoWired는 객체의 타입을 보고 맵핑이 된다면
	 *  @Resource는 객체의 name(id)를 보고 맵핑이 된다.
	 *  @Resource() 괄호에 객체 name을 명시하지 않으면 @AutoWired 처럼 해당 레퍼런스변수의 타입과 똑같은 객체 name을 찾는다.
	 */
	
	private String savePicture(MultipartFile multi, String oldPicture) throws Exception {
		
		String fileName = null;
		
		/* 파일 유무 확인 */
		if(!(multi == null || multi.isEmpty() || multi.getSize() > 1024 * 1024 * 1)) {
			/* 파일 저장 폴터 설정 */
			String uploadPath = picturePath;
			fileName = UUID.randomUUID().toString().replace("-", "") + ".jpg";
			File storeFile = new File(uploadPath, fileName);
			
			storeFile.mkdirs();
			
			// local HDD에 저장.
			multi.transferTo(storeFile);
			
			if(!oldPicture.isEmpty()) {
				File oldFile = new File(uploadPath, oldPicture);
				if(oldFile.exists()) {
					oldFile.delete();
				};
			};
		};
		return fileName;
	}
	
	@RequestMapping("/detailForm")
	public ModelAndView detailForm(ModelAndView mnv, String id) throws SQLException {
		String url = "member/detailForm.open";
		
		MemberVO member = memberService.selectMemberById(id);
		
		mnv.addObject("member", member);
		mnv.setViewName(url);
		return mnv;
	}
	
	@RequestMapping(value = "/detailForm", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImageAsResponseEntity(HttpServletRequest req, String id) throws IOException, SQLException {

	    MemberVO member = memberService.selectMemberById(id);

	    String pictureFilePath = "C:/member/picture/upload" + member.getPicture();

	    System.out.println(pictureFilePath);
	    ServletContext servletContext = req.getSession().getServletContext();
	    InputStream in = servletContext.getResourceAsStream(pictureFilePath);
	    
	    byte[] media = IOUtils.toByteArray(in);

	    HttpHeaders headers = new HttpHeaders();
	    headers.setCacheControl(CacheControl.noCache().getHeaderValue());
	    
	    ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
	    return responseEntity;
	}
	
}
