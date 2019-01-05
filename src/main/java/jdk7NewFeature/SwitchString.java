package jdk7NewFeature;

import java.util.Arrays;
import java.util.Scanner;

/**
 * jdk1.7支持在 switch 中使用 字符串
 *
 * @Author: YuTengjing
 * @Date: 2019/1/5
 */
public class SwitchString {
    enum StateCode {
        NOT_FOUND(404, "找不到您要访问的资源"),
        SERVER_DELAY(500, "服务器延迟"),
        ARGUMENTS_TYPE_ERRO(7000, "参数类型有误"),
        FORBIDDEN_ACCESS(400, "禁止访问");

        final private int code;
        final private String message;

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        StateCode(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public static StateCode fromCode(int code) {
            for (StateCode v : StateCode.values()) {
                if (v.getCode() == code) return v;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        // 正常我们使用 switch 的情况
        StateCode notFound = StateCode.fromCode(404);
        switch (notFound) {
            case NOT_FOUND:
                System.out.println("检查你的url");
                break;
            case SERVER_DELAY:
                System.out.println("服务器可能遭受ddos攻击");
                break;
            case FORBIDDEN_ACCESS:
                System.out.println("你是不是干了坏事");
                break;
            case ARGUMENTS_TYPE_ERRO:
                System.out.println("检查你的参数");
        }

        // 测试一下 switch string
        boolean loopFlag = true;
        do {
            System.out.println("输入你猜测的季节:");
            Scanner scan = new Scanner(System.in);
            String seansonYouGuess = scan.nextLine();

            switch (seansonYouGuess) {
                case "春":
                    System.out.println("春风又绿江南岸");
                    break;
                case "夏":
                    System.out.println("夏虫也为我沉默");
                    break;
                case "秋":
                    System.out.println("秋雨梧桐叶落时");
                    break;
                case "冬天":
                    System.out.println("冬霰秋霜春不歇");
                    break;
                default:
                    System.out.println("输入得内容有误");
            }

            System.out.println("继续按任意键，推出输入q");
            String input = scan.nextLine().trim();
            loopFlag = !input.equals("q") && !input.equals("Q");
        } while (loopFlag);
    }
}
