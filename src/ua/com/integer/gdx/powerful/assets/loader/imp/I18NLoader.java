package ua.com.integer.gdx.powerful.assets.loader.imp;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.I18NBundle;
import ua.com.integer.gdx.powerful.assets.loader.PowAssetLoader;

import java.util.Locale;

public class I18NLoader implements PowAssetLoader {
    private String locale;

    public void setLocale(String language) {
        this.locale = language;
    }

    public String getLocale() {
        return locale;
    }

    @Override
    public Object loadAsset(FileHandle fileHandle) {
        return I18NBundle.createBundle(fileHandle.parent().child(fileHandle.nameWithoutExtension()), new Locale(locale));
    }
}
