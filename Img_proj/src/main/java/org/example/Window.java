package org.example;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private static Window window;
    private static final JLayeredPane layeredPane = new JLayeredPane();
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 800;
    private static String filename = "C:\\Users\\idan\\IdeaProjects\\Img_proj\\src\\main\\java\\org\\example\\photos\\bape.JPG";

    public Window() {
        Window.window = this;
        this.setSize(WIDTH,HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        layeredPane.setBounds(0, 0, WIDTH, HEIGHT);
        this.add(layeredPane);
        addWorkSpace();
        this.setTitle("image prosses");
        setVisible(true);
    }

    public static void addWorkSpace()
    {
        ImageWorkSpace imageWorkSpace = new ImageWorkSpace(filename);
        imageWorkSpace.setBounds(0, 0, WIDTH, HEIGHT);
        layeredPane.add(imageWorkSpace,JLayeredPane.DEFAULT_LAYER);
        imageWorkSpace.repaint();

    }
}
