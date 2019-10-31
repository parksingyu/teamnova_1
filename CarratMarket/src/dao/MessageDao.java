package dao;

import java.util.ArrayList;

import vo.MessageVO;

public interface MessageDao {
	void sendMessage(MessageVO message);
	
	ArrayList<MessageVO> selectMessageList();
}
