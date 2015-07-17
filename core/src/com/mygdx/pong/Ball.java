/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author jose
 */
public class Ball {

    public static final float SPEED = 200;
    private Texture texture;
    private Rectangle bordes;
    private int dirx, diry;
    private float posx, posy;

    public Ball(float x, float y) {
        texture = new Texture(Gdx.files.internal("bola.png"));
        bordes = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
        dirx = diry = 1;
        posx = x;
        posy = y;
    }

    /**
     *
     * @param batch
     */
    public void draw(SpriteBatch batch) {
        batch.draw(texture, bordes.x, bordes.y, texture.getWidth(), texture.getHeight());
    }

    public void update(Paddle LPaddle, Paddle RPaddle) {
        float delta = Gdx.graphics.getDeltaTime();

        if (choqueconParedes()) {
            diry += -1;
        }
        if (choqueconPalas(LPaddle.getBordes(), RPaddle.getBordes())) {
            dirx += -1;
        }

        bordes.x += SPEED * delta * dirx;
        bordes.y += SPEED * delta * diry;
    }

    private boolean choqueconParedes() {
        if (bordes.y + texture.getHeight() >= Gdx.graphics.getHeight()) {
            bordes.y = Gdx.graphics.getHeight() - texture.getHeight();
            return true;
        } else if (bordes.y <= 0) {
            bordes.y = 0;
            return true;
        } else {
            return false;
        }
    }

    private boolean choqueconPalas(Rectangle Lpaddle, Rectangle Rpaddle) {
        if (bordes.overlaps(Lpaddle)) {
            bordes.x = Lpaddle.x + Lpaddle.getWidth();
            return true;
        }
        else if (bordes.overlaps(Rpaddle)) {
            bordes.x = Rpaddle.x - bordes.getWidth();
            return true;
        }
        else return false;
    }
    
    public void comprobarPosicionBolas() {
        if (bordes.x < 0 || bordes.x > Gdx.graphics.getWidth()) {
            bordes.x = posx;
            bordes.y = posy;
        }
    }
    
    public Rectangle getBordes() {
        return bordes;
    }

}
