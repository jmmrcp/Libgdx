/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kilobolt.gameworld;

import com.badlogic.gdx.Gdx;
import com.kilobolt.gameobjects.Bird;

/**
 *
 * @author JoséM
 */
public class GameWorld {

    //private Rectangle rect = new Rectangle(0, 0, 17, 12);
    private Bird bird;

    /**
     *
     * @param midPointY
     */
    public GameWorld(int midPointY) {
        bird = new Bird (33,midPointY - 5, 17,12);
    }
    
//    public GameWorld(Bird bird) {
//        this.bird = bird;
//    }

    /**
     *
     * @param delta
     */
    
    public void update(float delta) {
        Gdx.app.log("GameWorld", "Update");
//        rect.x++;
//        if (rect.x > 137) {
//            rect.x = 0;
//        }
        bird.update(delta);
    }
    
//    public Rectangle getRect() {
//        return rect;
//    }

    /**
     *
     * @return
     */
    
    public Bird getBird() {
        return bird;
    }
}
