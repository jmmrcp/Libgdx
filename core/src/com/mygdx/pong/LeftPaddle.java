package com.mygdx.pong;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class LeftPaddle extends Paddle {

    /**
     *
     */
    public LeftPaddle(float x, float y) {
        super(x, y);
    }

    @Override
    public void update() {

        float delta = Gdx.graphics.getDeltaTime();

        if (Gdx.app.getType() == ApplicationType.Desktop) {
            inputDesktop(delta);
        } else {
            inputAndroid(delta);
        }
    }

    private void inputDesktop(float delta) {

        if (Gdx.input.isKeyPressed(Keys.W)) {
            if (choqueArriba()) {
                bordes.y = Gdx.graphics.getHeight() - texture.getHeight();
            } else {
                bordes.y += SPEED * delta;
            }
        }

        if (Gdx.input.isKeyPressed(Keys.S)) {
            if (choqueAbajo()) {
                bordes.y = 0;
            } else {
                bordes.y -= SPEED * delta;
            }
        }

    }

    private void inputAndroid(float delta) {
        float coordenadaPaddle = bordes.y + texture.getHeight() / 2;

        if (Gdx.input.isTouched()) {
            float coordenadaY = Gdx.graphics.getHeight() - Gdx.input.getY();
            if (coordenadaPaddle >= coordenadaY - 5 && coordenadaPaddle <= coordenadaY + 5) {
                coordenadaY = coordenadaPaddle;
            }

            if (coordenadaY < coordenadaPaddle) {
                if (choqueAbajo()) {
                    bordes.y = 0;
                } else {
                    bordes.y -= SPEED * delta;
                }
            }

            if (coordenadaY > coordenadaPaddle) {
                if (choqueArriba()) {
                    bordes.y = Gdx.graphics.getHeight() - texture.getHeight();
                } else {
                    bordes.y += SPEED * delta;
                }
            }
        }
    }

   
}
