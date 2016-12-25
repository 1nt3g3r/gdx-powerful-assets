package ua.com.integer.gdx.powerful.assets.loader.imp;

import com.badlogic.gdx.files.FileHandle;
import ua.com.integer.gdx.powerful.assets.loader.PowAssetLoader;

public class StringLoader implements PowAssetLoader {
    private String encoding = "UTF-8";

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getEncoding() {
        return encoding;
    }

    @Override
    public Object loadAsset(FileHandle fileHandle) {
        return fileHandle.readString(encoding);
    }
}
