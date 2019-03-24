package game.scene;

import dots_and_boxes.Game;
import game.Background;
import game.GameObject;
import game.Player;

public class StageScene1 extends  Scene {
    @Override
    public void init(){
        GameObject.recycle(Background.class);
        GameObject.recycle(Player.class);
    }

    @Override
    public void clear(){
        GameObject.clearAll();
    }
}
