package strategy.improve;

public class ToyDuck extends Duck{

	
	public ToyDuck() {
		// TODO Auto-generated constructor stub
		flyBehavior = new NoFlyBehavior();
		quackBehavior = new NoQuackBehavior();
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("玩具鸭");
	}


	public void swim() {
		System.out.println("玩具鸭不会游泳~~");
	}
	
	
}
