package ua.com.integer.gdx.powerful.assets.loader.imp;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.ObjectMap;

import ua.com.integer.gdx.powerful.assets.PowAssets;
import ua.com.integer.gdx.powerful.assets.loader.PowAssetLoader;

public class SkinLoader implements PowAssetLoader {
    @Override
    public Object loadAsset(FileHandle fileHandle) {
        FileHandle skinDescription = fileHandle.sibling(fileHandle.nameWithoutExtension() + ".sdesc");
        if (skinDescription.exists()) {
            ObjectMap<String, String> paramsMap = JSON.fromJson(ObjectMap.class, skinDescription);
            String atlasName = paramsMap.get("atlas");
            TextureAtlas atlas = PowAssets.access().getAtlas(atlasName);
            return new Skin(fileHandle, atlas);
        } else {
            return new Skin(fileHandle);
        }
    }
}
