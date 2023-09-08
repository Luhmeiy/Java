import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;

public class App {
    public static void main(String[] args) throws Exception {
        User user = new User();

        user.name = "Luhmeiy";
        user.password = "I<3Pizza";

        FileOutputStream fileOut = new FileOutputStream("../UserInfo.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        out.writeObject(user);

        out.close();
        fileOut.close();

        System.err.println("Object info saved!");

        long serialVersionUID = ObjectStreamClass.lookup(user.getClass()).getSerialVersionUID();
        System.out.println(serialVersionUID);
    }
}
