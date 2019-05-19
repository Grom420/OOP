package io;
import humanresources.Employee;

public interface FileSource extends Source<Employee> {
    public void setPath(String path);
    public String getPath();
}
