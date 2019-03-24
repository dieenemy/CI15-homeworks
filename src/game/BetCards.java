package game;

import game.renderer.Renderer;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.*;

public class BetCards extends Renderer {
    SingleImageRenderer blueCard;

    public BetCards(){
        blueCard = new SingleImageRenderer(SpriteUtils.loadImage("assets/images/bet-tiles/Bet-Tile-Blue.png"));
    }

    @Override
    public void render(Graphics g, GameObject master) {
        blueCard.render(g,master);
    }
}
