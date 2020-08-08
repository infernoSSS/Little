package com.mygdx.game.SceneMaker.SceneMakerElements;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.mygdx.game.SceneMaker.SceneMakerElements.SceneMakerElement;
import com.mygdx.game.SceneMaker.SceneMakerObj.buttons.ApplySceneButton;
import com.mygdx.game.SceneMaker.SceneMakerObj.buttons.SceneMakerButton;
import com.mygdx.game.SceneMaker.SceneMakerObj.texture.UnUseTexture;
import com.mygdx.game.managers.GameManager;
import com.mygdx.game.managers.SceneManager;
import com.mygdx.game.scenes.SceneMakerScene;

import java.util.ArrayList;
import java.util.HashMap;

public class SceneSettingsSheet implements SceneMakerElement {
    private  GameManager gameManager;
    private SceneMakerScene sceneMakerScene;
    private boolean sceneIsCreated;
    private ArrayList<SceneMakerElement> elements;
    private Vector3 position;
    private HashMap<String, TextField> textFields;
    private ArrayList<SceneMakerButton> buttons;
    private Skin skin;
    private Stage stage;

    public void create(SceneMakerScene sceneMakerScene, GameManager gameManager, SceneManager sceneManager){
        this.gameManager = gameManager;
        this.sceneMakerScene = sceneMakerScene;
        sceneIsCreated = false;
        stage = sceneMakerScene.getStage();
        position = new Vector3(270, 590, 0);
        elements = new ArrayList<>();
        elements.add(new UnUseTexture(gameManager, position.x, position.y, "sceneSettingsSheet"));
        for (SceneMakerElement element : elements) {
            element.create(sceneMakerScene, gameManager, sceneManager);
        }
        textFields = new HashMap<>();
        skin = gameManager.getSkin();
        textFields.put("sceneChoose", new TextField("write scene Id or new", skin));
        textFields.put("audioChoose", new TextField("audio", skin));
        textFields.put("transfersChoose", new TextField("0, 0, 0, 0, 0", skin));

        calibrateTextFields(textFields);
        for(TextField fild : textFields.values()){
            stage.addActor(fild);
        }

        buttons = new ArrayList<>();
        buttons.add(new ApplySceneButton(this, gameManager, position.x+60, position.y+10, "apply"));

        for (SceneMakerButton button : buttons) {
            button.create(sceneMakerScene, gameManager, sceneManager);
        }
    }

    public void update(){
        for (SceneMakerButton button : buttons) {
            button.update();
        }
    }

    public void draw(SpriteBatch spriteBatch){
        for(SceneMakerElement element : elements){
            element.draw(spriteBatch);
        }
        for(TextField fild : textFields.values()){
            fild.draw(spriteBatch, 1);
        }
        for (SceneMakerButton button : buttons) {
            button.draw(spriteBatch);
        }
    }

    private void calibrateTextFields(HashMap<String, TextField> hashMap){
        hashMap.get("sceneChoose").setPosition(position.x+10, position.y+50);
        hashMap.get("sceneChoose").setSize(180,40);

        hashMap.get("audioChoose").setPosition(position.x+465, position.y+145);
        hashMap.get("audioChoose").setSize(180,30);

        hashMap.get("transfersChoose").setPosition(position.x+465, position.y+105);
        hashMap.get("transfersChoose").setSize(180,30);
    }

    public void sceneIsCreated(){
        sceneIsCreated = true;
    }

    public void sceneIsDeleted(){
        sceneIsCreated = false;
    }

    public void dispose(){

    }

    public SceneMakerScene getSceneMakerScene() {
        return sceneMakerScene;
    }

    public HashMap<String, TextField> getTextFields() {
        return textFields;
    }
}
