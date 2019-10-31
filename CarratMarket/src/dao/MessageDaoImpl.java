package dao;

import java.util.ArrayList;

import data.Database;
import vo.BoardVO;
import vo.MessageVO;

public class MessageDaoImpl implements MessageDao {
private static MessageDaoImpl instance;
	
	private MessageDaoImpl(){
		
	}
	
	public static MessageDaoImpl getInstance(){
		if(instance == null){
			instance = new MessageDaoImpl();
		}
		return instance;
	}
	
	Database database = Database.getInstance();

	@Override
	public void sendMessage(MessageVO message) {
		database.tb_message.add(message);
	}

	@Override
	public ArrayList<MessageVO> selectMessageList() {
		return database.tb_message;
	}
	
	
}
