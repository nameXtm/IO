package FileTest;

import org.junit.Test;

import java.io.*;

public class CopyFileStraem {
    public void copy(String i , String j) {
        FileInputStream stream = null;
        FileOutputStream stream1 = null;
        try {
            File file = new File(i);
            File file1 = new File(j);

            stream = new FileInputStream(file);
            stream1 = new FileOutputStream(file1);

            byte[] byte1 = new byte[1024];
            int dex;
            while( (dex=stream.read(byte1)) != -1){
                stream1.write(byte1,0,dex);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(stream!=null)
            if(stream!=null)
            try {
                stream.close();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    stream1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    @Test
    public void Test1(){
        long l = System.currentTimeMillis();
        String i = "C:\\Users\\肖提莫\\OneDrive\\桌面\\01.jpg";
        String j = "C:\\Users\\肖提莫\\OneDrive\\桌面\\02.jpg";
        copy(i,j);
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);

    }

}
