package spbu.murskiy;

/**
 * Created by Sergey Murskiy on 19.11.2018.
 */
public class MyClass {
    public int a;
    public int b;

    public MyClass(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object obj) {
        MyClass c = (MyClass) obj;
        return this.a == c.a && this.b == c.b;
    }

    @Override
    public int hashCode() {
        return a;
    }
}
