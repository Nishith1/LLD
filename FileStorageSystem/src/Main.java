public class Main {
    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        User alice = new User("alice");

        Folder root = fs.getRoot();
        Folder docs = new Folder("documents", root);
        root.addFolder(docs);

        FileEntity resume = new FileEntity("resume.pdf", "My Resume Content");
        resume.setPermission(alice, Permission.READ_WRITE);
        docs.addFile(resume);

        System.out.println("Path: " + docs.getPath());
        System.out.println("Read: " + resume.getContent());
    }
}