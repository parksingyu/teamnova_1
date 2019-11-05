import java.util.Scanner;

public class ma {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);  //스캐너 사용을 위한 선언
		int x, y;                               // 도형의 모양과 크기를 받을 변수 선언을 합니다.
		System.out.println("어떤 도형으로 하시겠습니까?");
		System.out.println("1.세로");
		System.out.println("2.가로");
		System.out.print("번호를 입력하세요 : "); 
		y = scan.nextInt();                     // y값에 가로인지 세로인지 값을 받습니다.

		System.out.println("크기를 선택하세요.");
		System.out.print("번호를 입력하세요 : ");
		x = scan.nextInt();                     // x값에  크기를 받습니다.

		if ( y==1) {
			///마름모 세로모양 시작
			//삼각형 시작. 
			for(int i=0; i<x; i++) {           // x라는 입력값에 따라 도는 횟수를 정합니다.
				for (int j=0; j<x-i; j++) {    // 맨 첫줄에 빈칸 갯수입니다.
					System.out.print(" ");
				}
				for(int j=0; j<2*i+1; j++) {   // 줄마다 나타내는 별 모양 갯수입니다. 첫줄에 1개 그다음 2개씩 늘어나게 설정 했습니다.
					System.out.print("*");
				}
				System.out.println("");
			}
			//삼각형 종료.

			//역삼각형 시작
			for(int i=x; i>0; i--) {            // x라는 입력값에 따라 도는 횟수를 정합니다.
				System.out.print(" ");
				for(int j=0; j<(x+1)-i; j++) {  // 줄마다 빈칸 갯수를 출력합니다.
					System.out.print(" ");
				}
				for(int j=2; j<2*i-1; j++) {   // 줄마다 찍히는 별의 갯수입니다. 
					System.out.print("*");      
				}
				System.out.println(" ");
			}
			//역삼각형 종료.
			///마름모 세로모양 종료
			///마름모 가로모양 시작
			//삼각형 시작.
		} else  {
			for(int i=0; i<x; i++) {              // x라는 입력값에 따라 도는 횟수를 정합니다.
				for (int j=0; j<3*x-(3*i); j++) { // 줄마다 줄어드는 빈칸의 갯수를 말합니다.
					System.out.print(" ");
				}
				for(int j=0; j<6*i+1; j++) {      // 첫줄부터 삼각형이 끝날때까지 표시되는 별의 갯수를 말합니다.
					System.out.print("*");
				}
				System.out.println("");
			}
			//삼각형 종료.

			//역삼각형 시작
			for(int i=0; i<x; i++) {    
				for(int j=0; j<3+(3*(i+1)); j++) { // 첫줄부터 삼각형이 끝날때 까지 빈칸의 갯수를 말합니다.  
					System.out.print(" ");
				}
				for(int j=0; j<(6*x)-11-6*(i); j++) { //역삼각형이 시작될때부터 표시되는 별의 갯수입니다. 양옆 3개, 총 6개씩 줄어듭니다.
					System.out.print("*");
				}
				System.out.println(" ");
				scan.close();  // 스캐너 닫기
			}
			//역삼각형 종료
		}
		///마름모 가로모양 종료
	}
}