/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.pong;

import com.badlogic.gdx.Gdx;

/**
 *
 * @author jose
 */
public class RightPaddle extends Paddle {
    private Ball ball;

    public RightPaddle(float x, float y, Ball bola) {
        super(x, y);
        ball = bola;
    }

    @Override
    public void update() {
        float delta = Gdx.graphics.getDeltaTime();
        float corP = bordes.y + texture.getHeight() / 2;
        float corB = ball.getBordes().y + ball.getBordes().getHeight() / 2;
        
        if (corP > corB - 10 && corP <= corB +10)
            corB = corP;
        
        if (corB < corP) {
            if (choqueAbajo())
                bordes.y = 0;
            else
                bordes.y = bordes.y - SPEED * delta;
        }
        
        if (corB > corP) {
            if (choqueArriba())
                bordes.y = Gdx.graphics.getHeight() - texture.getHeight();
            else
                bordes.y = bordes.y + SPEED * delta;
        }
    }
    
    
    
}
