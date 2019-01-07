package testLogback;

import lombok.extern.slf4j.Slf4j;

/**
 * 参考文章: https://www.cnblogs.com/warking/p/5710303.html
 *
 * @Author: YuTengjing
 * @Date: 2019/1/7
 */
@Slf4j
public class testLogback {
    public static void main(String[] args) {
        log.trace("test trace level!");
        log.debug("test debug level!");
        log.info("test info level!");
        log.warn("test warn level!");
        log.error("test error level!");
    }
}

