package ua.com.integer.gdx.powerful.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Settings {
    public static final String PUBLISHER_NAME = "Learning Games for kids by Umachka";

    private Preferences prefs;

    public Settings(String prefsName) {
        prefs = Gdx.app.getPreferences(prefsName);
    }

    public Preferences getPrefs() {
        return prefs;
    }

    public void setInAppDone(String inApp, boolean done) {
        prefs.putBoolean("in-app-" + inApp + "-done", done).flush();
    }

    public boolean isInAppDone(String inApp) {
        return prefs.getBoolean("in-app-" + inApp + "-done", false);
    }

    public void setGameRated() {
        prefs.putBoolean("game.rated", true).flush();
    }

    public boolean isGameRated() {
        return prefs.getBoolean("game.rated", false);
    }

    public String getLanguage() {
        return prefs.getString("game.language", Localize.DEFAULT_LANGUAGE);
    }

    public void setLanguage(String language) {
        prefs.putString("game.language", language).flush();
    }

    public boolean isFirstLaunch() {
        boolean firstLaunch = prefs.getBoolean("first.launch", true);
        prefs.putBoolean("first.launch", false).flush();
        return firstLaunch;
    }

    public boolean isSoundEnabled() {
        return prefs.getBoolean("sound.enabled", true);
    }

    public void setSoundEnabled(boolean enabled) {
        prefs.putBoolean("sound.enabled", enabled).flush();
    }

    public boolean isMusicEnabled() {
        return prefs.getBoolean("music.enabled", true);
    }

    public void setMusicEnabled(boolean enabled) {
        prefs.putBoolean("music.enabled", enabled).flush();
    }
}
