package com.mygdx.game.managers;

import com.badlogic.gdx.InputAdapter;

import java.util.HashMap;

import static com.mygdx.game.Util.HashMapTranslator.intMassTranslateHashMapToOneString;

public class LoadManager {
    public void loadObjsFromFile(String stringFromFile, HashMap<Integer, String> objMap){ //получает строку считанную из файла и ссылку на Hashmap
        stringFromFile = stringFromFile.replace("{","");// удаление кавычек
        stringFromFile =  stringFromFile.replace("}","");
        stringFromFile =  stringFromFile.replace(" ","");
        String[] supStrings = stringFromFile.split(","); // разбиваем на блоки ключ-значение
        String[] supStrings2;
        for(String s : supStrings){
            supStrings2 = s.split("=");
            objMap.put(Integer.parseInt(supStrings2[0]), supStrings2[1]);
        }
    }

    public void loadSceneTransfersFromFile(String stringFromFile, HashMap<Integer, Integer[]> sceneTransfersList){
        stringFromFile = stringFromFile.replace("{","");// удаление кавычек
        stringFromFile =  stringFromFile.replace("}","");
        stringFromFile =  stringFromFile.replace(" ","");
        String[] supStrings = stringFromFile.split(","); // разбиваем на блоки ключ-значение
        String[] supStrings2;
        Integer id;
        Integer[] transfers;
        for(String s1 : supStrings) {
            transfers = new Integer[5];
            supStrings2 = s1.split("=");
            id = Integer.parseInt(supStrings2[0]);
            supStrings2 = supStrings2[1].split("&");
            for(int i = 0; i < 5; i++){
                transfers[i] = Integer.parseInt(supStrings2[i]);
            }
            sceneTransfersList.put(id, transfers);
        }
    }
}
