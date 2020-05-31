package singleton;

public class SingletonTest {
    public static void main(String[] args) {
        //测试
        Singleton07 singleton1 = Singleton07.getInstance();
        Singleton07 singleton2 = Singleton07.getInstance();
        System.out.println(singleton1 == singleton2);//true

        Singleton08 instance01 = Singleton08.INSTANCE;
        Singleton08 instance02 = Singleton08.INSTANCE;
        System.out.println(instance01 == instance02);//true
    }
}

//饿汉式01(final静态变量)
//类装载完成实例化，避免线程同步问题，但是不能保证是getInstance()方法触发实例化，如果未用到，可能造成内存浪费
class Singleton01 {
    private Singleton01() {
    }

    private final static Singleton01 instance = new Singleton01();

    public static Singleton01 getInstance() {
        return instance;
    }
}

//饿汉式02(静态代码块)
//和饿汉式01一样，在类装载时，就执行静态代码块中的代码，避免线程不同步，可能造成内存浪费
class Singleton02 {
    private Singleton02() {
    }

    private static Singleton02 instance;

    //静态代码块中创建实例对象
    static {
        instance = new Singleton02();
    }

    public static Singleton02 getInstance() {
        return instance;
    }
}

//懒汉式01(线程不安全，开发中不用)
//我们假设有多个线程1，线程2都需要使用这个单例对象。而恰巧，线程1在判断完s==null后突然交换了cpu的使用权，
//变为线程2执行，由于s仍然为null，那么线程2中就会创建这个Singleton的单例对象。之后线程1拿回cpu的使用权，
//而正好线程1之前暂停的位置就是判断s是否为null之后，创建对象之前。这样线程1又会创建一个新的Singleton对象。
class Singleton03 {
    private Singleton03() {
    }

    private static Singleton03 instance;


    //使用到该方法才创建实例对象
    public static Singleton03 getInstance() {
        if (instance == null) {
            //暂停一会线程
            //try { TimeUnit.MILLISECONDS.sleep(800); } catch (InterruptedException e) { e.printStackTrace(); }
            instance = new Singleton03();
        }
        return instance;
    }
}

//懒汉式02(线程安全，同步方法，但是效率太低，开发中不推荐这种方法)
class Singleton04 {
    private Singleton04() {
    }

    private static Singleton04 instance;


    //使用到该方法才创建实例对象
    public static synchronized Singleton04 getInstance() {
        if (instance == null) {
            instance = new Singleton04();
        }
        return instance;
    }
}

//懒汉式03(使用同步代码块，但是问题同懒汉式01，线程不安全)
class Singleton05 {
    private Singleton05() {
    }

    private static Singleton05 instance;

    //使用到该方法才创建实例对象
    public static Singleton05 getInstance() {
        if (instance == null) {
            synchronized (Singleton05.class) {
                instance = new Singleton05();
            }
        }
        return instance;
    }
}

//双重检查(开发推荐使用)
class Singleton06 {
    private Singleton06() {
    }

    private static volatile Singleton06 instance;//保证可见性

    //解决线程安全问题，同时为懒加载模式，并且提高了效率
    public static Singleton06 getInstance() {
        if (instance == null) {//以后就在这里判断，不为空就直接返回，不会再进入同步代码块，提高了效率
            synchronized (Singleton06.class) {
                if (instance == null) {//第一次在这里创建实例，使用到同步代码块
                    instance = new Singleton06();
                }
            }
        }
        return instance;
    }
}

//静态内部类(开发推荐使用)
class Singleton07 {
    private Singleton07() {
    }

    //SingletonInstance在Singleton07类装载时不会马上执行
    private static class SingletonInstance {
        private static final Singleton07 instance = new Singleton07();
    }

    //提供一个共有方法直接返回SingletonInstance.instance，SingletonInstance会进行类加载，而类加载是线程安全的
    public static Singleton07 getInstance() {
        return SingletonInstance.instance;
    }
}

//枚举(开发推荐使用)
enum Singleton08 {
    INSTANCE;

    public void sayOK() {
        System.out.println("ok~");
    }
}