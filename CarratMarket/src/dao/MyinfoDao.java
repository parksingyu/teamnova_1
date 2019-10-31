package dao;

import java.util.ArrayList;

import vo.BoardVO;
import vo.MyinfoVO;



public interface MyinfoDao {
	//게시물 등록
	void insertWish(MyinfoVO board);
	
	//게시판조회
	ArrayList<MyinfoVO> selectWishList();
}
