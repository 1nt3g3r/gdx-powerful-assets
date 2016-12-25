package ua.com.integer.gdx.powerful.assets;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
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

    public static Texture getTexture(String name) {
        return PowAssets.getAsset(name, Texture.class);
    }

    public static void unloadTexture(String name) {
        PowAssets.unloadAsset(name, Texture.class);
    }

    public static AtlasRegion getRegion(String atlas, String region) {
        return getAtlas(atlas).findRegion(region);
    }

    public static TextureAtlas getAtlas(String name) {
        return PowAssets.getAsset(name, TextureAtlas.class);
    }

    public static void unloadAtlas(String name) {
        PowAssets.unloadAsset(name, TextureAtlas.class);
    }

    public static Sound getSound(String name) {
        return PowAssets.getAsset(name, Sound.class);
    }

    public static void unloadSound(String name) {
        PowAssets.unloadAsset(name, Sound.class);
    }

    public static Music getMusic(String name) {
        return PowAssets.getAsset(name, Music.class);
    }

    public static void unloadMusic(String name) {
        PowAssets.unloadAsset(name, Music.class);
    }

    public static <T extends Object> T getJsonConfig(String name, Class configClass) {
        String jsonString = PowAssets.getAsset(name, String.class);
        return (T) json.fromJson(configClass, jsonString);
    }

    public static void unloadJsonConfig(String name) {
        PowAssets.unloadAsset(name, String.class);
    }

    public static BitmapFont getFont(String name) {
        return PowAssets.getAsset(name, BitmapFont.class);
    }

    public static void unloadFont(String name) {
        PowAssets.unloadAsset(name, BitmapFont.class);
    }

    public static I18NBundle getI18NBundle(String name, String locale) {
        PowAssets.unloadAsset(name, I18NBundle.class);
        I18NLoader loader = (I18NLoader) PowAssets.getAssetLoader(I18NBundle.class);
        loader.setLocale(locale);
        return PowAssets.getAsset(name, I18NBundle.class);
    }

    public static void unloadI18NBundle(String name) {
        PowAssets.unloadAsset(name, I18NBundle.class);
    }

    public static Localize localize() {
        return localize;
    }

    public static Settings sets() {
        return sets;
    }
}
