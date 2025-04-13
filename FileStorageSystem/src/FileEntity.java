import java.util.HashMap;
import java.util.Map;

public class FileEntity {
    private String name;
    private String content;
    private Map<User, Permission> permissions = new HashMap<>();

    public FileEntity(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public void setPermission(User user, Permission permission) {
        permissions.put(user, permission);
    }

    public boolean canRead(User user) {
        return permissions.getOrDefault(user, Permission.NONE).canRead();
    }

    public boolean canWrite(User user) {
        return permissions.getOrDefault(user, Permission.NONE).canWrite();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content, User user) {
        if (canWrite(user)) this.content = content;
        else throw new SecurityException("User has no write access");
    }
}
