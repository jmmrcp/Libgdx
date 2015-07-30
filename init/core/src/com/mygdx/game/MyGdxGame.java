package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class MyGdxGame extends ApplicationAdapter {

    SpriteBatch batch;
    FPSLogger fpsLogger;
    OrthographicCamera camera;
    Texture background;
    TextureRegion terrainBelow;
    TextureRegion terrainAbove;
    float terrainOffset;
    Animation plane;
    float planeAnimTime;
    Vector2 planeVelocity = new Vector2();
    Vector2 planePosition = new Vector2();
    Vector2 planeDefaultPosition = new Vector2();
    Vector2 gravity = new Vector2();
    private static final Vector2 damping = new Vector2(0.99f, 0.99f);

    @Override
    public void create() {
        fpsLogger = new FPSLogger();
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        background = new Texture("background.png");
        terrainBelow = new TextureRegion(new Texture("groundGrass.png"));
        terrainAbove = new TextureRegion(terrainBelow);
        terrainAbove.flip(true, true);
        plane = new Animation(0.05f, new TextureRegion(new Texture("planeRed1.png")),
                new TextureRegion(new Texture("planeRed2.png")),
                new TextureRegion(new Texture("planeRed3.png")),
                new TextureRegion(new Texture("planeRed2.png")));
        plane.setPlayMode(PlayMode.LOOP);
        resetScene();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        fpsLogger.log();
        updateScene();
        drawScene();
    }

    private void resetScene() {
        terrainOffset = 0;
        planeAnimTime = 0;
        planeVelocity.set(400, 0);
        gravity.set(0, 0);
        planeDefaultPosition.set(400 - 88 / 2, 240 - 73 / 2);
        planePosition.set(planeDefaultPosition.x,
                planeDefaultPosition.y);
    }

    private void updateScene() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        planeAnimTime += deltaTime;
        planeVelocity.scl(damping);
        planeVelocity.add(gravity);
        planePosition.mulAdd(planeVelocity, deltaTime);
        terrainOffset -= planePosition.x - planeDefaultPosition.x;
        planePosition.x = planeDefaultPosition.x;
        if (terrainOffset * -1 > terrainBelow.getRegionWidth()) {
            terrainOffset = 0;
            if (terrainOffset > 0) {
                terrainOffset = -terrainBelow.getRegionWidth();
            }
        }
    }

    private void drawScene() {
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.disableBlending();
        batch.draw(background, 0, 0);
        batch.enableBlending();
        batch.draw(terrainBelow, terrainOffset, 0);
        batch.draw(terrainBelow, terrainOffset
                + terrainBelow.getRegionWidth(), 0);
        batch.draw(terrainAbove, terrainOffset, 480
                - terrainAbove.getRegionHeight());
        batch.draw(terrainAbove, terrainOffset
                + terrainAbove.getRegionWidth(), 480
                - terrainAbove.getRegionHeight());
        batch.draw(plane.getKeyFrame(planeAnimTime), planePosition.x,
                planePosition.y);
        batch.end();
    }
}
