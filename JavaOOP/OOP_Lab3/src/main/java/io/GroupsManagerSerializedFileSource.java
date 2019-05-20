package io;

import humanresources.Employee;
import humanresources.EmployeeGroup;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GroupsManagerSerializedFileSource extends GroupsManagerFileSource {
    public GroupsManagerSerializedFileSource(String path) {
        setPath(path);
    }

    @Override
    public void load(EmployeeGroup employeeGroup) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path(employeeGroup)))) {
            employeeGroup = (EmployeeGroup) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void store(EmployeeGroup employeeGroup) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path(employeeGroup)))) {
            out.writeObject(employeeGroup);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(EmployeeGroup employeeGroup) {
        try (PrintWriter writer = new PrintWriter(path(employeeGroup))) {
            writer.print("");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            Files.delete(Paths.get(getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(EmployeeGroup employeeGroup) {
        setPath(path(employeeGroup));
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(getPath()))) {
            out.writeObject(employeeGroup);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String path(EmployeeGroup employeeGroup) {
        return employeeGroup.getName() + ".txt";
    }
}
