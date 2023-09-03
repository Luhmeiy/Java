import javax.swing.JFrame;

public class MyFrame extends JFrame {
    DragPanel dragPanel;

    MyFrame() {
        this.setTitle("Drag & Drop Demo");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        dragPanel = new DragPanel();

        this.add(dragPanel);
        this.setVisible(true);
    }
}
