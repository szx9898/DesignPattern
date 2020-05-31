package proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory  {

	public static void main(String[] args) {
		TeacherDao teacherDao = new TeacherDao();
		TeacherDao p = (TeacherDao)Enhancer.create(teacherDao.getClass(), new MethodInterceptor() {
			@Override
			public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
				System.out.println("代理开始");
				Object returnVal = method.invoke(teacherDao, args);
				System.out.println("代理结束");
				return returnVal;
			}
		});
		p.teach();
	}

}
