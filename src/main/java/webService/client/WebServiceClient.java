package webService.client;

/**
 * @Author: YuTengjing
 * @Date: 2019/1/5
 */
public class WebServiceClient {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImplService().getUserServiceImplPort();
        System.out.println(userService.getUserByName("lyr"));
    }
}
