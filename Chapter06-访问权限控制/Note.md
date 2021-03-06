# 第6章 访问权限控制

## 6.1 包：库单元

​	一个java文件是一个编译单元，每一个编译单元必须有且只能有一个public类。

### 6.1.1 代码组织

​	Java文件编译之后，其中的每一个类都会生成一个class文件，因此可能编译一个文件，生成多个class文件。Java的可运行程序是一组可以打包并压缩成一个Java文档文件（JAR，使用Java的jar文档声称器）的.class文件。

​	可以认为，一个package是一个类库，其中的每个文件都有一个public类和任意数量的非public类，因此每个文件都有一个构件。

### 6.1.2 创建独一无二的包名

​	一般，package的第一部分是类的创建者的反向Internet域名；另外一种写法是把package分解为你机器上的一个目录，这样Java程序运行需要加载.class文件的时候，他就知道需要到哪里去找。

​	Java解释器的运行过程如下：首先找出CLASSPATH，将其作为根目录，把包名中的每一个句点替换为斜杠或者反斜杠。得到的路径会和CLASSAPATH中的每一个连接，解释器就会在这些目录中查找你要创建的类的class文件。

### 6.1.3 定制工具库

​	将你的工具类添加到一个特定的包中

### 6.1.4 用import改变行为

​	C可以使用条件编译，从而切换开关产生不同的行为，这大多数是用来解决跨平台问题的，Java没有跨屏台的问题，因此不需要使用条件编译。但是条件编译还有一些有价值的用途，比如调试。在Java中，你可以使用import不同的包产生不同的行为，使用这样的方式来达到调试的目的。

### 6.1.5 对使用包的忠告

​	必须保证CLASSPATH下目录存在，否则将会出错

## 6.2 Java访问权限修饰词

### 6.2.1 包访问权限

​	默认访问权限(有时也被称为friendly)就是包访问权限，它将包中所有的类组合起来，以使它们相互之间都能访问彼此。

### 6.2.2 public：接口访问权限

​	处于相同的路径而没有指定包，那么它们同处于默认包中。

### 6.2.3 private：你无法访问

### 6.2.4 protected：继承访问权限

​	使用protected修饰，即使位于不同的包，派生类也可以无限制使用该方法。

## 6.3 接口和实现

## 6.4 类的访问权限

​	编译单元中不带任何public类是被允许的，此情况下，可以随意对文件命名。class仅可以使用包访问权限和public来修饰，如果没有创建为public，如果该类中包含static方法，那么在包之外也是可以访问的。

## 6.5 总结

