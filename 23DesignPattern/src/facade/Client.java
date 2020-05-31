package facade;

import javax.security.auth.login.Configuration;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//这里直接调用。。 很麻烦
		HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();
		//homeTheaterFacade.ready();
		//homeTheaterFacade.play();
		String s1 = "hello";
		String s2 = new String("hello");
		String s3 = new String("hello");
		System.out.println(s2==s3);
		System.out.println(s3.hashCode());
		//homeTheaterFacade.end();
	}

}
