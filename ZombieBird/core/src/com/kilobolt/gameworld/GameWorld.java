package com.kilobolt.gameworld;

import com.kilobolt.gameobjects.Bird;
import com.kilobolt.gameobjects.ScrollHandler;

public class GameWorld {

    //private Rectangle rect = new Rectangle(0, 0, 17, 12);
    private Bird bird;
    private ScrollHandler scroller;

    public GameWorld(int midPointY) {

        bird = new Bird(33, midPointY - 5, 17, 12);
        scroller = new ScrollHandler(midPointY + 66);
    }
//    public GameWorld(Bird bird) {
//        this.bird = bird;
//    }
    public void update(float delta) {
        // Gdx.app.log("GameWorld", "Update");
//        rect.x++;
//        if (rect.x > 137) {
//            rect.x = 0;
//        }
        bird.update(delta);
        scroller.update(delta);
    }

//    public Rectangle getRect() {
//        return rect;
//    }
    public Bird getBird() {
        return bird;
    }

    public ScrollHandler getScroller() {
        return scroller;
    }
}
