package lt.vilniuscoding.paskaita2;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Kestas on 2016-05-10.
 */
public class Aplinka {

    private JFrame frame;

    Aplinka(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame = createFrame();
                frame.getContentPane().add(createContent());
                show();
            }
        });
    }

    private JFrame createFrame() {
        JFrame frame = new JFrame(getClass().getName());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        return frame;
    }

    private void show() {
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    protected Component createContent() {
        final Image image = requestImage();

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        };
        panel.setPreferredSize(new Dimension(500, 500));
        return panel;
    }

    protected Image requestImage() {
        Image image = null;

        try {
            image = ImageIO.read(new URL("https://scontent-waw1-1.xx.fbcdn.net/v/t1.0-9/13062345_1029101143805430_6168553800038757705_n.jpg?oh=25549884e336c68dc6c66f5420b8ab48&oe=57A969BC"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

}
