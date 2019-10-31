package dao;

import java.util.ArrayList;

import vo.NoticeVO;
import data.Database;

public class NoticeDaoImpl implements NoticeDao {

private static NoticeDaoImpl instance;
	
	private NoticeDaoImpl(){
		
	}
	
	public static NoticeDaoImpl getInstance(){
		if(instance == null){
			instance = new NoticeDaoImpl();
		}
		return instance;
	}
	
	Database database = Database.getInstance();

	@Override
	public void insertNotice(NoticeVO notice) {
		
		database.tb_notice.add(notice);
	}

	@Override
	public ArrayList<NoticeVO> selectNoticeList() {
		
		return database.tb_notice;
	}
	
	
}
