package ua.com.integer.gdx.powerful.assets;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.I18NBundle;
import com.badlogic.gdx.utils.ObjectMap;

import java.util.Locale;

public class Localize {
    public static final String DEFAULT_LANGUAGE = "en";

    private ObjectMap<String, I18NBundle> bundles = new ObjectMap<String, I18NBundle>();
    private String language = DEFAULT_LANGUAGE;
    private Locale locale = new Locale(DEFAULT_LANGUAGE);

    public Localize() {
        setLanguage(PowAssets.access().sets().getLanguage());
    }

    public void setLanguage(String language) {
        this.language = language;
        PowAssets.access().sets().setLanguage(language);
        locale = new Locale(language);
        reloadBundles();
    }

    private void reloadBundles() {
        Array<String> keys = new Array<String>();
        for(String key : bundles.keys()) {
            keys.add(key);
        }
        for(String key : keys) {
            loadBundle(key);
        }
    }

    public void loadBundle(String bundleName) {
        bundles.put(bundleName, PowAssets.access().getI18NBundle(bundleName, language));
    }

    public void unloadBundle(String bundleName) {
        bundles.remove(bundleName);
    }

    public I18NBundle getBundle(String bundle) {
        if (!bundles.containsKey(bundle)) {
            loadBundle(bundle);
        }
        return bundles.get(bundle);
    }

    public String translate(String key) {
        return translate("default", key);
    }

    public String translate(String bundle, String key) {
        return getBundle(bundle).get(key);
    }

    public String format(String key, String ... params) {
        return format("default", key, params);
    }

    public String format(String bundle, String key, String ... params) {
        return getBundle(bundle).format(key, params);
    }
}
