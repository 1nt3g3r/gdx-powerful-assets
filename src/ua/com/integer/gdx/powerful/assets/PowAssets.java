package ua.com.integer.gdx.powerful.assets;

import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.ObjectMap;

import ua.com.integer.gdx.powerful.assets.loader.PowAssetLoader;
import ua.com.integer.gdx.powerful.assets.loader.PowDefaultLoaders;

public class PowAssets {
    private ObjectMap<Class, PowAssetLoader> assetLoaders = new ObjectMap<Class, PowAssetLoader>();
    private ObjectMap<Class, FileHandleResolver> assetResolvers = new ObjectMap<Class, FileHandleResolver>();
    private ObjectMap<Class, ObjectMap<String, Object>> loadedAssets = new ObjectMap<Class, ObjectMap<String, Object>>();

    private static PowAssets instance = new PowAssets();

    private static AssetsAccess facade = new AssetsAccess();

    private PowAssets() {
    }

    public static AssetsAccess access() {
        return instance.facade;
    }

    public static void registerAssetLoader(Class assetClass, PowAssetLoader assetLoader) {
        instance.assetLoaders.put(assetClass, assetLoader);
    }

    public static PowAssetLoader getAssetLoader(Class assetClass) {
        return instance.assetLoaders.get(assetClass);
    }

    public static void registerAssetResolver(Class assetClass, FileHandleResolver assetResolver) {
        instance.assetResolvers.put(assetClass, assetResolver);
    }

    public static FileHandleResolver getAssetResolver(Class assetClass) {
        return instance.assetResolvers.get(assetClass);
    }

    public static <T extends Object> T getAsset(String name, Class tClass) {
        return (T) instance.getAndLoadAsset(name, tClass);
    }

    private <T extends Object> T getAndLoadAsset (String name, Class tClass) {
        ObjectMap<String, Object> assetMap = getAssetMap(tClass);
        if (!assetMap.containsKey(name)) {
            loadAsset(tClass, name);
        }
        return (T) getAssetMap(tClass).get(name);
    }

    private void loadAsset(Class assetClass, String assetName) {
        FileHandleResolver resolver = assetResolvers.get(assetClass);
        FileHandle assetFileHanle = resolver.resolve(assetName);
        PowAssetLoader assetLoader = assetLoaders.get(assetClass);
        Object asset = assetLoader.loadAsset(assetFileHanle);
        getAssetMap(assetClass).put(assetName, asset);
    }

    private ObjectMap<String, Object> getAssetMap(Class assetClass) {
        if (!loadedAssets.containsKey(assetClass)) {
            loadedAssets.put(assetClass, new ObjectMap<String, Object>());
        }
        return loadedAssets.get(assetClass);
    }

    public static void init(String settingsName) {
        instance.performInit(settingsName);
    }

    private void performInit(String settingsName) {
        dispose();
        PowDefaultLoaders.registerLoaders();
        access().init(settingsName);
    }

    public static void dispose() {
        instance.performDispose();
    }

    private void performDispose() {
        for(ObjectMap assetMap : loadedAssets.values()) {
            for(Object asset : assetMap.values()) {
                if (asset instanceof Disposable) {
                    ((Disposable) asset).dispose();
                }
            }
        }
        loadedAssets.clear();

        assetLoaders.clear();
        assetResolvers.clear();
    }

    public static void unloadAsset(String name, Class assetClass) {
        ObjectMap<String, Object> assetMap = instance.getAssetMap(assetClass);
        Object asset = assetMap.get(name);

        if (asset != null) {
            assetMap.remove(name);

            if (asset instanceof Disposable) {
                ((Disposable) asset).dispose();
            }
        }
    }
}
