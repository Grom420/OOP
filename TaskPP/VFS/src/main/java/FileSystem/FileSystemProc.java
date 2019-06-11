package FileSystem;

import java.util.List;
import java.util.SortedSet;

public class FileSystemProc {
    private SortedSet<FileSystemProc> directory;

    public SortedSet<FileSystemProc> getDirectory() {
        return directory;
    }

    public void setDirectory(SortedSet<FileSystemProc> directory) {
        this.directory = directory;
    }
}
