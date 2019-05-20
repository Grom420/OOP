package io;

import humanresources.Employee;
import humanresources.EmployeeGroup;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GroupsManagerTextFileSource extends GroupsManagerFileSource {
    public GroupsManagerTextFileSource(String path) {
        setPath(path);
    }

    @Override
    public void load(EmployeeGroup employeeGroup) {

    }

    @Override
    public void store(EmployeeGroup employeeGroup) {
        try {
            PrintWriter writer = new PrintWriter(path(employeeGroup), "UTF-8");
            writer.print(employeeGroup.toString());
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(EmployeeGroup employeeGroup) {
        try {
            PrintWriter writer = new PrintWriter(path(employeeGroup));
            writer.print("");
            writer.close();
        } catch (FileNotFoundException e) {
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
            PrintWriter writer = new PrintWriter(getPath(), "UTF-8");
            writer.print(employeeGroup.toString());
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private String path(EmployeeGroup employeeGroup) {
        return employeeGroup.getName() + ".txt";
    }
}
