package factory.factorymethod.order;

public class PizzaStore {

	public static void main(String[] args) {
		String loc = "ld";
		if (loc.equals("bj")) {
			//创建北京口味的各种Pizza
			new BJOrderPizza();
		} else {
			//创建伦敦口味的各种Pizza
			new LDOrderPizza();
		}
		// TODO Auto-generated method stub
	}

}
