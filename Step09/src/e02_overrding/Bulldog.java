package e02_overrding;

public class Bulldog extends Dog{

	@Override
	public void eat() {
		System.out.println("불독은 핫도그를 먹습니다.");
	}
	
}
