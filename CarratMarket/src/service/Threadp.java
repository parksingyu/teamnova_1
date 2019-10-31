package service;

public class Threadp extends Thread{
	
	public void threadLoading() {
		try
        {
			System.out.println("당근마트 로딩중...");
            for(int i = 1 ; i <= 40 ; i++)
            {
            	
            	System.out.print("■■");
                //System.out.println("Loading... " + i*20 + "%");
                Threadp.sleep(60);
                if( i == 40) {
                	System.out.println(" ");
                	System.out.println(" ");
                	System.out.println(" ");
                	System.out.println(" ");
                	System.out.println(" ");
                	System.out.println(" ");
                	System.out.println(" ");
                	System.out.println(" ");
                	System.out.println(" ");
                	System.out.println(" ");
                	System.out.println(" ");
                	System.out.println(" ");
                	System.out.println(" ");
                	System.out.println(" ");
                	System.out.println(" ");
                	System.out.println(" ");
                	System.out.println(" ");
                	System.out.println(" ");
                	System.out.println(" ");
                	System.out.println(" ");
                	System.out.println(" ");
                	System.out.println(" ");
                }
                }
                
            
        }catch(InterruptedException e)
        {
            System.out.println(e);
        }
		
	}
	
	public void threadJoin(String tname){
		
		try{
			for ( int i = 0 ; i<tname.length(); i++){
				System.out.print(tname.charAt(i));
				Threadp.sleep(200);
			}
			
			System.out.print("님");
			Threadp.sleep(200);
			System.out.print("의");
			Threadp.sleep(200);
			System.out.print(" 가");
			Threadp.sleep(200);
			System.out.print("입");
			Threadp.sleep(200);
			System.out.print("을");
			Threadp.sleep(200);
			System.out.print(" 환");
			Threadp.sleep(200);
			System.out.print("영");
			Threadp.sleep(200);
			System.out.print("합");
			Threadp.sleep(200);
			System.out.print("니");
			Threadp.sleep(200);
			System.out.print("다");
			Threadp.sleep(200);
			System.out.print("!");
			Threadp.sleep(200);
			System.out.print("!");
			Threadp.sleep(200);
			System.out.println("!");
			
		} catch(InterruptedException e){
			System.out.println(e);
		}
		
		
		
	}
	
}
