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
import com.kilobolt.gameobjects.Grass;
import com.kilobolt.gameobjects.Pipe;
import com.kilobolt.gameobjects.ScrollHandler;
import com.kilobolt.zbhelpers.AssetLoader;

public class GameRenderer {

    protected OrthographicCamera cam;
    protected int gameHeight;
    protected Bird bird;
    protected ScrollHandler scroller;
    protected TextureRegion birdMid, birdUp, birdDown;
    private GameWorld myWorld;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch batch;
    private int midPointY;
    private Grass frontGrass, backGrass;
    private Pipe pipe1, pipe2, pipe3;
    private TextureRegion bg, grass;
    private Animation birdAnimation;
    private TextureRegion skullUp,skullDown, bar;

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
        batch.draw(bg, 0, midPointY + 23, 136, 43);

        drawGrass();

        drawPipes();
        batch.enableBlending();

        drawSkulls();

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
        scroller = myWorld.getScroller();
        frontGrass = scroller.getFrontGrass();
        backGrass = scroller.getBackGrass();
        pipe1 = scroller.getPipe1();
        pipe2 = scroller.getPipe2();
        pipe3 = scroller.getPipe3();
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

    private void drawGrass() {
        batch.draw(grass, frontGrass.getX(), frontGrass.getY(), frontGrass.getWidth(), frontGrass.getHeight());
        batch.draw(grass, backGrass.getX(), backGrass.getY(), backGrass.getWidth(), backGrass.getHeight());
    }

    private void drawSkulls() {
        batch.draw(skullUp, pipe1.getX() - 1, pipe1.getY() + pipe1.getWidth() - 14, 24, 14);
        batch.draw(skullUp, pipe2.getX() - 1, pipe2.getY() + pipe2.getWidth() - 14, 24, 14);
        batch.draw(skullUp, pipe3.getX() - 1, pipe3.getY() + pipe3.getWidth() - 14, 24, 14);

        batch.draw(skullDown, pipe1.getX() - 1, pipe1.getY() + pipe1.getWidth() + 45, 24, 14);
        batch.draw(skullDown, pipe2.getX() - 1, pipe2.getY() + pipe2.getWidth() + 45, 24, 14);
        batch.draw(skullDown, pipe3.getX() - 1, pipe3.getY() + pipe3.getWidth() + 45, 24, 14);
    }

    private void drawPipes() {
        batch.draw(bar, pipe1.getX(), pipe1.getY(), pipe1.getWidth(), pipe1.getHeight());
        batch.draw(bar, pipe2.getX(), pipe2.getY(), pipe2.getWidth(), pipe2.getHeight());
        batch.draw(bar, pipe3.getX(), pipe3.getY(), pipe3.getWidth(), pipe3.getHeight());

        batch.draw(bar, pipe1.getX(), pipe1.getY() + pipe1.getHeight() + 45, pipe1.getWidth(), midPointY + 66 - (pipe1.getHeight() + 45));
        batch.draw(bar, pipe2.getX(), pipe2.getY() + pipe2.getHeight() + 45, pipe2.getWidth(), midPointY + 66 - (pipe2.getHeight() + 45));
        batch.draw(bar, pipe3.getX(), pipe3.getY() + pipe3.getHeight() + 45, pipe3.getWidth(), midPointY + 66 - (pipe3.getHeight() + 45));
    }
}
