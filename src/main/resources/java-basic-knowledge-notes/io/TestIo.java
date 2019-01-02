import java.io.*;
import java.nio.charset.Charset;

/**
 * IO
 */

public class TestIo {
    public static void main(String[] args) throws Exception {
        /* 
         * 使用用缓冲流读取文件
         * private char cb[] chunkBuffer
         * 默认缓冲区大小8192字节
         */
        BufferedReader br = new BufferedReader(new FileReader("./resource/io/a.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();

        /*
         * 使用缓冲流写文件 
         */
        BufferedWriter bw = new BufferedWriter(new FileWriter("./resource/io/b.txt", Charset.forName("GB18030")));
        bw.write("测试缓冲输出流");
        // 不刷新的化可能有些数据留在缓冲区中
        bw.flush();
        bw.close();

        // 字节流, 生成字节文件
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("./resource/io/testDataStream"));
        dos.writeInt(1234567);
        dos.close();
    }
}
