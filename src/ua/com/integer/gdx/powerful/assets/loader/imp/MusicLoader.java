package ua.com.integer.gdx.powerful.assets.loader.imp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import ua.com.integer.gdx.powerful.assets.loader.PowAssetLoader;

public class MusicLoader implements PowAssetLoader {
    @Override
    public Object loadAsset(FileHandle fileHandle) {
        return Gdx.audio.newMusic(fileHandle);
    }
}
