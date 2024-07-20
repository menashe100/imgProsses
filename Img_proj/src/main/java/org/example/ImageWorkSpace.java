package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageWorkSpace extends JPanel {
    private BufferedImage orignalImage;
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 800;
    public ImageWorkSpace(String filename)
    {
        try {
            this.orignalImage= ImageIO.read(new File(filename));
            System.out.println("dasda");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("das2da");
        setLayout(new BorderLayout());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("das1da");
        if(this.orignalImage!=null) {
            System.out.println("das3da");
            g.drawImage(this.orignalImage, 0, 0, WIDTH, HEIGHT, this);
        }
    }
}
