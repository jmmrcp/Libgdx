package com.mygdx.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author jose
 */

 public class GameScreenRescalado extends AbstractScreen {
 	private SpriteBatch batch;
 	private Texture texture;
 	private float scala;

 	public GameScreenRescalado (Main main) {
 		super(main);
 	} 
 	@Overrride
 	public void show() {
 		batch = new SpriteBatch();
 		texture = new Texture(Gdx.files.internal("pongcampo.png"));
 		}

 	@Overrride
 	public void render (float delta) {
 		Gdx.gl.glClearColor(0, 0, 0, 1);
 		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

 		batch.begin();
 		batch.draw(texture, 0, 0, texture.getWidth() / escala, texture.getHeight() / escala);
 		batch.end();
 	}

 	@Overrride
 	public void resize (int width, int height) {
 		float widhtImagen = new texture.getWidth();
 		float heightImagen = new texture.getHeight();
 		float r = heightImagen / widhtImagen;

 		if (heightImagen > height) {
 			heightImagen = height;
 			widhtImagen = heightImagen / r;
 		}

 		if (widhtImagen > width) {
 			widhtImagen = width;
 			heightImagen = widhtImagen * r;
 		}

 		escala = width / widhtImagen;
 	}
 }