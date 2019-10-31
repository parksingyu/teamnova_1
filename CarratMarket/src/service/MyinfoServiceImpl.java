package service;

import java.util.ArrayList;
import java.util.Scanner;

import controller.Controller;
import dao.BoardDao;
import dao.BoardDaoImpl;
import dao.MessageDao;
import dao.MessageDaoImpl;
import dao.MyinfoDao;
import dao.MyinfoDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import data.Session;
import vo.BoardVO;
import vo.MyinfoVO;
import vo.UserVO;

public class MyinfoServiceImpl implements MyinfoService{
	
	
	private static MyinfoServiceImpl instance;

	private MyinfoServiceImpl(){}

	public static MyinfoServiceImpl getInstance(){
		if(instance == null){
			instance = new MyinfoServiceImpl();
		}
		return instance;
	}

	MessageDao messageDao = MessageDaoImpl.getInstance();
	UserDao userDao = UserDaoImpl.getInstance();
	MyinfoDao myinfoDao = MyinfoDaoImpl.getInstance();
	BoardDao boardDao = BoardDaoImpl.getInstance();

	@Override
	public void wishSelect(int z) {
		UserVO session = Session.loginUser;
		BoardService boardService = BoardServiceImpl.getInstance();
		String a = session.getId();
		
		MyinfoVO myinfo = new MyinfoVO();
		myinfo.setId(a);
		myinfo.setNum(z);
		
		myinfoDao.insertWish(myinfo);
		
		boardService.boardList();
	}

	@Override
	public void wishList() {
		Scanner s = new Scanner(System.in);
		UserVO session = Session.loginUser;
		BoardService boardService = BoardServiceImpl.getInstance();
		ArrayList<BoardVO> boardList = boardDao.selectBoardList();
		ArrayList<MyinfoVO> myinfoList = myinfoDao.selectWishList();
		
		System.out.println("					 번호\t가격\t작성자\t제목");
		
		for(int i = 0; i < myinfoList.size(); i++){

			String a, b;
			int c;
			int d;
			MyinfoVO myinfo = myinfoList.get(i);
			for(int j =0; j<boardList.size(); j++){
				BoardVO board = boardList.get(j);
				a = session.getId();
				b = myinfo.getId();
				c = board.getBoardNum();
				d = myinfo.getNum();
				
				if ( a.equals(b) && c==d){ 
					System.out.println("					 "+j + " \t" + board.getPrice() + "\t" + board.getSaleId() + "\t" + board.getTitle() );
					
				}
			}
		}
		System.out.println("					 어떤거 입력하실래요?(돌아가기 : -1) : ");
		System.out.print("					 입력 : ");
		int input = Integer.parseInt(s.nextLine());
		
		if(input == -1) {
			myinfoMain();
		} else {
			boardService.odetail(input);
		}
	}

	@Override
	public void mySaleList() {
		
		BoardService boardService = BoardServiceImpl.getInstance();
		
		Scanner s = new Scanner(System.in);
		
		UserVO session = Session.loginUser;
		ArrayList<BoardVO> boardList = boardDao.selectBoardList();
		BoardVO board ;
		String a= session.getId();
		System.out.println("					  \t번호.\t\t판매자아이디.                        가격.                               제목.                                                                             ");
		
		//솎아낼 때 필요
		ArrayList<Integer> sok = new ArrayList<Integer>();
		
		for(int i =0 ;i < boardList.size() ; i++){
			
			board = boardList.get(i);
			String b = board.getSaleId();
			
			if(a.equals(b)){
				
				System.out.println("					 \t" + i + "\t\t"  + board.getSaleId()  + "\t \t"+ board.getPrice() + "\t\t"+ board.getTitle() );
				
				//솎아낼 때 필요
				sok.add(i);
			}
		}
		System.out.println("					 번호를 입력하세요(돌아가기 : -1)");
		System.out.print("					 입력 : ");
		int mySaleNum = Integer.parseInt(s.nextLine());
		
		//솎아낼 때 필요
		boolean sok2 = false;
		if(mySaleNum == -1){
			myinfoMain();
		}else{
			for(int i = 0 ; i<sok.size(); i++){
				if(sok.get(i) == mySaleNum){
					sok2 = true;
				}
			}
			if(sok2){
				boardService.mdetail(mySaleNum);
			} else {
				System.out.println("					 잘못된 정보입니다. 다시 입력해주세요.");
				mySaleList();
			}
		}
	}

	@Override
	public void myBuyList() {
		
		//판매자 : 
		//구매자 : session.getId()
		
		BoardService boardService = BoardServiceImpl.getInstance();
		
		Scanner s = new Scanner(System.in);
		
		UserVO session = Session.loginUser;
		ArrayList<BoardVO> boardList = boardDao.selectBoardList();
		BoardVO board ;
		String a = session.getId();
		
		System.out.println(" 					 \t번호.\t\t판매자아이디.\t\t구매자아이디.                        가격.                               제목.                                                                             ");
		ArrayList<Integer> sok = new ArrayList<Integer>();
		for(int i =0 ;i < boardList.size() ; i++){
			
			board = boardList.get(i);
			String b = board.getBuyId();
			
			if(a.equals(b)){
				
				System.out.println("					 \t" + i + "\t\t"  + board.getSaleId()  + "\t \t"+ board.getBuyId() + "\t \t"+ board.getPrice() + "\t\t"+ board.getTitle() );
				sok.add(i);
			}
		}
		System.out.println("					 번호를 입력하세요(돌아가기 : -1)");
		System.out.print("					 입력 : ");
		int mySaleNum = Integer.parseInt(s.nextLine());
		boolean sok2 = false;
		if(mySaleNum == -1){
			myinfoMain();
		}else{
			for(int i = 0 ; i<sok.size(); i++){
				if(sok.get(i) == mySaleNum){
					sok2 = true;
				}
			}
			if(sok2){
				boardService.mdetail(mySaleNum);
			} else {
				System.out.println("					 잘못된 정보입니다. 다시 입력해주세요.");
				myBuyList();
			}
		}
		
		
		
	}

	@Override
	public void myinfoMain() {
		Scanner s = new Scanner(System.in);
		
		UserVO session = Session.loginUser;
		ArrayList<BoardVO> boardList = boardDao.selectBoardList();
		
		System.out.println("					 ID : "+session.getId());
		System.out.println("					 전화번호 : "+session.getPhonenum());
		System.out.println("					 어떤 작업을 하시겠습니까?");
		System.out.println("					 1. 찜리스트  / 2. 판매내역  / 3. 구매내역  / -1. 돌아가기");
		System.out.print("					 입력 : ");
		int a = Integer.parseInt(s.nextLine());
		if( a == 1){
			wishList();
		} else if ( a==2){
			mySaleList();
		} else if ( a==3){
			myBuyList();
		} else if ( a==-1){
			new Controller().mainmenu();
		}
	}
}
