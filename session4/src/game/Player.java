package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player {
    BufferedImage image;
    Vector2D position;
    ArrayList<PlayerBullet> bullets;
    int fireCount;
    BufferedImage bulletType2Image;
    BufferedImage bulletType3Image;

    public Player() {
        image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        position = new Vector2D(200, 500);
//        bulletImage = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
//        bulletPositions = new ArrayList<>();
        bullets = new ArrayList<>();
        fireCount = 0;
        bulletType2Image = SpriteUtils.loadImage("assets/images/enemies/bullets/green.png");
        bulletType3Image = SpriteUtils.loadImage("assets/images/player-bullets/a/52459024_242087486572982_3015378839237820416_n.png");
    }

    public void render(Graphics g) {
        g.drawImage(
                image,
                (int) position.x,
                (int) position.y,
                null
        );
//        for(int i = 0; i < bulletPositions.size(); i++) {
//            Vector2D bulletPosition = bulletPositions.get(i);
//            g.drawImage(
//                    bulletImage,
//                    (int) bulletPosition.x,
//                    (int) bulletPosition.y,
//                    null
//            );
//        }
        for (int i = 0; i < bullets.size(); i++) {
            PlayerBullet bullet = bullets.get(i);
            bullet.render(g);
        }
    }

    private void bulletsRun() {
//        for(int i = 0; i < bulletPositions.size(); i++) {
//            Vector2D bulletPosition = bulletPositions.get(i);
//            bulletPosition.y -= 3;
//        }
        for (int i = 0; i < bullets.size(); i++) {
            PlayerBullet bullet = bullets.get(i);
            bullet.run();
        }
    }

    public void run() {
        playerMove();
        playerLimit();
        playerFire();
        bulletsRun();
    }

    private void playerFire() {
        fireCount++;
        if(GameWindow.isSpecialPress && fireCount>20)
        {
            PlayerBullet bullet = new PlayerBullet();
            bullet.image = bulletType3Image;
            bullet.position.set(this.position.x,this.position.y);
            bullet.velocity.setAngle(-Math.PI * 0.5);
            bullets.add(bullet);
            fireCount = 0;
        }
        if(GameWindow.isFirePress && fireCount > 20) {
//            Vector2D bulletPosition = new Vector2D(position.x, position.y);
//            bulletPositions.add(bulletPosition);
            PlayerBullet bullet = new PlayerBullet();
            bullet.position.set(this.position.x, this.position.y);
            bullet.velocity.setAngle(-Math.PI * 0.5);
            bullets.add(bullet);

            PlayerBullet bullet2 = new PlayerBullet();
            bullet2.image = bulletType2Image;
            bullet2.position.set(this.position.x, this.position.y);
            bullet2.velocity.setAngle(-Math.PI * 0.4);
            bullets.add(bullet2);

            PlayerBullet bullet3 = new PlayerBullet();
            bullet3.image = bulletType2Image;
            bullet3.position.set(this.position.x, this.position.y);
            bullet3.velocity.setAngle(-Math.PI * 0.6);
            bullets.add(bullet3);

            PlayerBullet bullet4 = new PlayerBullet();
            bullet4.image = bulletType2Image;
            bullet4.position.set(this.position.x,this.position.y);
            bullet4.velocity.setAngle(-Math.PI * 0.75 );
            bullets.add(bullet4);

            PlayerBullet bullet5 = new PlayerBullet();
            bullet5.image = bulletType2Image;
            bullet5.position.set(this.position.x,this.position.y);
            bullet5.velocity.setAngle(-Math.PI * 0.3 );
            bullets.add(bullet5);

            fireCount = 0;
        }
    }

    private void playerLimit() {
        if(position.x < 0) { // limit player
            position.x = 0;
        }
        if(position.x > 384 - 32) {
            position.x = 384 - 32;
        }
        if(position.y < 0) {
            position.y = 0;
        }
        if(position.y > 600 - 48) {
            position.y = 600 - 48;
        }
    }

    private void playerMove() {
        if(GameWindow.isUpPress) { // player move
            position.y--;
        }
        if(GameWindow.isRightPress) {
            position.x++;
        }
        if(GameWindow.isDownPress) {
            position.y++;
        }
        if(GameWindow.isLeftPress) {
            position.x--;
        }
    }
}
