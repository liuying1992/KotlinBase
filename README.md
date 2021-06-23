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
    
   ```
     fun main(){
           val names = arrayOf("sss","vvv","ss1")
           test(* names)
     }
     fun test(vararg names:String){
        names.forEach{println(it)}
     }

```
    