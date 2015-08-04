/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kilobolt.zbhelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 *
 * @author JoséM
 */
public class AssetLoader {

    /**
     *
     */
    public static Texture texture;
    public static TextureRegion bg,

    /**
     *
     */

    /**
     *
     */
    grass;

    /**
     *
     */
    public static Animation birdAnimation;
    public static TextureRegion bird,

    /**
     *
     */

    /**
     *
     */
    birdDown,

    /**
     *
     */

    /**
     *
     */
    birdUp;

    public static TextureRegion skullUp,

    /**
     *
     */

    /**
     *
     */
    SkullDown,

    /**
     *
     */

    /**
     *
     */
    bar;

    /**
     *
     */
    public static void load() {

        texture = new Texture(Gdx.files.internal("data/texture.png"));
        texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

    }

    /**
     *
     */
    public static void dispose() {
        texture.dispose();
    }

}
