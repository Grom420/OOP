package FileSystem;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class File {
    private String name;
    private LocalDateTime dateOfCreation;
    private boolean lock;
    private String content;
    private ArrayList<String> owners;

    public File(){}

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public ArrayList<String> getOwners() {
        return owners;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
