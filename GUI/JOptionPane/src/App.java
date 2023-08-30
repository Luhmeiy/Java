import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        // JOptionPane.showMessageDialog(null, "This is some info", "title",
        // JOptionPane.PLAIN_MESSAGE);
        // JOptionPane.showMessageDialog(null, "Here is more info", "title",
        // JOptionPane.INFORMATION_MESSAGE);
        // JOptionPane.showMessageDialog(null, "Really?", "title",
        // JOptionPane.QUESTION_MESSAGE);
        // JOptionPane.showMessageDialog(null, "Your computer has been infected!",
        // "title", JOptionPane.WARNING_MESSAGE);
        // JOptionPane.showMessageDialog(null, "Call tech support NOW!!!", "title",
        // JOptionPane.ERROR_MESSAGE);

        // System.out.println(
        // JOptionPane.showConfirmDialog(null, "Do you even code?", "Title",
        // JOptionPane.YES_NO_CANCEL_OPTION));

        // String name = JOptionPane.showInputDialog("What is your name? ");
        // System.out.println("Hello " + name);

        String[] responses = { "No, you're awesome!", "Thank you!", "*blush*" };

        JOptionPane.showOptionDialog(null,
                "You are awesome",
                "secret message",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                responses,
                0);
    }
}
