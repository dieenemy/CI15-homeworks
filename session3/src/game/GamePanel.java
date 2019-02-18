package game;

import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    Background background;
    BufferedImage backgroundImage;
    BufferedImage playerImage;
    Vector2D backgroundPosition;
    Vector2D playerPosition;
    BufferedImage bulletImage;
//    Vector2D bulletPositions;
    ArrayList <Vector2D> bulletPositions;
    int fireCount;

    public GamePanel(){
        background = new Background();
        playerPosition = new Vector2D(200,500);
        playerImage = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        bulletImage = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
        bulletPositions = new ArrayList<>();
        fireCount = 0;
//      bulletPositions.add()  them phan tu vao trong mang
//      bulletPositions.get() lay ra phan tu o vi tri cu the



    }

    @Override
    public void paint(Graphics g) {
        background.render(g);

        // ve anh

        g.drawImage(
                playerImage,
                (int)playerPosition.x,
                (int)playerPosition.y,
                null);
        for(int i = 0 ; i < bulletPositions.size(); i++){
            Vector2D bulletPosition = bulletPositions.get(i);
            g.drawImage(
                    bulletImage,
                    (int)bulletPosition.x,
                    (int) bulletPosition.y,
                    null
            );
        }
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
        background.run();
        playerRun();
        bulletsRun();

    }

    private void bulletsRun() {
        for (int i = 0; i < bulletPositions.size(); i++){
            Vector2D bulletPosition = bulletPositions.get(i);
            bulletPosition.y -= 3;
        }
    }

    private void playerRun() {
        playerMove();
        playerLimit();
        playerFire();
        if (GameWindow.isUpPress && playerPosition.y > 0) {
            playerPosition.y--;
    }
        if (GameWindow.isDownPress && playerPosition.y < 600 - 48) {
            playerPosition.y++;
    }
        if (GameWindow.isLeftPress && playerPosition.x > 0) {
            playerPosition.x--;
    }
        if (GameWindow.isRightPress && playerPosition.x < 384 - 32) {
            playerPosition.x++;
    }
    }

    private void playerFire() {
        fireCount++;
        if(GameWindow.isFirePress && fireCount > 20){
            Vector2D bulletPosition = new Vector2D(playerPosition.x, playerPosition.y);
            bulletPositions.add(bulletPosition);
            fireCount = 0;
        }
    }

    private void playerLimit() {
//
    }

    private void playerMove() {

    }


    }

