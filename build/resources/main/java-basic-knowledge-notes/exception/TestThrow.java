import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 通过在函数后面添加throws块抛出异常，就可以不用在函数中处理异常了，而是将错误抛给调用该函数的函数
 * 可以使用throw手动抛出异常
 */


public class TestThrow {
    public static void main(String[] args) throws Exception{
        TestThrow tt = new TestThrow();
        tt.mayThrowExceptionMethod(); // Hello thank you, thank you very much...
    }
    
    void mayThrowExceptionMethod() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("D:\\Code\\java\\java-notes\\exception\\test.txt");
        StringBuilder sb = new StringBuilder(1024);
        int codePoint = fr.read();
        while (codePoint != -1) {
            sb.appendCodePoint(codePoint);
            codePoint = fr.read();
        }
        System.out.println(sb.toString());
    }
    
    void testManuallyThrowException() {
        File file = new File("D:\\Code\\java\\java-notes\\exception\\test.txt");
        if (!file.exists()) try {
            throw new FileNotFoundException("找不到文件");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
