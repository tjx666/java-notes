public class TestStringBuffer {
    public static void main(String[] args) {
        // StringBuffer和StringBuilder差不多，StringBuffer类的成员方法前面多了一个关键字：synchronized
        // API测试参考StringBuilder
        StringBuffer strBuffer = new StringBuffer("hello");
        System.out.println(strBuffer.toString());
        
        StringBuffer sbf = new StringBuffer(256);
        for (int i = 0; i < 256; ++i) {
            sbf.append((char)i);
        }
        System.out.println(sbf);
        /* =>
         	
 !"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\]^_`abcdefghijklmnopqrstuvwxyz{|}~
         */
    }
}
