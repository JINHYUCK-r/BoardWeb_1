package com.idiot.pjt.vo;


//게시판 VO
public class BoardVO {
	
	private int i_board;
	private String title;
	private String ctnt;
	private int hits;
	private int i_user;
	private String r_dt;
	private String m_dt;
	//이름을 조인받아서 보여주기위해서 새로 추가
	private String nm;
	
	private int page;
	private int recordCnt; //페이지에 보여줄 글의 갯수
	private int pagingCnt; // 몇 페이지까지있나보여주는거 전체글의수/표시할 글의 수
	private int eIdx; //페이지의 끝 글번
	private int sIdx; //페이지의 시작 글번호
	
	//private int like;
	private int likecnt; //좋아요 갯
	private int yn_like; // 나의 좋아요 유무확인
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRecordCnt() {
		return recordCnt;
	}
	public void setRecordCnt(int recordCnt) {
		this.recordCnt = recordCnt;
	}
	public int getPagingCnt() {
		return pagingCnt;
	}
	public void setPagingCnt(int pagingCnt) {
		this.pagingCnt = pagingCnt;
	}
	public int geteIdx() {
		return eIdx;
	}
	public void seteIdx(int eIdx) {
		this.eIdx = eIdx;
	}
	public int getsIdx() {
		return sIdx;
	}
	public void setsIdx(int sIdx) {
		this.sIdx = sIdx;
	}
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	public int getI_board() {
		return i_board;
	}
	public void setI_board(int i_board) {
		this.i_board = i_board;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCtnt() {
		return ctnt;
	}
	public void setCtnt(String ctnt) {
		this.ctnt = ctnt;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getI_user() {
		return i_user;
	}
	public void setI_user(int i_user) {
		this.i_user = i_user;
	}
	public String getR_dt() {
		return r_dt;
	}
	public void setR_dt(String r_dt) {
		this.r_dt = r_dt;
	}
	public String getM_dt() {
		return m_dt;
	}
	public void setM_dt(String m_dt) {
		this.m_dt = m_dt;
	}
	public int getLikecnt() {
		return likecnt;
	}
	public void setLikecnt(int likecnt) {
		this.likecnt = likecnt;
	}
	public int getYn_like() {
		return yn_like;
	}
	public void setYn_like(int yn_like) {
		this.yn_like = yn_like;
	}
	

}
