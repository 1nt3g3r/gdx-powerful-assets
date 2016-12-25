package ua.com.integer.gdx.powerful.assets.loader.imp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import ua.com.integer.gdx.powerful.assets.loader.PowAssetLoader;

public class SoundLoader implements PowAssetLoader {
    @Override
    public Object loadAsset(FileHandle fileHandle) {
        return Gdx.audio.newSound(fileHandle);
    }
}
