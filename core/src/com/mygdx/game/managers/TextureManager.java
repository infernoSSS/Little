package com.mygdx.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;

public class TextureManager {
    public TextureAtlas createTextureAtlas(){      //создаём атлас текстур
        if(Gdx.files.local("resurs/packedImages/packed.png").exists()){ //если есть, то обновляем старое
            Gdx.files.local("resurs/packedImages/packed.png").delete();
        }
        if(Gdx.files.local("resurs/packedImages/packed.atlas").exists()){
            Gdx.files.local("resurs/packedImages/packed.atlas").delete();
        }
        TexturePacker.process("resurs/images", "resurs/packedImages", "packed");
        return new TextureAtlas(Gdx.files.local("resurs/packedImages/packed.atlas"));
    }
}
