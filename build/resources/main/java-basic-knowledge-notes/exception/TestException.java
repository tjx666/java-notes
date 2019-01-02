import java.io.*;

/**
 * 异常处理
 * 注意事项:
 * 1. 捕获异常的顺序应该是先捕获子类再捕获父类，因为JAVA中异常处理是捕获到一个异常后就不会被其它catch块捕获
 */


public class TestException {
    public static void main(String[] args) {
        TestException test = new TestException();
        test.fileReaderExample();
        
        String result = test.fileInput();
        System.out.println(result);
// =>     H
//        Start method fileInput
//        Normally execute over
//        Execute finally
//        多次return

        // 只有 try 块无意义，编译不通过
//        try {
//            
//        }

        try {

        } catch (Exception e) {

        }

        try {

        } finally {

        }
    }
    
    void fileReaderExample() {
        String filePath = "D:\\Code\\java\\java-notes\\exception\\test.txt";
        File testFile = new File(filePath);

        FileReader fr = null;
        try {
            fr = new FileReader(testFile);
            System.out.println((char)fr.read());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    
    
    String fileInput() {
        FileInputStream fis = null;
        try {
            System.out.println("Start method fileInput");
            fis = new FileInputStream("D:\\Code\\java\\java-notes\\exception\\test.txt");
            byte[] bs= new byte[2];
            fis.read(bs, 0, 2);
            System.out.println("Normally execute over");
            return new String(bs, 0, 2);
        } catch (FileNotFoundException e) {
            System.out.println("Catch FileNotFoundException");
            e.printStackTrace();
            return "FileNotFoundException";
        } catch (IOException e) {
            System.out.println("Catch IOException");
            e.printStackTrace();
            return "IOException";
        } finally { // finally块一定会被执行，一般建议不要再finally中return。函数正常执行结束会先检查有没有finally块，执行完finally块再函数出栈
            System.out.println("Execute finally");
            return "多次return";
        }
    }
}
