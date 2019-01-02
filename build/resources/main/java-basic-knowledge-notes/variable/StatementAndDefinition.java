public class StatementAndDefinition {
    // Java中const是保留字
    // 使用final声明常量，常量建议全部大写使用下划线分隔单词
    static final int CONST_VARIABLE = 666666;
    
    public static void main(String[] args) {
        System.out.println(CONST_VARIABLE);
        // 合法的表示符以字母，下划线，美元符开头，非开头部分还可以是数字
        // java中标识符是可以用中文的，中文也是字母。只要不是unicode中的特殊字符就可以
        float 浮点数 = 3.14f;
        
        // 声明变量并没有初始化，debug中并没有该变量，即没有分配内存给variable
        int variable;
        // 未初始化就使用会报编译错误
//        System.out.println(variable);
        // 初始化，通过debug发现执行下面的初始化语句才出现变量variable
        variable = 666;
        System.out.println(variable);
        
        // 是否可以作为Java标识符的首字母
        System.out.println(Character.isJavaIdentifierStart('1')); // false
        // 是否可以作为Java标识符的一部分
        System.out.println(Character.isJavaIdentifierPart('1')); // true
        
        // 变量的声明尽量靠近第一次使用的地方
        final double PI = Math.PI;
        System.out.println(PI);
        
        // JAVA中，可以使用null对变量进行初始化，这和声明变量不进行任何初始化是有区别的
        Object obj;
        // 下面代码无法通过编译
//        obj.toString();
        obj = null;
        // 下面代码可以通过编译, 但是会报异常
//        System.out.println(obj.toString());
        
    }
}


