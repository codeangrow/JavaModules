import com.sun.org.apache.bcel.internal.classfile.InnerClass;

public class MyClass {
    public int j=1;
    public int printThisValue(int val){

        InnerClass ic=new InnerClass();
        j=ic.printThisValue(val);

        return j;
    }

    public class InnerClass{
        int i=0;
        public int j=1;
        public InnerClass(){
            j++;
        }

        public int printThisValue(int j){
            return this.j++;
        }
    }
}
