package ua.com.integer.gdx.powerful.assets.loader.imp;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import ua.com.integer.gdx.powerful.assets.loader.PowAssetLoader;

public class TextureAtlasLoader implements PowAssetLoader {
    @Override
    public Object loadAsset(FileHandle fileHandle) {
        return new TextureAtlas(fileHandle);
    }
}