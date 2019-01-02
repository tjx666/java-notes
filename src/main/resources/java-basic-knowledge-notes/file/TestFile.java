import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * JAVA中的File类提供的API类似于python中的os.path和node中的path
 * 提供了访问文件信息的获取和操作，没有对文件内容的操作
 */


public class TestFile {
    public static void main(String[] args) {
        File testFile = new File("D:\\Code/java\\java-notes/file\\test-file.txt");
        File hiddenFile = new File("D:\\Code\\java\\java-notes\\file\\.hidden");
        
        // 不会报异常的API
        // 文件名
        System.out.println(testFile.getName()); // test.txt
        // 获取文件大小
        System.out.println(testFile.length()); // 13
        // 检查文件是否存在
        System.out.println(testFile.exists()); // true
        // 上次修改时间
        System.out.println(new Date(testFile.lastModified())); // Sun Dec 09 12:11:30 CST 2018
        
        //检查文件读写执行权限
        System.out.println(testFile.canRead()); // true
        System.out.println(testFile.canWrite()); // true
        // 检查java应用是否可以执行该文件，不需要这个文件有执行权限
        System.out.println(testFile.canExecute()); // true

        // 检查文件类型
        System.out.println(testFile.isFile()); // true
        System.out.println(testFile.isDirectory()); // false
        // unix系统以.开始的文件被视为隐藏文件, windows上不会
        System.out.println(testFile.isHidden()); // false
        System.out.println(hiddenFile.isHidden()); // false
        
        // 检查磁盘空间
        final int G = 1024 * 1024 * 1024;
        // 磁盘分区空间
        System.out.println(testFile.getTotalSpace() / G);
        // 未分配的空间
        System.out.println(testFile.getUsableSpace() / G);
        // 可以被虚拟机使用的空间
        System.out.println(testFile.getFreeSpace() / G );

        // 获取File对象中处理过路径分隔符的路径
        File relativePath = new File("../Date");
        System.out.println(relativePath.getPath()); // ..\Date
       // 获取绝对路径, 可以看到路径分隔符被修改成了对应平台的分隔符
        System.out.println(testFile.getAbsolutePath()); // D:\Code\java\java-notes\file\test-file.txt
        // 获取父路径
        System.out.println(testFile.getParent()); // D:\Code\java\java-notes\file
        
        // 设置
        // 设置修改时间
        System.out.println(testFile.setLastModified(new GregorianCalendar(2019, 1, 27).getTimeInMillis())); // true
        // 设置只读
        System.out.println(testFile.setReadOnly()); // true
//        System.out.println(testFile.setReadable(false));
//        System.out.println(testFile.setWritable(true));
        
        
        // 需要处理异常的api
        String fileName = "D:\\Code\\java\\java-notes\\file\\createdFile.md";
        File createdFile = new File(fileName);
        try {
            // 返回true表示创建成功, 仅当文件不存在创建一个指定的空文件
            System.out.println(testFile.createNewFile()); // false
            System.out.println(createdFile.createNewFile()); // true
            
            // 正常使用时应该先检查文件是否存在
            if (createdFile.exists()) System.out.println(createdFile.delete()); // true
            System.out.println(createdFile.createNewFile()); // true
            
            // 获取文件夹下面所有文件名
            File dir = new File("D:\\Code\\java\\java-notes\\file");
            String[] fileNames = dir.list();
            for (String name : fileNames) {
                System.out.print(name + " "); // .hidden createdFile.md test-file.txt TestFile.java 
            }
            
            // 获取文件夹下面所有文件
            File[] files = dir.listFiles();
            for (File file : files) {
                System.out.println(file.getPath());
            }
//            D:\Code\java\java-notes\file\createdFile.md
//            D:\Code\java\java-notes\file\test-file.txt
//            D:\Code\java\java-notes\file\TestFile.java

            System.out.println(testFile.list()); // null
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
