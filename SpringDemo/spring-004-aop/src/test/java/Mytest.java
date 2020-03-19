import com.kc345ws.service.UserService;
import com.kc345ws.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    public static void main(String[]args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userserviceimpl = (UserService) applicationContext.getBean("userserviceimpl");
        userserviceimpl.add();
        userserviceimpl.update();
        userserviceimpl.select();
        userserviceimpl.delete();
    }
}
