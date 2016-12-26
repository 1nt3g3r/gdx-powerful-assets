package ua.com.integer.gdx.powerful.assets;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.StringBuilder;

public class PowFileResolver implements FileHandleResolver {
    private Array<String> folders = new Array<String>();
    private Array<String> suffixes = new Array<String>();
    private Array<Files.FileType> fileTypes = new Array<Files.FileType>();

    private StringBuilder stringBuilder = new StringBuilder();

    public void addFolder(String folder) {
        folders.add(folder);
    }

    public void addFolders(String ... folders) {
        this.folders.addAll(folders);
    }

    public void addSuffix(String suffix) {
        suffixes.add(suffix);
    }

    public void addSuffixes(String ... suffixes) {
        this.suffixes.addAll(suffixes);
    }

    public void addFileType(Files.FileType fileType) {
        fileTypes.add(fileType);
    }

    public void addFileTypes(Files.FileType ... fileTypes) {
        this.fileTypes.addAll(fileTypes);
    }

    public Array<String> getFolders() {
        return folders;
    }

    public Array<String> getSuffixes() {
        return suffixes;
    }

    public Array<Files.FileType> getFileTypes() {
        return fileTypes;
    }

    @Override
    public FileHandle resolve(String fileName) {
        for(String folder : folders) {
            for(String extension: suffixes) {
                stringBuilder.setLength(0);
                stringBuilder.append(folder).append("/").append(fileName).append(".").append(extension);
                String fullPath = stringBuilder.toString();

                for(Files.FileType fileType : fileTypes) {
                    FileHandle fileHandle = Gdx.files.getFileHandle(fullPath, fileType);
                    if (fileHandle.exists()) {
                        return fileHandle;
                    }
                }
            }
        }

        return Gdx.files.getFileHandle(fileName, Files.FileType.Absolute);
    }
}
