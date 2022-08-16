import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWTListenerEx {
    public static void main(String[] args) {
        Frame screen = new Frame();
        screen.addWindowListener((WindowClosing)(e)->System.exit(1));
        Button button = new Button("Press me !!");
        screen.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Welcome to java by vuong","java sample",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        screen.setSize(250,400);
        screen.isVisible();
    }
}
