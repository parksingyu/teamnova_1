package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import vo.BoardVO;
import vo.MessageVO;
import vo.UserVO;
import controller.Controller;
import dao.BoardDao;
import dao.BoardDaoImpl;
import dao.MessageDao;
import dao.MessageDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import data.Session;

public class MessageServiceImpl implements MessageService {
	
	private static MessageServiceImpl instance;

	private MessageServiceImpl(){}

	public static MessageServiceImpl getInstance(){
		if(instance == null){
			instance = new MessageServiceImpl();
		}
		return instance;
	}

	MessageDao messageDao = MessageDaoImpl.getInstance();
	UserDao userDao = UserDaoImpl.getInstance();
	BoardDao boardDao = BoardDaoImpl.getInstance();

	@Override
	public void incomingList() {  //수신 리스트
		ArrayList<MessageVO> messageList = messageDao.selectMessageList();
		UserVO session = Session.loginUser ;
		Scanner s = new Scanner(System.in);
		
		System.out.println("					 ─────────────────────────────────────");
		System.out.println("					 번호\t받는사람\t보낸사람\t보낸시간\t\t내용 ");
		System.out.println("					 ─────────────────────────────────────");
		for(int i = 0; i < messageList.size() ; i++){
			MessageVO message = messageList.get(i);
			String a = session.getId();
			String b = message.getSaleId();
			
			if ( a.equals(b) ){ // 쪽지받은사람과 로그인한 사람이 같을경우 뿌려줌.
				System.out.println("					 "+message.getMsgnum()+"\t"+message.getSaleId()+"\t" +message.getBuyId() +"\t" +message.getDate() +"\t" + message.getContent());
			}
		}
		System.out.println("					 ---------------------------------");
		System.out.println("					 아무키나 입력하면 메뉴로 돌아갑니다.");
		System.out.print("					 입력 : ");
		String a = s.nextLine();
	}

	@Override
	public void outcomingList() {  //발신 리스트
		ArrayList<MessageVO> messageList = messageDao.selectMessageList();
		UserVO session = Session.loginUser ;
		Scanner s = new Scanner(System.in);
		
		System.out.println("					 ─────────────────────────────────────");
		System.out.println("					 번호\t받는사람\t보낸사람\t보낸시간\t\t내용 ");
		System.out.println("					 ─────────────────────────────────────");
		for(int i = 0; i < messageList.size() ; i++){
			MessageVO message = messageList.get(i);
			
			String a = session.getId();
			String b = message.getBuyId();
			String c = message.getSaleId();
			if( a.equals(b) && !c.equals("adminm")){ // 쪽지보낸사람과 로그인한 사람이 같을경우 뿌려줌.
				System.out.println("					 "+message.getMsgnum()+"\t"+message.getSaleId()+"\t" +message.getBuyId() +"\t" +message.getDate() +"\t" + message.getContent());
			} 
		}
		System.out.println("					 ---------------------------------");
		System.out.println("					 아무키나 입력하면 메뉴로 돌아갑니다.");
		System.out.print("					 입력 : ");
		String a = s.nextLine();
	}

	@Override
	public void detailMessage(int m) {  //쪽지 보내기
		
		Scanner s = new Scanner(System.in);
		ArrayList<UserVO> userList = userDao.selectUserList();
		ArrayList<BoardVO> boardList = boardDao.selectBoardList();
		BoardService boardService = BoardServiceImpl.getInstance();
		Date today = new Date(); //현재 날짜
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd hh:mm");
		String format = sdf1.format(today);
		
		UserVO session = Session.loginUser ;
		MessageVO message = new MessageVO();
		
		
		BoardVO board  = boardList.get(m);
		
		
		String saleID = board.getSaleId();
		
		System.out.println("					 전송할 아이디 : " + saleID);
		
		
		
		boolean a = false;
		for(int i = 0; i<userList.size(); i++){
			UserVO user = userList.get(i);
			if(saleID.equals(user.getId())){
				a = true;
			}
		}
		
		if(a){
			System.out.print("					 내용 : ");
			String content = s.nextLine();
			message.setSaleId("adminm");    // 보낼 사람 아이디 입력
			message.setSaleId(saleID);    // 보낼 사람 아이디 입력
			message.setContent(content);  // 내용 입력
			message.setBuyId(session.getId()); // 메시지 보낸 사람 입력
			message.setDate(format);      //현재 시간 입력
			message.setMsgnum(msgcount);  //쪽지의 번호를 매겨줍니다.
			messageDao.sendMessage(message);  //이 내용 입력 후 전송하기
			boardService.boardList();
			
			msgcount++;
		} else {
			System.out.println("					 없는 아이디입니다. 다시 입력해주세요.");
			sendMessage();
		}
	}
	
	int msgcount = 1;
	
	@Override
	public void sendMessage() {  //쪽지 보내기
		
		Scanner s = new Scanner(System.in);
		ArrayList<UserVO> userList = userDao.selectUserList();
		
		Date today = new Date(); //현재 날짜
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd hh:mm");
		String format = sdf1.format(today);
		
		UserVO session = Session.loginUser ;
		
		System.out.print("					 전송할 아이디(돌아가기 : -1) : ");
		String saleID = s.nextLine();
		if(saleID.equals("-1")){
			sendm();
		}
		
		boolean a = false;
		for(int i = 0; i<userList.size(); i++){
			UserVO user = userList.get(i);
			if(saleID.equals(user.getId())){
				a = true;
			}
		}
		
		if(a){
			System.out.print("					 내용 : ");
			String content = s.nextLine();
			MessageVO message1 = new MessageVO(); 
			message1.setSaleId(saleID);    // 보낼 사람 아이디 입력
			message1.setContent(content);  // 내용 입력
			message1.setBuyId(session.getId()); // 메시지 보낸 사람 입력
			message1.setDate(format);      //현재 시간 입력
			message1.setMsgnum(msgcount);  //쪽지의 번호를 매겨줍니다.
			messageDao.sendMessage(message1);  //이 내용 입력 후 전송하기
			
			MessageVO message2 = new MessageVO();
			message2.setSaleId("adminm");    // 보낼 사람 아이디 입력
			message2.setContent(content);  // 내용 입력
			message2.setBuyId(session.getId()); // 메시지 보낸 사람 입력
			message2.setDate(format);      //현재 시간 입력
			message2.setMsgnum(msgcount);  //쪽지의 번호를 매겨줍니다.
			messageDao.sendMessage(message2);  //이 내용 입력 후 전송하기
			msgcount++;
		} else {
			System.out.println("					 없는 아이디입니다. 다시 입력해주세요.");
			sendMessage();
		}
	}
	
	int rm;
	
	@Override
	public void rm2() {
		BoardService boardService = BoardServiceImpl.getInstance();
		rm = boardService.rm(); 
	}

	@Override
	public void completesendMessage(String saleID) {
		//쪽지 보내기
		rm2();
		ArrayList<BoardVO> boardList = boardDao.selectBoardList();
		BoardVO board  = boardList.get(rm);
		BoardService boardService = BoardServiceImpl.getInstance();
		Scanner s = new Scanner(System.in);
		ArrayList<UserVO> userList = userDao.selectUserList();
		
		Date today = new Date(); //현재 날짜
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd hh:mm");
		String format = sdf1.format(today);

		UserVO session = Session.loginUser ;
		MessageVO message = new MessageVO();
		
		boolean a = false;
		for(int i = 0; i<userList.size(); i++){
			UserVO user = userList.get(i);
			if(saleID.equals(user.getId())){
				a = true;
			}
		}
		
		if(a){
			//System.out.println("내용 : ");
			//String content = s.nextLine();
			board.setBuyId(saleID);
			System.out.println("					 거래가 완료되었습니다.");
			String content = "					 "+session.getId()+"님과 거래가 완료되었습니다.";
			message.setSaleId("adminm");    // 보낼 사람 아이디 입력
			message.setSaleId(saleID);    // 보낼 사람 아이디 입력
			message.setContent(content);  // 내용 입력
			message.setBuyId(session.getId()); // 메시지 보낸 사람 입력
			message.setDate(format);      //현재 시간 입력
			message.setMsgnum(msgcount);  //쪽지의 번호를 매겨줍니다.
			messageDao.sendMessage(message);  //이 내용 입력 후 전송하기
			msgcount++;
		} else {
			System.out.println("					 없는 아이디입니다. 다시 입력해주세요.");
			boardService.salecomplete();
		}
	}

	@Override
	public void sendm() {
		Scanner s= new Scanner(System.in);
		System.out.println("					 어떤 작업을 하시겠습니까?");
		System.out.println("					 1. 쪽지보내기  /  2. 수신함   / 3. 발신함 / -1.돌아가기");
		System.out.print("					 입력 : ");
		int a = Integer.parseInt(s.nextLine());
		if ( a == 1 ){ //쪽지 보내기   
			sendMessage();
		} else if ( a == 2){ //수신함
			incomingList();
		} else if ( a == 3){ //발신함
			outcomingList();
		} else if ( a == -1){ //돌아가기					
			new Controller().mainmenu();
		} 
	}
}