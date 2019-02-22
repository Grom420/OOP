package Task19;

import java.util.ArrayList;

public class Student implements Comparable<Student>
{

    public int compareTo(Student other)
    {
        return (int)(other.average - average);
    }

    private String sName;
    private String name;
    private int math;
    private int phys;
    private int inf;
    private double average;

    public Student(){
        sName = null;
        name = null;
        math = 0;
        phys = 0;
        inf = 0;
    }

    public Student(String sName, String name, int math, int phys, int inf) {
        this.sName = sName;
        this.name = name;
        this.math = math;
        this.phys = phys;
        this.inf = inf;
        Average();
    }

    public String getsName() {
        return sName;
    }


    public String getName() {
        return name;
    }


    public int getMath() {
        return math;
    }


    public int getPhys() {
        return phys;
    }


    public int getInf() {
        return inf;
    }


    @Override
    public String toString()
    {
        return String.format("%s %s %d %d %d", sName, name, math, phys, inf);
    }

    public double Average(){

        return average = (math + inf + phys)/3.0;
    }

    public static Student Parse(String value){
        String[] bufSplit;
        bufSplit = value.split(" ");
        Student student = new Student(bufSplit[0], bufSplit[1], Integer.parseInt(bufSplit[2]), Integer.parseInt(bufSplit[3]), Integer.parseInt(bufSplit[4]));
        return student;
    }

    public static ArrayList<String> PerfectStud(Student[] students, int size){

        ArrayList<String> perfectStud = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (students[i].getPhys() > 3 && students[i].getMath() > 3 && students[i].getInf() > 3)
                perfectStud.add(String.format("%s %s", students[i].getsName(), students[i].getName()));
        }
        return perfectStud;
    }

    public static double AverageInf(Student[] students, int size){

        double averageInf = 0;
        for (int i = 0; i < size; i++) {
            averageInf += students[i].getInf();
        }
        return averageInf/size;
    }

    public static double AverageMath(Student[] students, int size){

        double averageMath = 0;
        for (int i = 0; i < size; i++) {
            averageMath += students[i].getMath();
        }
        return averageMath/size;
    }

    public static double AveragePhys(Student[] students, int size){
        double averagePhys = 0;
        for (int i = 0; i < size; i++) {
            averagePhys += students[i].getPhys();
        }
        return averagePhys/(double)size;
    }
}
