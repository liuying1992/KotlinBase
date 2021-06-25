# Kotlin学习记录

## 基础
### 数据类型
  * kotlin中一切都是对象，不区分基本数据类型和其它的包装类。而且kotlin中没有Java中的原始基本类型，但是`char` ,`byte`,`integer`,
      `float`,`boolean` 类型仍可使用，但是都是作为对象存在。
  * 字符串 基本与Java相似， 可以用for迭代、用[]来方位单个字符。可以支持在字符串面值中引用局部变量，例如 `"string $name"`
  * 数组 数组是带有类型参数的类。
    * 数组创建方法：
        1. 使用arrayOf函数创建数组。
        2. 使用arrayOfNulls创建一个给定大小的数组，元素均为NULL。
        3. 使用Array类的构造方法，使用lambda表达式，并且指定数组大小。
    * Unit 与java 中的void用法一致，可以用于没有返回值时的情况下使用。（返回值为Unit 可以省略该声明）值得注意的是，Unit
      可以作为类型参数，但是void 不行。
    * Any 顾名思义 Any是Kotlin中所有非空类型的超类。如果把基本数据类型赋值给Any类型的变量，则会自动装箱。如果想要使用变量可以存储null
      在内的所有可能值，则需要使用 Any?
    * Nothing 一般用于函数返回值使用，或者泛型函数返回值类型参数使用。
    
 ### Kotlin函数
   * kotlin中函数可以将函数名一起标明，这样增强了代码的可读性（如果指定了一个参数名，其它就必须指定）
  
   ```
fun main(){
        test(name = "user",sex = 1)
        test("user",1)
}
fun test(name:String,sex:Int){

}

```

   * kotlin可以在构造函数中设置默认参数值，从而避免创建重载的函数 `sex:Int = 1`  
   * 如果使用了命名参数，可以省略任何的默认值得参数，而且可以按照任意顺序传入需要的参数
   * 可变参数 所谓可变参数，就是可以让我们把任意个数的参数打包到数组中传给函数，使用关键字`vararg` java中可以直
     接把数组传给函数的可变参数，Kotlin中则需要显式的解包数组，以便于每个数组元素在函数中能够作为单独的参数来调用，
     这个功能被称为展开函数，使用方式就是在数组参数钱加一个 `*`
    
   ```js
     fun main(){
           val names = arrayOf("sss","vvv","ss1")
           test(* names)
     }
     fun test(vararg names:String){
        names.forEach{println(it)}
     }

```

   * 局部函数 kotlin支持在函数中嵌套函数，被嵌套的函数称为局部函数
   
   ### kotlin中的表达式跟条件循环
   
   * 语句是指可单独运行，能够产生实际效果的代码。
   * 表达式可以是一个值、变量、常量、操作符、或者他们之间的组合。可以认为是包含返回值的语句。
   * if 表达式 if可以是代码块，作为表达式的返回值

   ```js
    val max = if(12>10){
        println("max value = 12")
        12    
    }else{
        println("maxValue = 10")
        10
    }
    println(max)
```
   
   * when表达式 等价于Java中的switch/case 。但是功能上要比Java的强大的多。when可以当做表达式使用也可以被当做语句使用。
  ```js
    val value =2 
    when(value){
    in 4..9 -> println("in 4..9")//区间判断
    3 -> println("value is 3")//相等性判断
    2,6 -> println("value is 2 or 6")//多值相等性判断
    is Int -> println("is Int")//类型判断
    else -> println("else") //以上条件都不满足    
    
    //表达式
    fun parser(obj:Any):Stirng{
        when(obj){
            1 -> "value is 1"
            "4" -> "value is String 4"
            is Long -> "value type is Long"
            else -> "unknown"
        }
    }
    println(parser("1"))

}
```

   * for循环 用法与Java基本相同 
   
   ```js
     val list  = listOf(1,2,3,4,5)
     for(value in list)//正常使用
     for(index in list.indices)//通过索引来遍历
     for((index,value) in list.withIndex())//索引跟相应的值
     for(index in 2..10)//自定义循环区间
```
 
   * while 和 do/while 循环 用法与Java基本无异
   
   ```js
    val list  = listOf(1,2,3,4,5,6) 
    var index =0
    while(index<list.size){
        println(list[index])
        index++
    }  
```

   * 返回和跳转 kotlin中有三种结构化跳转表达式
    1. return 默认从最直接包围它的函数或者匿名函数返回
    2. break 终止最直接包围它的循环
    3. continue 继续下一次最直接包围它的循环
    
  ### 修饰符
   * final和open  kotlin类和方法默认都是final， 如果需要被继承， 则需要使用open修饰符来标识这个类。
   * public  默认修饰符。
   * protected 只能被用在类或者接口中的成员上。在Java种，可以从同一个包中访问一个protected的成员，但对于kotlin来说
     protected成员只在该类和它的子类中可见。不适用于顶层声明
   * internal 对于module可见 其他module不可见
   * private private修饰符是最高级别的修饰符，kotlin中允许在顶层声明中适用private可见性，包括类、函数和属性
     这标识只在自己所在的文件中可见，所以如果将一个类声明成private,就不能在定义这个类之外的地方使用它。此外，如果在一个类中
     使用了private修饰符，那么访问权限就被限制在了这个类里面，继承这个类的子类也不能使用它。如果类、对象、接口等被定义为private,
     那么他只对被定义所在的文件可见。
  
  ### 空安全
   * kotlin中，类型系统将一个引用分为可容纳null或者不能容纳null两种类型。例如 String类型不能指向null
   
   ```js
    var name:String = "name"
    //name ==null //报错 不能指向null
    var name:String? = "name"
    name = null //可以 
    
```

   * kotlin对可控类型的显示支持有助于防止NullPointerException导致的问题，编译器不允许对不可空变量做null检查就直接调用期
     属性。
     
   ```js
    fun check(name:String?):Boolean{
      return name.isNotEmpty()//报错 编译器不允许不做null检查
      //正确做法
      if(name !=null){
        return name.isNotEmpty()
      }
      return false;
    }
     
```

   * `？.`安全调用运算符 具体作用是把一次null检测和一次方法合并为一个操作，如果变量值为非空，则方法或者属性会被调用，否者直接返回null
   * Elvis运算符`？：` 该操作用于替代 `?.`直接返回默认null的情况  `name ?:"defaultName"`
   * 安全转换运算符：`as？` 用于把值转换为指定的类型，如果值不适合该类型则返回null
   * 非空断言：`!!` 非空断言用于把任何值转换为非空类型，如果对null值做非空断言，则会抛出异常。
   
   ### 类型检查与转换
   
   * is 与 ！is操作符用于在运行时检查对象是否符合给定类型（参考上面的 when案例） is操作符还附带一个只能转换功能。不需要再
    kotlin中使用显示转换操作符，因为编译器跟踪不可变值is检查以及显示转换，并在需要时自动插入安全的转换。
   * 不安全的转换操作符 如果转换是不符合的 操作转换符`as`会抛出一个异常。
   * 安全的操作符`as?` 可以避免转化异常。
   
   ### 类 
   * class 关键字来声明类
   * 主构造函数 ： 类头的一部分，跟在类名（和可选的类型参数）后，主构造函数的参数可以是可变的`var`  和`val` 不可变
   * 次构造函数： 类可以声明包含前缀` constructor`的次构造函数。如果类有一个主构造函数，每个次构造函数都需要直接委托给主
    构造函数或者委托给另一个次构造函数以此进行间接委托，用` this ` 关键字来指定即可
    
  ```js
    class Test(val x:Int ,val y:Int){
        private  val localX = x+1
        private val localY = y+1
        constructor(base:Int):this(base+1,base+1){
        }
    }  
```
   * 属性 kotlin中，属性是头等的语言特性，完全替代了字段和访问器的方法。在类中声明一个变量一样是使用val和var关键字。
     val 变量中只有一个getter var变量既有getter 也有 setter
   * 自定义访问器 访问器的默认实现逻辑很简单，创建一个存储值的字段，以及返回属性值的getter和更新属性值的setter.如果需要的话，也可以
     自定义访问器
     
   ```js
    class Test(val x:Int,val y:Int){
        val isSame:Boolean
            get(){
                return x ==y 
            }
        
    }   
```

   * 延迟初始化 lateinit 一帮情况，非空类型的属性必须在构造函数中初始化，但是可以用lateinit修饰符来标记该属性，用于
   告诉编译器该属性会在稍后的时间被初始化。
   
   ### 类的分类
   * 抽象类 `abstract`修饰符 用法与java类似，不需要用open标注一个抽象类或者抽象方法，因为这是默认声明的
   * 数据类型`data`  数据类是一个非常强大的类，可以避免重复创建java中的用于保存状态但又操作非常简单的pojo额模板代码
     它通常只提供了用于访问他们属性的简单的getter 和setter
   * 密封类 `sealed` 修饰符定义的直接子类只允被定义在sealed类所在的文件中，这有助于帮助开发者掌握父类与子类之间的变动关系，
   避免犹豫代码更迭导致的潜在BUG 而且密封函数只能是private
   * 枚举类 与java基本无异 但是需要多使用class关键字来声明枚举 枚举可以实现接口
   
   ```js
   interface OnChangeListener {
    fun onChange()
  }

  enum class Day(val index: Int) : OnChangeListener {
    SUNDAY(0) {
      override fun onChange() {

      }
    },
    MONDAY(1) {
      override fun onChange() {
        
      }
    }
  }
```

  * 嵌套类：在kotlin中类里面再定义类默认是嵌套类，此时嵌套类不会包含对外部类的隐式引用。
  * 内部类：如果需要去访问外部类的成员变量 需要使用到 `inner`修饰符，内部类会隐式持有对外部类的引用。
  * 匿名内部类：可以使用对象表达式来创建匿名内部类实例 
  
  ```js
  interface OnClickListener {
    fun onClick()
  }

  class MyView {
    fun setClickListener(clickListener: OnClickListener) {
    }
  }
    //main()
    val view = MyView()
    view.setClickListener(object : OnClickListener {
      override fun onClick() {
      
      }
    })
```

  * 内联类(`inline`)：有些时候需要对原生类型进行包装以便提升程序的健壮性。如：对sendEmail方法入参参数而言，我们无法严格限制入参参数
  的含义类型，有的开发者会将delay理解为毫秒为单位，有的则会理解为分钟为单位。
  
  ```js
    fun sendEmail(dealy:Long){
       println(delay)    
}  
//为了提升健壮性，我们可以声明一个包装类来作为参数类型：
    fun sendEmail(delay:Time){
        println(delay.second)
    }
    
calss Time(val second:Long)
calss Minute(private val count:Int){
    fun toTime():Time{
        return Time(count*60L)
    }
}

```
上述代码可以看出 我们在入参源头就限制了开发者能够传入的参数类型，开发者通过类名就能直表达出自己需要的时间大小。内连类
使用关键字 `inline` 

  ### 接口
  * 抽象方法与默认方法
  * 抽象属性 接口中可以包含抽象属性声明，接口不定义该抽象属性是应该存储到一个支持字段还是通过getter来获取，接口本身并不包含
    任何状态，因此只有实现这个接口的类在需要的情况下才会存储这个值。
    
  ### 继承 
  * 需要使用关键字 `open` 显示标注可覆盖的成员和覆盖后的成员
  * 属性覆盖：与方法覆盖类似。在超类中声明为open的属性，如果需要覆盖则必须在派生类中重新声明且以override开头
  ### 调用超类实现
  * 派生类可以通过super关键字调用其超类的函数与属性访问器的实现，如果需要在内部类访问外部类的超类，则需要通过由外部类名限定
    super关键字来实现。
   ```js
    open class Base{
        open fun fun1(){
            println("Base fun1")
        }
    }   
    
    class SubClass:Base(){
        override fun fun1(){
            println("subclass fun1")
        }
        
        inner class InnerClass{
            fun fun2(){
                super@SubClass.fun1()
            }
        }
    }
```
   ### 集合
   * 只读集合与可变集合
     kotlin 的集合设计和java不同的另一项特性是：kotlin把访问数据的接口和修改集合数据的接口分开了， `kotlin.collections.Collection`
     接口提供了遍历集合元素、获取集合大小、判断集合是否包含某元素等操作，但这个接口没有提供集合添加和移除元素的方法。
     `kotlin.collections.MutableCollection`接口继承于 `kotlin.collections.Collection`接口，扩展出了用于添加，移除，清空
     元素的方法。
     
   |集合元素|只读|可变|
   |----|----| ---|
   | List | listOf | mutableListOf、arrayListOf |
   | Set | setOf | mutableSetOf、hashSetOf 、linkedSetOf、sortedSetOf |
   | Map | mapOf | mutableMapOf、hashMapOf、linkedMapOf、sortedMapOf |
      
     
     
   
   
   
    
    