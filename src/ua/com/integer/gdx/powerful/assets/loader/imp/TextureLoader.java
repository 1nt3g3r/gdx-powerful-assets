package ua.com.integer.gdx.powerful.assets.loader.imp;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import ua.com.integer.gdx.powerful.assets.loader.PowAssetLoader;

public class TextureLoader implements PowAssetLoader {
    private Texture.TextureFilter minFilter = Texture.TextureFilter.Linear;
    private Texture.TextureFilter magFilter = Texture.TextureFilter.Linear;

    @Override
    public Object loadAsset(FileHandle fileHandle) {
        Texture result = new Texture(fileHandle);
        result.setFilter(minFilter, magFilter);
        return result;
    }
}
