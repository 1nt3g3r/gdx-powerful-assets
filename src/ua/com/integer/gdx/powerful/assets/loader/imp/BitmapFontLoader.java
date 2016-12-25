package ua.com.integer.gdx.powerful.assets.loader.imp;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.ObjectMap;
import ua.com.integer.gdx.powerful.assets.PowAssets;
import ua.com.integer.gdx.powerful.assets.loader.PowAssetLoader;

public class BitmapFontLoader implements PowAssetLoader {
    private Json json = new Json();

    @Override
    public Object loadAsset(FileHandle fileHandle) {
        String name = fileHandle.nameWithoutExtension();
        FileHandle parent = fileHandle.parent();
        FileHandle fontConfig = parent.child(name + ".bfdesc");
        if (fontConfig.exists()) {
            ObjectMap<String, String> bitmapFontParams = json.fromJson(ObjectMap.class, fontConfig);
            String atlasName = bitmapFontParams.get("atlas");
            String regionName = bitmapFontParams.get("region");

            if (atlasName == null && regionName == null) {
                return new BitmapFont(fileHandle);
            } else if (atlasName != null && regionName == null) {
                regionName = name;
            }

            TextureRegion region = PowAssets.access().getRegion(atlasName, regionName);
            return new BitmapFont(fileHandle, region);
        } else {
            return new BitmapFont(fileHandle);
        }
    }
}
