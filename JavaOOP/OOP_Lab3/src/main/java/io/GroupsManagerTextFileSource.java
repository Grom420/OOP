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
    public void store(EmployeeGroup employeeGroup) {
        try {
            PrintWriter writer = new PrintWriter(path(employeeGroup), "UTF-8");
            //todo ДОлго и муторно считываешь данные из файла и на основе этих данных создаешь новых эмплоев и заменяешь ими имеющийеся
            employeeGroup.clear();
            //todo затем набиваешь новых эмплоев, инфу о которых считал из файла

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

    //todo с удалением и созданием та же фигня, что и BinaryFileSource

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

    @Override
    public void load(EmployeeGroup employeeGroup) {
        //todo ДОлго и муторно записываешь все поля всех эмплоев в файл writeUtf, writeInt, writeDouble

    }

    private String path(EmployeeGroup employeeGroup) {
        return employeeGroup.getName() + ".txt";
    }
}
