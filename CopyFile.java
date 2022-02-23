package FileTest;

import org.junit.Test;

import java.io.*;

public class CopyFile {
    public void test1(String reader1, String writer1) {
        //1,遍历File
        FileReader reader = null;
        FileWriter writer = null;
        try {
            File file = new File(reader1);
            File file1 = new File(writer1);
            //2,
            reader = new FileReader(file);
            writer = new FileWriter(file1);
            //3
            char[] dach = new char[1024];
            int path;
            while ((path = reader.read(dach)) != -1) {
                writer.write(dach, 0, path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4,释放内存
            if (writer != null)
                if (reader != null)


                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            writer.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

        }

    }

    @Test
    public void Test2() {
        long l = System.currentTimeMillis();
        String i = "Test.txt";
        String j = "Test1.txt";
        test1(i, j);
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);

    }
}