package controller;

import java.util.ArrayList;
import java.util.Scanner;

import service.BoardService;
import service.BoardServiceImpl;
import service.MessageService;
import service.MessageServiceImpl;
import service.MyinfoService;
import service.MyinfoServiceImpl;
import service.NoticeService;
import service.NoticeServiceImpl;
import service.Threadp;
import service.UserService;
import service.UserServiceImpl;
import vo.BoardVO;
import vo.MyinfoVO;
import vo.UserVO;
import dao.BoardDao;
import dao.BoardDaoImpl;
import dao.MyinfoDao;
import dao.MyinfoDaoImpl;
import dao.NoticeDao;
import dao.NoticeDaoImpl;
import data.Session;

public class Controller {

	UserService userService = UserServiceImpl.getInstance();
	BoardService boardService = BoardServiceImpl.getInstance();
	MessageService messageService = MessageServiceImpl.getInstance();
	MyinfoService myinfoService = MyinfoServiceImpl.getInstance();
	NoticeService noticeService = NoticeServiceImpl.getInstance();

	BoardDao boardDao = BoardDaoImpl.getInstance();
	MyinfoDao myinfoDao = MyinfoDaoImpl.getInstance();
	NoticeDao noticeDao = NoticeDaoImpl.getInstance();

	public static void main(String[] args) {
		Start dm = new Start();
		Threadp tp = new Threadp();
		tp.threadLoading();
		dm.start();
	}

	public void start() {	//초기화면
		Scanner s = new Scanner(System.in);

		int menu;
		do{
			System.out.println("					┌─────────────── 메뉴  ───────────────┐");
			System.out.println("					│            1. 회원가입                            │ ");
			System.out.println("					│            2. 로그인                               │");
			System.out.println("					│            0. 프로그램 종료                     │");
			System.out.println("					└───────────────────────────────────┘");
			System.out.println("					 ▶▶▶▶▶▶▶ 메뉴에 해당하는 번호 입력 ◀◀◀◀◀◀◀ ");
			System.out.print("					 입력 : ");
			try{
				menu = Integer.parseInt(s.nextLine());
				switch(menu){
				case 1 : //회원가입
					userService.join();
					break;
				case 2 : //로그인
					userService.login();
					mainmenu();
					break;
				case 0 : //프로그램 종료
					System.out.println("                                                                                          당근마트를 이용해주셔서 감사합니다");
					System.exit(0);
				}
			} catch(Exception e){ //모든 예외의 부모클래스
				System.out.println("                                        !!! 잘못된 입력방식입니다. 다시 입력해주세요 !!!");
			}
		}while(true);
	}

	public void mainmenu(){//메인화면
		Scanner s =new Scanner(System.in);

		UserVO session = Session.loginUser;
		ArrayList<BoardVO> boardList = boardDao.selectBoardList();
		ArrayList<MyinfoVO> myinfoList = myinfoDao.selectWishList();

		int menu;

		do{
			System.out.println("                                             ┌──────────< 메뉴 >─────────┐");
			System.out.println("                                             │      1. 카테고리별 검색           │  ");
			System.out.println("                                             │      2. 지역별 검색                 │    ");
			System.out.println("                                             │      3. 판매등록                     │     ");
			System.out.println("                                             │      4. 내정보                        │    ");
			System.out.println("                                             │      5. 게시판                        │    ");
			System.out.println("                                             │      6. 쪽지함                        │     ");
			System.out.println("                                             │      7. 공지사항                     │      ");
			System.out.println("                                             │      9. 검색                           │       ");
			System.out.println("                                             │      0. 로그아웃                     │       ");
			System.out.println("                                            ───────────────────────────── ");
			System.out.println("                                                                                                               ▶▶▶▶ 메뉴에 해당하는 번호 입력 ◀◀◀◀ ");
			System.out.print("                                                                                                               입력 : ");
  
			try{
				menu = Integer.parseInt(s.nextLine());
				switch(menu){
				case 1 : //카테고리
					boardService.category();
					break;
				case 2 : //지역
					boardService.region();
					break;
				case 3 : //판매등록
					boardService.sale();
					break;
				case 4 : //내정보
					myinfoService.myinfoMain();
				case 5 : //게시판
					boardService.boardList();
					break;
				case 6 : //쪽지함
						messageService.sendm();
					break;
				case 7 : //공지사항
					noticeService.noticem();
					break;
				case 9 : //검색
					boardService.search();
					break;
				case 0 : //로그아웃
					System.out.println("                                                                                                                                ※※※ 로그아웃 ※※※");
					start();
					break;
				}
			}
			catch(Exception e){ //모든 예외의 부모클래스
				System.out.println("                                        !!! 잘못된 입력방식입니다. 다시 입력해주세요 !!!");
			}

		}while(true);

	}
}