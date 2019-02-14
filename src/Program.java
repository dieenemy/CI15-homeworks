import game.GamePanel;
import game.GameWindow;
import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by huynq on 7/4/17.
 */
public class Program {
    public double[] equation2(double a, double b, double c) {
        double[] result = new double[2];
        if(a == 0) {
            if(b == 0) {
                result = null;
            } else {
                result[0] = -c / b;
                result[1] = -c / b;
            }
        } else {
            double delta = b * b - (4 * a * c);
            if(delta < 0) {
                result = null;
            } else {
                result[0] = (-b - Math.sqrt(delta)) / 2 / a;
                result[1] = (-b + Math.sqrt(delta)) / 2 / a;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        GameWindow window = new GameWindow();
        window.setSize(800, 600);
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GamePanel panel = new GamePanel();
        panel.setBackground(Color.CYAN);
        window.add(panel);

        window.setVisible(true);

        panel.gameLoop();

        // bien
        // ham
        // if/else switch/case
        // for while
        // try/catch

        try {
            divide(10,0);
        } catch (Exception exception){
//            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
        System.out.println("Hello");
    }

    private static int divide(int x, int y) {
        return x / y;
    }
}
