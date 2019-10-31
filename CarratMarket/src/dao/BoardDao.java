package dao;

import java.util.ArrayList;
import java.util.HashMap;

import vo.BoardVO;
import vo.MessageVO;
import vo.UserVO;

public interface BoardDao {

/*	//단일회원 조회
	BoardVO category(String key, String value);

	BoardVO selectUser(HashMap<String, String> param);
	
	//회원 삽입
	void insertUser(BoardVO user);*/
	
	
	
	//게시물 등록
	void insertBoard(BoardVO board);
	
	//게시판조회
	ArrayList<BoardVO> selectBoardList();

	
	
}