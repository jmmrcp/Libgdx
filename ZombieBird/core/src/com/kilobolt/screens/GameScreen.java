/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kilobolt.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.kilobolt.gameworld.GameRenderer;
import com.kilobolt.gameworld.GameWorld;
import com.kilobolt.zbhelpers.InputHandler;

/**
 *
 * @author JoséM
 */
public class GameScreen implements Screen{
    
    private GameWorld world;
    private GameRenderer renderer;
    
    /**
     *
     */
    public GameScreen() {
        Gdx.app.log("GameScreen", "Attached");
        
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = screenHeight / (screenWidth / gameWidth);
        
        int midPointY = (int) (gameHeight / 2);
        
        world = new GameWorld(midPointY);
        renderer = new GameRenderer(world);
        
        Gdx.input.setInputProcessor(new InputHandler(world.getBird()));
    
}

    @Override
    public void show() {
        Gdx.app.log("GameScreen", "Show Called");
    }

    @Override
    public void render(float delta) {
        // Gdx.gl.glClearColor(10/255.0f, 15/255.0f, 230/255.0f, 1f);
        // Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // Gdx.app.log("GameScreen FPS: ", (1/delta) + "");
        
        world.update(delta);
        renderer.render();
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "Resizing");
    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "Pause Called");
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "Resume Called");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "Hide Called");
    }

    @Override
    public void dispose() {
        
    }
    
}
