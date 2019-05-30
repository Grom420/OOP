package io;

import humanresources.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GroupsManagerBinaryFileSource extends GroupsManagerFileSource {
    public GroupsManagerBinaryFileSource(String path) {
        setPath(path);
    }

    @Override
    public void load(EmployeeGroup employeeGroup) {
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(path(employeeGroup)))) {
            employeeGroup.setName(inputStream.readUTF());
            List<Employee> employees = loadEmployee(inputStream);
            inputStream.close();
            employeeGroup.clear();
            employeeGroup.addAll(employees);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (IllegalDatesException e) {
            e.printStackTrace();
        }
    }

    private List<Employee> loadEmployee(DataInputStream inputStream) throws IOException, IllegalDatesException {
        int size = inputStream.readInt();
        List<Employee> employees = new ArrayList<>(size);
        String firstName;
        String lastName;
        String jobTitle;
        String description;
        String destination;
        LocalDateTime startTravel;
        LocalDateTime endTravel;
        int salary;
        int bonus;
        StaffEmployee staffEmployee;
        for (int i = 0; i < size; i++) {
            firstName = inputStream.readUTF();
            lastName = inputStream.readUTF();
            jobTitle = inputStream.readUTF();
            salary = inputStream.readInt();
            bonus = inputStream.readInt();
            if(bonus != 0) {
                staffEmployee = new StaffEmployee(firstName, lastName, JobTitilesEnum.valueOf(jobTitle), salary);
                description = inputStream.readUTF();
                destination = inputStream.readUTF();
                startTravel = LocalDateTime.of(inputStream.readInt(), inputStream.readInt(), inputStream.readInt(), 0, 0);
                endTravel = LocalDateTime.of(inputStream.readInt(), inputStream.readInt(), inputStream.readInt(), 0, 0);
                staffEmployee.add(new BusinessTravel(bonus, description, destination, startTravel, endTravel));
                employees.add(staffEmployee);
            }
            else
                employees.add(new PartTimeEmployee(firstName, lastName, salary));
        }
        return employees;
    }

    private void writeEmployee(DataOutputStream outputStream, EmployeeGroup employeeGroup) throws IOException {
        BusinessTravel[] businessTravels;
        outputStream.writeUTF(employeeGroup.getName());
        outputStream.writeInt(employeeGroup.size());
        for(Employee employee : employeeGroup){
            outputStream.writeUTF(employee.getFirstName());
            outputStream.writeUTF(employee.getSecondName());
            outputStream.writeUTF(employee.getJobTitle().toString());
            outputStream.writeInt(employee.getSalary());
            if(employee.isTraveller()){
                outputStream.writeInt(((StaffEmployee) employee).getBonus());
                businessTravels = ((StaffEmployee) employee).getTravels();
                for(BusinessTravel businessTravel : businessTravels){
                    outputStream.writeInt(businessTravel.getCompensation());
                    outputStream.writeUTF(businessTravel.getDescription());
                    outputStream.writeUTF(businessTravel.getDestination());
                    outputStream.writeInt(businessTravel.getStartBusinessTravel().getYear());
                    outputStream.writeInt(businessTravel.getStartBusinessTravel().getMonthValue());
                    outputStream.writeInt(businessTravel.getStartBusinessTravel().getDayOfMonth());
                    outputStream.writeInt(businessTravel.getEndBusinessTravel().getYear());
                    outputStream.writeInt(businessTravel.getEndBusinessTravel().getMonthValue());
                    outputStream.writeInt(businessTravel.getEndBusinessTravel().getDayOfMonth());
                }
            }
            else
                outputStream.writeInt(0);
        }
        outputStream.close();
    }

    @Override
    public void store(EmployeeGroup employeeGroup) {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(getPath()))) {
            dataOutputStream.writeUTF(employeeGroup.toString());
            writeEmployee(dataOutputStream, employeeGroup);
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
        return getPath() + employeeGroup.getName() + ".bin";
    }
}
