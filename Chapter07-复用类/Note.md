# 第7章 复用类

### 7.1 组合语法

​	编译起并不是简单地为类中定义的引用进行初始化，要初始化这些引用可以在代码的下列地方进行：

1. 在定义对象的地方，在构造器执行之前执行
2. 构造器中
3. 执行代码之前，即```惰性初始化```
4. 使用实例初始化

## 7.2 继承语法

​	为了保证包外继承，一般将父类中的数据成员定义为private，方法定义为public。

### 7.2.1 初始化基类

​	继承并不只是复用了基类的借口和数据成员，还创建了一个基类的子对象，除了是内部生成的，该子对象与手动创建的对象并无明显的不同。Java会自动在导出类的构造器中插入基类的构造器，在执行导出类的构造器之前就已经被执行了。类的构建过程是从内向外扩散的，即现执行基类的构造器，后执行导出类的构造器。

## 7.3 代理

​	代理是组合和继承的中庸之道，组合一个对象，将主类需要的方法，封装进文件中，这样可以自由选择将哪些方法暴露在主类中。

## 7.4 结合使用组合和继承

​	编译器只会强制你去初始化基类，但是不会强制初始化成员对象。

### 7.4.1 确保正确清理

​	可以使用try和finally子句来进行清理工作，try后面的子块执行之后一定会执行finally中的子句，可以在finally中进行清理，如果需要清理，最好是自己编写清理方法，但是不要使用finalize。

​	清理顺序一般是先清理类的特定清理动作，其清理顺序与生成顺序相反；然后再调用基类的清理方法。

### 7.4.2 名称屏蔽

​	如果基类中拥有一个已经被重载多次的方法，在导出类中重新定义该方法并不会屏蔽其在基类中的任何版本。使用Java SE5中引入的override注解，如果在应该使用重写的地方使用了重载，编译器会报错。

## 7.5 在组合与继承之间选择

​	组合和继承都可以在新类中放置一个子对象，组合式显示的，继承是隐式的。通常，组合的时候，需要在新类中创建一个private的对象，组合更倾向于使新类具有某种功能。有时候也允许组合类为public，可以使用户知道新类在进行类的组合。

​	而继承，一般使某个类成为一个通用类。组合是has-a，继承是is-a。

### 7.6 protected关键字

​	了解了继承之后，protected关键字才开始具有意义，对于类的用户而言，域或者方法是不可见的，但是对于导出类却是可见的。尽管可以创建为protected，但是最好的方法还是将类保持为private，应当一直保留更改底层实现的权力，然后痛殴protected方法来控制类的访问权限。

## 7.7 向上转型

​	将导出类作为基类处理的过程叫做向上转型，这一叫法来自于传统的类继承图的画法。

​	虽然多次强调继承，但是实际上继承是不常用的，组合是更为多用的方法。实际上，继承最重要的使用场景是你需要使用向上转型的时候。

## 7.8 final关键字

​	final关键字传达给用户的信息是，这是不能被改变的。

### 7.8.1 final数据

​	通常有两种用法：

1. 编译时常量
2. 运行时常量

​        编译时常量必须是基本类型，用final关键字修饰；如果不是基本类型，则表示一个不变的引用，该引用只能指向一个对象，但是对象本身可变。

​	final数据在定义时必须被初始化。

​	static final和final的区别：

1. static final若修饰对象，则对象只有一个，对象也是不可变的
2. static final在类加载的时候就被初始化，final在执行时初始化

使用static final和final的初始化测试：

```java
public class Test {
	private final Value v1 = new Value(1);
	private static final Value v2 = new Value(2);
	
	public Test() {
		System.out.println("v1:" + v1.i);
		System.out.println("v2:" + v2.i);
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		System.out.println("testv1:" + test.v1.i);
		System.out.println("testv2:" + test.v2.i);
	}
}

class Value {
	int i;
	public Value(int i){
		System.out.println("Value:" + i);
		this.i=i;
	}
}
/*Value:2
Value:1
v1:1
v2:2
testv1:1
testv2:2*///:~
```

- 空白final

  ​	Java中允许空白final的存在，即，域可以不初始化，但是一定要在构造器中初始化

```java
public class Test {
	private final Value v1;// = new Value(1);;
	private static final Value v2 = new Value(2);
	
	public Test() {
		System.out.println("Constructor!");
		v1 = new Value(1);
		System.out.println("v1:" + v1.i);
		System.out.println("v2:" + v2.i);
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		System.out.println("testv1:" + test.v1.i);
		System.out.println("testv2:" + test.v2.i);
	}
}

class Value {
	int i;
	public Value(int i){
		System.out.println("Value:" + i);
		this.i=i;
	}
}
/*Value:2
Value:1
Constructor!
v1:1
v2:2
testv1:1
testv2:2
*///:~
```

- final参数

  ​	Java允许在参数列表中以声明的方式将参数指明为final，则该引用指向的对象不能被改变。这个特性一般用来向匿名内部类传递数据，参见第10章。

```java
public class Test {
	public int negate(final int n) {
		//n = -1 * n;
		return -1 * n;
	}
	public static void main(String[] args) {
		Test test = new Test();
		System.out.println(test.negate(1));
	}
}
/*-1
*///:~
```

### 7.8.2 final方法 

​	使用final方法的场景包括：1、锁定方法，防止任何修改	2、提高效率（已经不常用）

​	final和private关键字：

```java
public class Test {
	public static void main(String[] args) {
		Override2 o2 = new Override2();
		o2.f();
		o2.g();

		//You could upcast but can't call the methods.
		Override1 o1 = o2;
		//o1.f();
		//o1.g();
		o1.testUpcast();
		
		WithFinals base = o2;
		//base.f();
		//base.g();
		base.testUpcast();
	}
}

class WithFinals {
	private final void f() {System.out.println("base f()");}
	private void g() {System.out.println("base g()");}
	public void testUpcast() {f();g();};
}

class Override1 extends WithFinals{
	private final void f() {System.out.println("extend 1 f()");}
	private void g() {System.out.println("extend 1 g()");}
	public void testUpcast() {f();g();}
}

class Override2 extends Override1 {
	public final void f() {System.out.println("extend 2 f()");}
	public void g() {System.out.println("extend 2 g()");}
}
```

​	所有的private方法都是隐式地指定为final的，为private添加final关键字没有任何意义，可以在派生类中“重写”基类的private方法，编译器不会报错，但是其实并不是在重写，重写是针对基类的可见方法（上溯之后能够调用相同的方法）的，private本身不可见，所以，上面的操作仅仅是定义了名字一样的新方法而已。

### 7.8.3 final类

​	final类的域可以根据个人意愿选择是不是定义为final，不论类是不是final类。

​	然而，final类禁止继承，因此，final类的所有方法都是隐式地指定为final的，无法进行覆盖，可以在方法中为方法添加final修饰词，但是这不会添加任何意义。

### 7.8.4 有关final的忠告

​	很多时候，将方法指定为final是有效的，但是你无法完整地预料其他开发者何时会需要复用你的方法，所以可能会妨碍后续的开发。

## 7.9 初始化及类的加载

​	C++中，如果一个static期望另一个static在初始化之前就能有效使用，就会出现问题，但是Java不会有这个问题。Java中所有的事物都是对象，每个类的编译代码都存在与自己独立的文件中，且只会在初次使用是才会被加载。这通常发生在第一次创建对象的时候，对于static域和方法而言，发生在第一次访问之时，会按照书写顺序进行初始化。

### 7.9.1 继承与初始化

​	包含继承的初始化过程如下（以main方法发生在派生类中为例）：

​	通过extends关键字找到根基类->

​	从上到下进行类的加载（加载时初始化静态变量）->

​	加载完毕开始创建对象->

​	基类的变量初始化->基类构造器->派生类变量初始化->派生类构造器

### 7.10 总结

​	设计对象的时候，不要太大难以复用，也不要太小无法使用。把程序当做一个进化的生命体。