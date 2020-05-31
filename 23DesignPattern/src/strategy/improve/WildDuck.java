package strategy.improve;

public class WildDuck extends Duck {

	
	//构造器，传入FlyBehavor 的对象
	public  WildDuck() {
		flyBehavior = new GoodFlyBehavior();
		quackBehavior = new ZhiZhiQuackBehavior();
	}
	
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println(" 这是野鸭 ");
	}

}
