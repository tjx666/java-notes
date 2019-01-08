package testMybatis.dao;

import testMybatis.entity.User;

/**
 * @Author: YuTengjing
 * @Date: 2019/1/8
 */
public interface UserMapper {
    User getUserById(String id);
}
