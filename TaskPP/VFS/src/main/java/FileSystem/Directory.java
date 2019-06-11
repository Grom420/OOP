package FileSystem;

import java.time.LocalDateTime;
import java.util.List;

public class Directory {
    private List<File> directory;
    private LocalDateTime dateCreate;
    private String name;

    public List<File> getDirectory() {
        return directory;
    }

    public void setDirectory(List<File> directory) {
        this.directory = directory;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
