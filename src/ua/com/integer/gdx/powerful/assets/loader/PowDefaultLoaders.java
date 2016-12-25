package ua.com.integer.gdx.powerful.assets.loader;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.I18NBundle;
import ua.com.integer.gdx.powerful.assets.ExtendedFileResolver;
import ua.com.integer.gdx.powerful.assets.PowAssets;
import ua.com.integer.gdx.powerful.assets.loader.imp.BitmapFontLoader;
import ua.com.integer.gdx.powerful.assets.loader.imp.I18NLoader;
import ua.com.integer.gdx.powerful.assets.loader.imp.MusicLoader;
import ua.com.integer.gdx.powerful.assets.loader.imp.SoundLoader;
import ua.com.integer.gdx.powerful.assets.loader.imp.StringLoader;
import ua.com.integer.gdx.powerful.assets.loader.imp.TextureAtlasLoader;
import ua.com.integer.gdx.powerful.assets.loader.imp.TextureLoader;

public class PowDefaultLoaders {
    public static void registerLoaders() {
        registerTextureLoader();
        registerTextureAtlasLoader();
        registerSoundLoader();
        registerMusicLoader();
        registerStringLoader();
        registerBitmapFontLoader();
        registerI18NLoader();
    }

    private static void registerTextureLoader() {
        ExtendedFileResolver textureFileResolver = new ExtendedFileResolver();
        textureFileResolver.addExtensions("png", "jpg", "etc1");
        textureFileResolver.addFolder("textures");
        textureFileResolver.addFileType(Files.FileType.Internal);
        PowAssets.registerAssetResolver(Texture.class, textureFileResolver);

        PowAssets.registerAssetLoader(Texture.class, new TextureLoader());
    }

    private static void registerTextureAtlasLoader() {
        ExtendedFileResolver resolver = new ExtendedFileResolver();
        resolver.addExtensions("atlas", "pack");
        resolver.addFolder("atlases");
        resolver.addFileType(Files.FileType.Internal);
        PowAssets.registerAssetResolver(TextureAtlas.class, resolver);

        PowAssets.registerAssetLoader(TextureAtlas.class, new TextureAtlasLoader());
    }

    private static void registerSoundLoader() {
        ExtendedFileResolver resolver = new ExtendedFileResolver();
        resolver.addExtensions("mp3", "ogg", "wav");
        resolver.addFolder("sounds");
        resolver.addFileType(Files.FileType.Internal);
        PowAssets.registerAssetResolver(Sound.class, resolver);

        PowAssets.registerAssetLoader(Sound.class, new SoundLoader());
    }

    private static void registerMusicLoader() {
        ExtendedFileResolver resolver = new ExtendedFileResolver();
        resolver.addExtensions("mp3", "ogg", "wav");
        resolver.addFolder("music");
        resolver.addFileType(Files.FileType.Internal);
        PowAssets.registerAssetResolver(Music.class, resolver);

        PowAssets.registerAssetLoader(Music.class, new MusicLoader());
    }

    private static void registerStringLoader() {
        ExtendedFileResolver resolver = new ExtendedFileResolver();
        resolver.addExtensions("json");
        resolver.addFolder("configs");
        resolver.addFileType(Files.FileType.Internal);
        PowAssets.registerAssetResolver(String.class, resolver);

        PowAssets.registerAssetLoader(String.class, new StringLoader());
    }

    private static void registerBitmapFontLoader() {
        ExtendedFileResolver resolver = new ExtendedFileResolver();
        resolver.addExtensions("fnt");
        resolver.addFolder("fonts");
        resolver.addFileType(Files.FileType.Internal);
        PowAssets.registerAssetResolver(BitmapFont.class, resolver);

        PowAssets.registerAssetLoader(BitmapFont.class, new BitmapFontLoader());
    }

    private static void registerI18NLoader() {
        ExtendedFileResolver resolver = new ExtendedFileResolver();
        resolver.addExtensions("properties");
        resolver.addFolder("i18n");
        resolver.addFileType(Files.FileType.Internal);
        PowAssets.registerAssetResolver(I18NBundle.class, resolver);

        PowAssets.registerAssetLoader(I18NBundle.class, new I18NLoader());
    }

}
