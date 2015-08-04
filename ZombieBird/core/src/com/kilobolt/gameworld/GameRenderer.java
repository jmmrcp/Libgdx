/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kilobolt.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 *
 * @author JoséM
 */
public class GameRenderer {
    
    private GameWorld myWorld;
    private OrthographicCamera cam;
//    private ShapeRenderer shapeRenderer;

    /**
     *
     * @param world
     */
    public GameRenderer(GameWorld world) {
        myWorld = world;
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 136, 204);
//        shapeRenderer = new ShapeRenderer();
//        shapeRenderer.setProjectionMatrix(cam.combined);
    }

    /**
     *
     */
    public void render() {
        Gdx.app.log("GameRenderer", "Render");
        Gdx.gl.glClearColor(10/255.0f, 15/255.0f, 230/255.0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // Gdx.app.log("GameScreen FPS: ", (1/delta) + "");
        
//        shapeRenderer.begin(ShapeType.Filled);
//        shapeRenderer.setColor(87/255.0f, 109/255.0f, 120/255.0f, 1.0f);
//        shapeRenderer.rect(myWorld.getRect().x, myWorld.getRect().y, myWorld.getRect().width, myWorld.getRect().height);
//        shapeRenderer.end();
//        
//        shapeRenderer.begin(ShapeType.Line);
//        shapeRenderer.setColor(255/255.0f, 109/255.0f, 120/255.0f, 1.0f);
//        shapeRenderer.rect(myWorld.getRect().x, myWorld.getRect().y, myWorld.getRect().width, myWorld.getRect().height);
//        shapeRenderer.end();
    }
}
