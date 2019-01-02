/**
 * 学习Java String 类
 */


public class TestString {
    public static void main(String[] args) {
        // 字符串字面量 "Hello world"
        System.out.println("Hello world"); // Hello world
        
        // 构造器
        System.out.println(new String());
        
        
        
        String str = "Less is more";
        // == 在JAVA中比较的内存地址，debug发现str和sameStr中的value内存地址相同
        System.out.println(str == "Less is more"); // true
        String sameStr = "Less is more";
        
        
        // Java中string无法通过下标访问，可以用charAt
//        System.out.println(str[0]);
        System.out.println(str.charAt(0)); // L
        
        
        // 使用length获取字符串长度，这个长度表示的是字符串有多少个16位的unicode字符，也叫代码单元
        System.out.println("😱".length()); // 2
        // 使用String.codePointCount获取码点数, 码点就是实际字符的码值
        String sexWords = "I❤Y";
        System.out.println(sexWords.codePointCount(0, sexWords.length())); // 3
        // 获取第i个码点：先获取第i个码点的下标，再获取下标对应的码点
        final int index = sexWords.offsetByCodePoints(0,2);
        int codePoint = sexWords.codePointAt(index);
        System.out.println(codePoint); // 89
        
        
        //**************************String的一些API, 参数大多数都是下标**********************//
        String testString = "Yu😘Tengjing is cool!";
        
        // chatAt 返回下标对应字符, 码点和下标(索引)都是从0开始计算
        System.out.println(testString.charAt(1)); // u
        // codePointAt 返回下标对应的码点
        System.out.println(testString.codePointAt(2)); // 128536, 大于双字节最大数65535
        // offsetByCodePoints(int index, int codePointOffset) 计算从index开始，第codePointOffset个码点的下标
        System.out.println(testString.offsetByCodePoints(0, 3)); // 4
        
        // codePoints 正真的遍历字符串的方法
        int[] cpArray = testString.codePoints().toArray();
        for (int i = 0; i < cpArray.length; ++i) {
            System.out.printf("%s, ", new String(new int[]{cpArray[i]}, 0, 1));
        }
        System.out.println();
        // => Y, u, 😘, T, e, n, g, j, i, n, g,  , i, s,  , c, o, o, l, !,
        
        
        // 字符串相等如何判断？
        // 按字典顺序一个一个字符比较两个字符串 还有一个IgnoreCase版本的
        System.out.println(testString.compareTo("Yu😘Tengjing")); // 9
        System.out.println(testString.compareTo("Yu😘Tengjing is cool!~~~~")); // -4
        System.out.println(testString.compareTo("Yu😘Tengjing is cool!")); // 0
        // equal 判断两个字符串是否内容相等得常用方法，返回值为booleanl类型, 也有一个ignoreCase版本
        // 下面两种写法有点区别 后者更省事
        if (testString != null && testString.equals("Yu😘Tengjing is cool!")) System.out.println("内容相等"); // 内容相等 
        if ("Yu😘Tengjing is cool!".equals(testString)) System.out.println("内容相等"); // 内容相等
        System.out.println("ABC".equals("abc")); // false
        System.out.println("ABC".equalsIgnoreCase("abc")); // true
        
        // ES6 String 的API和java有点像哈, startsWith, endsWidth
        System.out.println(testString.startsWith("Yu")); // true
        System.out.println(testString.endsWith("cool")); // false
        
        
        // 如何在字符串中搜索一个元素？
        // 搜索一个子串， 返回第一个匹配的子串的下标
        System.out.println(testString.indexOf("😘"));; // 2
        System.out.println(testString.indexOf("💥")); // -1
        // 从某个下标开始搜索，提高搜索速度
        System.out.println(testString.indexOf("😘", 1)); // 还是2
        // 根据码值来搜索，也可以再传一个表示搜索的起始位置的参数
        System.out.println(testString.indexOf((int)'!')); // 20
        // 查看是否包含某个字符串
        System.out.println(testString.contains("😘")); // true
        
        // 反向搜索，返回最后一个匹配的下标，也有带起始位置和搜索码点版本
        System.out.println("ABC A".lastIndexOf("A")); // 4
        
        
        // 返回字符串长度
        System.out.println(testString.length());
        // 返回码点数
        System.out.println(testString.codePointCount(0, testString.length())); // 20
        
        
        // 操作字符串, 由于java中字符串是不可变的，所有对字符串的操作基本上都会返回一个新字符串
        // 替换(所有的) replace(CharSequence target, CharSequence replacement)
        System.out.println(testString.replace("cool", "very cool")); // Yu😘Tengjing is very cool!
        
        // 截取子串, endIndex是被截取的最后一个字符的下标+1， String substring(int beginIndex, int endIndex)
        System.out.println(testString.substring(4)); // Tengjing is cool!
        System.out.println(testString.substring(2, 4)); // 😘
        
        // 大小写转换
        System.out.println(testString.toLowerCase());
        System.out.println(testString.toUpperCase());
        // => 
//        yu😘tengjing is cool!
//        YU😘TENGJING IS COOL!
        
        // 去除两头的空白符
        System.out.println("\n abc\tdef\n\n".trim());
        
        // 拼接
        System.out.println(String.join(" => ", "😂", "🍕", "🎇", "🚀")); // 😂 => 🍕 => 🎇 => 🚀
        System.out.println("Hello".concat(" world"));
        
        // 其它
        // 判断是否为空串
        System.out.println(testString.isEmpty()); // false
        // 判断是否是空串或者只包含空白符
        System.out.println(testString.isBlank());
        // 重复count次
        System.out.println("223 ".repeat(5)); // 223 223 223 223 223
    }
}
