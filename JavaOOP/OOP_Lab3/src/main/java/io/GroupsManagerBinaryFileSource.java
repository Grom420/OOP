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
            //todo ДОлго и муторно считываешь данные из файла и на основе этих данных создаешь новых эмплоев и заменяешь ими имеющийеся
            employeeGroup.clear();
            //todo затем набиваешь новых эмплоев, инфу о которых считал из файла
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void store(EmployeeGroup employeeGroup) {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(getPath()))) {
            dataOutputStream.writeUTF(employeeGroup.toString());
            //todo ДОлго и муторно записываешь все поля всех эмплоев в файл writeUtf, writeInt, writeDouble
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(EmployeeGroup employeeGroup) {
        try {
            Files.delete(Paths.get(getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(EmployeeGroup employeeGroup) {
        store(employeeGroup);
    }

    private String path(EmployeeGroup employeeGroup) {
        return employeeGroup.getName() + ".txt";
    }
}
