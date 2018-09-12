package chapter11;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author jianweilin
 * @date 2018/9/12
 */
public class TSLog {
    private PrintWriter writer;

    public TSLog(String filename) {
        try{
            writer = new PrintWriter(new FileWriter(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void println(String s){
        writer.println(s);
    }

    public void close(){
        writer.println("===== End of Log =====");
        writer.close();
    }
}
