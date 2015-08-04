/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kilobolt.gameobjects;

import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author JoséM
 */
public class Bird {

    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    private float rotation;
    private int width;
    private int height;

    /**
     *
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Bird(float x, float y, int width, int height) {
        this.width = width;
        this.height = height;
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 400);
    }

    /**
     *
     * @param delta
     */
    public void update(float delta) {
        velocity.add(acceleration.cpy().scl(delta));
        if (velocity.y > 200) {
            velocity.y = 200;
        }
        position.add(velocity.cpy().scl(delta));
    }

    /**
     *
     */
    public void onClick() {
        velocity.y = -140;
    }

    /**
     *
     * @return
     */
    public float getX() {
        return position.x;
    }

    /**
     *
     * @return
     */
    public float getY() {
        return position.y;
    }

    /**
     *
     * @return
     */
    public int getWidth() {
        return width;
    }

    /**
     *
     * @return
     */
    public int getHeight() {
        return height;
    }

    /**
     *
     * @return
     */
    public float getRotation() {
        return rotation;
    }
}
