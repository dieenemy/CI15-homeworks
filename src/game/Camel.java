package game;

import dots_and_boxes.Game;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import game.renderer.SingleImageRenderer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Camel extends GameObject {
    public Camel(){
        BufferedImage image = SpriteUtils.loadImage("assets/images/camels/Camel-Blue-1-0.png");
        this.renderer = new SingleImageRenderer(image);
        this.position.set(Settings.GAME_WIDTH , Settings.GAME_HEIGHT);
        this.position.set(0, 0);
        this.anchor.set(0,0);
    }


}