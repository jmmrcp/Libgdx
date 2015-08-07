package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.uwsoft.editor.renderer.SceneLoader;


public class Essential extends Game {
	private SceneLoader sl;
	
	@Override
	public void create () {
		sl = new SceneLoader();
		sl.loadScene("MainScene");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sl.getEngine().update(Gdx.graphics.getDeltaTime());
	}
}
