package com.camel;

import com.uwsoft.editor.renderer.Overlap2DStage;

public class GameStage extends Overlap2DStage {

    private PlayerControler player;

    public GameStage() {

        initSceneLoader();

        sceneLoader.loadScene("MainScene");
        addActor(sceneLoader.getRoot());

        player = new PlayerControler(this);
        sceneLoader.getRoot().getCompositeById("player").addScript(player);
    }
}
