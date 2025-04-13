import java.util.ArrayList;
import java.util.List;

public class Folder {
    private String name;
    private Folder parent;
    private List<Folder> subFolders = new ArrayList<>();
    private List<FileEntity> files = new ArrayList<>();

    public Folder(String name, Folder parent) {
        this.name = name;
        this.parent = parent;
    }

    public void addFile(FileEntity file) {
        files.add(file);
    }

    public void addFolder(Folder folder) {
        subFolders.add(folder);
    }

    public List<Folder> getSubFolders() {
        return subFolders;
    }

    public List<FileEntity> getFiles() {
        return files;
    }

    public String getPath() {
        return parent == null ? name : parent.getPath() + "/" + name;
    }
}
