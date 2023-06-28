package kr.or.dw.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class PdsVO {
	
	private int pno;
	private String title;
	private String writer;
	private String content;
	private int viewcnt;
	private Date regdate;
	private Date updatedate;
	private Date startdate;
	private Date enddate;
	
	private List<AttachVO> attachList;
	
	
	
	
}
