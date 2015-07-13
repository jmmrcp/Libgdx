package com.mygdx.pong;

import com.badlogic.gdx.Game;

public class Main extends Game   {
	public AbstractScreen gamescreen;
	
	@Override
	public void create () {
            gamescreen = new GameScreen(this);
            setScreen(gamescreen);		
	}
}
