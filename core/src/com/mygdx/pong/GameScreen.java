/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author jose
 */
public class GameScreen extends AbstractScreen {
    private SpriteBatch batch;
    private Texture texture;
    private Paddle Lpaddle, Rpaddle;
    private Ball ball;

    public static final int BORDE = 80;

    public GameScreen(Main main) {
        super(main);
    }

    @Override
    public void show() {
        //super.show();
        batch = new SpriteBatch();
        
        texture = new Texture(Gdx.files.internal("pongcampo.png"));
        Lpaddle = new LeftPaddle(BORDE, Gdx.graphics.getHeight()/2);
        Rpaddle = new RightPaddle(Gdx.graphics.getWidth() - BORDE+20, Gdx.graphics.getHeight()/2, ball);
        
        ball = new Ball(Gdx.graphics.getHeight() / 2, Gdx.graphics.getWidth()/2);
    }

    @Override
    public void render(float delta) {
        //super.render(f);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        Lpaddle.update();
        Rpaddle.update();
        ball.update(Lpaddle, Rpaddle);
        
        batch.begin();
        batch.draw(texture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        ball.draw(batch);
        Lpaddle.draw(batch);
        Rpaddle.draw(batch);
        batch.end();
    }    
}
