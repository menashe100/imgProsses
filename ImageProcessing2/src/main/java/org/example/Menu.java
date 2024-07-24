package org.example;
import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {
    private Scene scene;
    private boolean didHePickPicture;
    private final int border = 2;
    private final int ButtenHight = Window.HEIGHT/10-4*border;

    public Menu (Scene scene) {
        this.scene=scene;
        didHePickPicture=false;
        this.setBounds(0, 0, 100, 600);
        this.setBackground(Color.RED);

    }
    public  void PickedPicture(){
        didHePickPicture=true;
        JButton graysacle = new JButton("graysacle");
        graysacle.setBounds(5,0,90,ButtenHight);
        graysacle.addActionListener(e -> {
            scene.GrayScale();

        });
        this.add(graysacle);
        repaint();

    }
    public  void PickedPicture2(){
        didHePickPicture=true;
        JButton blackToWhite = new JButton("From black to white");
        blackToWhite.setBounds(5,ButtenHight+border,90,ButtenHight);
        blackToWhite.addActionListener(e -> {
            scene.BlackToWhite();
        });
        this.add(blackToWhite);
        repaint();

    }
    public  void PickedPicture3(){
        didHePickPicture=true;
        JButton ElminiteRed = new JButton("ElminiteRed");
        ElminiteRed.setBounds(5,2*ButtenHight+
                2*border,90,ButtenHight);
        ElminiteRed.addActionListener(e -> {
            scene.ElminiteRed();


        });
        this.add(ElminiteRed);
        repaint();



    }
    public  void PickedPicture4(){
        didHePickPicture=true;
        JButton Postorize = new JButton("show border");
        Postorize.setBounds(5,3*ButtenHight+3*border,90,ButtenHight);
        Postorize.addActionListener(e -> {
            scene.showBorders();


        });
        this.add(Postorize);
        repaint();



    }
    public  void PickedPicture5(){
        didHePickPicture=true;
        JButton Negetive = new JButton("Negetive");
        Negetive.setBounds(5,4*ButtenHight+4*border,90,ButtenHight);
        Negetive.addActionListener(e -> {
            scene.Negetive();


        });
        this.add(Negetive);
        repaint();



    }
    public  void PickedPicture6(){
        didHePickPicture=true;
        JButton Postorize = new JButton("Postorize");
        Postorize.setBounds(5,5*ButtenHight+5*border,90,ButtenHight);
        Postorize.addActionListener(e -> {
            scene.Postorize();


        });
        this.add(Postorize);
        repaint();



    }
    public  void PickedPicture7(){
        didHePickPicture=true;
        JButton Postorize = new JButton("ColorShiftRight");
        Postorize.setBounds(5,6*ButtenHight+6*border,90,ButtenHight);
        Postorize.addActionListener(e -> {
            scene.colorShiftRight();


        });
        this.add(Postorize);
        repaint();

    }
    public  void PickedPicture8(){
        didHePickPicture=true;
        JButton ColorShiftLeft = new JButton("ColorShiftLeft");
        ColorShiftLeft.setBounds(5,7*ButtenHight+7*border,90,ButtenHight);
        ColorShiftLeft.addActionListener(e -> {
            scene.colorShiftLeft();


        });
        this.add(ColorShiftLeft);
        repaint();

    }
    public  void PickedPicture9(){
        didHePickPicture=true;
        JButton Postorize = new JButton("Ligher");
        Postorize.setBounds(5,8*ButtenHight+8*border,90,ButtenHight);
        Postorize.addActionListener(e -> {
            scene.Ligher();


        });
        this.add(Postorize);
        repaint();

    }
    public  void PickedPicture10(){
        didHePickPicture=true;
        JButton Postorize = new JButton("darker");
        Postorize.setBounds(5,9*ButtenHight+9*border,90,ButtenHight);
        Postorize.addActionListener(e -> {
            scene.Darker();
        });
        this.add(Postorize);
        repaint();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(!didHePickPicture) {

            // הגדרת צבע הטקסט
            g.setColor(Color.BLACK);
            // הגדרת הפונט של הטקסט
            g.setFont(new Font("Arial", Font.BOLD, 15));
            // כתיבת הטקסט על הפאנל
            g.drawString("בבקשה,", 0, 200);
            g.drawString("בחר תמונה", 0, 300);
        }

    }
}

