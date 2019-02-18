import game.GamePanel;
import game.GameWindow;
import game.Vector2D;
import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

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
//        window.setSize(800, 600);
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GamePanel panel = new GamePanel();
        panel.setPreferredSize(new Dimension(800,600));
        panel.setBackground(Color.CYAN);
        window.add(panel);
        window.pack();
        window.setVisible(true);

        panel.gameLoop();
//
//        // bien
//        // ham
//        // if/else switch/case
//        // for while
//        // try/catch
//
//        try {
//            divide(10,0);
//        } catch (Exception exception){
////            System.out.println(exception.getMessage());
//            exception.printStackTrace();
//        }
//        System.out.println("Hello");
//    }
//
//    private static int divide(int x, int y) {
//        return x / y;
//        ArrayList<Vector2D> vectors = new ArrayList<>();
//        vectors.add(new Vector2D(1,4));
//        vectors.add(new Vector2D(3,4));
//        vectors.add(new Vector2D(5,6));
//        vectors.add(new Vector2D(1,4));
//        double max = 0;
//        int maxIndex = 0;

//        Vector2D v1 = new Vector2D(1, 1);
//        Vector2D v2 = new Vector2D(2, 2);
//        vectors.add(v1);
//        vectors.add(v2);

//        for (int i = 0; i < vectors.size(); i++){
//            Vector2D vector = vectors.get(i);
//            if(vector.x + vector.y > max){
//                max = vector.x + vector.y;
//                maxIndex = i;
//            }
//
//            Vector2D vectorMax = vectors.get(maxIndex);
//            System.out.println(vectorMax.x + " " + vectorMax.y);
//        }
    }
}
