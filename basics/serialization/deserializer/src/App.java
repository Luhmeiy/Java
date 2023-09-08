import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

public class App {
    public static void main(String[] args) throws Exception {
        User user = null;

        FileInputStream fileIn = new FileInputStream("../UserInfo.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);

        user = (User) in.readObject();
        user.sayHello();

        in.close();
        fileIn.close();

        System.out.println(user.name);
        System.out.println(user.password);

        long serialVersionUID = ObjectStreamClass.lookup(user.getClass()).getSerialVersionUID();
        System.out.println(serialVersionUID);
    }
}
