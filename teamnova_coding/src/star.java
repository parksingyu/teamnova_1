import java.util.Scanner;

public class star {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);  //스캐너 사용을 위한 선언
		int x, y;                               // 도형의 모양과 크기를 받을 변수 선언을 합니다.
		
		System.out.println("어떤 도형으로 하시겠습니까?");
		System.out.println("1.일반적인 모양");
		System.out.println("2.이스라엘 국기 모양");
		System.out.print("번호를 입력하세요 : "); 
		y = scan.nextInt();                     // y값에 일반적인 모양인지 이스라엘 국기 모양인지 값을 받습니다.

		System.out.println("크기를 선택하세요.");
		System.out.print("번호를 입력하세요 : ");
		x = scan.nextInt();                     // x값에  크기를 받습니다.

		if ( y==1 ) {
			//별 상단부 시작
			for(int i=0; i<x; i++) {                        // i<x의 x는 출력되는 줄의 수 이기도 합니다.
				// 빈칸
				for (int j=0; j<((x*2)+x)-i; j++) {         // 줄이 바뀌게 되면   중반 시작 이전까지 빈칸이 한칸 씩 줄어듭니다.
					System.out.print(" ");
				}
				// 별
				for(int j=0; j<2*i+1; j++) {                // 줄마다 출력되는 별의 갯수 입니다. 줄이 바뀔 때마다2개씩 증가합니다.
					System.out.print("*");
				}
				System.out.println("");
			}
			// 별 상단부 종료

			// 별 중반부 시작
			for(int i=1; i<=x-1; i++) {                     // int i=1 을 입력할 경우 출력되는 줄 수는 x-1입니다. / 0을 입력할 경우 출력되는 줄 수는 x
				//빈칸
				for(int j=1; j<=2*i; j++) {  				// 빈칸을 표시합니다. 중반 시작  이후 줄이 바뀔 때마다 두칸 씩 늘어납니다.
					System.out.print(" ");                  // 매번 늘어나는 줄 수 입니다.
				}
				//별
				for(int j=1; j<=((6*x)-3)-4*(i-1); j++) {   // 매번 줄어드는 별을 표시합니다. 줄이 바뀔 때마다 양옆 2개, 총 4개씩 줄어들게 됩니다.
					System.out.print("*");
				}
				System.out.println("");		
			}
			// 별 중반부 종료

			// 별 하단부 시작  (별 하단은 4가지로 나뉩니다. 빈칸 -> 별 -> 빈칸 -> 별)
			for(int i=1; i<=(x-2)/2+3; i++) {              // x가 2 증가할때 1증가합니다.
				//빈칸
				for(int j=0; j<(2*x)-i-2; j++) {           // 줄이 바뀌게 되면 빈칸이 한칸 씩 줄어듭니다.
					System.out.print(" ");
				}
				// 별 (짝수 일 때와 홀수 일때로 구분했습니다. 결국엔 홀수로 끝나야 하기 때문입니다.)
				// 홀수
				if ( x % 2 == 1) {
					for(int j=0; j<=x+3-(2*i); j++) {      // 줄이 바뀌게 되면 별이 두개씩 감소합니다.
						System.out.print("*");	
					}
					// 짝수
				} else if ( x % 2 == 0) {
					for(int j=0; j<=x+4-(2*i); j++) {      // 줄이 바뀌게 되면 별이 두개씩 감소합니다.
						System.out.print("*");	
					}
				}
				// 빈칸 (짝수 일 때와 홀수 일때로 구분했습니다. 결국엔 홀수로 끝나야 하기 때문입니다.)
				// 짝수
				if (x % 2 == 0) {
					for(int j=0; j<6*i-5; j++) {           // 줄이 바뀌게 되면 빈칸이 7칸씩 늘어납니다.
						System.out.print(" ");	
					}
					// 홀수
				} else if (x % 2 == 1) {
					for(int j=0; j< 6*i-3; j++) {          // 줄이 바뀌게 되면 빈칸이 7칸씩 늘어납니다.
						System.out.print(" ");	
					}
				}
				// 별 (짝수 일 때와 홀수 일때로 구분했습니다. 결국엔 홀수로 끝나야 하기 때문입니다.)
				// 홀수
				if ( x % 2 == 1) {
					for(int j=0; j<=x+3-(2*i); j++) {      // 줄이 바뀌게 되면 별이 2씩 줄어든다.
						System.out.print("*");	
					}
					// 짝수
				} else if ( x % 2 == 0) {
					for(int j=0; j<=x+4-(2*i); j++) {      // 줄이 바뀌게 되면 별이 2씩 줄어든다.
						System.out.print("*");	
					}
				}
				System.out.println("");
			}
		} else if ( y==2) {
			//이스라엘 별 상단부 시작

			for(int i=0; i<x; i++) {                       // i<x의 x는 중간부는 출력되는 줄의 수 입니다.
				//빈칸
				for (int j=0; j<((x*2)+x)-i; j++) {        // 줄이 바뀌게 되면 빈칸이 한칸씩 감소합니다.
					System.out.print(" ");
				}
				//별
				for(int j=0; j<2*i+1; j++) {               // 줄이 바뀌게 되면 별이 2개씩 증가합니다.
					System.out.print("*");
				}
				System.out.println("");
			}
			// 이스라엘 별 상단부 종료

			// 이스라엘 별 중반_상단부 시작
			for(int i=1; i<=x-1; i++) {                    // int i에서 i는 출력되는 줄 수 -1 입니다.
				// 빈칸
				for(int j=1; j<=2*i; j++) {                // 줄이 바뀌게 되면 빈칸이 두칸씩 증가합니다.
					System.out.print(" ");                 // 매번 늘어나는 줄 수 입니다.
				}
				// 별
				for(int j=1; j<=((6*x)-3)-4*(i-1); j++) {  // 줄이 바뀌게 되면 별이 양옆에 두개 총 4개씩 감소합니다.   
					System.out.print("*");
				}
				System.out.println("");
			}
			// 이스라엘 별 중반_상단부 종료
			
			// 이스라엘 별 중반_하단부 시작
			for(int i=1; i<=x-2; i++) {                     // 초기값은 출력되는 줄 수 -1 입니다.
				// 빈칸
				for(int j=1; j<=(2*x)-(2*i)-2; j++) {       // 줄이 바뀔 때마다 빈칸이 두칸 감소합니다.  
					System.out.print(" ");    
				}
				// 별
				for(int j=1; j<=((2*x)+9)+4*(i-1); j++) {   //  줄이 바뀔 때마다 별이 양옆에 2개 총 4개씩 증가합니다.
					System.out.print("*");
				}
				System.out.println("");
			} 
			// 이스라엘 별 중반_하단부 종료
			
			// 이스라엘 별 하단부 시작
			for(int i=0; i<x; i++) {                       // 중간부는 출력되는 줄의 수 입니다.
				// 빈칸
				for (int j=0; j<((2*x)+1)+i; j++) {        // 줄이 바뀔때마다 빈칸이 한칸씩 증가합니다.
					System.out.print(" ");
				}
				// 별
				for(int j=0; j<(2*x)-1-(2*i); j++) {       // 줄이 바뀔때마다 별이 양옆에 1개 총 2개씩 증가합니다.
					System.out.print("*");
				}
				System.out.println("");
			}
			// 이스라엘 별 하단 종료
		}		
		scan.close();  // 스캐너 닫기
		// 별 하단부 종료
	}
}