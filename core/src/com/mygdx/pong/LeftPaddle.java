package com.mygdx.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class LeftPaddle extends Paddle {
	public static final float SPEED = 100;
	
	public LeftPaddle(float x, float y) {
		super(x, y);
		
	}
	

	@Override
	public void update() {
		if(Gdx.input.isKeyPressed(Keys.W))
			bordes.y += SPEED;
		if(Gdx.input.isKeyPressed(Keys.S))
			bordes.y -= SPEED;
	}
}
