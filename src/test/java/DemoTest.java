import org.fkit.hrm.dao.UserDao;
import org.fkit.hrm.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DemoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testConnect() {
        if (userDao != null) {
            String user = "admin";
            String password = "123456";
            User user1 = userDao.selectByLoginnameAndPassword(user, password);
            if (user1 != null)
                System.out.println("成功");
            else
                System.out.println("失败");
        } else {
            System.out.println("重新");
        }
    }
}
