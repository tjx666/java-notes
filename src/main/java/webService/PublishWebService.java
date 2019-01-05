package webService;

import javax.xml.ws.Endpoint;

/**
 * @Author: YuTengjing
 * @Date: 2019/1/5
 */
public class PublishWebService {
    public static void main(String[] args) {
        final String PUBLISH_ADDRESS = "http://localhost:9001/webService/users";
        Endpoint.publish(PUBLISH_ADDRESS, new UserServiceImpl());
        System.out.println("Service is on " + PUBLISH_ADDRESS);
    }
}
