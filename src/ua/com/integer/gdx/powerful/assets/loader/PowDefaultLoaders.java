package ua.com.integer.gdx.powerful.assets.loader;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.I18NBundle;
import ua.com.integer.gdx.powerful.assets.PowFileResolver;
import ua.com.integer.gdx.powerful.assets.PowAssets;
import ua.com.integer.gdx.powerful.assets.loader.imp.BitmapFontLoader;
import ua.com.integer.gdx.powerful.assets.loader.imp.I18NLoader;
import ua.com.integer.gdx.powerful.assets.loader.imp.MusicLoader;
import ua.com.integer.gdx.powerful.assets.loader.imp.PixmapLoader;
import ua.com.integer.gdx.powerful.assets.loader.imp.SkinLoader;
import ua.com.integer.gdx.powerful.assets.loader.imp.SoundLoader;
import ua.com.integer.gdx.powerful.assets.loader.imp.StringLoader;
import ua.com.integer.gdx.powerful.assets.loader.imp.TextureAtlasLoader;
import ua.com.integer.gdx.powerful.assets.loader.imp.TextureLoader;

public class PowDefaultLoaders {

    public static final String DEFAULT_ATLASES_FOLDER = "atlases";
    public static final String DEFAULT_TEXTURES_FOLDER = "textures";
    public static final String DEFAULT_PIXMAPS_FOLDER = "pixmaps";
    public static final String DEFAULT_SOUNDS_FOLDER = "sounds";
    public static final String DEFAULT_MUSIC_FOLDER = "music";
    public static final String DEFAULT_CONFIGS_FOLDER = "configs";
    public static final String DEFAULT_FONTS_FOLDER = "fonts";
    public static final String DEFAULT_I18N_FOLDER = "i18n";
    public static final String DEFAULT_SKINS_FOLDER = "skins";

    public static final String PNG_SUFFIX = "png";
    public static final String JPG_SUFFIX = "jpg";
    public static final String ETC1_SUFFIX = "etc1";
    public static final String ATLAS_SUFFIX = "atlas";
    public static final String PACK_SUFFIX = "pack";
    public static final String MP3_SUFFIX = "mp3";
    public static final String OGG_SUFFIX = "ogg";
    public static final String WAV_SUFFIX = "wav";
    public static final String JSON_SUFFIX = "json";
    public static final String BITMAP_FONT_SUFFIX = "fnt";
    public static final String I18N_SUFFIX = "properties";
    public static final String SKIN_SUFFIX = "json";

    public static void registerLoaders() {
        registerTextureLoader();
        registerTextureAtlasLoader();
        registerSoundLoader();
        registerMusicLoader();
        registerStringLoader();
        registerBitmapFontLoader();
        registerI18NLoader();
        registerSkinLoader();
        registerPixmapLoader();
    }

    private static void registerTextureLoader() {
        PowFileResolver textureFileResolver = new PowFileResolver();
        textureFileResolver.addSuffixes(PNG_SUFFIX, JPG_SUFFIX, ETC1_SUFFIX);
        textureFileResolver.addFolders(DEFAULT_TEXTURES_FOLDER, DEFAULT_ATLASES_FOLDER);
        textureFileResolver.addFileType(Files.FileType.Internal);
        PowAssets.registerAssetResolver(Texture.class, textureFileResolver);

        PowAssets.registerAssetLoader(Texture.class, new TextureLoader());
    }

    private static void registerTextureAtlasLoader() {
        PowFileResolver resolver = new PowFileResolver();
        resolver.addSuffixes(ATLAS_SUFFIX, PACK_SUFFIX);
        resolver.addFolder(DEFAULT_ATLASES_FOLDER);
        resolver.addFileType(Files.FileType.Internal);
        PowAssets.registerAssetResolver(TextureAtlas.class, resolver);

        PowAssets.registerAssetLoader(TextureAtlas.class, new TextureAtlasLoader());
    }

    private static void registerSoundLoader() {
        PowFileResolver resolver = new PowFileResolver();
        resolver.addSuffixes(MP3_SUFFIX, OGG_SUFFIX, WAV_SUFFIX);
        resolver.addFolder(DEFAULT_SOUNDS_FOLDER);
        resolver.addFileType(Files.FileType.Internal);
        PowAssets.registerAssetResolver(Sound.class, resolver);

        PowAssets.registerAssetLoader(Sound.class, new SoundLoader());
    }

    private static void registerMusicLoader() {
        PowFileResolver resolver = new PowFileResolver();
        resolver.addSuffixes(MP3_SUFFIX, OGG_SUFFIX, WAV_SUFFIX);
        resolver.addFolder(DEFAULT_MUSIC_FOLDER);
        resolver.addFileType(Files.FileType.Internal);
        PowAssets.registerAssetResolver(Music.class, resolver);

        PowAssets.registerAssetLoader(Music.class, new MusicLoader());
    }

    private static void registerStringLoader() {
        PowFileResolver resolver = new PowFileResolver();
        resolver.addSuffixes(JSON_SUFFIX);
        resolver.addFolder(DEFAULT_CONFIGS_FOLDER);
        resolver.addFileType(Files.FileType.Internal);
        PowAssets.registerAssetResolver(String.class, resolver);

        PowAssets.registerAssetLoader(String.class, new StringLoader());
    }

    private static void registerBitmapFontLoader() {
        PowFileResolver resolver = new PowFileResolver();
        resolver.addSuffixes(BITMAP_FONT_SUFFIX);
        resolver.addFolder(DEFAULT_FONTS_FOLDER);
        resolver.addFileType(Files.FileType.Internal);
        PowAssets.registerAssetResolver(BitmapFont.class, resolver);

        PowAssets.registerAssetLoader(BitmapFont.class, new BitmapFontLoader());
    }

    private static void registerI18NLoader() {
        PowFileResolver resolver = new PowFileResolver();
        resolver.addSuffixes(I18N_SUFFIX);
        resolver.addFolder(DEFAULT_I18N_FOLDER);
        resolver.addFileType(Files.FileType.Internal);
        PowAssets.registerAssetResolver(I18NBundle.class, resolver);

        PowAssets.registerAssetLoader(I18NBundle.class, new I18NLoader());
    }

    private static void registerSkinLoader() {
        PowFileResolver resolver = new PowFileResolver();
        resolver.addSuffix(SKIN_SUFFIX);
        resolver.addFolder(DEFAULT_SKINS_FOLDER);
        resolver.addFileType(Files.FileType.Internal);
        PowAssets.registerAssetResolver(Skin.class, resolver);

        PowAssets.registerAssetLoader(Skin.class, new SkinLoader());
    }

    private static void registerPixmapLoader() {
        PowFileResolver resolver = new PowFileResolver();
        resolver.addSuffixes(PNG_SUFFIX, JPG_SUFFIX);
        resolver.addFolders(DEFAULT_PIXMAPS_FOLDER, DEFAULT_TEXTURES_FOLDER, DEFAULT_ATLASES_FOLDER);
        resolver.addFileType(Files.FileType.Internal);
        PowAssets.registerAssetResolver(Pixmap.class, resolver);

        PowAssets.registerAssetLoader(Pixmap.class, new PixmapLoader());
    }
}
