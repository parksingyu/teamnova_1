package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import vo.NoticeVO;
import vo.UserVO;
import controller.Controller;
import dao.BoardDao;
import dao.BoardDaoImpl;
import dao.MessageDao;
import dao.MessageDaoImpl;
import dao.MyinfoDao;
import dao.MyinfoDaoImpl;
import dao.NoticeDao;
import dao.NoticeDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import data.Session;

public class NoticeServiceImpl implements NoticeService {
	
	private static NoticeServiceImpl instance;

	private NoticeServiceImpl(){}

	public static NoticeServiceImpl getInstance(){
		if(instance == null){
			instance = new NoticeServiceImpl();
		}
		return instance;
	}
	
	MessageDao messageDao = MessageDaoImpl.getInstance();
	UserDao userDao = UserDaoImpl.getInstance();
	MyinfoDao myinfoDao = MyinfoDaoImpl.getInstance();
	BoardDao boardDao = BoardDaoImpl.getInstance();
	NoticeDao noticeDao = NoticeDaoImpl.getInstance();

	@Override
	public void noticeSelect() {
		
		
	}

	@Override
	public void noticeList() {
		Scanner s = new Scanner(System.in);
		ArrayList<NoticeVO> noticeList = noticeDao.selectNoticeList();
		
		NoticeVO notice1 = null;
		System.out.println("					 번호\t일시\t제목");
		for(int i = 0; i < noticeList.size(); i++){
			
			notice1 = noticeList.get(i);
			//board = boardList.get(i);
			
			System.out.println("					 "+i + "\t"+ notice1.getNoticeDate() +"\t"+  notice1.getNoticeTitle() );
			
		}
		System.out.println("					 몇번을 볼래요(돌아가기:-1)>");
		System.out.print("					 입력 : ");
		
		int noticenum = Integer.parseInt(s.nextLine());
		if(noticenum == -1){
			new Controller().mainmenu();
		}else {
			noticeDetail(noticenum);
		}
		
	}
	
	@Override
	public void noticem() {
		Scanner s = new Scanner(System.in);
		UserVO session = Session.loginUser;
		System.out.println("");
		System.out.println("                                                                                                           ▶▶▶▶▶ 어떤 작업을 하시겠습니까? ◀◀◀◀◀");

		if(session.getGrade() == 0){
			System.out.println("                                     ┌────────────┐  ┌────────────┐  ┌─────────┐");
			System.out.println("                                     │1.공지사항 보기 │  │2.공지사항 등록 │  │0.돌아가기  │");
			System.out.println("                                     └────────────┘  └────────────┘  └─────────┘");
			System.out.print("					 입력 : ");
		} else{
			System.out.println("                                            ┌────────────┐    ┌─────────┐");
			System.out.println("                                            │1.공지사항 보기 │    │0.돌아가기  │");
			System.out.println("                                            └────────────┘    └─────────┘");
			System.out.print("					 입력 : ");
		}
		int a = Integer.parseInt(s.nextLine());

		if ( a == 1 ){
			noticeList();
		} else if (a==2){
			noticeInsert();
		} else if (a==-1){
			new Controller().mainmenu();
		}
	}
	
	
	@Override
	public void noticeDetail(int m) {
		ArrayList<NoticeVO> noticeList = noticeDao.selectNoticeList();
		UserVO session = Session.loginUser;
		NoticeVO notice = noticeList.get(m);
		Scanner s = new Scanner(System.in);
		
		System.out.println("					 제목 : " + notice.getNoticeTitle());
		System.out.println("					 등록날짜 : " + notice.getNoticeDate());
		System.out.println("					 내용 : " + notice.getNoticeContent());
		int b = session.getGrade();
		if( b == 0){
			System.out.println("					 1.수정 2.삭제 -1.돌아가기");
			System.out.print("					 입력 : ");
			int noticeNum = Integer.parseInt(s.nextLine());
			if(noticeNum==1){
				noticeChange(m);
			}else if(noticeNum==2){
				noticeDelete(m);
			}else if(noticeNum==-1){
				noticeList();
			}
			
		}else{
			System.out.println("					 아무키나 입력하시면 목록으로 돌아갑니다");
			System.out.print("					 입력 : ");
			String noticeNum = s.nextLine();
			try {
				noticeList();
			}catch (Exception e) {
				noticeList();
			}
		}
	}
	
	int count = 3;
	@Override
	public void noticeInsert() {
		UserVO session = Session.loginUser;
		Scanner s =new Scanner(System.in);
		int b = session.getGrade();
		if(b == 0){
			
			System.out.print("					 제목 : ");
			String noticeTitle = s.nextLine();
			System.out.print("					 내용 : ");
			String noticeContent = s.nextLine();
			
			NoticeVO notice = new NoticeVO();
			
			Date today = new Date(); //현재 날짜
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			String format = sdf1.format(today);
			
			notice.setNoticeTitle(noticeTitle);
			notice.setNoticeContent(noticeContent);
			notice.setNoticeNum(count);
			notice.setNoticeDate(format);
			
			noticeDao.insertNotice(notice);
			count++;
			System.out.println("					 게시물 등록이 완료되었습니다.");
			noticem();
		}else{
			System.out.println("					 권한이 없습니다.");
			noticem();
		}
	}

	@Override
	public void noticeChange(int m) {
		Scanner s = new Scanner(System.in);
		ArrayList<NoticeVO> noticeList = noticeDao.selectNoticeList();
		UserVO session = Session.loginUser;
		
		NoticeVO notice = noticeList.get(m);
		
		notice.getNoticeTitle();
		if(session.getGrade() == 0){
			System.out.println("					 어떤 내용을 삭제하시겠습니까?");
			System.out.println("					 1. 제목 / 2. 내용  / -1.돌아가기");
			System.out.print("					 입력 : ");
			int input =Integer.parseInt(s.nextLine());
			if(input == 1){
				System.out.println("					 현재 제목 : " + notice.getNoticeTitle());
				System.out.print("					 입력 : ");
				String input2 = s.nextLine();
				notice.setNoticeTitle(input2);
				System.out.println("					 변경이 완료되었습니다.");
				noticeList();
			} else if(input == 2){
				System.out.println("					 현재 내용 : " + notice.getNoticeContent());
				System.out.print("					 입력 : ");
				String input2 = s.nextLine();
				notice.setNoticeContent(input2);
				System.out.println("					 변경이 완료되었습니다.");
				noticeList();
			} else if (input ==-1){
				noticeList();
			}
		}
	}
	
	@Override
	public void noticeDelete(int m) {
		ArrayList<NoticeVO> noticeList = noticeDao.selectNoticeList();
		UserVO session = Session.loginUser;
		
		if(session.getGrade() == 0){  //관리자일경우
			noticeList.remove(m); //해당 게시물을 삭제한다.
			noticeList(); //공지사항 리스트로 돌아간다.
		}else{
			System.out.println("					 넌 안돼 인마!!!!!!!!!!!");
			noticeList(); //공지사항 리스트로 돌아간다.
		}
	}

}
