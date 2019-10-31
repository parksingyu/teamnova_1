package service;

public interface BoardService {

	int rm();
	
	void boardList();
	
	void category();
	
	void region();
	
	void sale();
	
	void myInfo();
	
	void search();
		
	void detail(int s);
	
	void mdetail(int s);
	
	void delete(String saleId);
	
	void change(int s);
	
	void purchaseList();
	
	void buyList();
	
	void wishList();
	
	void wishSelect();
	
	void salecomplete();
	
	void sdetail(int m);
	
	void odetail(int m);
	
}
