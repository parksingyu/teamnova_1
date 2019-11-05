import java.util.Random;
import java.util.Scanner;

public class sudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);// 스캐너 사용을 위한 선언입니다.
		Random r = new Random();            // 랜덤 수를 받기 위한 선언을 위한 선언입니다.

		System.out.print("숫자를 입력하세요 : ");
		int n = sc.nextInt();               // n*n의 스도쿠를 만들기 위한 입력값을 받습니다.
		
		// 이차원 배열 선언
		int[][] ar = new int[n][n];         // 2차원 배열을 생성합니다. 입력값 X 입력값.
		int[][] arr = new int[n][n];        // 값을 복사해야할 2차원 배열을 생성합니다.

		// 배열에 들어갈 초기값 입력
		for (int i=0; i<n; i++) {           // 0부터 입력값 까지 반복합니다.
			for(int j=0; j<n; j++) {        // i는 열 j는 행입니다.
				ar[i][j] = j+1;             // 열에 값이 같은 n * n 2차원 배열을 만듭니다.
			}
		}
		// 배열에 들어갈 초기값을 한칸씩 밀기.
		for(int i=0; i<n-1; i++) {          // n-1을 하지 않으면 out of index오류가 발생 합니다.
			ar[i+1][0] = ar[i][n-1];        // 행 마지막 숫자를 그다음 행 첫 숫자로 보냅니다. ex) 입력값이 5일 경우 ar[0][4] -> ar[1][0]
			for(int j=0; j<n-1; j++) {      // n-1을 하지 않으면 out of index오류가 발생 합니다.
				ar[i+1][j+1] = ar[i][j];    // 배열에 들어 있는 숫자를 다음 행 +1칸에 넣습니다. ex) ar[0][0] -> ar[1][1] / ar[0][1] -> ar[1][2]
			}
		}

		int a[] = new int[2];            // a[]에 난수를 받습니다. 저는 난수가 2개만 필요하기 때문에 2로 선언합니다.
		int c, d;                        // 난수 선언에 필요한 변수입니다.

		// 열 섞기 시작.
		for (int k=0; k<n; k++) {        // 행을 섞는 횟수는 n회입니다.
			for (int i=0; i<=1; i++ ) {  // 두개의 난수를 받습니다.
				a[i] = r.nextInt(n);     // a[i]에 1부터 입력값(n)-1 범위 안에 있는 난수를 받습니다. 
				for(int j=0;j<i;j++)     // 중복제거를 위한 for문 입니다. 
				{
					if(a[i]==a[j])  {    // 두개의 난수를 받는데 두개의 난수가 같을 경우 for문을 한번 더 반복합니다.
						i--;             // i-- 가 되면 i가 줄어드는게 아니고 위로 올라가서 다시 i++가 되기 때문에 숫자는 그대로인 상태에서 난수를 다시 받습니다.
					}
				}
			}
			c = a[0];                    // 현재 a[0]에는 1부터 n-1까지중 한개의 난수가 들어가 있습니다. 이것을 c로 선언합니다.
			d = a[1];                    // 현재 a[0]에는 1부터 n-1까지중 한개의 난수가 들어가 있습니다. 이것을 d로 선언합니다.

			for (int m=0; m<n; m++) {
				arr[m][0] = ar[m][c];    // 곧 삭제될 ar[m][c]를 다른 배열인 arr[m][0]에 보관합니다.
				ar[m][c] = ar[m][d];     // ar[m][d]를 ar[m][c]에 덮어쓰기 합니다.
				ar[m][d] = arr[m][0];    // ar[m][m] 자리에 ar[m][c]가 옵니다. 현재 ar[m][c]는 arr[m][0]에 있습니다.
			}
		}
		// 열 섞기 종료
		// 행 섞기 시작
		for (int k=0; k<n; k++) {        // 행을 섞는 횟수는 n-1회입니다.
			for (int i=0; i<=1; i++ ) {  // 두개의 난수를 받습니다.
				a[i] = r.nextInt(n);     // a[i]에 1부터 입력값(n) -1 범위 안에 있는 난수를 받습니다. 

				for(int j=0;j<i;j++)     // 중복제거를 위한 for문 입니다.
				{
					if(a[i]==a[j])  {    // 두개의 난수를 받는데 두개의 난수가 같을 경우 for문을 한번 더 반복합니다.
						i--;             // i-- 가 되면 i가 줄어드는게 아니고 위로 올라가서 다시 i++가 되기 때문에 숫자는 그대로인 상태에서 난수를 다시 받습니다.
					}
				}
				c = a[0];                // 현재 a[0]에는 1부터 n-1까지중 한개의 난수가 들어가 있습니다. 이것을 c로 선언합니다.
				d = a[1];                // 현재 a[0]에는 1부터 n-1까지중 한개의 난수가 들어가 있습니다. 이것을 d로 선언합니다.

				for (int m=0; m<n; m++) {
					arr[0][m] = ar[d][m];  // 곧 삭제될 ar[d][m]을 다른 배열인 arr[0][m]에 보관합니다.
					ar[d][m]  = ar[c][m];  // ar[c][m]을 ar[d][m]에 덮어쓰기 합니다.
					ar[c][m] = arr[0][m];  // ar[c][m] 자리에 ar[d][m]이 옵니다. 현재 ar[d][m]은  arr[0][m]에 있습니다.
				}
			}
		}
		//행 섞기 종료
		//최종 값 출력
		System.out.println(" 최종값 ");       // 최종값을 출력합니다.
		for (int i=0; i<n; i++) {         // 입력한 숫자만큼 for문이 반복됩니다. 
			for (int j=0; j<n; j++) {     // 입력한 숫자만큼 for문이 반복됩니다.
				if (ar[i][j] >= 10) {                       // 10 이상을 입력해도 자리수가 바뀌지 않게 for문 안에 if문으로 구역을 설정합니다.
					System.out.print(ar[i][j]+" ");         // ar[0][0]부터 ar[n][n]까지 출력합니다.
				} else {
					System.out.print(" " + ar[i][j] + " "); // ar[0][0]부터 ar[n][n]까지 출력합니다.
				}	
			}
			System.out.println("");
		}
		sc.close();  // 스캐너 닫기.
	}
}