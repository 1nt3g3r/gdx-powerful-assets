package ua.com.integer.gdx.powerful.assets.preload;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.I18NBundle;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.ReflectionPool;

import ua.com.integer.gdx.powerful.assets.PowAssets;

public class PowAssetSetLoader {
    private ObjectMap<String, Class<? extends Object>> typeDefs = new ObjectMap<>();
    private Pool<AssetDef> defsPool = new ReflectionPool<AssetDef>(AssetDef.class, 64, 1024);

    private Array<AssetDef> loadQueue = new Array<>();

    private int loadedCount;
    private int totalCount;

    public PowAssetSetLoader() {
        registerDef("texture", Texture.class);
        registerDef("atlas", TextureAtlas.class);
        registerDef("sound", Sound.class);
        registerDef("music", Music.class);
        registerDef("font", BitmapFont.class);
        registerDef("i18n", I18NBundle.class);
        registerDef("pixmap", Pixmap.class);
        registerDef("skin", Skin.class);
        registerDef("string", String.class);
        registerDef("config", String.class);
    }

    public void registerDef(String name, Class<? extends Object> type) {
        typeDefs.put(name, type);
    }

    public void unloadAll() {
        for(AssetDef def: loadQueue) {
            PowAssets.unloadAsset(def.name, typeDefs.get(def.type));
        }
        clear();
    }

    public void clear() {
        defsPool.freeAll(loadQueue);
        loadQueue.clear();

        loadedCount = 0;
        totalCount = 0;
    }

    public void add(String type, String name) {
        AssetDef def = defsPool.obtain();
        def.type = type;
        def.name = name;
        loadQueue.add(def);

        totalCount++;
    }

    public void add(String type, Array<String> names) {
        for(String name : names) {
            add(type, name);
        }
    }

    public boolean loadStep() {
        if (loadQueue.size == 0) {
            return false;
        }

        AssetDef def = loadQueue.pop();
        PowAssets.getAsset(def.name, typeDefs.get(def.type));

        loadedCount ++;

        return loadQueue.size <= 0;
    }

    public float getPercent() {
        if (totalCount == 0) {
            return 0f;
        }

        return (float) loadedCount / (float) totalCount;
    }
}
