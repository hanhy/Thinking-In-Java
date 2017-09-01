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



### 7.8.3 final类