package chapter9;

/**
 * @author jianweilin
 * @date 2018/9/10
 */
public class RealData implements Data{
    private final String content;

    public RealData(int count,char c){
        System.out.printf("making realData(%d,%s)BEGIN\n",count,c);
        char[] buffer = new char[count];
        for(int i = 0; i < count; i++){
            buffer[i] = c;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("making realData(%d,%s)END\n",count,c);
        this.content = new String(buffer);
    }

    @Override
    public String getContent() {
        return content;
    }
}
