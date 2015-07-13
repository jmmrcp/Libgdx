package com.mygdx.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class Paddle {

    public static final float SPEED = 400;

    protected Texture texture;
    protected Rectangle bordes;

    public Paddle(float x, float y) {
        texture = new Texture(Gdx.files.internal("pala.png"));
        bordes = new Rectangle(x, y, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, bordes.x, bordes.y, texture.getWidth(), texture.getHeight());
    }

    public abstract void update();

    public Rectangle getBordes() {
        return bordes;
    }
    
     public boolean choqueArriba() {
        return bordes.y + texture.getHeight() >= Gdx.graphics.getHeight();
    }

    public boolean choqueAbajo() {
        return bordes.y <= 0;
    }
}
