package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vo.UserVO;
import controller.Controller;
import dao.UserDao;
import dao.UserDaoImpl;
import data.Session;

public class UserServiceImpl implements UserService {

	private static UserServiceImpl instance;
	
	private UserServiceImpl(){}
	
	public static UserServiceImpl getInstance(){
		if(instance == null){
			instance = new UserServiceImpl();
		}
		return instance;
	}
	
	UserDao userDao = UserDaoImpl.getInstance();
	
	@Override
	public void join() {
		//회원가입
		//사용자에게 정보 입력 받음
		Scanner s =new Scanner(System.in);
		
		String id;
		String password;
		String name;
		String phonenum;
		
		UserVO user = new UserVO();
		
		//정규식
		String regex1 = "[a-zA-Z0-9]{4,10}";
		String regex2 = "[a-zA-Z0-9]{8,16}";
		String regex3 = "^[가-힣a-zA-Z0-9]{2,12}$";
		String regex4 = "^\\d{3}-\\d{3,4}-\\d{4}$";
		
		boolean run, run2;
		
		do{
//			System.out.println("-1입력시 메인화면으로 돌아갑니다.");
//			System.out.print("아이디 : ");
			System.out.println("					 -1입력시 메인화면으로 돌아갑니다. ");
			System.out.print("					 아이디 : ");
			id = s.nextLine();
			
			if(id.equals("-1")){
				new Controller().start();
			}
			Pattern a = Pattern.compile(regex1);
			Matcher w = a.matcher(id);
			run = false;
			if(!(w.matches())){
				System.out.println("					 아이디가 적당하지 않습니다.");
				System.out.println("					 영대소문자와 숫자를 5개~20개 이내로 작성해주세요.");
//				System.out.println("아이디가 적당하지 않습니다.");
//				System.out.println("영대소문자와 숫자를 5개~20개 이내로 작성해주세요.");
				run = true;
			}
			
			//--------------------------
			UserVO userCheck = userDao.selectUser("ID", id); //key와 value를 파라미터로 받는다
			if(userCheck != null){
				System.out.println("					 이미 존재하는 아이디입니다.");
				//System.out.println("이미 존재하는 아이디입니다.");
				run = true;
			}
			//-----------------------------
		}while(run);
		
		do{
			System.out.print("					 비밀번호 : ");
			//System.out.print("비밀번호 : ");
			password = s.nextLine();
			
			if(password.equals("-1")){
				new Controller().start();
			}
			Pattern b = Pattern.compile(regex2);
			Matcher x = b.matcher(password);
			run = false;
			if(!(x.matches())){
				System.out.println("					 비밀번호가 보안에 취약합니다.");
				System.out.println("					 영대소문자와 숫자를 8개~16개 이내로 작성해주세요.");
//				System.out.println("비밀번호가 보안에 취약합니다.");
//				System.out.println("영대소문자와 숫자를 8개~16개 이내로 작성해주세요.");
				run = true;
			}
		}while(run);
		
		do{
			System.out.print("					 이름 : ");
			//System.out.print("이름 : ");
			name = s.nextLine();
			if(name.equals("-1")){
				new Controller().start();
			}
			Pattern c = Pattern.compile(regex3);
			Matcher y = c.matcher(name);
			run = false;
			if(!(y.matches())){
				System.out.println("					 이름이 적당하지 않습니다.");
				System.out.println("					 한글, 영대소문자와 숫자를 2개~12개 이내로 작성해주세요.");
//				System.out.println("이름이 적당하지 않습니다.");
//				System.out.println("한글, 영대소문자와 숫자를 2개~12개 이내로 작성해주세요.");
				run = true;
			}
		}while(run);
		
		do{
			System.out.print("					 전화번호 : ");
			//System.out.print("전화번호 : ");
			phonenum = s.nextLine();
			if(phonenum.equals("-1")){
				new Controller().start();
			}
			Pattern d = Pattern.compile(regex4);
			Matcher z = d.matcher(phonenum);
			run = false;
			if(!(z.matches())){
				System.out.println("					 휴대폰 작성양식에 맞게 입력해주세요");
				System.out.println("					 예)010-1234-1234");
//				System.out.println("휴대폰 작성양식에 맞게 입력해주세요");
//				System.out.println("예)010-1234-1234");
				run = true;
			}
		}while(run);
		
		//아이디 중복 검사(데이터베이스에서 아이디가 일치하는 회원 검색) 후
		user.setId(id);
		user.setPassword(password);
		user.setName(name);
		user.setPhonenum(phonenum);
		user.setGrade(1);
		
		
		userDao.insertUser(user);
/*		HashMap<String, String> param = new HashMap<String, String>();
		param.put("ID", id);
		UserVO user = userDao.selectUser(param);*/
		//System.out.println(user.getName() + "님의 가입을 환영합니다.");
		Threadp treadp = new Threadp();
		treadp.threadJoin(name);
		
		//사용자 정보 저장

	}

	@Override
	public void login() {
		//로그인
		//아이디, 비밀번호 입력
		Scanner s = new Scanner(System.in);
		
		System.out.println("					 -1입력시 메인화면으로 돌아갑니다. ");
		System.out.print("					 아이디 : ");
//		System.out.println("-1 입력시 메인화면으로 돌아갑나다.");
//		System.out.print("아이디 : ");
		String id = s.nextLine();
		if(id.equals("-1")){
			new Controller().start();
		}
		
		System.out.print("					 비밀번호 : ");
//		System.out.print("비밀번호 : ");
		String password = s.nextLine();
		if(password.equals("-1")){
			new Controller().start();
		}
		
		
		//database에서 아이디와 비밀번호가 일치하는 회원을 찾는다
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("ID", id);
		param.put("PASSWORD", password);
		
		UserVO user = userDao.selectUser(param);
		
		//있으면 로그인
		//없으면 로그인 실패
		if(user == null){
			System.out.println("					 아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
			//System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
			Controller ct = new Controller();
			ct.start();
		}else{
			Session.loginUser = user;
			System.out.println("					 로그인 성공");
			System.out.println("					 "+user.getName() + "님 환영합니다.");
//			System.out.println("					 아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
//			System.out.println("로그인 성공");
		}
	}

	@Override
	public void userList() {
		//회원 전체 목록 출력
		//회원 전체 검색
		ArrayList<UserVO> userList = userDao.selectUserList();
		//출력
		System.out.println("---------------------------------");
		System.out.println("번호\t아이디\t이름\t전화번호");
		System.out.println("---------------------------------");
		for(int i = 0; i < userList.size() ; i++){
			UserVO user = userList.get(i);
			System.out.println(i + 1 + "\t" + user.getId()+ "\t" + user.getName() + "\t "+ user.getPhonenum());
		}
		System.out.println("---------------------------------");
		
		
	}

	@Override
	public void category() {
		
		
		
	}

	@Override
	public void region() {
		
		
	}

	@Override
	public void sale() {
		
		
	}

	@Override
	public void myInfo() {
		
		
	}

	@Override
	public void search() {
		
		
	}

}
