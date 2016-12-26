package ua.com.integer.gdx.powerful.assets;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.I18NBundle;
import com.badlogic.gdx.utils.Json;

import ua.com.integer.gdx.powerful.assets.loader.imp.I18NLoader;

public class AssetsAccess {
    private static Json json = new Json();
    private static Localize localize;
    private static Settings sets;


    static void init(String settingsName) {
        sets = new Settings(settingsName);
        localize = new Localize();
    }

    public Texture getTexture(String name) {
        return PowAssets.getAsset(name, Texture.class);
    }

    public void unloadTexture(String name) {
        PowAssets.unloadAsset(name, Texture.class);
    }

    public AtlasRegion getRegion(String atlas, String region) {
        return getAtlas(atlas).findRegion(region);
    }

    public TextureAtlas getAtlas(String name) {
        return PowAssets.getAsset(name, TextureAtlas.class);
    }

    public void unloadAtlas(String name) {
        PowAssets.unloadAsset(name, TextureAtlas.class);
    }

    public Sound getSound(String name) {
        return PowAssets.getAsset(name, Sound.class);
    }

    public void unloadSound(String name) {
        PowAssets.unloadAsset(name, Sound.class);
    }

    public Music getMusic(String name) {
        return PowAssets.getAsset(name, Music.class);
    }

    public void unloadMusic(String name) {
        PowAssets.unloadAsset(name, Music.class);
    }

    public <T extends Object> T getJsonConfig(String name, Class configClass) {
        String jsonString = PowAssets.getAsset(name, String.class);
        return (T) json.fromJson(configClass, jsonString);
    }

    public void unloadJsonConfig(String name) {
        PowAssets.unloadAsset(name, String.class);
    }

    public BitmapFont getFont(String name) {
        return PowAssets.getAsset(name, BitmapFont.class);
    }

    public void unloadFont(String name) {
        PowAssets.unloadAsset(name, BitmapFont.class);
    }

    public I18NBundle getI18NBundle(String name, String locale) {
        PowAssets.unloadAsset(name, I18NBundle.class);
        I18NLoader loader = (I18NLoader) PowAssets.getAssetLoader(I18NBundle.class);
        loader.setLocale(locale);
        return PowAssets.getAsset(name, I18NBundle.class);
    }

    public void unloadI18NBundle(String name) {
        PowAssets.unloadAsset(name, I18NBundle.class);
    }

    public Skin getSkin(String name) {
        return PowAssets.getAsset(name, Skin.class);
    }

    public void unloadSkin(String name) {
        PowAssets.unloadAsset(name, Skin.class);
    }

    public Pixmap getPixmap(String name) {
        return PowAssets.getAsset(name, Pixmap.class);
    }

    public void unloadPixmap(String name) {
        PowAssets.unloadAsset(name, Pixmap.class);
    }

    public Localize localize() {
        return localize;
    }

    public Settings sets() {
        return sets;
    }
}
