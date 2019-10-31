package dao;

import java.util.ArrayList;

import vo.NoticeVO;

public interface NoticeDao {

	//게시물 등록
	void insertNotice(NoticeVO notice);
	
	//게시판조회
	ArrayList<NoticeVO> selectNoticeList();
}
