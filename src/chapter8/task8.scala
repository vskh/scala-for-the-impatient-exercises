package chapter8

/**
 * task8 <Description>
 *
 * @author vadya
 */
object task8 extends App {
  class Person(val name: String) {
    override def toString = getClass.getName + "[name=" + name + "]"
  }
  class SecretAgent(codename: String) extends Person(codename) {
    override val name = "secret" // Don't want to reveal name . . .
    override val toString = "secret" // . . . or class name
  }
}

//% javap -c -private task8\$Person
//Warning: Binary file task8$Person contains chapter8.task8$Person
//Compiled from "task8.scala"
//public class chapter8.task8$Person {
//private final java.lang.String name;
//
//public java.lang.String name();
//Code:
//0: aload_0
//1: getfield      #10                 // Field name:Ljava/lang/String;
//4: areturn
//
//public java.lang.String toString();
//Code:
//0: new           #15                 // class scala/collection/mutable/StringBuilder
//3: dup
//4: invokespecial #19                 // Method scala/collection/mutable/StringBuilder."<init>":()V
//7: aload_0
//8: invokevirtual #23                 // Method java/lang/Object.getClass:()Ljava/lang/Class;
//11: invokevirtual #28                 // Method java/lang/Class.getName:()Ljava/lang/String;
//14: invokevirtual #32                 // Method scala/collection/mutable/StringBuilder.append:(Ljava/lang/Object;)Lscala/collection/mutable/StringBuilder;
//17: ldc           #34                 // String [name=
//19: invokevirtual #32                 // Method scala/collection/mutable/StringBuilder.append:(Ljava/lang/Object;)Lscala/collection/mutable/StringBuilder;
//22: aload_0
//23: invokevirtual #36                 // Method name:()Ljava/lang/String;
//26: invokevirtual #32                 // Method scala/collection/mutable/StringBuilder.append:(Ljava/lang/Object;)Lscala/collection/mutable/StringBuilder;
//29: ldc           #38                 // String ]
//31: invokevirtual #32                 // Method scala/collection/mutable/StringBuilder.append:(Ljava/lang/Object;)Lscala/collection/mutable/StringBuilder;
//34: invokevirtual #40                 // Method scala/collection/mutable/StringBuilder.toString:()Ljava/lang/String;
//37: areturn
//
//public chapter8.task8$Person(java.lang.String);
//Code:
//0: aload_0
//1: aload_1
//2: putfield      #10                 // Field name:Ljava/lang/String;
//5: aload_0
//6: invokespecial #42                 // Method java/lang/Object."<init>":()V
//9: return
//}
//8% javap -c -private task8\$SecretAgent
//Warning: Binary file task8$SecretAgent contains chapter8.task8$SecretAgent
//Compiled from "task8.scala"
//public class chapter8.task8$SecretAgent extends chapter8.task8$Person {
//private final java.lang.String name;
//
//private final java.lang.String toString;
//
//public java.lang.String name();
//Code:
//0: aload_0
//1: getfield      #11                 // Field name:Ljava/lang/String;
//4: areturn
//
//public java.lang.String toString();
//Code:
//0: aload_0
//1: getfield      #15                 // Field toString:Ljava/lang/String;
//4: areturn
//
//public chapter8.task8$SecretAgent(java.lang.String);
//Code:
//0: aload_0
//1: aload_1
//2: invokespecial #19                 // Method chapter8/task8$Person."<init>":(Ljava/lang/String;)V
//5: aload_0
//6: ldc           #21                 // String secret
//8: putfield      #11                 // Field name:Ljava/lang/String;
//11: aload_0
//12: ldc           #21                 // String secret
//14: putfield      #15                 // Field toString:Ljava/lang/String;
//17: return
//}
