import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class 打印Test {
    //注使用try--catch--finally解决异常，我范懒啦，使用使用了throws；
    @Test
    public void test() throws IOException {

        //创建Map集合
        Map<Character, Integer> map = new HashMap<>();
        //创建流编辑器
        FileReader fol =  new FileReader("Test.txt");
        //遍历每个字节出现的次数，并放到map当中，注需要一个一个遍历不可一次遍历多个；
        int c;
        while((c = fol.read()) != -1){
          char ch = (char) c;
          if (map.get(ch) == null){
              map.put(ch,1);
          }else {
              map.put(ch, map.get(ch) + 1);
          }
        }

         //把map中的数据存到Writer.txt
        BufferedWriter reader = new BufferedWriter(new FileWriter("Writer.txt"));
        //遍历map，再写入数据
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry:entries){
            switch(entry.getKey()){
                case ' ':
                    reader.write("空格" +entry.getValue());
                    break;
                case '\t':
                    reader.write("tab键" +entry.getValue());
                    break;

                case '\r':
                    reader.write("回车" +entry.getValue());
                    break;

                case '\n':
                    reader.write("换行" +entry.getValue());
                    break;
                default:
                    reader.write(entry.getKey()+"="+entry.getValue());
                    break;
            }
            //换行操作
            reader.newLine();




            //关闭流
        }
        if (reader != null) {

            reader.close();
        }
        if (fol != null)
            fol.close();
    }



}
