package com.mygdx.game.managers;

import static com.mygdx.game.Util.fileSupport.takeStringFromFile;

public class SaveManager {
    private String lastSaveFileName;
    private int lastSceneId;
    private int numbOfStartScene;
    private int lastSaveSceneId;

    public SaveManager(){
        lastSaveFileName = "resurs/saves/lastSave.txt";
        loadLastSave(lastSaveFileName);
    }

    private void loadLastSave(String lastSaveFileName){
        String stringFromFile = takeStringFromFile(lastSaveFileName);
        String[] valuesFromFile = stringFromFile.split(",");
        stringFromFile.replace(" ", "");
        lastSceneId = Integer.parseInt(valuesFromFile[0]);
        lastSaveSceneId = Integer.parseInt(valuesFromFile[1]);
    }

    public int getNumbOfStartScene(){
        return 1;
    }//номер и метод нужно заменить так чтобы подгружалась последняя сохранённая сцена

    public int getLastSceneId() {
        return lastSceneId;
    }

    public int getLastSaveSceneId() {
        return lastSaveSceneId;
    }
}
