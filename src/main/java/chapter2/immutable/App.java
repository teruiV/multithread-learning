package chapter2.immutable;

/**
 * @author jianweilin
 * @date 2018/9/1
 */
public class App {
    public static void main(String[] args) {
        for (int i=0;i<3;i++){
            new PrintPersonThread(new Person("Lisa","shangHai")).start();
        }
    }
}
