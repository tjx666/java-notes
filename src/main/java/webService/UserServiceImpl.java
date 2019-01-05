package webService;

import javax.jws.WebService;

/**
 * @Author: YuTengjing
 * @Date: 2019/1/5
 */

@WebService
public class UserServiceImpl implements UserService {
    @Override
    public String getUserByName(String name) {
        System.out.println("Request happen!");
        return String.format("{ \"name\": %s, \"age\": 21 }", name);
    }
}
