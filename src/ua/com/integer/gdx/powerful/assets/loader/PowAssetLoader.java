package ua.com.integer.gdx.powerful.assets.loader;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;

public interface PowAssetLoader {
    Json JSON = new Json();
    Object loadAsset(FileHandle fileHandle);
}
