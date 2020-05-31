package proxy.dynamic;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建目标对象
		ITeacherDao teacherDao = new TeacherDao();

		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTeacherDao(teacherDao);
		ITeacherDao dao = (ITeacherDao)proxyFactory.getProxyInstance();
		dao.sayHello("111");
		dao.teach();
	}

}
