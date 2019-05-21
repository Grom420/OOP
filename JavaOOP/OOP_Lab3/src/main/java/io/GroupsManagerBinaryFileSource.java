package io;

import humanresources.Employee;
import humanresources.EmployeeGroup;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GroupsManagerBinaryFileSource extends GroupsManagerFileSource {
    public GroupsManagerBinaryFileSource(String path) {
        setPath(path);
    }

    @Override
    public void load(EmployeeGroup employeeGroup) {
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(path(employeeGroup)))) {
            String stringEmployee = inputStream.readUTF();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void store(EmployeeGroup employeeGroup) {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(getPath()))) {
            dataOutputStream.writeUTF(employeeGroup.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(EmployeeGroup employeeGroup) {
        setPath(path(employeeGroup));
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(getPath()))) {
            dataOutputStream.writeUTF("");
        } catch (IOException e) {
            e.printStackTrace();
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
        try {
            Files.createFile(Paths.get(getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        store(employeeGroup);
    }

    private String path(EmployeeGroup employeeGroup) {
        return employeeGroup.getName() + ".txt";
    }
}
