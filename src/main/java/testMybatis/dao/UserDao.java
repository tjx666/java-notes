package testMybatis.dao;

import org.apache.ibatis.annotations.Select;
import testMybatis.entity.User;

/**
 * @Author: YuTengjing
 * @Date: 2019/1/8
 */
public interface UserDao {
    @Select("select * from user where id=#{id}")
    User getUserById(String id);
}
