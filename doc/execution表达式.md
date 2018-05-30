##execution(* com.sample.service.impl..\*.\*(..))
####execution()   表达式的主体;
####第一个"\*"符号  表示返回值的类型任意;
####com.sample.service.impl   AOP所切的服务的包名,即,我们的业务部分
####包名后面的".." 表示当前包及子包
####第二个"\*"    表示类名,*即所有类
####.\*(..)   表示任何方法名,括号表示参数,两个点表示任何参数类型

###execution(<修饰符模式>?<返回类型模式><方法名模式>(<参数模式>)<异常模式>?)  除了返回类型模式、方法名模式和参数模式外,其它项都是可选的

```
通过方法签名定义切点
execution(public * *(..))
匹配所有目标类的public方法,但不匹配SmartSeller和protected void showGoods()方法.第一个*代表返回类型,第二个*代表方法名,而..代表任意入参的方法;
```
*********************
```
execution(* *To(..))
匹配目标类所有以To为后缀的方法.它匹配NaiveWaiter和NaughtyWaiter的greetTo()和serveTo()方法.第一个*代表返回类型,而*To代表任意以To为后缀的方法;
```
*********************
```
通过类定义切点
 execution(* com.baobaotao.Waiter.*(..))
匹配Waiter接口的所有方法,它匹配NaiveWaiter和NaughtyWaiter类的greetTo()和serveTo()方法.第一个*代表返回任意类型,com.baobaotao.Waiter.*代表Waiter接口中的所有方法;
```
*********************
```
execution(* com.baobaotao.Waiter+.*(..))
匹配Waiter接口及其所有实现类的方法,它不但匹配NaiveWaiter和NaughtyWaiter类的greetTo()和serveTo()这两个Waiter接口定义的方法,同时还匹配NaiveWaiter#smile()和NaughtyWaiter#joke()这两个不在Waiter接口中定义的方法.
```
*********************
```
通过类包定义切点
在类名模式串中,".*"表示包下的所有类,而"..*"表示包、子孙包下的所有类.
execution(* com.baobaotao.*(..)) 匹配com.baobaotao包下所有类的所有方法;
```
*********************
```
execution(* com.baobaotao..*(..)) 匹配com.baobaotao包、子孙包下所有类的所有方法,如com.baobaotao.dao,com.baobaotao.servier以及com.baobaotao.dao.user包下的
所有类的所有方法都匹配.".."出现在类名中时,后面必须跟"*",表示包、子孙包下的所有类;
```
*********************
```
execution(* com..*.*Dao.find*(..)) 匹配包名前缀为com的任何包下类名后缀为Dao的方法,方法名必须以find为前缀.如com.baobaotao.UserDao#findByUserId()、
com.baobaotao.dao.ForumDao#findById()的方法都匹配切点.
```
*********************
```
通过方法入参定义切点
切点表达式中方法入参部分比较复杂,可以使用"*"和".."通配符,其中"*"表示任意类型的参数,而".."表示任意类型参数且参数个数不限.
```
*********************
```
execution(* joke(String,int))) 匹配joke(String,int)方法,且joke()方法的第一个入参是String,第二个入参是int.它匹配NaughtyWaiter#joke(String,int)方法.
如果方法中的入参类型是java.lang包下的类,可以直接使用类名,否则必须使用全限定类名,如joke(java.util.List,int);
```
*********************
```
execution(* joke(String,*))) 匹配目标类中的joke()方法,该方法第一个入参为String,第二个入参可以是任意类型,如joke(Strings1,String s2)和joke(String s1,double d2)
都匹配,但joke(String s1,doubled2,String s3)则不匹配;
```
*********************
```
execution(* joke(String,..))) 匹配目标类中的joke()方法,该方法第 一个入参为String,后面可以有任意个入参且入参类型不限,如joke(Strings1)、joke(String s1,String s2)
和joke(String s1,double d2,Strings3)都匹配.
```
*********************
```
execution(* joke(Object+))) 匹配目标类中的joke()方法,方法拥有一个入参,且入参是Object类型或该类的子类.它匹配joke(Strings1)和joke(Client c).
如果我们定义的切点是execution(*joke(Object)),则只匹配joke(Object object)而不匹配joke(Stringcc)或joke(Client c).
```