package testDesktop;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * jdk1.6 新增Desktop, SystemTray两个很实用的类，这里只测试Desktop类，gui相关的目前都不是重点
 * 可以方便地调用操作系统打开浏览器，发送邮件，打开或编辑文件，打印文件
 *
 * @Author: YuTengjing
 * @Date: 2019/1/4
 */
public class TestDesktop {
    public static void main(String[] args) throws IOException, URISyntaxException {
//        openBrowser();
//        openFile();
        editFile();
    }

    /**
     * 测试使用浏览器打开uri
     */
    private static void openBrowser() throws URISyntaxException, IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(new URI("http://lyreal666.com"));
    }

    /**
     * 打开文件
     */
    private static void openFile() throws IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File("C:\\Users\\YuTengjing\\Downloads\\Compressed\\apache-maven-3.6.0-bin.zip"));
    }

    /**
     * 编辑文件
     */
    private static void editFile() throws IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.edit(new File("C:\\Users\\YuTengjing\\Documents\\School\\SubjectProject\\oop\\9月19日修改2018面向对象课程设计--（分组情况及项目内容）.xlsx"));
    }
}
