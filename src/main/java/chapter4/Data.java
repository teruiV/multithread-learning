package chapter4;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author jianweilin
 * @date 2018/9/2
 */
public class Data {
    private final String filename;
    private String content;
    private boolean changed;

    public Data(String filename, String content) {
        this.filename = filename;
        this.content = content;
        this.changed = true;
    }

    public synchronized void change(String newContent){
        this.content = newContent;
        this.changed = true;
    }

    public synchronized void save() throws IOException {
        if(!this.changed){
            return;
        }
        doSave();
        this.changed = false;
    }

    private void doSave() throws IOException {
        System.out.println(String.format("threadName: %s, calls doSave content is : %s",Thread.currentThread().getName(),content));
        Writer writer = new FileWriter(filename,true);
        writer.write(content);
        writer.close();
    }
}
