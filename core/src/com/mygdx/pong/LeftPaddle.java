package com.mygdx.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class LeftPaddle extends Paddle {

    /**
     *
     */
    public static final float SPEED = 400;
	
	public LeftPaddle(float x, float y) {
		super(x, y);	
	}
	
	@Override
	public void update() {

		float delta = Gdx.graphics.getDeltaTime();

		if(Gdx.input.isKeyPressed(Keys.W)) {
			if (choqueArriba()) 
				bordes.y = Gdx.graphics.getHeight() - texture.getHeight();
			else
				bordes.y += SPEED * delta; 
		}

		if(Gdx.input.isKeyPressed(Keys.S)) {
			if (choqueAbajo())
				bordes.y = 0;
			else 
				bordes.y -= SPEED * delta;
		}
	}

	public boolean choqueArriba() {
		return bordes.y + texture.getHeight() >= Gdx.graphics.getHeight();
	}

	public boolean choqueAbajo() {
		return bordes.y <= 0;
	}
}
