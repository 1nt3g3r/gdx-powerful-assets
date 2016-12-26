package ua.com.integer.gdx.powerful.assets.loader.imp;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;

import ua.com.integer.gdx.powerful.assets.loader.PowAssetLoader;

public class PixmapLoader implements PowAssetLoader {
    @Override
    public Object loadAsset(FileHandle fileHandle) {
        return new Pixmap(fileHandle);
    }
}
