package dao;

import java.util.ArrayList;

import data.Database;
import vo.MyinfoVO;

public class MyinfoDaoImpl implements MyinfoDao {
	
	
	private static MyinfoDaoImpl instance;
	
	private MyinfoDaoImpl(){
		
	}
	
	public static MyinfoDaoImpl getInstance(){
		if(instance == null){
			instance = new MyinfoDaoImpl();
		}
		return instance;
	}
	
	Database database = Database.getInstance();
	
	

	@Override
	public void insertWish(MyinfoVO myinfo) {
		database.tb_myinfo.add(myinfo);
	}

	@Override
	public ArrayList<MyinfoVO> selectWishList() {
		
		return database.tb_myinfo;
	}

}
