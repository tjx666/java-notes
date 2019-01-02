package staticImport;

import static java.lang.Math.*;

/*
 * JDK1.5 新特性之静态导入
 *
 * 参考文章: https://blog.csdn.net/xyz_fly/article/details/8178104?spm=5176.100034.1.11.b95b654fVKp9KY
 * @Author: YuTengjing
 * @Date: 2019/1/2 22:57
 */

/**
 * @Author: YuTengjing
 * @Date: 2019/1/2
 */
public class StaticImport {
    public static void main(String[] args) {
        // 先来看一个例子
        // 现在需要获取一个1~20之间的随机整数
        int r = (int)Math.floor(Math.random() * 20 + 1.0);

        // 使用静态导入的话, floor 和 random 还是比较特殊的，冲突问题不是很大
        r = (int)floor(random() * 20 + 1.0);


    }
}
