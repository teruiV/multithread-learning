package chapter7;

/**
 * @author jianweilin
 * @date 2018/9/9
 */
public class Helper {
    public void handle(int count, char c){
        System.out.printf("handle(%d,%s) BEGIN \n",count,c);
        for (int i = 0;i < count ; i++){
            slowly();
            System.out.print(c);
        }
        System.out.println("");
        System.out.printf("handle(%d,%s) END \n",count,c);
    }

    private void slowly(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
