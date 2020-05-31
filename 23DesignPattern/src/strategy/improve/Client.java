package strategy.improve;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WildDuck wildDuck = new WildDuck();
		//wildDuck.fly();//
		wildDuck.quack();
		
		ToyDuck toyDuck = new ToyDuck();
		//toyDuck.fly();
		toyDuck.quack();
		
		PekingDuck pekingDuck = new PekingDuck();
		//pekingDuck.fly();
		pekingDuck.quack();
		
		//动态改变某个对象的行为, 北京鸭 不能飞
		pekingDuck.setFlyBehavior(new NoFlyBehavior());
		System.out.println("北京鸭的实际飞翔能力");
		pekingDuck.fly();
	}

}
