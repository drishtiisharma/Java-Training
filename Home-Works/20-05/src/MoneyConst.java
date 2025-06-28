class Money{
	
	int rupees, paisa;
	
	Money(int r, int p){
		rupees=r;
		paisa=p;
	}
	
	int rupeesToPaisa() {
		return rupees*100;
	}
	
	double paisaToRupees(){
		return (double)paisa/100;
	}
	
	void showMoney() {
		System.out.println("money: "+rupees+" rupees "+paisa+" paisa");
	}
}
public class MoneyConst {

	public static void main(String[] args) {
		Money m=new Money(80, 50);
		
		System.out.println("rupees to paisa: "+m.rupeesToPaisa()+" paisa");
		System.out.println("paisa to rupees: "+m.paisaToRupees()+" rupees");

	}

}
