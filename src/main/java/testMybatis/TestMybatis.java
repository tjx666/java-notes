package testMybatis;

import org.apache.ibatis.session.SqlSession;
import testMybatis.dao.UserDao;
import testMybatis.dao.UserMapper;
import testMybatis.entity.User;

/**
 * 其实我觉得mybatis配置还是挺繁琐的
 * @Author: YuTengjing
 * @Date: 2019/1/8
 */
public class TestMybatis {
    private static SqlSession sqlSession = MybatisUtil.getSqlSession();


    public static void main(String[] args) {
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        System.out.println(userDao.getUserById("201626204040"));
        MybatisUtil.closeSqlSession();
    }

    private static void testPureXmlAccess() {
        String statementID = "testMybatis.entity.User.getUserById";
        User user = sqlSession.selectOne(statementID, "201626204040");
        System.out.println(user);
    }

    private static  void testByInterface() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById("201626204040");
        System.out.println(user);
    }
}
