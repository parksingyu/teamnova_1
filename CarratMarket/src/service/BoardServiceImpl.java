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
import data.Session;

public class BoardServiceImpl implements BoardService {
	

	private static BoardServiceImpl instance;

	private BoardServiceImpl(){}; 

	public static BoardServiceImpl getInstance(){
		if(instance == null){
			instance = new BoardServiceImpl();
		}
		return instance;
	}

	BoardDao boardDao = BoardDaoImpl.getInstance();
	MessageService messageService = MessageServiceImpl.getInstance();
	MyinfoService myinfoService = MyinfoServiceImpl.getInstance();



	@Override
	public void boardList() {

		//추가할 것 : 등록한 시각

		Scanner s = new Scanner(System.in);
		ArrayList<BoardVO> boardList = boardDao.selectBoardList();
		ArrayList<BoardVO> tb_board = new ArrayList<BoardVO>();

		//출력
		System.out.println("             ────────────────────────────────────────── <게시판> ──────────────────────────────────────────");
		System.out.println("              \t번호.           판매자아이디.        가격.                   제목.                              ");
		System.out.println("             ─────────────────────────────────────────────────────────────────────────────────────────────");
		BoardVO board =null;
		for(int i = 0; i < boardList.size() ; i++){
			board = boardList.get(i);
			System.out.println("              "+"\t" + i + "\t\t"  + board.getSaleId()  + "\t \t"+ board.getPrice() + "\t\t"+ board.getTitle() );
		}
		System.out.println("             ─────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println("");
		System.out.println("             ─────────────────────────────────────────────────────────────────────────────────────────────");

		//게시판의 한 행을 누르면 그 제품의 상세내역 보기
		System.out.println("                                                                                              ▶▶▶▶▶ 제품상세내역 번호를 선택하세요(-1 돌아가기) ◀◀◀◀◀");
		System.out.print("					 입력 : ");
		int input =Integer.parseInt( s.nextLine());
		if(input== -1){
			new Controller().mainmenu();
		} else{
			
			detail(input);
		}

	}

	ArrayList<BoardVO> boardList = boardDao.selectBoardList();
	BoardVO board;
	public int m;

	@Override
	public void detail(int m) {
		
		UserVO session = Session.loginUser;
		Scanner s = new Scanner(System.in);
		
		try{
			board  = boardList.get(m);
		}catch(Exception e){
			System.out.print("					 다시입력 : ");
			int input =Integer.parseInt( s.nextLine());
			detail(input);
		}
		this.m = m ;
		board  = boardList.get(m);
		
		int z=board.getBoardNum();
		
		int gu = board.getRegion() / 100;
		int dong = board.getRegion() % 100; 
		String local = "";
		String panme ="";
		if(gu == 1){
			local = guarr[gu-1] + arr1[dong -1];
		} else if(gu == 2){
			local = guarr[gu-1] + arr2[dong -1];
		} else if (gu == 3){
			local = guarr[gu-1] + arr3[dong -1];
		} else if(gu == 4){
			local = guarr[gu-1] + arr4[dong -1];
		} else if (gu  == 5){
			local = guarr[gu-1] + arr5[dong -1];
		}
		if (board.isStatus()){
			panme="판매 완료";
		} else {
			panme="판매 중";
		}
		//출력
		System.out.println("             ─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println("              "+(board.getBoardNum()-1) + "번 게시물");
		System.out.println("             ─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println("              \t제목 : " + board.getTitle());
		System.out.println("              \t가격 : " + board.getPrice());
		System.out.println("              \t상태 : " + panme);
		System.out.println("              \t작성자 : " + board.getSaleId());
		System.out.println("              \t카테고리 : " + categoryArr[board.getCategory()-1]);
		System.out.println("              \t지역 : " + local);
		System.out.println("              \t제품명 : " + board.getProduct()); 
		System.out.println("              \t내용 : " + board.getContent());
		System.out.println("              \t넘버 : " + (board.getBoardNum()-1));
		System.out.println("             ────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println("");
		System.out.println("             ────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

		
		System.out.println("				┌───────┐  ┌──────────┐  ┌──────┐  ┌──────┐  ┌────────────────┐");
		System.out.println("				│1.찜하기 │  │2.쪽지보내기 │  │3.수정  │  │4.삭제  │  │-1.목록으로 돌아가기 │");
		System.out.println("				└───────┘  └──────────┘  └──────┘  └──────┘  └────────────────┘");
		System.out.print("					 입력 : ");
		int input =Integer.parseInt( s.nextLine());
		switch(input){
		case 1 :
			myinfoService.wishSelect(z);
			break;
		case 2 : 
			messageService.detailMessage(this.m);
			break;
		case 3 : 
			
			String a = session.getId();
			String b = board.getSaleId();
			
			if(a.equals(b)){
				System.out.println("						  ▶▶▶▶▶ 어떤 항목을 수정하시겠습니까? ◀◀◀◀◀");
				System.out.println("				┌──────┐  ┌──────┐  ┌─────────┐  ┌──────┐  ┌────────────┐  ┌─────────┐");
				System.out.println("				│1.제목  │  │2.가격  │  │3.카테고리  │  │4.내용  │  │5.판매상태 변경 │  │-1.돌아가기  │");
				System.out.println("				└──────┘  └──────┘  └─────────┘  └──────┘  └────────────┘  └─────────┘");
				System.out.print("					 입력 : ");
				input =Integer.parseInt( s.nextLine());
				change(input);
			}else{
				System.out.println("					 권한이 없습니다.");
				detail(m);
			}
			break;
		case 4 :  //김영호
			a = session.getId();
			b = board.getSaleId();
			if(a.equals(b) || session.getGrade() == 0 ){
				System.out.println("					 게시물이 삭제되었습니다.");
				delete(board.getSaleId());
			} else {
				System.out.println("					 권한이 없습니다.");
				detail(m);
			}
			break;
		case 5 :
			
			break;
		case -1 :
			boardList();
			break;
		}
	}
	
	
	@Override
	public int rm() {
		return m;
	}
	
	@Override
	public void salecomplete(){
		board.setBuyId("");
		Scanner s = new Scanner(System.in);
		System.out.println("					 거래한 유저의 ID를 입력하세요.");
		System.out.print("					 입력 : ");
		String inputID = s.nextLine();
		
		messageService.completesendMessage(inputID);
		
		
		//board.setBuyId(inputID);
		//System.out.println("board.setBuyId : " + board.getBuyId());
	}
	
	@Override
	public void mdetail(int m) {
		UserVO session = Session.loginUser;
		
		
		Scanner s = new Scanner(System.in);
		try{
			board  = boardList.get(m);
		}catch(Exception e){
			System.out.print("					 다시입력 : ");
			int input =Integer.parseInt( s.nextLine());
			detail(input);
		}
		this.m = m ;
		board  = boardList.get(m);
		
		int z=board.getBoardNum();
		
		int gu = board.getRegion() / 100;
		int dong = board.getRegion() % 100; 
		String local = "";
		String panme ="";
		if(gu == 1){
			local = guarr[gu-1] + arr1[dong -1];
		} else if(gu == 2){
			local = guarr[gu-1] + arr2[dong -1];
		} else if (gu == 3){
			local = guarr[gu-1] + arr3[dong -1];
		} else if(gu == 4){
			local = guarr[gu-1] + arr4[dong -1];
		} else if (gu  == 5){
			local = guarr[gu-1] + arr5[dong -1];
		}
		if (board.isStatus()){
			panme="판매 완료";
		} else {
			panme="판매 중";
		}
		//출력
		System.out.println("					─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println("               					                                         "+(board.getBoardNum()-1) + "번 게시물");
		System.out.println("					─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println(" 					제목 : " + board.getTitle());
		System.out.println(" 					가격 : " + board.getPrice());
		System.out.println(" 					상태 : " + panme);
		System.out.println(" 					작성자 : " + board.getSaleId());
		System.out.println(" 					카테고리 : " + categoryArr[board.getCategory()-1]);
		System.out.println(" 					지역 : " + local); 
		System.out.println(" 					내용 : " + board.getContent());
		System.out.println(" 					넘버 : " + (board.getBoardNum()-1));
		System.out.println("					────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println("");
		System.out.println("					────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

		
		System.out.println("					┌───────┐  ┌──────────┐  ┌──────┐  ┌──────┐  ┌────────────────┐");
		System.out.println("					│1.찜하기 │  │2.쪽지보내기 │  │3.수정  │  │4.삭제  │  │-1.목록으로 돌아가기 │");
		System.out.println("					└───────┘  └──────────┘  └──────┘  └──────┘  └────────────────┘");
		System.out.print("					 입력 : ");
		int input =Integer.parseInt( s.nextLine());
		switch(input){
		case 1 :
			myinfoService.wishSelect(z);
			break;
		case 2 : 
			messageService.detailMessage(this.m);
			break;
		case 3 : 
			String a = session.getId();
			String b = board.getSaleId();
			if(a.equals(b)){
				System.out.println("						  ▶▶▶▶▶ 어떤 항목을 수정하시겠습니까? ◀◀◀◀◀");
				System.out.println("					┌──────┐  ┌──────┐  ┌─────────┐  ┌──────┐  ┌────────────┐  ┌──────────┐");
				System.out.println("					│1.제목  │  │2.가격  │  │3.카테고리  │  │4.내용  │  │5.판매상태 변경 │  │-1.돌아가기  │");
				System.out.println("					└──────┘  └──────┘  └─────────┘  └──────┘  └────────────┘  └──────────┘");
				System.out.print("					 입력 : ");
				input = Integer.parseInt( s.nextLine());
				change(input);
			}else{
				System.out.println("권한이 없습니다.");
				mdetail(m);
			}
			break;
		case 4 :
			a = session.getId();
			b = board.getSaleId();
			if(a.equals(b) || session.getGrade() == 0 ){
				System.out.println("					 게시물이 삭제되었습니다.");
				delete(board.getSaleId());
			} else {
				System.out.println("					 권한이 없습니다.");
				mdetail(m);
			}
			break;
		case -1 :
			myinfoService.mySaleList();
			break;
		}
	}

	@Override
	public void delete(String saleId){
		UserVO session = Session.loginUser ;
		String a = session.getId();
		if(a.equals(saleId) || session.getGrade() == 0){
			boardList.remove(this.m);
			//new Controller().mainmenu();
			boardList();
		}else{
			System.out.println("					 넌 안돼 인마!!!!!!!!!!!");
			detail(this.m);
		}
	}

	@Override
	public void change(int choice){

		Scanner s = new Scanner(System.in);
		boardList.get(this.m);
		String input;
		int input2;
		
		if(choice == 1){  //제목
			System.out.println("						※※※변경할 내용을 입력하세요※※※");
			System.out.print("					 입력 : ");
			input =s.nextLine();
			System.out.println("				     		※※※정상적으로 변경되었습니다.※※※");
			System.out.println("");
			board.setTitle(input);
			boardList();
		} else if (choice == 2){ //가격
			System.out.println("						※※※가격을을 변경할 내용을 입력하세요※※※");
			System.out.print("					 입력 : ");
			input2 =Integer.parseInt(s.nextLine());
			System.out.println("				     		※※※정상적으로 변경되었습니다.※※※");
			System.out.println("");
			board.setPrice(input2);
			boardList();
		} else if (choice == 3){ //카테고리
			System.out.println("						※※※변경할 내용을 입력하세요※※※");
			System.out.println("");
			System.out.print("					 입력 : ");
			
			
		} else if (choice == 4){ //내용
			System.out.println("					 변경할 내용을 입력하세요");
			System.out.print("					 입력 : ");
			input =s.nextLine();
			System.out.println("				     		※※※정상적으로 변경되었습니다.※※※");
			System.out.println("");
			board.setContent(input);
			boardList();
		}else if(choice ==5){//판매상태변경
			System.out.println("					               ▶▶▶ 판매가 완료 되었습니까? ◀◀◀");
			System.out.println("						┌──────┐   ┌────────┐");
			System.out.println("						│1. 예   │ / │2. 아니오 │");
			System.out.println("						└──────┘   └────────┘");
			System.out.print("					 입력 : ");
			input2 = Integer.parseInt( s.nextLine());
			if(input2 == 1){
				System.out.println("				     		※※※정상적으로 변경되었습니다.※※※");
				System.out.println("");
				board.setStatus(true);
				salecomplete();
			} else if (input2 ==2){
				odetail(m);
			}
		}else if(choice == -1){
			new Controller().mainmenu();	
		}
	}

	String[] categoryArr = new String[]{"디지털&가전","가구&인테리어","유아","식품","여성의류&잡화","남성의류&잡화","뷰티&미용",
			"스포츠&레저","게임","도서&티켓","반려동물용품","기타"};
	@Override
	public void category() {

		Scanner s = new Scanner(System.in);

		System.out.println("                          ┌──────────────────────────────카테고리──────────────────────────────┐");
		System.out.println("                          │1.디지털&가전  2.가구&인테리어  3.유아  4.식품         5.여성의류&잡화   6.남성의류&잡화 │");
		System.out.println("                          │7.뷰티&미용    8.스포츠&레저    9.게임  10.도서&티켓  11.반려동물용품   12.기타            │");
		System.out.println("                          │-1:뒤로가기                                                                                                                  │");
		System.out.println("                          └──────────────────────────────────────────────────────────────────┘");
		System.out.println(""); 
		System.out.println("                                                                                                   ▶▶▶▶▶ 원하는 카테고리에 해당하는 번호 입력 ◀◀◀◀◀");
		System.out.print("					 입력 : ");
		int input = Integer.parseInt(s.nextLine());
		
		if(input == -1) {
			new Controller().mainmenu(); 
		}

		// 카테고리에 맞는 게시물 띄워줘야함
		//효율적인 코딩중
		while(input!=-1){
			ArrayList<BoardVO> boardList = boardDao.selectBoardList();
			ArrayList<BoardVO> tb_board = new ArrayList<BoardVO>();

			//출력
			System.out.println("                    ──────────────────────────────────────────────────────────────────────────────────");
			System.out.println("                                           번호\t작성자\t\t      가격\t\t\t      제목");
			System.out.println("                    ──────────────────────────────────────────────────────────────────────────────────");
			
			BoardVO board =null;
			for(int i = 0; i < boardList.size() ; i++){
				board = boardList.get(i);
				if(input == board.getCategory()){
					System.out.println("                       "+i+ "\t" + board.getSaleId() + "\t\t "+ board.getPrice() + "\t\t" + board.getTitle());
				}
			}
			System.out.println("                    ──────────────────────────────────────────────────────────────────────────────────");
			System.out.println("");
			System.out.println("                    ──────────────────────────────────────────────────────────────────────────────────");


			//게시판의 한 행을 누르면 그 제품의 상세내역 보기
			System.out.println("                                                                                    ▶▶▶▶▶ 제품상세내역 번호를 선택하세요(-1을 입력시 뒤로 감) ◀◀◀◀◀");
			System.out.print("					 입력 : ");
			int input1 = Integer.parseInt(s.nextLine());
			if( input1 == (-1)){
				category();
			} else {
				odetail(input1);
			}
		}
	}

	
		String[] guarr = new String[]{"동구","중구","유성구","서구","대덕구"};
		
		String[] arr1 = new String[]{"원동","인동","효동","가오동","신흥동","판암동",
									"삼정동","용운동", "대동","대동","자양동","신안동",
									"가양동","용전동","성남동","홍도동","삼성동","정동",
									"중동","추동","비룡동","주산동","용계동","마산동",
									"효평동","직동","세천동","신상동","신하동","신촌동",
									"사성동","내탑동","오동","주촌동","낭월동","대별동",
									"이사동","대성동","장척동","소호동","구도동","삼괴동",
									"상소동","하소동","중앙동","신인동","판암동","가양동",
									"대청동","산내동"};
		
		String[] arr2 = new String[]{"은행동","선화동","목동","중촌동","대흥동","문창동",
				                     "석교동","옥계동","대사동","부사동","용두동","오류",
				                     "태평동","유천동","문화동","산성동","사정동","안영동",
				                     "무수동","구완동","침산동","목달동","정생동","어남동",
				                     "태평동","선화동","문화동"};
		
		String[] arr3 = new String[]{"원내동","교촌동","대정동","용계동","학하동","계산동",
									"성북동","세동","송정","방동","봉명동","구암동",
									"덕명동","신흥동","상대동","복용동","장대동","갑동",
									"노은동","지족동","죽동","궁동","어은동","구성동",
									"신성동","가정동","도룡동","장동","방현동","화암동",
									"덕진동","하기동","추목동","자운동","신봉동","수남동",
									"안산동","외삼동","반석동","문지동","전민동","원촌동",
									"탑립동","용산동","봉산동","관평동","송강동","금고동",
									"대동","금탄동","신동","둔곡동","구룡동","진잠동",
									"온천동","노은동","구즉동"};
									
		String[] arr4 = new String[]{"복수동","변동","도마동","정림동","용문동","탄방동",
									"괴정동","가장동","내동","갈마동","둔산동","월평동","가수원",
									"도안동","관저동","흑석동","매노동","산직동","장안동","평촌동",
									"오동","우명동","원정동","용촌동","봉곡동","봉곡동","괴곡동",
									"만년동","도마동","갈마동","기성동"};
			
		
		String[] arr5 = new String[]{"오정동","대화동","읍내동","연축동","신대동","와동",
									"송촌동","법동","중리동","비래동","석봉동","목상동","문평동","신일동",
									"덕암동","상서동","평촌동","장동","용호동","이현동","갈전동","부수동",
									"황호동","삼정동","미호동","신탄진","회덕동"};
		
		@Override
		public void region() {
		Scanner s = new Scanner(System.in);
		System.out.println("");
		System.out.println("");
		System.out.println("                                                                                           ▶▶▶▶▶ 원하는 지역(대전광역시)의  구를 선택해 주세요 ◀◀◀◀◀");
		System.out.println("                            ┌──────┐  ┌──────┐  ┌───────┐  ┌──────┐  ┌───────┐  ┌─────────┐");
		System.out.println("                            │1.동구  │  │2.중구  │  │3.유성구 │  │4.서구  │  │5.대덕구 │  │-1:뒤로가기│");
		System.out.println("                            └──────┘  └──────┘  └───────┘  └──────┘  └───────┘  └─────────┘");
		System.out.print("					 입력 : ");
		int input1 = Integer.parseInt(s.nextLine());
		
		if(input1 == 1){
			System.out.println("                             ┌─────────────────────동을 선택해 주세요─────────────────────────┐");
			System.out.println("                             │ 01.원동. / 02.인동. /03.효동. /04.가오동 /05.신흥동 /06.판암동 /   │");
			System.out.println("                             │ 07.삼정동 /08.용운동 /09.대동. /10.대동. /11.자양동 /12.신안동 /    │");
			System.out.println("                             │ 13.가양동 /14.용전동 /15.성남동 /16.홍도동 /17.삼성동 /18.정동. /    │");
			System.out.println("                             │ 19.중동. /21.추동. /22.비룡동 /23.주산동 /24.용계동 /25.마산동 /    │");
			System.out.println("                             │ 26.효평동 /27.직동. /28.세천동 /29.신상동 /30.신하동 /31.신촌동 /    │");
			System.out.println("                             │ 32.사성동 /33.오동. /34.내탑동 /35.주촌동 /36.낭월동 /37.대별동 /    │");
			System.out.println("                             │ 38.이사동 /39.대성동 /40.장척동 /41.소호동 /42.구도동 / 43.삼괴동 /   │");
			System.out.println("                             │ 44.상소동 /45.하소동 /46.중앙동 /47.신인동 /48.판암동 /49.가양동 /    │");
			System.out.println("                             │ 50.대청동/51.산내동/                                         │");
			System.out.println("                             └ ────────────────────────────────────────────────────━──── ┘");
			System.out.print("					 입력 : ");
			int input2 = Integer.parseInt(s.nextLine());
			int input3 = input1*100 + input2;
			System.out.println("				<지역 : " + guarr[input1-1]+ " " + arr1[input2-1]+">");
			System.out.println("				────────────────────────────────────────────────────────────────────────────────────────");
			System.out.println("				번호\t\t            제목\t\t                        가격\t\t                  작성자");
			System.out.println("				────────────────────────────────────────────────────────────────────────────────────────");
			for(int i = 0; i < boardList.size() ; i++){
				board = boardList.get(i);
				if(input3 == board.getRegion()){
					System.out.println("				"+i + "\t\t"+ board.getTitle() + "\t\t\t   "+ board.getPrice() + "\t\t " + board.getSaleId());
					System.out.println("");
					System.out.println("				────────────────────────────────────────────────────────────────────────────────────────");
				}
			}
			System.out.println("					 제품상세내역 번호를 선택하세요(-1을 입력시 지역선택으로 돌아갑니다.)");
			System.out.print("					 입력 : ");
			input1 =Integer.parseInt( s.nextLine());
			if( input1 == -1){
				region();
			} else {
				odetail(input1);
			}
		} else if(input1 == 2){
			System.out.println("                             ┌─────────────────────동을 선택해 주세요────────────────────────┐");
			System.out.println("                             │ 01.은행동/ 02.선화동/03.목동 /04.중촌동/05.대흥동 / 06.문창동 /    │");
			System.out.println("                             │ 07.석교동/ 08.옥계동/ 09.대사동/ 10.부사동/ 11.용두동/12.오류 /   │");
			System.out.println("                             │ 13.태평동 /14.유천동/ 15.문화동/ 16.산성동/ 17.사정동/ 18.안영동 / │");
			System.out.println("                             │ 19.무수동 /20.구완동/ 21.침산동/ 22.목달동/ 23.정생동/ 24.어남동 / │");
			System.out.println("                             │ 25.태평동 /26.선화동/ 27.문화동/                              │");
			System.out.println("                             └ ───────────────────────────────────────────────────━──── ┘");
			System.out.print("					 입력 : ");
			int input2 = Integer.parseInt(s.nextLine());
			int input3 = input1*100 + input2;
			System.out.println("				<지역 : " + guarr[input1-1]+ " " + arr2[input2-1]+">");
			System.out.println("				────────────────────────────────────────────────────────────────────────────────────────");
			System.out.println("				번호\t\t       제목\t\t                                   가격\t\t                  작성자");
			System.out.println("				────────────────────────────────────────────────────────────────────────────────────────");
			for(int i = 0; i < boardList.size() ; i++){
				board = boardList.get(i);
				if(input3 == board.getRegion()){
					System.out.println("				"+i + "\t\t" + board.getTitle() + "\t\t\t "+ board.getPrice() + "\t\t\t" + board.getSaleId());
					System.out.println("");
					System.out.println("				────────────────────────────────────────────────────────────────────────────────────────");
				}
			}
			System.out.println("					 제품상세내역 번호를 선택하세요(-1을 입력시 지역선택으로 돌아갑니다.)");
			System.out.print("					 입력 : ");
			input1 =Integer.parseInt( s.nextLine());
			if( input1 == -1){
				region();
			} else {
				odetail(input1);
			}
			//System.out.println(arr2[input2 - 1]);
		} else if(input1 == 3){
			System.out.println("                             ┌─────────────────────동을 선택해 주세요────────────────────────┐");
			System.out.println("                             │ 01.원내동 /02.교촌동 /03.대정동 /04.용계동 /05.학하동 /06.계산동 /   │");
			System.out.println("                             │ 07.성북동 /08.세동. /09.송정 /10.방동. /11.봉명동 /12.구암동/     │");
			System.out.println("                             │ 13.덕명동 /14.신흥동 /15.상대동 /16.복용동 /17.장대동 / 18.갑동/    │");
			System.out.println("                             │ 19.노은동 /20.지족동 /21.죽동. /22.궁동. /23.어은동 /24.구성동 /   │");
			System.out.println("                             │ 25.신성동 /26.가정동 /27.도룡동 /28.장동. /29.방현동 /30.화암동 /   │");
			System.out.println("                             │ 31.덕진동 /32.하기동 /33.추목동 /34.자운동 /35.신봉동 /36.수남동 /   │");
			System.out.println("                             │ 37.안산동 /38.외삼동 /39.반석동 /40.문지동 /41.전민동 /42.원촌동 /   │");
			System.out.println("                             │ 43.탑립동 /44.용산동 /45.봉산동 /46.관평동 /47.송강동 /48.금고동 /   │");
			System.out.println("                             │ 49.대동. /50.금탄동 /51.신동. /52.둔곡동 /53.구룡동 /54.진잠동 /   │");
			System.out.println("                             │ 55.온천동 /56.노은동 /57.구즉동   /                             │");
			System.out.println("                             └ ───────────────────────────────────────────────────━──── ┘");
			System.out.print("					 입력 : ");
			int input2 = Integer.parseInt(s.nextLine());
			int input3 = input1*100 + input2;
			System.out.println("				<지역 : " + guarr[input1-1]+ " " + arr3[input2-1]+">");
			System.out.println("				────────────────────────────────────────────────────────────────────────────────────────");
			System.out.println("				번호\t\t              제목\t\t                          가격\t\t          작성자");
			System.out.println("				────────────────────────────────────────────────────────────────────────────────────────");
			for(int i = 0; i < boardList.size() ; i++){
				board = boardList.get(i);
				if(input3 == board.getRegion()){
					System.out.println("				"+i + "\t\t" + board.getTitle() + "\t\t    "+ board.getPrice() + "\t\t    " + board.getSaleId());
					System.out.println("");
					System.out.println("				────────────────────────────────────────────────────────────────────────────────────────");
				}
			}
			System.out.println("					 제품상세내역 번호를 선택하세요(-1을 입력시 지역선택으로 돌아갑니다.)");
			System.out.print("					 입력 : ");
			input1 =Integer.parseInt( s.nextLine());
			if( input1 == -1){
				region();
			} else {
				odetail(input1);
			}
			//System.out.println(arr3[input2 - 1]);
		} else if(input1 == 4){
			System.out.println("                             ┌────────────────────동을 선택해 주세요─────────────────────────┐");
			System.out.println("                             │ 01.복수동 /02.변동. /03.도마동 /04.정림동 /05.용문동 /06.탄방동 /   │");
			System.out.println("                             │ 07.괴정동 /08.가장동 /09.내동. /10.갈마동 /11.둔산동 /12.월평동 /   │");
			System.out.println("                             │ 13.가수원 /14.도안동 /15.관저동 /16.흑석동 /17.매노동 /18.산직동 /   │");
			System.out.println("                             │ 19.장안동 /20.평촌동 /21.오동. /22.우명동 /23.원정동 /24.용촌동 /   │");
			System.out.println("                             │ 25.봉곡동 /26.봉곡동 /27.괴곡동 /28.만년동 /29.도마동 /30.갈마동 /   │");
			System.out.println("                             │ 31.기성동 /                                                │");
			System.out.println("                             └──────────────────────────────────────────────────────────┘");
			System.out.print("					 입력 : ");
			int input2 = Integer.parseInt(s.nextLine());
			int input3 = input1*100 + input2;
			System.out.println("				<지역 : " + guarr[input1-1]+ " " + arr4[input2-1]+">");
			System.out.println("				────────────────────────────────────────────────────────────────────────────────────────");
			System.out.println("				번호\t\t       제목\t\t                             가격\t\t            작성자");
			System.out.println("				────────────────────────────────────────────────────────────────────────────────────────");
			for(int i = 0; i < boardList.size() ; i++){
				board = boardList.get(i);
				if(input3 == board.getRegion()){
					System.out.println("				"+i + "\t\t" + board.getTitle() + "\t\t\t "+ board.getPrice() + "\t\t       " + board.getSaleId());
					System.out.println("");
					System.out.println("				────────────────────────────────────────────────────────────────────────────────────────");
				}
			}
			System.out.println("					 제품상세내역 번호를 선택하세요(-1을 입력시 지역선택으로 돌아갑니다.)");
			System.out.print("					 입력 : ");
			input1 =Integer.parseInt( s.nextLine());
			if( input1 == -1){
				region();
			} else {
				odetail(input1);
			}
		} else if(input1 == 5){
			System.out.println("                             ┌─────────────────────동을 선택해 주세요─────────────────────────┐");
			System.out.println("                             │ 01.오정동 /02.대화동 /03.읍내동 /04.연축동 /05.신대동 /06.와동. /    │");
			System.out.println("                             │ 07.송촌동 /08.법동. /09.중리동 /10.비래동 /11.석봉동 /12.목상동 /    │");
			System.out.println("                             │ 13.문평동 /14.신일동 /15.덕암동 /16.상서동 /17.평촌동 /18.장동. /    │");
			System.out.println("                             │ 19.용호동 /20.이현동 /21.갈전동 /22.부수동 /23.황호동 /24.삼정동 /    │");
			System.out.println("                             │ 25.미호동 /26.신탄진 /27.회덕동   /                              │");
			System.out.println("                             └───────────────────────────────────────────────────────────┘");
			System.out.print("					 입력 : ");
			int input2 = Integer.parseInt(s.nextLine());
			int input3 = input1*100 + input2;
			System.out.println("				<지역 : " + guarr[input1-1]+ " " + arr5[input2-1]+">");
			System.out.println("				────────────────────────────────────────────────────────────────────────────────────────");
			System.out.println("				번호\t\t       제목\t\t                                   가격\t\t            작성자");
			System.out.println("				────────────────────────────────────────────────────────────────────────────────────────");
			for(int i = 0; i < boardList.size() ; i++){
				board = boardList.get(i);
				if(input3 == board.getRegion()){
					System.out.println("				"+i + "\t" + board.getTitle() + "\t\t\t "+ board.getPrice() + "\t\t       " + board.getSaleId());
					System.out.println("");
					System.out.println("				────────────────────────────────────────────────────────────────────────────────────────");
				}
			}
			System.out.println("					 제품상세내역 번호를 선택하세요(-1을 입력시 지역선택으로 돌아갑니다.)");
			System.out.print("					 입력 : ");
			input1 =Integer.parseInt( s.nextLine());
			if( input1 == -1){
				region();
			} else {
				odetail(input1);
			}
			//System.out.println(arr5[input2 - 1]);
		} else if(input1 == -1) {
			new Controller().mainmenu(); //main에 public 줬음.
		}else {
			System.out.println("					※※※※※ 다시 입력해주세요! ※※※※※");
			region();
		}
	}

	int count = 101;  //선욱씨의 보드넘

	@Override
	public void sale() {

		//추가할 것 :  등록할 시각, 댓글, 
		Scanner s =new Scanner(System.in);

		System.out.println("                             ┌──────────────────────────────카테고리──────────────────────────────┐");
		System.out.println("                             │1.디지털&가전  2.가구&인테리어  3.유아  4.식품         5.여성의류&잡화   6.남성의류&잡화 │");
		System.out.println("                             │7.뷰티&미용    8.스포츠&레저    9.게임  10.도서&티켓  11.반려동물용품   12.기타            │");
		System.out.println("                             │-1:뒤로가기                                                                                                                  │");
		System.out.println("                             └──────────────────────────────────────────────────────────────────┘");
		System.out.println("");
		System.out.println("							▶▶▶▶▶ 원하는 카테고리에 해당하는 번호 입력 ◀◀◀◀◀");
		System.out.print("					 입력 : ");
		int category = Integer.parseInt(s.nextLine());
		

		System.out.println("");
		System.out.println("");
		System.out.println("					  	 ▶▶▶▶▶ 원하는 지역(대전광역시)의  구를 선택해 주세요 ◀◀◀◀◀");
		System.out.println("                            ┌──────┐  ┌──────┐  ┌───────┐  ┌──────┐  ┌───────┐  ┌─────────┐");
		System.out.println("                            │1.동구  │  │2.중구  │  │3.유성구 │  │4.서구  │  │5.대덕구 │  │-1:뒤로가기  │");
		System.out.println("                            └──────┘  └──────┘  └───────┘  └──────┘  └───────┘  └─────────┘");
		System.out.print("					 입력 : ");
		int input1 = Integer.parseInt(s.nextLine());
		int input2 = 0;
		int input3 = 0;
		int region = 0;
		if(input1 == 1){
			System.out.println("                             ┌─────────────────────동을 선택해 주세요─────────────────────────┐");
			System.out.println("                             │ 01.원동. / 02.인동. /03.효동. /04.가오동 /05.신흥동 /06.판암동 /   │");
			System.out.println("                             │ 07.삼정동 /08.용운동 /09.대동. /10.대동. /11.자양동 /12.신안동 /    │");
			System.out.println("                             │ 13.가양동 /14.용전동 /15.성남동 /16.홍도동 /17.삼성동 /18.정동. /    │");
			System.out.println("                             │ 19.중동. /21.추동. /22.비룡동 /23.주산동 /24.용계동 /25.마산동 /    │");
			System.out.println("                             │ 26.효평동 /27.직동. /28.세천동 /29.신상동 /30.신하동 /31.신촌동 /    │");
			System.out.println("                             │ 32.사성동 /33.오동. /34.내탑동 /35.주촌동 /36.낭월동 /37.대별동 /    │");
			System.out.println("                             │ 38.이사동 /39.대성동 /40.장척동 /41.소호동 /42.구도동 / 43.삼괴동 /   │");
			System.out.println("                             │ 44.상소동 /45.하소동 /46.중앙동 /47.신인동 /48.판암동 /49.가양동 /    │");
			System.out.println("                             │ 50.대청동/51.산내동/                                         │");
			System.out.println("                             └───────────────────────────────────────────────────────────┘");
			System.out.print("					 입력 : ");
			 input2 = Integer.parseInt(s.nextLine());
			 input3 = input1*100 + input2;
			 region = input3;
		} else if(input1 == 2){
			System.out.println("				┌─────────────────────동을 선택해 주세요────────────────────────┐");
			System.out.println("				│ 01.은행동/ 02.선화동/03.목동 /04.중촌동/05.대흥동 / 06.문창동 /    │");
			System.out.println("				│ 07.석교동/ 08.옥계동/ 09.대사동/ 10.부사동/ 11.용두동/12.오류 /   │");
			System.out.println("				│ 13.태평동 /14.유천동/ 15.문화동/ 16.산성동/ 17.사정동/ 18.안영동 / │");
			System.out.println("				│ 19.무수동 /20.구완동/ 21.침산동/ 22.목달동/ 23.정생동/ 24.어남동 / │");
			System.out.println("				│ 25.태평동 /26.선화동/ 27.문화동/                              │");
			System.out.println("				└──────────────────────────────────────────────────────────┘");
			System.out.print("					 입력 : ");
			 input2 = Integer.parseInt(s.nextLine());
			 input3 = input1*100 + input2;
			 region = input3;
			
		} else if(input1 == 3){
			System.out.println("				┌─────────────────────동을 선택해 주세요────────────────────────┐");
			System.out.println("				│ 01.원내동 /02.교촌동 /03.대정동 /04.용계동 /05.학하동 /06.계산동 /   │");
			System.out.println("				│ 07.성북동 /08.세동. /09.송정 /10.방동. /11.봉명동 /12.구암동/     │");
			System.out.println("				│ 13.덕명동 /14.신흥동 /15.상대동 /16.복용동 /17.장대동 / 18.갑동/    │");
			System.out.println("				│ 19.노은동 /20.지족동 /21.죽동. /22.궁동. /23.어은동 /24.구성동 /   │");
			System.out.println("				│ 25.신성동 /26.가정동 /27.도룡동 /28.장동. /29.방현동 /30.화암동 /   │");
			System.out.println("				│ 31.덕진동 /32.하기동 /33.추목동 /34.자운동 /35.신봉동 /36.수남동 /   │");
			System.out.println("				│ 37.안산동 /38.외삼동 /39.반석동 /40.문지동 /41.전민동 /42.원촌동 /   │");
			System.out.println("				│ 43.탑립동 /44.용산동 /45.봉산동 /46.관평동 /47.송강동 /48.금고동 /   │");
			System.out.println("				│ 49.대동. /50.금탄동 /51.신동. /52.둔곡동 /53.구룡동 /54.진잠동 /   │");
			System.out.println("				│ 55.온천동 /56.노은동 /57.구즉동   /                             │");
			System.out.println("				└──────────────────────────────────────────────────────────┘");
			System.out.print("					 입력 : ");
			 input2 = Integer.parseInt(s.nextLine());
			 input3 = input1*100 + input2;
			 region = input3;
		} else if(input1 == 4){
			System.out.println("				┌────────────────────동을 선택해 주세요─────────────────────────┐");
			System.out.println("				│ 01.복수동 /02.변동. /03.도마동 /04.정림동 /05.용문동 /06.탄방동 /   s│");
			System.out.println("				│ 07.괴정동 /08.가장동 /09.내동. /10.갈마동 /11.둔산동 /12.월평동 /   │");
			System.out.println("				│ 13.가수원 /14.도안동 /15.관저동 /16.흑석동 /17.매노동 /18.산직동 /   │");
			System.out.println("				│ 19.장안동 /20.평촌동 /21.오동. /22.우명동 /23.원정동 /24.용촌동 /   │");
			System.out.println("				│ 25.봉곡동 /26.봉곡동 /27.괴곡동 /28.만년동 /29.도마동 /30.갈마동 /   │");
			System.out.println("				│ 31.기성동 /                                                │");
			System.out.println("				└──────────────────────────────────────────────────────────┘");
			System.out.print("					 입력 : ");
			 input2 = Integer.parseInt(s.nextLine());
			 input3 = input1*100 + input2;
			 region = input3;
		} else if(input1 == 5){
			System.out.println("				┌─────────────────────동을 선택해 주세요─────────────────────────┐");
			System.out.println("				│ 01.오정동 /02.대화동 /03.읍내동 /04.연축동 /05.신대동 /06.와동. /    │");
			System.out.println("				│ 07.송촌동 /08.법동. /09.중리동 /10.비래동 /11.석봉동 /12.목상동 /    │");
			System.out.println("				│ 13.문평동 /14.신일동 /15.덕암동 /16.상서동 /17.평촌동 /18.장동. /    │");
			System.out.println("				│ 19.용호동 /20.이현동 /21.갈전동 /22.부수동 /23.황호동 /24.삼정동 /    │");
			System.out.println("				│ 25.미호동 /26.신탄진 /27.회덕동   /                              │");
			System.out.println("				└───────────────────────────────────────────────────────────┘");
			System.out.print("					 입력 : ");
			 input2 = Integer.parseInt(s.nextLine());
			 input3 = input1*100 + input2;
			 region = input3;
		} else if(input1 == -1) {
			new Controller().mainmenu(); //main에 public 줬음.
		}else {
			System.out.println("					※※※※※ 다시 입력해주세요! ※※※※※");
		}
		Date today = new Date(); //현재 날짜
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd hh:mm");
		String format = sdf1.format(today);
	
		System.out.print("						● 제목 : ");
		String title = s.nextLine();
		System.out.print("						● 제품명 : ");
		String product = s.nextLine();
		System.out.print("						● 가격 : ");
		int price = Integer.parseInt(s.nextLine());
		System.out.print("						● 내용 : ");
		String content = s.nextLine();

		BoardVO board = new BoardVO();
		UserVO user = new UserVO();
		UserVO session = Session.loginUser ;

		String a = session.getId();

		board.setCategory(category);
		board.setRegion(region);
		board.setTitle(title);
		board.setProduct(product);
		board.setPrice(price);
		board.setContent(content);
		board.setStatus(false);
		board.setSaleId(a);
		board.setBoardNum(count);
		board.setDate(format);
		board.setBuyId(null);
		board.setStarScore(5);
		boardDao.insertBoard(board);
		count++;
	}
	
	@Override
	public void myInfo() {
		//탈퇴하기,  찜리스트, 구매내역, 판매내역, 공지사항
		Scanner s =new Scanner(System.in);
		UserVO session = Session.loginUser ;

		String a = session.getId();
		String b = session.getPhonenum();
		System.out.print("					 ID : " + a);
		System.out.print("					 Phone : " + b);

		System.out.println("					┌─────────┐  ┌─────────┐  ┌─────────┐  ┌─────────┐  ┌─────────┐");
		System.out.println("					│1.찜리스트  │  │2.구매내역  │  │3.판매내역  │  │4.공지사항  │  │-1.돌아가기│");
		System.out.println("					└─────────┘  └─────────┘  └─────────┘  └─────────┘  └─────────┘");
		System.out.print("					 입력 : ");
		int c = Integer.parseInt(s.nextLine());
		if(c == 1){
				wishList();
		}else if(c == 2){
			
		}else if(c == 3){
			
		}else if(c == 4){
			
		}else if(c == -1){
			new Controller().mainmenu();
		}

	}
	
	@Override
	public void wishSelect() {
		boardList.get(this.m);
		UserVO user = new UserVO();
		Session.loginUser = user;
		
		if(user.isWish()){
			user.setWish(false);
		}else{
			user.setWish(true);
		}
	}
	
	@Override
	public void wishList() {
		UserVO user = new UserVO();
		Session.loginUser = user;
	}

	@Override
	public void search() {
		Scanner s = new Scanner(System.in);
		ArrayList<BoardVO> boardList = boardDao.selectBoardList();
		
		BoardVO board = null;
		
		System.out.println("");
		System.out.println("						▶▶▶▶▶ 어떤 종류로 찾으시겠습니까? ◀◀◀◀◀");
		System.out.println("					┌──────┐  ┌───────┐  ┌──────┐  ┌────────┐  ┌─────────┐");
		System.out.println("					│1.ID  │  │2. 제목  │  │3.내용  │  │4.가격대   │  │-1.돌아가기│");
		System.out.println("					└──────┘  └───────┘  └──────┘  └────────┘  └─────────┘");
		System.out.print("					 입력 : ");
		int input = Integer.parseInt(s.nextLine());
		int count = 0;
		
		if(input ==1) {
			System.out.print("					검색어 입력 : ");
			String a = s.nextLine();
			
			ArrayList<Integer> sok = new ArrayList<Integer>();
			
			System.out.println("				───────────────────────────────────────────────────────────────────────────────────────────────────────────");
			System.out.println("				   \t번호\t\t              아이디\t\t                  가격\t\t                    제목");
			System.out.println("				───────────────────────────────────────────────────────────────────────────────────────────────────────────");
			
			for(int i = 0; i < boardList.size() ; i++){

				board = boardList.get(i);
				
				if(board.getSaleId().contains(a) && board.getSaleId().length() == a.length() ) {
					System.out.println("		\t\t\t" + i + "\t\t\t"  + board.getSaleId()+ "\t\t\t" + board.getPrice()  + "\t\t\t"+ board.getTitle());
					System.out.println("");
					System.out.println("				───────────────────────────────────────────────────────────────────────────────────────────────────────────");
				
					count++;
					sok.add(i);
				}
			}
			if(count == 0){
				System.out.print("					 검색결과가 없습니다");
			search();
			}else{
				System.out.println("					▶▶▶▶▶ 제품상세내역 번호를 선택하세요(-1을 입력시 뒤로 감) ◀◀◀◀◀");
				System.out.print("					 입력 : ");
				input = Integer.parseInt(s.nextLine());
				boolean sok2 = false;
				if(input == -1){
					search();
				}else{
					for(int i = 0 ; i<sok.size(); i++){
						if(sok.get(i) == input){
							sok2 = true;
						}
					}
					if(sok2){
						sdetail(input);
					} else {
						System.out.print("					 잘못된 정보입니다. 다시 입력해주세요.");
						search();
					}
				}
			}
		} else if (input==2) {
			System.out.print("					검색어 입력 : ");
			String a = s.nextLine();
			System.out.println("				───────────────────────────────────────────────────────────────────────────────────────────────────────────");
			System.out.println("				   \t번호\t\t              아이디\t\t                  가격\t\t                    제목");
			System.out.println("				───────────────────────────────────────────────────────────────────────────────────────────────────────────");
			
			ArrayList<Integer> sok = new ArrayList<Integer>();
			for(int i = 0; i < boardList.size() ; i++){

				board = boardList.get(i);
				if(board.getTitle().contains(a)) {
					System.out.println("		\t\t\t" + i + "\t\t\t"  + board.getSaleId()+ "\t\t\t" + board.getPrice()  + "\t\t\t"+ board.getTitle());
					System.out.println("");
					System.out.println("				───────────────────────────────────────────────────────────────────────────────────────────────────────────");
					count++;
					sok.add(i);
				}
			}
			if(count == 0){
				System.out.print("					 검색결과가 없습니다");
				search();
			}else{
				System.out.println("					▶▶▶▶▶ 제품상세내역 번호를 선택하세요(-1을 입력시 뒤로 감) ◀◀◀◀◀");
				System.out.print("					 입력 : ");
				input = Integer.parseInt(s.nextLine());
				
				boolean sok2 = false;
				if(input == -1){
					search();
				}else{
					for(int i = 0 ; i<sok.size(); i++){
						if(sok.get(i) == input){
							sok2 = true;
						}
					}
					if(sok2){
						sdetail(input);
					} else {
						System.out.print("					 잘못된 정보입니다. 다시 입력해주세요.");
						search();
					}
				}
			}
		} else if (input==3) {
			System.out.print("					검색어 입력 : ");
			String a = s.nextLine();
			System.out.println("				───────────────────────────────────────────────────────────────────────────────────────────────────────────");
			System.out.println("				   \t번호\t\t              아이디\t\t                  가격\t\t                    제목");
			System.out.println("				───────────────────────────────────────────────────────────────────────────────────────────────────────────");
			
			ArrayList<Integer> sok = new ArrayList<Integer>();
			for(int i = 0; i < boardList.size() ; i++){

				board = boardList.get(i);
				if(board.getContent().contains(a)) {
					System.out.println("		\t\t\t" + i + "\t\t\t"  + board.getSaleId()+ "\t\t\t" + board.getPrice()  + "\t\t\t"+ board.getTitle());
					System.out.println("");
					System.out.println("				───────────────────────────────────────────────────────────────────────────────────────────────────────────");
				
					count++;
					sok.add(i);
				}
			}
			if(count == 0){
				System.out.print("					 검색결과가 없습니다");
				search();
			}else{
				System.out.println("					▶▶▶▶▶ 제품상세내역 번호를 선택하세요(-1을 입력시 뒤로 감) ◀◀◀◀◀");
				System.out.print("					 입력 : ");
				input = Integer.parseInt(s.nextLine());
				boolean sok2 = false;
				if(input == -1){
					search();
				}else{
					for(int i = 0 ; i<sok.size(); i++){
						if(sok.get(i) == input){
							sok2 = true;
						}
					}
					if(sok2){
						sdetail(input);
					} else {
						System.out.print("					 잘못된 정보입니다. 다시 입력해주세요.");
						search();
					}
				}
			}
		} else if (input==4) {
			boolean check;
			int a;
			int b;
			do{
				check = false;
				System.out.print("					최소가격 입력 : ");
				a =Integer.parseInt( s.nextLine());
				System.out.print("					최대가격 입력 : ");
				b =Integer.parseInt( s.nextLine());
				if(a>b){
					System.out.println("					 최대가격이 최소가격보다 작습니다!!수정해주세요");
					check =true;
				}
			}while(check);
			
			ArrayList<Integer> sok = new ArrayList<Integer>();
			
			System.out.println("				───────────────────────────────────────────────────────────────────────────────────────────────────────────");
			System.out.println("				   \t번호\t\t              아이디\t\t                  가격\t\t                    제목");
			System.out.println("				───────────────────────────────────────────────────────────────────────────────────────────────────────────");
			
			for(int i = 0; i < boardList.size() ; i++){
				board = boardList.get(i);
				if( a < board.getPrice() && board.getPrice() < b) {
					System.out.println("		\t\t\t" + i + "\t\t\t"  + board.getSaleId()+ "\t\t\t" + board.getPrice()  + "\t\t\t"+ board.getTitle());
					System.out.println("");
					System.out.println("				───────────────────────────────────────────────────────────────────────────────────────────────────────────");
				
					count++;
					sok.add(i);
				}
			}
			
			//검색결과가 없습니다출력
			if(count == 0){
				System.out.println("					 검색결과가 없습니다");
				search();
			}else{
				System.out.println("					▶▶▶▶▶ 제품상세내역 번호를 선택하세요(-1을 입력시 뒤로 감) ◀◀◀◀◀");
				System.out.print("					 입력 : ");
				input = Integer.parseInt(s.nextLine());
				boolean sok2 = false;
				if(input == -1){
					search();
				}else{
					for(int i = 0 ; i<sok.size(); i++){
						if(sok.get(i) == input){
							sok2 = true;
						}
					}
					if(sok2){
						sdetail(input);
					} else {
						System.out.println("					 잘못된 정보입니다. 다시 입력해주세요.");
						search();
					}
				}
			}
		} else if (input==-1) {
			new Controller().mainmenu();
		}

	}

	
	@Override
	public void sdetail(int m){
		
		UserVO session = Session.loginUser;
		
		Scanner s = new Scanner(System.in);
		
		try{
			board  = boardList.get(m);
		}catch(Exception e){
			System.out.print("					 다시입력 : ");
			int input =Integer.parseInt( s.nextLine());
			sdetail(input);
		}
		this.m = m ;
		board  = boardList.get(m);
		
		int z=board.getBoardNum();
		
		int gu = board.getRegion() / 100;
		int dong = board.getRegion() % 100; 
		String local = "";
		String panme ="";
		if(gu == 1){
			local = guarr[gu-1] + arr1[dong -1];
		} else if(gu == 2){
			local = guarr[gu-1] + arr2[dong -1];
		} else if (gu == 3){
			local = guarr[gu-1] + arr3[dong -1];
		} else if(gu == 4){
			local = guarr[gu-1] + arr4[dong -1];
		} else if (gu  == 5){
			local = guarr[gu-1] + arr5[dong -1];
		}
		if (board.isStatus()){
			panme="판매 완료";
		} else {
			panme="판매 중";
		}
		//출력
		System.out.println("					─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println("               					                                         "+(board.getBoardNum()-1) + "번 게시물");
		System.out.println("					─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println(" 					제목 : " + board.getTitle());
		System.out.println(" 					가격 : " + board.getPrice());
		System.out.println(" 					상태 : " + panme);
		System.out.println(" 					작성자 : " + board.getSaleId());
		System.out.println(" 					카테고리 : " + categoryArr[board.getCategory()-1]);
		System.out.println(" 					지역 : " + local);
		System.out.println(" 					내용 : " + board.getContent());
		System.out.println(" 					넘버 : " + (board.getBoardNum()-1));
		System.out.println("					────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println("");
		System.out.println("					────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

		
		System.out.println("					┌───────┐  ┌──────────┐  ┌──────┐  ┌──────┐  ┌────────────────┐");
		System.out.println("					│1.찜하기 │  │2.쪽지보내기 │  │3.수정  │  │4.삭제  │  │-1.목록으로 돌아가기 │");
		System.out.println("					└───────┘  └──────────┘  └──────┘  └──────┘  └────────────────┘");
		System.out.print("					 입력 : ");
		int input =Integer.parseInt( s.nextLine());
		switch(input){
		case 1 :
			myinfoService.wishSelect(z);
			break;
		case 2 : 
			messageService.detailMessage(this.m);
			break;
		case 3 : 
			String a = session.getId();
			String b = board.getSaleId();
			if(a.equals(b)){
				System.out.println("						  ▶▶▶▶▶ 어떤 항목을 수정하시겠습니까? ◀◀◀◀◀");
				System.out.println("					┌──────┐  ┌──────┐  ┌─────────┐  ┌──────┐  ┌────────────┐  ┌──────────┐");
				System.out.println("					│1.제목  │  │2.가격  │  │3.카테고리  │  │4.내용  │  │5.판매상태 변경 │  │-1.돌아가기  │");
				System.out.println("					└──────┘  └──────┘  └─────────┘  └──────┘  └────────────┘  └──────────┘");
				System.out.print("					 입력 : ");
				input =Integer.parseInt( s.nextLine());
				change(input);
			}else{
				System.out.println("					 권한이 없습니다.");
				System.out.println("					 번호를 입력하면 상세내역을 볼 수 있어요(-1 : 돌아가기)");
				input = Integer.parseInt(s.nextLine());
				if(input == -1){
					search();
				}else{
				sdetail(input);
				}
			}
			break;
		case 4 :
			a = session.getId();
			b = board.getSaleId();
			if(a.equals(b) || session.getGrade() == 0 ){
				System.out.println("					 게시물이 삭제되었습니다.");
				delete(board.getSaleId());
				
			} else {
				System.out.println("					 권한이 없습니다.");
				sdetail(m);
			}
			break;
		case 5 :
//			System.out.println("판매가 완료 되었습니까?");
//			System.out.println("1. 예  / 2. 아니오");
//			input = Integer.parseInt( s.nextLine());
//			if(input == 1){
//				salecomplete();
//			} else if (input ==2){
//				detail(m);
//			}
			
			break;
		case -1:
			search();
//			boardList();
			break;
		}
	}
	
	@Override
	public void purchaseList() {
		
		
	}

	@Override
	public void buyList() {
		
		
	}

	
	
	
	/////
	@Override
	public void odetail(int m) {
		UserVO session = Session.loginUser;
		Scanner s = new Scanner(System.in);
		
		try{
			board  = boardList.get(m);
		}catch(Exception e){
			System.out.print("					 다시입력 : ");
			int input =Integer.parseInt( s.nextLine());
			detail(input);
		}
		this.m = m ;
		board  = boardList.get(m);
		
		int z=board.getBoardNum();
		
		int gu = board.getRegion() / 100;
		int dong = board.getRegion() % 100; 
		String local = "";
		String panme ="";
		if(gu == 1){
			local = guarr[gu-1] + arr1[dong -1];
		} else if(gu == 2){
			local = guarr[gu-1] + arr2[dong -1];
		} else if (gu == 3){
			local = guarr[gu-1] + arr3[dong -1];
		} else if(gu == 4){
			local = guarr[gu-1] + arr4[dong -1];
		} else if (gu  == 5){
			local = guarr[gu-1] + arr5[dong -1];
		}
		if (board.isStatus()){
			panme="판매 완료";
		} else {
			panme="판매 중";
		}
		//출력
		System.out.println("					─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println("               					                                         "+(board.getBoardNum()-1) + "번 게시물");
		System.out.println("					─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println(" 					제목 : " + board.getTitle());
		System.out.println(" 					가격 : " + board.getPrice());
		System.out.println(" 					상태 : " + panme);
		System.out.println(" 					작성자 : " + board.getSaleId());
		System.out.println(" 					카테고리 : " + categoryArr[board.getCategory()-1]);
		System.out.println(" 					지역 : " + local);
		System.out.println(" 					내용 : " + board.getContent());
		System.out.println(" 					넘버 : " + (board.getBoardNum()-1));
		System.out.println("					────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println("");
		System.out.println("					────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		
		System.out.println("					┌───────┐  ┌──────────┐  ┌──────┐  ┌──────┐  ┌────────────────┐");
		System.out.println("					│1.찜하기 │  │2.쪽지보내기 │  │3.수정  │  │4.삭제  │  │-1.목록으로 돌아가기 │");
		System.out.println("					└───────┘  └──────────┘  └──────┘  └──────┘  └────────────────┘");
		System.out.print("					 입력 : ");
		int input =Integer.parseInt( s.nextLine());
		switch(input){
		case 1 :
			myinfoService.wishSelect(z);
			break;
		case 2 : 
			messageService.detailMessage(this.m);
			break;
		case 3 : 
			
			String a = session.getId();
			String b = board.getSaleId();
			
			if(a.equals(b)){
				System.out.println("						  ▶▶▶▶▶ 어떤 항목을 수정하시겠습니까? ◀◀◀◀◀");
				System.out.println("					┌──────┐  ┌──────┐  ┌─────────┐  ┌──────┐  ┌────────────┐  ┌──────────┐");
				System.out.println("					│1.제목  │  │2.가격  │  │3.카테고리  │  │4.내용  │  │5.판매상태 변경 │  │-1.돌아가기  │");
				System.out.println("					└──────┘  └──────┘  └─────────┘  └──────┘  └────────────┘  └──────────┘");
				System.out.print("					 입력 : ");
				input =Integer.parseInt( s.nextLine());
				change(input);
			}else{
				System.out.println("					 권한이 없습니다.");
				detail(m);
			}
			break;
		case 4 :  //김영호
			a = session.getId();
			b = board.getSaleId();
			if(a.equals(b) || session.getGrade() == 0 ){
				System.out.println("					 게시물이 삭제되었습니다.");
				delete(board.getSaleId());
			} else {
				System.out.println("					 권한이 없습니다.");
				detail(m);
			}
			break;
		case 5 :
			
			break;
		case -1 :
			new Controller().mainmenu();
			break;
		}
		
	}

	





}
