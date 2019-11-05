import java.util.Scanner;

public class circle {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);  //스캐너 사용을 위한 선언
		int x;  // x값에 크기를 받습니다.
		
		System.out.print("번호를 입력하세요 : ");
		x = scan.nextInt();
		
		if ( x < 4)
		{
			x = 4;    // 최소값을 4로 설정했습니다.
		}
		
		//원 완성본 시작
		// 원의 방정식 공식은 (x-a) * (x-a) + (y-b)*(y-b) = r2입니다.
		for (int i=x*2; i>=0; i--) {
			for (int j=x*2; j>=0; j--) {
				if( (i-x)*(i-x) + (j-x)*(j-x) < (x*x) +2   ) {
					System.out.print("* ");
				} else if ( (i-x)*(i-x) + (j-x)*(j-x) >= (x*x) +2  ) {
					System.out.print("  ");  // 이 범위에 속하지 않는다면 빈칸을 출력합니다. 빈칸이 찍히는 지 확인하고 싶다면 '^'로 표시.
				}
			}
			System.out.println(" ");
			scan.close();  // 스캐너 닫기
		}
		//원 완성본 종료
	}
}