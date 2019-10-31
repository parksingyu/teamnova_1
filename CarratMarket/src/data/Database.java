package data;

import java.util.ArrayList;

import vo.BoardVO;
import vo.MessageVO;
import vo.MyinfoVO;
import vo.NoticeVO;
import vo.UserVO;

public class Database {

	private static Database instance;
	private Database(){}
	
	public static Database getInstance(){
		if(instance == null){
			instance = new Database();
		}
		return instance;
	}
	public ArrayList<UserVO> tb_user = new ArrayList<UserVO>();
	
	{
		UserVO admin1 = new UserVO();
		admin1.setId("admin1");
		admin1.setPassword("admin1");
		admin1.setName("김영호");
		admin1.setPhonenum("010-1111-1111");
		admin1.setGrade(0);
		tb_user.add(admin1);
		
		UserVO admin2 = new UserVO();
		admin2.setId("admin2");
		admin2.setPassword("admin2");
		admin2.setName("최도혁");
		admin2.setPhonenum("010-2222-2222");
		admin2.setGrade(0);
		tb_user.add(admin2);
		
		UserVO admin3 = new UserVO();
		admin3.setId("admin3");
		admin3.setPassword("admin3");
		admin3.setName("이선욱");
		admin3.setPhonenum("010-3333-3333");
		admin3.setGrade(0);
		tb_user.add(admin3);
		
		UserVO admin4 = new UserVO();
		admin4.setId("admin4");
		admin4.setPassword("admin4");
		admin4.setName("이이슬");
		admin4.setPhonenum("010-4444-4444");
		admin4.setGrade(0);
		tb_user.add(admin4);
		
		UserVO admin5 = new UserVO();
		admin5.setId("admin5");
		admin5.setPassword("admin5");
		admin5.setName("박신규");
		admin5.setPhonenum("010-5555-5555");
		admin5.setGrade(0);
		tb_user.add(admin5);
		
		UserVO adminm = new UserVO();
		adminm.setId("adminm");
		adminm.setPassword("adminm");
		adminm.setName("박신규");
		adminm.setPhonenum("010-5555-5555");
		adminm.setGrade(0);
		tb_user.add(adminm);
		
		UserVO user1 = new UserVO();
		user1.setId("user1");
		user1.setPassword("user1");
		user1.setName("김영호");
		user1.setPhonenum("010-1111-1111");
		user1.setGrade(1);
		tb_user.add(user1);
		
		UserVO user2 = new UserVO();
		user2.setId("user2");
		user2.setPassword("user2");
		user2.setName("최도혁");
		user2.setPhonenum("010-2222-2222");
		user2.setGrade(1);
		tb_user.add(user2);
		
		UserVO user3 = new UserVO();
		user3.setId("user3");
		user3.setPassword("user3");
		user3.setName("이선욱");
		user3.setPhonenum("010-3333-3333");
		user3.setGrade(1);
		tb_user.add(user3);
		
		UserVO user4 = new UserVO();
		user4.setId("user4");
		user4.setPassword("user4");
		user4.setName("오동규");
		user4.setPhonenum("010-5641-4743");
		user4.setGrade(1);
		tb_user.add(user4);
		
		UserVO user5 = new UserVO();
		user5.setId("user5");
		user5.setPassword("user5");
		user5.setName("박재욱");
		user5.setPhonenum("010-2165-1486");
		user5.setGrade(1);
		tb_user.add(user5);
		
		UserVO user6 = new UserVO();
		user6.setId("user6");
		user6.setPassword("user6");
		user6.setName("전보영");
		user6.setPhonenum("010-2181-9513");
		user6.setGrade(1);
		tb_user.add(user6);
		
		UserVO user7 = new UserVO();
		user7.setId("user7");
		user7.setPassword("user7");
		user7.setName("오제민");
		user7.setPhonenum("010-4981-2745");
		user7.setGrade(1);
		tb_user.add(user7);
		
		UserVO user8 = new UserVO();
		user8.setId("user8");
		user8.setPassword("user8");
		user8.setName("김명성");
		user8.setPhonenum("010-4567-1234");
		user8.setGrade(1);
		tb_user.add(user8);
		
		UserVO user9 = new UserVO();
		user9.setId("user9");
		user9.setPassword("user9");
		user9.setName("박희제");
		user9.setPhonenum("010-1329-1324");
		user9.setGrade(1);
		tb_user.add(user9);
		
		UserVO user10 = new UserVO();
		user10.setId("user10");
		user10.setPassword("user10");
		user10.setName("현솔비");
		user10.setPhonenum("010-1493-7621");
		user10.setGrade(1);
		tb_user.add(user10);
	}
	
	public ArrayList<BoardVO> tb_board = new ArrayList<BoardVO>();
	{
		
		BoardVO board = new BoardVO();
		
		board.setTitle("이케아 레르베리 선반 입니다.");
		board.setProduct("이케아 선반");
		board.setContent("사이즈는 60*148이고 책을 정리하게 되어 필요 없어져서 판매합니다.");
		board.setPrice(80000);
		board.setRegion(321);
		board.setCategory(2);
		board.setStatus(false);
		board.setDate("10-22 15:21");
		board.setSaleId("user1");
		board.setBoardNum(1);
		tb_board.add(board);
		
		BoardVO board2 = new BoardVO();
		
		board2.setTitle("(급매) 가격다운! 소파 베드 1년 사용");
		board2.setProduct("에보니아가구 소파 >_<!!");
		board2.setContent("소파도 되고 베드도 되는 소파베드 1년 사용한거 팝니다. 에보니아 가구꺼 펜션에서 사용했고 6개 있습니다.");
		board2.setPrice(100000);
		board2.setRegion(507);
		board2.setCategory(2);
		board2.setStatus(false);
		board2.setDate("10-14 19:41");
		board2.setSaleId("user2");
		board2.setBoardNum(2);
		tb_board.add(board2);
		
		BoardVO board3 = new BoardVO();
		
		board3.setTitle("쌀독 팝니다~!!!");
		board3.setProduct("도자기 쌀독");
		board3.setContent("도자기로 된 꽤 큰 쌀독입니다. 전통의 쌀맛을 느끼고 싶다면 지금바로 구매하세요!! (직접 받으러 와주셔야 합니다. ㅠㅠ)");
		board3.setPrice(50000);
		board3.setRegion(508);
		board3.setCategory(3);
		board3.setStatus(false);
		board3.setDate("10-17 18:02");
		board3.setSaleId("user3");
		board3.setBoardNum(3);
		tb_board.add(board3);
		
		BoardVO board4 = new BoardVO();
		
		board4.setTitle("테이블/의자 판매해요");
		board4.setProduct("카페에서 사용하는 테이블 및 의자");
		board4.setContent("카페 정리하며 사용하던 의자와 테이블 판매해요. 원형 테이블은 같은 디자인 작은사이즈도 있는데 저건 큰 사이즈라 식탁으로도 사용 가능해요"
				+ "의자는 화이트 의자와 원목 의자 두 종류 있고 개당 2만원씩에 처분합니다.");
		board4.setPrice(20000);
		board4.setRegion(410);
		board4.setCategory(2);
		board4.setStatus(false);
		board4.setDate("10-14 19:41");
		board4.setSaleId("user4");
		board4.setBoardNum(4);
		tb_board.add(board4);
		
		BoardVO board5 = new BoardVO();
		
		board5.setTitle("(향기 개쩜) 향수 개당 1만원에 드립니다.");
		board5.setProduct("향수");
		board5.setContent("이사가 코앞이라 처분하려고 합니다. 각 1만원이고 모우 구매시 할인해드립니다. 향수라 오염의 우려가 없고"
				+ "1년 미만 제품이라 오래 쓰실 수 있습니다. 연락주세요");
		board5.setPrice(10000);
		board5.setRegion(101);
		board5.setCategory(7);
		board5.setStatus(false);
		board5.setDate("10-22 10:33");
		board5.setSaleId("user5");
		board5.setBoardNum(5);
		tb_board.add(board5);
		
		BoardVO board6 = new BoardVO();
		
		board6.setTitle("(급매) 중고 컴퓨터 본체 4만원 가져가세요~");
		board6.setProduct("나의 피같은 게이밍 컴퓨터ㅠㅠ");
		board6.setContent("게이밍본체로 구매했는데 요즘 게임은 잘 안돌아가요 그냥 적절히 사무용으로 쓰시기에는 적절합니다."
				+ "파워케이블 및 vga케이블은 무료로 드리겠습니다!!!");
		board6.setPrice(40000);
		board6.setRegion(150);
		board6.setCategory(1);
		board6.setStatus(false);
		board6.setDate("10-21 14:45");
		board6.setSaleId("user6");
		board6.setBoardNum(6);
		tb_board.add(board6);
		
		BoardVO board7 = new BoardVO();
		
		board7.setTitle("삼성기어 s3 프론티어");
		board7.setProduct("스마트워치");
		board7.setContent("교체 가능한 가죽 시계줄도 같이 드릴게요! SKT만 블루투스로 연동 되는 것 같습니다."
				+ "남편이 더이상 안쓴다고 내놓으라고 하네요 충전잭은 없고 5핀충전기로 충전하면 됩니다. 배송비는 별도입니다");
		board7.setPrice(40000);
		board7.setRegion(225);
		board7.setCategory(1);
		board7.setStatus(false);
		board7.setDate("10-24 20:41");
		board7.setSaleId("user7");
		board7.setBoardNum(7);
		tb_board.add(board7);
		
		BoardVO board8 = new BoardVO();
		
		board8.setTitle("아이패드 미니 4세대 A1538");
		board8.setProduct("갬성 넘치는 사과패드");
		board8.setContent("배송료 포함된 가격이고 가격 제안도 받겠습니다. 비교적 양심적인 제안 기다리고 있겠습니다. 쪽지 주세요");
		board8.setPrice(100000);
		board8.setRegion(144);
		board8.setCategory(1);
		board8.setStatus(false);
		board8.setDate("10-20 16:08");
		board8.setSaleId("user8");
		board8.setBoardNum(8);
		tb_board.add(board8);
		
		BoardVO board9 = new BoardVO();
		
		board9.setTitle("건강을 챙겨주는 호박손즙");
		board9.setProduct("건강식품");
		board9.setContent("임산부 조산 예방에 필요한 호박손즙 판매합니다. (새거 1박스) 유통기한도 충분합니다."
				+ "보건소에서 받은 철분제 소화에 도움되는 효소제 함께 드리겠습니다.");
		board9.setPrice(30000);
		board9.setRegion(415);
		board9.setCategory(12);
		board9.setStatus(false);
		board9.setDate("10-18 00:27");
		board9.setSaleId("user9");
		board9.setBoardNum(9);
		tb_board.add(board9);
		
		BoardVO board10 = new BoardVO();
		
		board10.setTitle("미켈란 접이식 자전거");
		board10.setProduct("승차감이 좋은 자전거");
		board10.setContent("조립하고 한번 탔습니다. 접이식이고 직접 받으러 오실 분만 연락 주세요!!!");
		board10.setPrice(20000);
		board10.setRegion(344);
		board10.setCategory(8);
		board10.setStatus(false);
		board10.setDate("10-11 19:07");
		board10.setSaleId("user10");
		board10.setBoardNum(10);
		tb_board.add(board10);
		
		BoardVO board11 = new BoardVO();
		
		board11.setTitle("18k 핑크골드 목걸이");
		board11.setProduct("스와로브스키 목걸이");
		board11.setContent("18k 로즈골드 목걸이 입니다. 새제품이고 펜던트는 18k 아니고 스톤진주 스와로브스키 입니다."
				+ "광택이 살아있어서 선물하기도 좋습니다. 길이는 44센치 입니다.");
		board11.setPrice(120000);
		board11.setRegion(414);
		board11.setCategory(5);
		board11.setStatus(false);
		board11.setDate("10-23 08:41");
		board11.setSaleId("user1");
		board11.setBoardNum(11);
		tb_board.add(board11);
		
		BoardVO board12 = new BoardVO();
		
		board12.setTitle("시계 새거 팝니다 로만손등등..");
		board12.setProduct("시계");
		board12.setContent("예전에 시계점 할 때 가지고 있던 상품입니다. 새거구요~ 배터리는 교체 하셔야 합니다."
				+ "*남자시계 각 3만원, 여자시계 각 2만원 씩입니다.");
		board12.setPrice(20000);
		board12.setRegion(146);
		board12.setCategory(12);
		board12.setStatus(false);
		board12.setDate("10-16 22:26");
		board12.setSaleId("user2");
		board12.setBoardNum(12);
		tb_board.add(board12);
		
		BoardVO board13 = new BoardVO();
		
		board13.setTitle("쌤쏭 제습기 팝니다.");
		board13.setProduct("제습기");
		board13.setContent("쌤쏭 제품이고 사용을 한두번밖에 안했지만 중고는 중고겠죠...? 꼭 필요하신 분만 연락 주세요 환불 및 반품은 사양합니다."
				+ "참고로 저는 30만원 주고 샀습니다.");
		board13.setPrice(50000);
		board13.setRegion(201);
		board13.setCategory(1);
		board13.setStatus(false);
		board13.setDate("10-21 11:57");
		board13.setSaleId("user3");
		board13.setBoardNum(13);
		tb_board.add(board13);
		
		BoardVO board14 = new BoardVO();
		
		board14.setTitle("전자피아노 팝니다~");
		board14.setProduct("전자피아노");
		board14.setContent("다이나톤 전자피아노입니다. 모델명 dcp-550 입니다. 아이가 중학생이 되니 피아노를 치지 않아서 내놓습니다."
				+ "외관 비교적 깨끗하고 소리도 전부 다 납니다~");
		board14.setPrice(50000);
		board14.setRegion(341);
		board14.setCategory(1);
		board14.setStatus(false);
		board14.setDate("10-11 16:25");
		board14.setSaleId("user4");
		board14.setBoardNum(14);
		tb_board.add(board14);
		
		BoardVO board15 = new BoardVO();
		
		board15.setTitle("나이키 에어맥스 신발 팝니다.");
		board15.setProduct("나이키신발");
		board15.setContent("새제품 한번도 착용 안했습니다. 정품 사이즈 265 빨리 연락주세요~!");
		board15.setPrice(60000);
		board15.setRegion(408);
		board15.setCategory(6);
		board15.setStatus(false);
		board15.setDate("10-14 21:16");
		board15.setSaleId("user5");
		board15.setBoardNum(15);
		tb_board.add(board15);
		
		BoardVO board16 = new BoardVO();
		
		board16.setTitle("낚시용품 팝니다");
		board16.setProduct("낚시용품");
		board16.setContent("낚시도구 2개 있습니다. 길이 2.4m-2만원 / 길이2.1m-1만원 환불 및 교환 거부합니다.");
		board16.setPrice(20000);
		board16.setRegion(201);
		board16.setCategory(12);
		board16.setStatus(false);
		board16.setDate("10-17 23:01");
		board16.setSaleId("user1");
		board16.setBoardNum(16);
		tb_board.add(board16);
		
		
		BoardVO board17 = new BoardVO();
		
		board17.setTitle("가정용 미싱 팝니다.");
		board17.setProduct("옷수선도구");
		board17.setContent("사용하려고 샀는데 처음 받을 때 사용하고 안했어요. 얼마전에 해보니까 돌아가더라구요 바늘은 없어서"
				+ "바늘 있으신분 한번 해보고 들고가세요 중고특성상 환불 안되고 원하시면 에누리 해드릴게요");
		board17.setPrice(70000);
		board17.setRegion(114);
		board17.setCategory(12);
		board17.setStatus(false);
		board17.setDate("10-17 23:01");
		board17.setSaleId("user2");
		board17.setBoardNum(17);
		tb_board.add(board17);
		
		BoardVO board18 = new BoardVO();
		
		board18.setTitle("굳찌 정품 클러치백(마지막 가격내림)");
		board18.setProduct("굳찌 정품백");
		board18.setContent("갤러리아에서 2019.8.9에 1240000원에 구입했습니다. 돈이 급해서 급처합니다.."
				+ "보증서 당연히 있고 구입 의사 있으셔서 연락 주시면 바로 확인 가능합니다. 모바일 보증서도 있습니다.");
		board18.setPrice(880000);
		board18.setRegion(222);
		board18.setCategory(5);
		board18.setStatus(false);
		board18.setDate("10-24 07:22");
		board18.setSaleId("user3");
		board18.setBoardNum(18);
		tb_board.add(board18);
		
		BoardVO board19 = new BoardVO();
		
		board19.setTitle("쿠첸밥솥");
		board19.setProduct("부엌용품");
		board19.setContent("직거래만 가능해요:) 구입한지 2개월 되었는데 5인가족 쓰기에는 좀 작아서 판매합니다."
				+ "실사용 6회 완전 새거입니다.");
		board19.setPrice(30000);
		board19.setRegion(315);
		board19.setCategory(1);
		board19.setStatus(false);
		board19.setDate("10-23 10:03");
		board19.setSaleId("user4");
		board19.setBoardNum(19);
		tb_board.add(board19);
		
		BoardVO board20 = new BoardVO();
		
		board20.setTitle("중고가구/침대(사은품 드림!)");
		board20.setProduct("가구");
		board20.setContent("침대 40만원에 두샘에서 구매했습니다. 손님방에서 사용한거라 구입년도에 비해 사용횟수는 적습니다."
				+ "매트리스 사이즈는 150*200 프레임 155*206*22 입니다.");
		board20.setPrice(70000);
		board20.setRegion(421);
		board20.setCategory(2);
		board20.setStatus(false);
		board20.setDate("10-20 19:47");
		board20.setSaleId("user5");
		board20.setBoardNum(20);
		tb_board.add(board20);
		
		BoardVO board21 = new BoardVO();
		
		board21.setTitle("테이블파라솔 팝니다.");
		board21.setProduct("테이블");
		board21.setContent("1년 반정도 썼는데 거의 쓸 일이 없어서 판매합니다. 평일에 와주시면 할인 해드립니다."
				+ "10만원 선입금 필수! 판매는 입금순입니다.");
		board21.setPrice(120000);
		board21.setRegion(201);
		board21.setCategory(2);
		board21.setStatus(false);
		board21.setDate("10-03 13:59");
		board21.setSaleId("user6");
		board21.setBoardNum(21);
		tb_board.add(board21);
		
		BoardVO board22 = new BoardVO();
		
		board22.setTitle("미미인형 가져가세요");
		board22.setProduct("인형");
		board22.setContent("집플러스에서 구매했습니다. 몇 번 만지다가 안가지고 놀아서 장식장에만 올려놨었어요"
				+ "한번 닦아서 쓰세요!");
		board22.setPrice(20000);
		board22.setRegion(112);
		board22.setCategory(12);
		board22.setStatus(false);
		board22.setDate("10-13 00:28");
		board22.setSaleId("user7");
		board22.setBoardNum(22);
		tb_board.add(board22);
		
		BoardVO board23 = new BoardVO();
		
		board23.setTitle("드릴 새거 팜!");
		board23.setProduct("전동드릴");
		board23.setContent("드릴을 실수로 2개 구매해서 의도치 않게 하나 판매하게 되었습니다. 입금순으로 우선권 드립니다.");
		board23.setPrice(25000);
		board23.setRegion(222);
		board23.setCategory(1);
		board23.setStatus(false);
		board23.setDate("10-21 05:17");
		board23.setSaleId("user8");
		board23.setBoardNum(23);
		tb_board.add(board23);
		
		BoardVO board24 = new BoardVO();
		
		board24.setTitle("암막커튼 거의 무료나눔 수준으로 드림");
		board24.setProduct("커튼");
		board24.setContent("상태 매우 깨끗하고 두장 입니다. 커튼봉은 미포함입니다.");
		board24.setPrice(15000);
		board24.setRegion(304);
		board24.setCategory(2);
		board24.setStatus(false);
		board24.setDate("10-24 08:33");
		board24.setSaleId("user9");
		board24.setBoardNum(24);
		tb_board.add(board24);
		
		BoardVO board25 = new BoardVO();
		
		board25.setTitle("거실 원목테이블 빠른처분 중");
		board25.setProduct("테이블");
		board25.setContent("좌식이고 원목 테이블입니다. 1500*700 사이즈고, 이사 관계로 처분합니다."
				+ "직접 오셔서 가져가실 분한테만 판매 하겠습니다.");
		board25.setPrice(100000);
		board25.setRegion(401);
		board25.setCategory(2);
		board25.setStatus(false);
		board25.setDate("10-05 11:11");
		board25.setSaleId("user10");
		board25.setBoardNum(25);
		tb_board.add(board25);
		
		BoardVO board26 = new BoardVO();
		
		board26.setTitle("장식용 전화기 판매합니다.");
		board26.setProduct("인테리어");
		board26.setContent("인테리어 및 장식용이지만 집 전화기로도 사용 가능합니다.");
		board26.setPrice(10000);
		board26.setRegion(513);
		board26.setCategory(2);
		board26.setStatus(false);
		board26.setDate("09-28 15:08");
		board26.setSaleId("user1");
		board26.setBoardNum(26);
		tb_board.add(board26);
		
		BoardVO board27 = new BoardVO();
		
		board27.setTitle("하리뽀 젤리 팜!");
		board27.setProduct("식품");
		board27.setContent("100봉지 안되게 들었는데 세봉지 정도 먹고... 선물받았는데 못먹겠어서 팝니다");
		board27.setPrice(5000);
		board27.setRegion(106);
		board27.setCategory(4);
		board27.setStatus(false);
		board27.setDate("10-19 07:38");
		board27.setSaleId("user2");
		board27.setBoardNum(27);
		tb_board.add(board27);
		
		BoardVO board28 = new BoardVO();
		
		board28.setTitle("빈티지 조명");
		board28.setProduct("조명");
		board28.setContent("제가 쇼룸에서 쓰고 있는 조명들이에요 4만원부터 시작합니다. 3만원 이하 제시하실분들 처내겠습니다.");
		board28.setPrice(40000);
		board28.setRegion(219);
		board28.setCategory(2);
		board28.setStatus(false);
		board28.setDate("10-17 23:01");
		board28.setSaleId("user3");
		board28.setBoardNum(28);
		tb_board.add(board28);
		
		BoardVO board29 = new BoardVO();
		
		board29.setTitle("락키금성 광파스팀오븐");
		board29.setProduct("주방용품");
		board29.setContent("직접 가져가셔야 해요. 무게 좀 있어요 52*40 사이즈 입니다. 기능은 문제 없고"
				+ "안쪽에 기름때, 사용감이 많아서 저렴하게 드립니다.");
		board29.setPrice(20000);
		board29.setRegion(327);
		board29.setCategory(1);
		board29.setStatus(false);
		board29.setDate("10-21 20:47");
		board29.setSaleId("user4");
		board29.setBoardNum(29);
		tb_board.add(board29);
		
		BoardVO board30 = new BoardVO();
		
		board30.setTitle("복합기 팝니다~");
		board30.setProduct("쌤쏭 복합기");
		board30.setContent("쌤쏭 제품이고 복사 스캔 프린터 가능합니다. 직접 오셔서 받아가세요");
		board30.setPrice(15000);
		board30.setRegion(411);
		board30.setCategory(1);
		board30.setStatus(false);
		board30.setDate("10-19 18:08");
		board30.setSaleId("user5");
		board30.setBoardNum(30);
		tb_board.add(board30);
		
		BoardVO board31 = new BoardVO();
		
		board31.setTitle("단화 팝니다 완전 새거");
		board31.setProduct("신발");
		board31.setContent("휘일라 단화 사이즈 260입니다. 사놓고 한번도 안신어서 판매 올려봅니다");
		board31.setPrice(35000);
		board31.setRegion(505);
		board31.setCategory(6);
		board31.setStatus(false);
		board31.setDate("10-15 04:51");
		board31.setSaleId("user6");
		board31.setBoardNum(31);
		tb_board.add(board31);
		
		BoardVO board32 = new BoardVO();
		
		board32.setTitle("티비 내놓습니다.");
		board32.setProduct("가전제품");
		board32.setContent("이사로 인해 부득이하게 팔게 되었고 이상없이 잘 동작됩니다.");
		board32.setPrice(50000);
		board32.setRegion(108);
		board32.setCategory(1);
		board32.setStatus(false);
		board32.setDate("10-05 22:17");
		board32.setSaleId("user7");
		board32.setBoardNum(32);
		tb_board.add(board32);
		
		BoardVO board33 = new BoardVO();
		
		board33.setTitle("뜨숩한 전기장판(최고출력시 오징어도 구울 수 있음)");
		board33.setProduct("전기장판");
		board33.setContent("2인용 전기장판 상태 양호! 한번 누우면 못일어날 수도 있음.");
		board33.setPrice(5000);
		board33.setRegion(212);
		board33.setCategory(1);
		board33.setStatus(false);
		board33.setDate("10-25 10:07");
		board33.setSaleId("user8");
		board33.setBoardNum(33);
		tb_board.add(board33);
		
		BoardVO board34 = new BoardVO();
		
		board34.setTitle("고풍스런 화장대 입니다.");
		board34.setProduct("화장대");
		board34.setContent("시댁에서 사용하던 화장대 입니다. 못 없이 이음새를 맞춰 만든 가구라고 합니다."
				+ "생활 스크레치는 있으나 전체적으로 깨끗합니다. 유리도 올려져 있고 화장대는 거울 포함입니다.");
		board34.setPrice(20000);
		board34.setRegion(321);
		board34.setCategory(2);
		board34.setStatus(false);
		board34.setDate("10-25 09:12");
		board34.setSaleId("user9");
		board34.setBoardNum(34);
		tb_board.add(board34);
		
		BoardVO board35 = new BoardVO();
		
		board35.setTitle("장농 팔아봅니다");
		board35.setProduct("가구 장농");
		board35.setContent("10.27 이사날 사다리차로 내리면 됩니다. 상태는 깨끗합니다 쪽지 주세요");
		board35.setPrice(50000);
		board35.setRegion(402);
		board35.setCategory(2);
		board35.setStatus(false);
		board35.setDate("10-26 11:36");
		board35.setSaleId("user10");
		board35.setBoardNum(35);
		tb_board.add(board35);
		
		BoardVO board36 = new BoardVO();
		
		board36.setTitle("우드블라인드");
		board36.setProduct("블라인드");
		board36.setContent("고급스런 다운된 그레이색상의 고급우드 블라인드 입니다. 35평형 사이즈고요"
				+ "사용감은 전혀 없고 새거라고 보시면 됩니다. 쿨거래시 가격조정 가능합니다. 410*216");
		board36.setPrice(350000);
		board36.setRegion(503);
		board36.setCategory(2);
		board36.setStatus(false);
		board36.setDate("10-23 08:49");
		board36.setSaleId("user1");
		board36.setBoardNum(36);
		tb_board.add(board36);
		
		BoardVO board37 = new BoardVO();
		
		board37.setTitle("캐리어 20리터");
		board37.setProduct("여행용 캐리어");
		board37.setContent("여행가려고 샀는데 결국 한번도 못쓰고 판매합니다.. 저렵하게 가져가세요");
		board37.setPrice(10000);
		board37.setRegion(133);
		board37.setCategory(12);
		board37.setStatus(false);
		board37.setDate("10-24 13:04");
		board37.setSaleId("user2");
		board37.setBoardNum(37);
		tb_board.add(board37);
		
		BoardVO board38 = new BoardVO();
		
		board38.setTitle("떡갈나무 원목 개집");
		board38.setProduct("개집");
		board38.setContent("유명한 목수에게 제작의뢰한 개집입니다. 개들이 아주 환장을 하고 집에서 나올 생각을 안합니다."
				+ "중형견 사이즈 까지는 사용 가능ㅇ합니다.");
		board38.setPrice(100000);
		board38.setRegion(208);
		board38.setCategory(11);
		board38.setStatus(false);
		board38.setDate("10-23 06:14");
		board38.setSaleId("user3");
		board38.setBoardNum(38);
		tb_board.add(board38);
		
		BoardVO board39 = new BoardVO();
		
		board39.setTitle("탑십 패딩조끼 검정 S 미착용");
		board39.setProduct("의류");
		board39.setContent("사이즈 미스로 사놓고 살빼면 입어야지 하다가 결국 살과의 전쟁에서 패배하고 올립니다");
		board39.setPrice(15000);
		board39.setRegion(318);
		board39.setCategory(5);
		board39.setStatus(false);
		board39.setDate("10-12 14:08");
		board39.setSaleId("user4");
		board39.setBoardNum(39);
		tb_board.add(board39);
		
		
		BoardVO board40 = new BoardVO();
		
		board40.setTitle("넵하 패딩 팝니다(급식필수템)");
		board40.setProduct("의류");
		board40.setContent("일진들의 괴롭힘과 빵셔틀이라는 현실에 힘들어하는 급식들에게 강력히 추천합니다."
				+ "이 패딩을 입는 순간 당신은 빵셔틀에서 벗어나게 될 것입니다.");
		board40.setPrice(50000);
		board40.setRegion(404);
		board40.setCategory(5);
		board40.setStatus(false);
		board40.setDate("10-20 21:01");
		board40.setSaleId("user5");
		board40.setBoardNum(40);
		tb_board.add(board40);
		
	BoardVO board41 = new BoardVO();
		
		board41.setTitle("헤라비누 10개 세트!!");
		board41.setProduct("비누");
		board41.setContent("비누가 너무 많아 정리하다 보니 다 쓰지도 못할 것 같아서 10개 만원에 드립니다 "
				+ "직접 받으러 오실 분만 연락 주셨으면 좋겠습니다.");
		board41.setPrice(10000);
		board41.setRegion(526);
		board41.setCategory(12);
		board41.setStatus(false);
		board41.setDate("10-20 21:01");
		board41.setSaleId("user6");
		board41.setBoardNum(41);
		tb_board.add(board41);
		
		BoardVO board42 = new BoardVO();
		
		board42.setTitle("스타우브그릴펜");
		board42.setProduct("주방용품");
		board42.setContent("그릴펜 입니다. 미사용이고 스테이크 구우려고 했으나 스테이크 살 돈이 없어서 팝니다.");
		board42.setPrice(28000);
		board42.setRegion(109);
		board42.setCategory(12);
		board42.setStatus(false);
		board42.setDate("10-14 10:14");
		board42.setSaleId("user7");
		board42.setBoardNum(42);
		tb_board.add(board42);
		
		BoardVO board43 = new BoardVO();
		
		board43.setTitle("골프채(테일러메이드버너)");
		board43.setProduct("스포츠용품");
		board43.setContent("프로 준비하면서 샀던 골프채지만 재능이 없다는 사실을 깨닫고 처분합니다. 싸게 드려요");
		board43.setPrice(130000);
		board43.setRegion(226);
		board43.setCategory(12);
		board43.setStatus(false);
		board43.setDate("10-01 09:07");
		board43.setSaleId("user8");
		board43.setBoardNum(43);
		tb_board.add(board43);
		

		BoardVO board44 = new BoardVO();
		
		board44.setTitle("공기팟 2세대 유선충전 모델");
		board44.setProduct("공기팟");
		board44.setContent("2세대 유선충전 모델인데 케이블을 잃어버려서 싸게 내놓습니다. 직거래로 오시는 분들은 10만원에 드리겠습니다.");
		board44.setPrice(110000);
		board44.setRegion(339);
		board44.setCategory(12);
		board44.setStatus(false);
		board44.setDate("10-4 12:17"); 
		board44.setSaleId("user9");
		board44.setBoardNum(44);
		tb_board.add(board44);
		
		BoardVO board45 = new BoardVO();
		
		board45.setTitle("공기팟 2세대 유선충전 모델");
		board45.setProduct("공기팟");
		board45.setContent("2세대 유선충전 모델인데 케이블을 잃어버려서 싸게 내놓습니다. 직거래로 오시는 분들은 10만원에 드리겠습니다.");
		board45.setPrice(110000);
		board45.setRegion(405);
		board45.setCategory(12);
		board45.setStatus(false);
		board45.setDate("10-4 12:17"); 
		board45.setSaleId("user10");
		board45.setBoardNum(45);
		tb_board.add(board45);
		
		BoardVO board46 = new BoardVO();
		
		board46.setTitle("막스마라코트");
		board46.setProduct("코트");
		board46.setContent("검안색 단정한 코트이고 44-마른55입니다. 검은색이라 먼지가 잘 붙는 단점 외에는 상태 양호합니다.");
		board46.setPrice(40000);
		board46.setRegion(507);
		board46.setCategory(5);
		board46.setStatus(false);
		board46.setDate("10-8 12:04"); 
		board46.setSaleId("user1");
		board46.setBoardNum(46);
		tb_board.add(board46);
		
		BoardVO board47 = new BoardVO();
		
		board47.setTitle("공기팟 2세대 유선충전 모델");
		board47.setProduct("공기팟");
		board47.setContent("2세대 유선충전 모델인데 케이블을 잃어버려서 싸게 내놓습니다. 직거래로 오시는 분들은 10만원에 드리겠습니다.");
		board47.setPrice(110000);
		board47.setRegion(104);
		board47.setCategory(12);
		board47.setStatus(false);
		board47.setDate("10-4 12:17"); 
		board47.setSaleId("user2");
		board47.setBoardNum(47);
		tb_board.add(board47);
		
		BoardVO board48 = new BoardVO();
		
		board48.setTitle("철제수납장");
		board48.setProduct("수납장");
		board48.setContent("밑에 바퀴 달려있고 스크레치 하나 없이 깨끗합니다. 냄새도 전혀 나지 않고 새제품 이라고 생각 하시면 될 것 같습니다.");
		board48.setPrice(10000);
		board48.setRegion(210);
		board48.setCategory(2);
		board48.setStatus(false);
		board48.setDate("10-11 08:06"); 
		board48.setSaleId("user3");
		board48.setBoardNum(48);
		tb_board.add(board48);
		
		BoardVO board49 = new BoardVO();
		
		board49.setTitle("철제수납장");
		board49.setProduct("수납장");
		board49.setContent("밑에 바퀴 달려있고 스크레치 하나 없이 깨끗합니다. 냄새도 전혀 나지 않고 새제품 이라고 생각 하시면 될 것 같습니다.");
		board49.setPrice(10000);
		board49.setRegion(414);
		board49.setCategory(2);
		board49.setStatus(false);
		board49.setDate("10-11 08:06"); 
		board49.setSaleId("user4");
		board49.setBoardNum(49);
		tb_board.add(board49);
		
		BoardVO board50 = new BoardVO();
		
		board50.setTitle("ASUS 노트북");
		board50.setProduct("노트북");
		board50.setContent("영화,동영상,인강,웹서핑,문서작업 등 무리없이 가능하고 가벼워서 휴대하기도 좋습니다."
				+ "포멧 완료 후 최적화 설정한 상태라 전원 누르고 바로 사용하시면 됩니다. 구성은 본체,파우치,충전어답터 입니다.");
		board50.setPrice(120000);
		board50.setRegion(210);
		board50.setCategory(12);
		board50.setStatus(false);
		board50.setDate("10-19 07:06"); 
		board50.setSaleId("user5");
		board50.setBoardNum(50);
		tb_board.add(board50);

BoardVO board51 = new BoardVO();
		
		board51.setTitle("갈락시노트5");
		board51.setProduct("휴대폰");
		board51.setContent("1년정도 사용한 폰입니다. 상태 아주 좋고 배터리도 교체 해놨습니다. 완전 공기계입니다. 케이스도 같이 드릴게요!");
		board51.setPrice(80000);
		board51.setRegion(356);
		board51.setCategory(1);
		board51.setStatus(false);
		board51.setDate("10-08 13:46"); 
		board51.setSaleId("user6");
		board51.setBoardNum(51);
		tb_board.add(board51);
		
		BoardVO board52 = new BoardVO();
		
		board52.setTitle("이키야~ 철제선반");
		board52.setProduct("선반");
		board52.setContent("이키야에서 구매했고 조립했습니다. 집에 공간이 부족해서 팝니다! 크기상 직접 가져가셔야 해요~~");
		board52.setPrice(5000);
		board52.setRegion(415);
		board52.setCategory(2);
		board52.setStatus(false);
		board52.setDate("10-13 08:46"); 
		board52.setSaleId("user7");
		board52.setBoardNum(52);
		tb_board.add(board52);
		
		BoardVO board53 = new BoardVO();
		
		board53.setTitle("노뜨페이뜨 오리솜털 롱패딩(여성)");
		board53.setProduct("패딩");
		board53.setContent("오리솜털이고 여자 95 사이즈 입니다. 따뜻하고 예뻐요 학생들이 교복 위에 입어도 좋을 듯 합니다.");
		board53.setPrice(50000);
		board53.setRegion(506);
		board53.setCategory(5);
		board53.setStatus(false);
		board53.setDate("10-18 04:46"); 
		board53.setSaleId("user8");
		board53.setBoardNum(53);
		tb_board.add(board53);
		
		BoardVO board54 = new BoardVO();
		
		board54.setTitle("스팀다리미 팔아봅니다.");
		board54.setProduct("스팀다리미");
		board54.setContent("구매한지는 좀 되었으나 사용을 안해서 판매합니다. 직거래만 받습니다~!");
		board54.setPrice(20000);
		board54.setRegion(121);
		board54.setCategory(1);
		board54.setStatus(false);
		board54.setDate("10-21 18:06"); 
		board54.setSaleId("user9");
		board54.setBoardNum(54);
		tb_board.add(board54);
		
		BoardVO board55 = new BoardVO();
		
		board55.setTitle("쌤쏭 에어컨(2014년 모델)");
		board55.setProduct("에어컨");
		board55.setContent("2014년식이고 에너지소비효율등급 1등급 입니다. 다른 나라로 이사가게 되어 싸게 판매하게 되었어요 ㅠㅠ");
		board55.setPrice(200000);
		board55.setRegion(215);
		board55.setCategory(1);
		board55.setStatus(false);
		board55.setDate("10-07 17:56"); 
		board55.setSaleId("user10");
		board55.setBoardNum(55);
		tb_board.add(board55);
		
		BoardVO board56 = new BoardVO();
		
		board56.setTitle("쌤쏭 32인치 티비 팝니다.");
		board56.setProduct("티비");
		board56.setContent("리모콘은 없는대신 HDMI 케이블 외 1종 포함드립니다. 중고라서 물건에 큰 하자 없으면 교환 및 환불은 어려운 점 이해 부탁드려요"
				+ "거래일정 약속은 입금 후 가능합니다.(당일취소 예방)");
		board56.setPrice(60000);
		board56.setRegion(317);
		board56.setCategory(1);
		board56.setStatus(false);
		board56.setDate("10-10 16:51"); 
		board56.setSaleId("user1");
		board56.setBoardNum(56);
		tb_board.add(board56);
		
		BoardVO board57 = new BoardVO();
		
		board57.setTitle("독서실책상");
		board57.setProduct("책상");
		board57.setContent("깔끔하고 책상도 넓어서 노트북 작업 하기에도 좋습니다. ");
		board57.setPrice(20000);
		board57.setRegion(429);
		board57.setCategory(2);
		board57.setStatus(false);
		board57.setDate("10-17 12:38"); 
		board57.setSaleId("user2");
		board57.setBoardNum(57);
		tb_board.add(board57);
		
		BoardVO board58 = new BoardVO();
		
		board58.setTitle("독서실책상");
		board58.setProduct("책상");
		board58.setContent("깔끔하고 책상도 넓어서 노트북 작업 하기에도 좋습니다.");
		board58.setPrice(20000);
		board58.setRegion(509);
		board58.setCategory(2);
		board58.setStatus(false);
		board58.setDate("10-17 12:38"); 
		board58.setSaleId("user3");
		board58.setBoardNum(58);
		tb_board.add(board58);
		
		BoardVO board59 = new BoardVO();
		
		board59.setTitle("4인용 텐트와 캠핑의자 판매");
		board59.setProduct("캠핑도구");
		board59.setContent("캠프타운 텐트와 버팔로 의자 2개 판매합니다. 사용은 5회도 안했고 깨끗합니다.");
		board59.setPrice(100000);
		board59.setRegion(128);
		board59.setCategory(12);
		board59.setStatus(false);
		board59.setDate("10-22 08:47"); 
		board59.setSaleId("user4");
		board59.setBoardNum(59);
		tb_board.add(board59);
		
		BoardVO board60 = new BoardVO();
		
		board60.setTitle("4인용 텐트와 캠핑의자 판매");
		board60.setProduct("캠핑도구");
		board60.setContent("캠프타운 텐트와 버팔로 의자 2개 판매합니다. 사용은 5회도 안했고 깨끗합니다.");
		board60.setPrice(100000);
		board60.setRegion(214);
		board60.setCategory(12);
		board60.setStatus(false);
		board60.setDate("10-04 10:14"); 
		board60.setSaleId("user5");
		board60.setBoardNum(60);
		tb_board.add(board60);
		
		BoardVO board61 = new BoardVO();
		
		board61.setTitle("JBL 블루투스 이어폰");
		board61.setProduct("이어폰");
		board61.setContent("5회정도 사용했고 구성품은 풀박스 입니다. 연락주세요");
		board61.setPrice(10000);
		board61.setRegion(340);
		board61.setCategory(12);
		board61.setStatus(false);
		board61.setDate("10-09 21:47"); 
		board61.setSaleId("user6");
		board61.setBoardNum(61);
		tb_board.add(board61);
		
		BoardVO board62 = new BoardVO();
		
		board62.setTitle("JBL 블루투스 이어폰");
		board62.setProduct("이어폰");
		board62.setContent("5회정도 사용했고 구성품은 풀박스 입니다. 연락주세요");
		board62.setPrice(10000);
		board62.setRegion(340);
		board62.setCategory(12);
		board62.setStatus(false);
		board62.setDate("10-07 21:47"); 
		board62.setSaleId("user7");
		board62.setBoardNum(62);
		tb_board.add(board62);

		BoardVO board63 = new BoardVO();
		
		board63.setTitle("JBL 블루투스 이어폰");
		board63.setProduct("이어폰");
		board63.setContent("5회정도 사용했고 구성품은 풀박스 입니다. 연락주세요");
		board63.setPrice(10000);
		board63.setRegion(340);
		board63.setCategory(12);
		board63.setStatus(false);
		board63.setDate("10-07 21:47"); 
		board63.setSaleId("user8");
		board63.setBoardNum(63);
		tb_board.add(board63);


BoardVO board64 = new BoardVO();
		
		board64.setTitle("쇼파 팝니당");
		board64.setProduct("쇼파");
		board64.setContent("작년에 산 쇼파입니다. 흠집 한군데 있고 이사가게 되면서 사이즈가 안맞아서 팝니다.");
		board64.setPrice(50000);
		board64.setRegion(514);
		board64.setCategory(2);
		board64.setStatus(false);
		board64.setDate("10-16 15:00"); 
		board64.setSaleId("user9");
		board64.setBoardNum(64);
		tb_board.add(board64);
		
		BoardVO board65 = new BoardVO();
		
		board65.setTitle("쇼파 팝니당");
		board65.setProduct("쇼파");
		board65.setContent("작년에 산 쇼파입니다. 흠집 한군데 있고 이사가게 되면서 사이즈가 안맞아서 팝니다.");
		board65.setPrice(50000);
		board65.setRegion(133);
		board65.setCategory(2);
		board65.setStatus(false);
		board65.setDate("10-19 13:00"); 
		board65.setSaleId("user10");
		board65.setBoardNum(65);
		tb_board.add(board65);
		
		BoardVO board66 = new BoardVO();
		
		board66.setTitle("양문형 냉장고");
		board66.setProduct("냉장고");
		board66.setContent("양문형냉장고 입니다. 이상없이 잘 작동되고 직접 가져가셔야 합니다.");
		board66.setPrice(180000);
		board66.setRegion(223);
		board66.setCategory(1);
		board66.setStatus(false);
		board66.setDate("10-21 15:39"); 
		board66.setSaleId("user1");
		board66.setBoardNum(66);
		tb_board.add(board66);
		
		BoardVO board67 = new BoardVO();
		
		board67.setTitle("오토바이하이바&블루투스 헤드셋");
		board67.setProduct("헬멧");
		board67.setContent("홍진헬멧&세미블루투스 포함 미사용 헬멧이고 M 사이즈 입니다. 저한테는 작아서 팝니다 ㅠㅠ");
		board67.setPrice(60000);
		board67.setRegion(318);
		board67.setCategory(12);
		board67.setStatus(false);
		board67.setDate("10-24 08:46"); 
		board67.setSaleId("user2");
		board67.setBoardNum(67);
		tb_board.add(board67);
		
		BoardVO board68 = new BoardVO();
		
		board68.setTitle("락호스테 신발");
		board68.setProduct("신발");
		board68.setContent("그새 발이 자랐는지 신을 수가 없어서 팝니다.. 세탁 해놓은 상태입니다!");
		board68.setPrice(10000);
		board68.setRegion(410);
		board68.setCategory(5);
		board68.setStatus(false);
		board68.setDate("10-25 12:46"); 
		board68.setSaleId("user3");
		board68.setBoardNum(68);
		tb_board.add(board68);
		
		BoardVO board69 = new BoardVO();
		
		board69.setTitle("남자 롱코트");
		board69.setProduct("의류");
		board69.setContent("저의 키를 고려하지 않고 무리하게 롱코트를 샀다가 질질 끌리는 바람에 팔게 되었습니다 180이상인 분들만 사주세요");
		board69.setPrice(20000);
		board69.setRegion(516);
		board69.setCategory(6);
		board69.setStatus(false);
		board69.setDate("10-26 14:46"); 
		board69.setSaleId("user4");
		board69.setBoardNum(69);
		tb_board.add(board69);
		
		BoardVO board70 = new BoardVO();
		
		board70.setTitle("고급 엔틱거실장");
		board70.setProduct("가구");
		board70.setContent("상당히 고급스럽고 기스없고 상태 최상입니다. 가지러 오셔야 하고 배달 원하시면 배송료 5만원에 가능합니다.");
		board70.setPrice(150000);
		board70.setRegion(146);
		board70.setCategory(2);
		board70.setStatus(false);
		board70.setDate("10-26 20:57"); 
		board70.setSaleId("user5");
		board70.setBoardNum(70);
		tb_board.add(board70);
		
		BoardVO board71 = new BoardVO();
		
		board71.setTitle("락키금성 42인치 티비");
		board71.setProduct("티비");
		board71.setContent("벽걸이도 가능한 티비고 리모콘은 없습니다. 에눌 가능하니까 편안하게 제시해 주세요");
		board71.setPrice(400000);
		board71.setRegion(219);
		board71.setCategory(1);
		board71.setStatus(false);
		board71.setDate("10-23 19:15"); 
		board71.setSaleId("user6");
		board71.setBoardNum(71);
		tb_board.add(board71);
		
		BoardVO board72 = new BoardVO();
		
		board72.setTitle("방문 손잡이");
		board72.setProduct("손잡이");
		board72.setContent("미개봉 새상품 반품,환불,에눌 사양합니다.");
		board72.setPrice(9000);
		board72.setRegion(333);
		board72.setCategory(2);
		board72.setStatus(false);
		board72.setDate("10-03 09:20"); 
		board72.setSaleId("user7");
		board72.setBoardNum(72);
		tb_board.add(board72);
		
		BoardVO board73 = new BoardVO();
		
		board73.setTitle("쌤쏭 무선보조배터리 팝니다.");
		board73.setProduct("보조배터리");
		board73.setContent("처음 이틀정도 사용하고 서랍에 넣어놨었습니다. 뒷면에는 생활기스 있습니다.");
		board73.setPrice(20000);
		board73.setRegion(430);
		board73.setCategory(12);
		board73.setStatus(false);
		board73.setDate("10-19 21:05"); 
		board73.setSaleId("user8");
		board73.setBoardNum(73);
		tb_board.add(board73);
		
		BoardVO board74 = new BoardVO();
		
		board74.setTitle("한번 사용한 캐리어 팝니다.");
		board74.setProduct("캐리어");
		board74.setContent("기내용 캐리어입니다. 실사용은 한번밖에 안했고 2개 개당 3만원에 팝니다.");
		board74.setPrice(30000);
		board74.setRegion(523);
		board74.setCategory(12);
		board74.setStatus(false);
		board74.setDate("10-19 20:47"); 
		board74.setSaleId("user9");
		board74.setBoardNum(74);
		tb_board.add(board74);
		
		BoardVO board75 = new BoardVO();
		
		board75.setTitle("4인용 의탁자");
		board75.setProduct("탁자");
		board75.setContent("가게에서 사용한 의탁자 입니다. 의자4개 탁자1개 상태 아주 좋고 큰 차를 가져오셔야 합니다.");
		board75.setPrice(60000);
		board75.setRegion(139);
		board75.setCategory(2);
		board75.setStatus(false);
		board75.setDate("10-22 08:47"); 
		board75.setSaleId("user10");
		board75.setBoardNum(75);
		tb_board.add(board75);
		
		BoardVO board76 = new BoardVO();
		
		board76.setTitle("BBQ그릴 새상품");
		board76.setProduct("그릴");
		board76.setContent("바베큐 그릴 새상품이고 캠핑때 사용하셔도 좋고 야외에서 고기 구워먹을 때 정말 편리합니다!");
		board76.setPrice(25000);
		board76.setRegion(220);
		board76.setCategory(12);
		board76.setStatus(false);
		board76.setDate("10-12 04:54"); 
		board76.setSaleId("user1");
		board76.setBoardNum(76);
		tb_board.add(board76);
		
		BoardVO board77 = new BoardVO();
		
		board77.setTitle("뱃살안마기");
		board77.setProduct("안마기");
		board77.setContent("작동 잘 되고 효과도 아주 훌륭합니다. 이제 더이상 뺄 뱃살이 없어서 내놓습니다.");
		board77.setPrice(10000);
		board77.setRegion(331);
		board77.setCategory(12);
		board77.setStatus(false);
		board77.setDate("10-26 19:54"); 
		board77.setSaleId("user2");
		board77.setBoardNum(77);
		tb_board.add(board77);
		
		BoardVO board78 = new BoardVO();
		
		board78.setTitle("커피숍 고재 엔틱 테이블");
		board78.setProduct("테이블");
		board78.setContent("고재 엔틱 테이블 판매합니다. 사이즈는 1200*800*700 입니다. 가지러 오셔야 합니다.");
		board78.setPrice(50000);
		board78.setRegion(416);
		board78.setCategory(2);
		board78.setStatus(false);
		board78.setDate("10-26 10:11"); 
		board78.setSaleId("user3");
		board78.setBoardNum(78);
		tb_board.add(board78);
		
		BoardVO board79 = new BoardVO();
		
		board79.setTitle("냉장고 팝니다.");
		board79.setProduct("냉장고");
		board79.setContent("냉장고 서브로 사용했고 투도어인데 제꺼 양문형보다 좋았습니다. 수납공간이 넓어서 좋고 필요하신 분 빠르게 쪽지 주세요");
		board79.setPrice(100000);
		board79.setRegion(516);
		board79.setCategory(1);
		board79.setStatus(false);
		board79.setDate("10-26 13:40"); 
		board79.setSaleId("user4");
		board79.setBoardNum(79);
		tb_board.add(board79);
		
		BoardVO board80 = new BoardVO();
		
		board80.setTitle("극강의 편안함 쇼파베드");
		board80.setProduct("쇼파");
		board80.setContent("거의 사용을 판매합니다. 쇼파 또는 1인침대 사용 가능하고 방수도 되고 굉장히 튼튼합니다. 구매한지는 5개월 정도 됐습니다.");
		board80.setPrice(70000);
		board80.setRegion(119);
		board80.setCategory(2);
		board80.setStatus(false);
		board80.setDate("10-24 16:11"); 
		board80.setSaleId("user5");
		board80.setBoardNum(80);
		tb_board.add(board80);
		
		BoardVO board81 = new BoardVO();
		
		board81.setTitle("뜨숩한 침낭 팝니다.");
		board81.setProduct("침낭");
		board81.setContent("인터넷구입 후 한번도 사용하지 않았어요. 중량700그램 짜리로 얇은 편입니다. 가벼워서 좋아요");
		board81.setPrice(10000);
		board81.setRegion(234);
		board81.setCategory(12);
		board81.setStatus(false);
		board81.setDate("10-25 16:30"); 
		board81.setSaleId("user6");
		board81.setBoardNum(81);
		tb_board.add(board81);
		
		BoardVO board82 = new BoardVO();
		
		board82.setTitle("설화수 자음3종 세트");
		board82.setProduct("화장품");
		board82.setContent("설화수 자음3종 유통기한:2022.07.25 구성:자음수,자음유액,윤조에센스 포장상태로 드립니다.");
		board82.setPrice(80000);
		board82.setRegion(352);
		board82.setCategory(12);
		board82.setStatus(false);
		board82.setDate("10-25 12:03"); 
		board82.setSaleId("user7");
		board82.setBoardNum(82);
		tb_board.add(board82);
		
		BoardVO board83 = new BoardVO();
		
		board83.setTitle("헬로카봇 변신로봇");
		board83.setProduct("장난감");
		board83.setContent("자동차 로봇 변신 가능하고 합체도 가능합니다. 합체하면 건담보다 멋있는 변신로봇으로 탈바꿈 됩니다");
		board83.setPrice(5000);
		board83.setRegion(421);
		board83.setCategory(12);
		board83.setStatus(false);
		board83.setDate("10-25 13:03"); 
		board83.setSaleId("user8");
		board83.setBoardNum(83);
		tb_board.add(board83);
		
		BoardVO board84 = new BoardVO();
		
		board84.setTitle("몸에좋은 늙은호박 팔아요");
		board84.setProduct("식품");
		board84.setContent("1개에 4천원 입니다. 10개 4만원, 몸에 붓기빼서 다이어트 하시고 건강도 챙기세요!");
		board84.setPrice(4000);
		board84.setRegion(523);
		board84.setCategory(4);
		board84.setStatus(false);
		board84.setDate("10-25 15:13"); 
		board84.setSaleId("user9");
		board84.setBoardNum(84);
		tb_board.add(board84);
		
		BoardVO board85 = new BoardVO();
		
		board85.setTitle("양모 버벌이 머플러 팝니다.");
		board85.setProduct("머플러");
		board85.setContent("한번착용했고 멋진 중후함을 낼 수 있답니다. 포근하고 점잖은 느낌 좋습니다. 백화점에서 사면 10만원 넘어갑니다.");
		board85.setPrice(30000);
		board85.setRegion(523);
		board85.setCategory(4);
		board85.setStatus(false);
		board85.setDate("10-25 15:13"); 
		board85.setSaleId("user10");
		board85.setBoardNum(85);
		tb_board.add(board85);
		
		BoardVO board86 = new BoardVO();
		
		board86.setTitle("PS4 팝니다.");
		board86.setProduct("게임기");
		board86.setContent("이사가면서 정리합니다. 어제 확인해보니 이상 없고 듀얼쇼크 추가로 하나 더 드리는 가격입니다. 직거래만 연락 주세요");
		board86.setPrice(120000);
		board86.setRegion(129);
		board86.setCategory(12);
		board86.setStatus(false);
		board86.setDate("10-21 12:23"); 
		board86.setSaleId("user1");
		board86.setBoardNum(86);
		tb_board.add(board86);
		
		BoardVO board87 = new BoardVO();
		
		board87.setTitle("햇살 햅쌀 새쌀");
		board87.setProduct("쌀");
		board87.setContent("2019년 햅쌀 사세요 며칠 전 정미소에서 도정한 새쌀입니다. 오셔서 직접 가져가셔야 합니다!");
		board87.setPrice(50000);
		board87.setRegion(220);
		board87.setCategory(4);
		board87.setStatus(false);
		board87.setDate("10-21 23:23"); 
		board87.setSaleId("user2");
		board87.setBoardNum(87);
		tb_board.add(board87);
		
		BoardVO board88 = new BoardVO();
		
		board88.setTitle("블랙박스 팔아요~");
		board88.setProduct("차량용 블랙박스");
		board88.setContent("상태 좋은 블랙박스 팝니다. sd카드 8기가짜리도 같이 드려요");
		board88.setPrice(10000);
		board88.setRegion(332);
		board88.setCategory(12);
		board88.setStatus(false);
		board88.setDate("10-24 07:07"); 
		board88.setSaleId("user3");
		board88.setBoardNum(88);
		tb_board.add(board88);
		
		BoardVO board89 = new BoardVO();
		
		board89.setTitle("아딧아스 신발 판매");
		board89.setProduct("운동화");
		board89.setContent("정품이고 디자인 예쁘고 굉장히 발이 편합니다. 쿠셔닝도 있어서 발에 자극을 주지 않아서 좋습니다. 사이즈는260입니다.");
		board89.setPrice(32000);
		board89.setRegion(424);
		board89.setCategory(6);
		board89.setStatus(false);
		board89.setDate("10-23 19:07"); 
		board89.setSaleId("user4");
		board89.setBoardNum(89);
		tb_board.add(board89);
		
		BoardVO board90 = new BoardVO();
		
		board90.setTitle("5.1채널홈시어터 블루투스 연결 가능");
		board90.setProduct("홈시어터");
		board90.setContent("락키금성꺼 5.1채널 블루투스 fullHD화질 신형입니다. 이거 사시면 앞으로 극장 가실 일이 없으실 겁니다.");
		board90.setPrice(120000);
		board90.setRegion(520);
		board90.setCategory(1);
		board90.setStatus(false);
		board90.setDate("10-23 19:37"); 
		board90.setSaleId("user5");
		board90.setBoardNum(90);
		tb_board.add(board90);
		
		BoardVO board91 = new BoardVO();
		
		board91.setTitle("갈락시s7 32기가 공기계");
		board91.setProduct("휴대폰");
		board91.setContent("갈락시s7 오닉스블랙 색상입니다. 슼용 자급제폰이니까 문제 없습니다.");
		board91.setPrice(75000);
		board91.setRegion(144);
		board91.setCategory(12);
		board91.setStatus(false);
		board91.setDate("10-24 20:25"); 
		board91.setSaleId("user6");
		board91.setBoardNum(91);
		tb_board.add(board91);
		
		BoardVO board92 = new BoardVO();
		
		board92.setTitle("아딫아스 트레이닝복 판매(여성용)");
		board92.setProduct("트레이닝복");
		board92.setContent("아딫아스 매장에서 산 정품이고 아랫단에 자크도 있습니다. 특별한 하자 없어요~");
		board92.setPrice(10000);
		board92.setRegion(209);
		board92.setCategory(5);
		board92.setStatus(false);
		board92.setDate("10-21 11:32"); 
		board92.setSaleId("user7");
		board92.setBoardNum(92);
		tb_board.add(board92);
		
		BoardVO board93 = new BoardVO();
		
		board93.setTitle("에어매트 1인용 2개");
		board93.setProduct("에어매트");
		board93.setContent("인텍스, 사이즈는 75*190*20 미사용 제품입니다. 상부가 부드럽고 새제품 냄새는 세워놓고 다 빼놨습니다.");
		board93.setPrice(20000);
		board93.setRegion(330);
		board93.setCategory(12);
		board93.setStatus(false);
		board93.setDate("10-21 13:32"); 
		board93.setSaleId("user8");
		board93.setBoardNum(93);
		tb_board.add(board93);
		
		BoardVO board94 = new BoardVO();
		
		board94.setTitle("4단 선반 판매합니다.");
		board94.setProduct("선반");
		board94.setContent("유성시장 가구점에서 구매했던 제품이고 이사오면서 필요가 없어져서 판매합니다. 직접 가지러 오셔야 해요~");
		board94.setPrice(20000);
		board94.setRegion(427);
		board94.setCategory(2);
		board94.setStatus(false);
		board94.setDate("10-22 15:08"); 
		board94.setSaleId("user9");
		board94.setBoardNum(94);
		tb_board.add(board94);
		
		BoardVO board95 = new BoardVO();
		
		board95.setTitle("카페트 팝니다.");
		board95.setProduct("카페트");
		board95.setContent("157*220 사이즈 입니다. 꼭 사실분만 연락 주세요");
		board95.setPrice(20000);
		board95.setRegion(501);
		board95.setCategory(2);
		board95.setStatus(false);
		board95.setDate("10-22 15:28"); 
		board95.setSaleId("user10");
		board95.setBoardNum(95);
		tb_board.add(board95);
		
		BoardVO board96 = new BoardVO();
		
		board96.setTitle("아이뽕8 플러스 64기가골드");
		board96.setProduct("휴대폰");
		board96.setContent("17년도 12월에 구입했고 정상해지폰입니다. 초기화 다 해놨고 30에 드립니다. 에눌 가능하고 직거래만 연락 받습니다.");
		board96.setPrice(300000);
		board96.setRegion(147);
		board96.setCategory(12);
		board96.setStatus(false);
		board96.setDate("10-22 16:28"); 
		board96.setSaleId("user1");
		board96.setBoardNum(96);
		tb_board.add(board96);
		
		BoardVO board97 = new BoardVO();
		
		board97.setTitle("전자렌지 팝니다.");
		board97.setProduct("전자렌지");
		board97.setContent("작년에 구매했고 좋은 점은 탈취 기능이 있습니다. 렌지 안에서 냄새가 안나서 쾌적하게 사용하실 수 있습니다.");
		board97.setPrice(30000);
		board97.setRegion(147);
		board97.setCategory(1);
		board97.setStatus(false);
		board97.setDate("10-25 11:28"); 
		board97.setSaleId("user2");
		board97.setBoardNum(97);
		tb_board.add(board97);
		
		BoardVO board98 = new BoardVO();
		
		board98.setTitle("쇼파의자 1인용 서재쇼파");
		board98.setProduct("의자");
		board98.setContent("평상시에는 쇼파의자로 사용하면서 눕고싶을 때는 허리조정 가능합니다. 저는 마약쇼파보다 이 쇼파가 훨씬 좋았습니다.");
		board98.setPrice(65000);
		board98.setRegion(207);
		board98.setCategory(2);
		board98.setStatus(false);
		board98.setDate("10-25 16:16"); 
		board98.setSaleId("user3");
		board98.setBoardNum(98);
		tb_board.add(board98);
		
		BoardVO board99 = new BoardVO();
		
		board99.setTitle("그라인더4인치+전선릴 팝니다.");
		board99.setProduct("공구");
		board99.setContent("그라인더 4인치 1번사용 전선릴 20미터 1번사용 합쳐서 6만원에 팝니다. 직거래하신다면 4만원에 드립니다.");
		board99.setPrice(40000);
		board99.setRegion(323);
		board99.setCategory(12);
		board99.setStatus(false);
		board99.setDate("10-15 22:16"); 
		board99.setSaleId("user4");
		board99.setBoardNum(99);
		tb_board.add(board99);
		
		BoardVO board100 = new BoardVO();
		
		board100.setTitle("빤스 체커보드 슬립온 신발");
		board100.setProduct("신발");
		board100.setContent("빤스 정품이고 완전 새거입니다 ...ㅠㅠ 사이즈는 230이니까 사이즈 꼭 확인하고 연락주세요!!!");
		board100.setPrice(25000);
		board100.setRegion(418);
		board100.setCategory(5);
		board100.setStatus(false);
		board100.setDate("10-26 16:14"); 
		board100.setSaleId("user5");
		board100.setBoardNum(100);
		tb_board.add(board100);

	}
	
	public ArrayList<MessageVO> tb_message = new ArrayList<MessageVO>();
	{
		
	}
	
	public ArrayList<MyinfoVO> tb_myinfo = new ArrayList<MyinfoVO>();
	{
		MyinfoVO myinfo = new MyinfoVO();
		myinfo.setId("admin5");
		myinfo.setNum(1);
		tb_myinfo.add(myinfo);
		
		MyinfoVO myinfo2 = new MyinfoVO();
		myinfo2.setId("admin5");
		myinfo2.setNum(2);
		tb_myinfo.add(myinfo2);
		
		MyinfoVO myinfo3 = new MyinfoVO();
		myinfo3.setId("admin4");
		myinfo3.setNum(1);
		tb_myinfo.add(myinfo3);
		
		MyinfoVO myinfo4 = new MyinfoVO();
		myinfo4.setId("admin3");
		myinfo4.setNum(2);
		tb_myinfo.add(myinfo4);
	}
	
	public ArrayList<NoticeVO> tb_notice = new ArrayList<NoticeVO>();
	{
		NoticeVO notice1 = new NoticeVO();
		notice1.setNoticeTitle("서버 장애 안내");
		notice1.setNoticeContent("안녕하세요?\n\n 11월 22일 오전 8시경부터 서버 장애로 인해 서비스 사용이 어렵습니다."
				+ "\n\n당근마트에 서버를 공급하는 아마존 웹서비스(AWS)장애로 인해 당근마트 서비스도 영양을 받고 있습니다."
				+ "\n\n이로 인해 AWS를 사용하는 쿠팡, 배민 등의 많은 국내 서비스들이 장애 현상을 겪고 있어요."
				+ "\n\n한국 아마존 측과 같이 대응하며 빠른 복구를 위해 노력중입니다."
				+ "\n\n불편을 드려 죄송합니다.\n\n\n당근마트팀 ");
		notice1.setNoticeDate("2018-11-22");
		notice1.setNoticeNum(1);
		notice1.setNoticeGrade(0);
		tb_notice.add(notice1);
		
		NoticeVO notice2 = new NoticeVO();
		notice2.setNoticeTitle("[공지]당근마트 사무실 이전으로 위치기반서비스 이용약관이 변경될 예정이예요.");
		notice2.setNoticeContent("당근마트 서비스를 이용해주시는 고객 여러분께 감사드리며, 위치기반서비스 이용약관 변경에 관한 안내 말씀 드려요."
				+ "\n\n1.변경 사항\n당근마트 회사의 주소 및 연락처 등이 변경되며, 다른 내용은 이전과 동일합니다.\n(변경된 약관은 기존과 동일한 목적 및 범위로 적용됩니다.)"
				+ "\n\n2.변경 시기\n변경된 위치기반서비스 이용약관은 2019년 06년 01일자로 효력이 발생됩니다."
				+ "\n\n3.문의 및 동의 철회\n변경된 위치기반서비스 이용약관 내용에 동의하지 않으시는 경우, '탈퇴'신청을 통해 회원 탈퇴를 하실 수 있습니다."
				+ "\n\n관련하여 궁금하신 점이나 소중한 의견은 언제든지 고객센터로 알려 주세요."
				+ "\n\n당근마트은 이용자 여러분의 위치정보 및 개인정보 보호를 최우선으로 하는 것을 약속드리며, 신뢰받는 서비스로 보답할게요."
				+ "\n\n따뜻한 지역 거래 문화를 함께 만들어가요.");
		notice2.setNoticeDate("2019-05-15");
		notice2.setNoticeGrade(0);
		tb_notice.add(notice2);

		NoticeVO notice3 = new NoticeVO();
		notice3.setNoticeTitle("[공지]광고 계좌 결제 서비스 점검 일정 안내드려요.");
		notice3.setNoticeContent("결제사 서비스 점검에 따라 아래 시간에 광고 계좌 이체결제가 일시 중단될 예정이예요."
				+ "\n\n(결제 서비스만 점검 대상이며, 당근마트 서비스 이용은 가능해요."
				+ "\n\n\t작업일시\n\t2019.06.16(일) 23:50 ~ 2019.06.17(월) 00:30(40분 전면 중단)"
				+ "\n\n\t작업내용\n\t신규DB서버로 교체 및 서비스 전환 작업"
				+ "\n\n\t영향범위\n\t가상계좌, 실계좌이체 등 PG서비스 일시 중단(승인, 취소 등)"
				+ "\n\n해당 작업은 작업상태에 따라 단축되거나 연장될 수 있다고 해요."
				+ "\n\n광고 결제를 계좌 이체로 이용하시는 사장님들은 위 시간을 참고 부탁드려요."
				+ "\n\n보다 나은 서비스로 당근마트을 사용하실 수 있도록 노력할게요~ 지켜봐주세요!"
				+ "\n항상 감사드려요.");
		notice3.setNoticeDate("2019-06-12");
		notice3.setNoticeNum(3);
		notice3.setNoticeGrade(0);
		tb_notice.add(notice3);
	}
	
}