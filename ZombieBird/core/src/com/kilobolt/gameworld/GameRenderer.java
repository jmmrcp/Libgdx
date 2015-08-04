/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kilobolt.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.kilobolt.gameobjects.Bird;
import com.kilobolt.zbhelpers.AssetLoader;

/**
 *
 * @author JoséM
 */
public class GameRenderer {
    
    private GameWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    
    private SpriteBatch batch;
    
    private int midPointY;
    private int gameHeight;
    
    private Bird bird;
    
    private TextureRegion bg, grass;
    private Animation birdAnimation;
    private TextureRegion skullUp,skullDown, bar;
    private TextureRegion birdMid, birdUp, birdDown;
    

    /**
     *
     * @param world
     * @param gameHeight
     * @param midPointY
     */
    //public GameRenderer(GameWorld world) {
    public GameRenderer(GameWorld world, int gameHeight, int midPointY) {
        myWorld = world;
        
        this.gameHeight = gameHeight;
        this.midPointY = midPointY;
        
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 136, gameHeight);
        
        batch = new SpriteBatch();
        batch.setProjectionMatrix(cam.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
        
        initGameObject();
        initAssets();
    }

    /**
     *
     * @param runTime
     */
    public void render(float runTime) {
        Gdx.app.log("GameRenderer", "Render");
        
        Bird bird = myWorld.getBird();
        
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
        
        shapeRenderer.begin(ShapeType.Filled);
        // BackGround
        shapeRenderer.setColor(55/255.0f, 80/255.0f, 100/255.0f, 1.0f);
        shapeRenderer.rect(0, 0, 136, midPointY + 66);
        // Grass
        shapeRenderer.setColor(111/255.0f, 186/255.0f, 45/255.0f, 1.0f);
        shapeRenderer.rect(0, midPointY + 66, 136, 11);
        // Dirt
        shapeRenderer.setColor(147/255.0f, 80/255.0f, 27/255.0f, 1.0f);
        shapeRenderer.rect(0, midPointY + 77, 136, 52);
        
        shapeRenderer.end();
        
        batch.begin();
        batch.disableBlending();
        batch.draw(AssetLoader.bg,0, midPointY + 23, 136, 43);
        
        batch.enableBlending();
        
        if (bird.shouldntFlap()) {
            batch.draw(birdMid, bird.getX(), bird.getY(), 
                    bird.getWidth() / 2.0f, bird.getHeight() / 2.0f,
                    bird.getWidth(), bird.getHeight(), 1, 1, bird.getRotation());
        } else {
            batch.draw(birdAnimation.getKeyFrame(runTime), bird.getX(), bird.getY(), 
                    bird.getWidth() / 2.0f, bird.getHeight() / 2.0f,
                    bird.getWidth(), bird.getHeight(), 1, 1, bird.getRotation());
        }
        batch.end();
        
    }
    private void initGameObject() {
        bird = myWorld.getBird();
    }
    
    private void initAssets() {
        bg = AssetLoader.bg;
        grass = AssetLoader.grass;
        birdAnimation = AssetLoader.birdAnimation;
        birdMid = AssetLoader.bird;
        birdDown = AssetLoader.birdDown;
        birdUp = AssetLoader.birdUp;
        skullUp = AssetLoader.skullUp;
        skullDown = AssetLoader.skullDown;
        bar = AssetLoader.bar;
    }
}
