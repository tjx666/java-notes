package jdk7NewFeature;

import java.io.*;

/**
 * jdk7新增语法 try with resource 即所谓的 twr语法
 *
 * @Author: YuTengjing
 * @Date: 2019/1/5
 */
public class TryWithResource {
    public static void main(String[] args) {
        /*
         * try ()中其实可以定义多个资源对象
         *
         * 查看包下的反编译后的内容，可以发现 twr 只是编译器的黑魔法，并不需要jvm添加新支持
         * javac 自动帮我们添加了 try catch finally 代码
         */
        try (
                FileReader fr = new FileReader(new File(TryWithResource.class.getResource("/testFiles/input.txt").getFile()));
                BufferedReader br = new BufferedReader(fr);
        ) {
            String line;
            while ((line = br.readLine()) != null) System.out.println(line);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            // 通过getSuppressed获取当处理资源和关闭资源同时抛异常时被抑制的关闭资源的异常
            System.out.println(e.getSuppressed());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
