package game;

import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {
    BufferedImage backgroundImage;
    BufferedImage playerImage;
    int backgroundX;
    int backgroundY;
    int playerX;
    int playerY;

    public GamePanel(){
        backgroundImage = SpriteUtils.loadImage("assets/images/background/0.png");
        playerImage = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        backgroundX = 0;
        backgroundY = 600 - 3109;
        playerX = 200;
        playerY = 500;

    }

    @Override
    public void paint(Graphics g) {


        // ve anh
        g.drawImage(backgroundImage, backgroundX, backgroundY, null);
        g.drawImage(playerImage, playerX, playerY,null);
    }

    public  void gameLoop(){
        long lastTime = 0;
        long delay = 1000 / 60;
        while(true){
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastTime >= delay){
                // ve anh + chay logic
                runAll(); // chay tat ca trong game
                renderAll(); // ve tat ca
                lastTime = currentTime;
            }
        }
    }


    private void renderAll() {
        repaint();
    }


    private void runAll() {
        if (backgroundY < 0) {
            backgroundY += 1;
        }

        if (GameWindow.isUpPress && playerY > 0) {
            playerY--;
        }
        if (GameWindow.isDownPress && playerY < 500) {
            playerY++;
        }
        if (GameWindow.isLeftPress && playerX > 0) {
            playerX--;
        }
        if (GameWindow.isRightPress && playerX < 350) {
            playerX++;
        }


    }
}
