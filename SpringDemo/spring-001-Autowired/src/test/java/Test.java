import com.kc345ws.People;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[]args){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
        People people = (People) classPathXmlApplicationContext.getBean("people");
        System.out.println(people.toString());
    }
}
