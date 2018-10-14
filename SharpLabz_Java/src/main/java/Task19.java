import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task19 {

    public static void main(String[] args) throws IOException {

        Student stud = new Student();

        List<String> studList = null;

        try {
            studList = Files.readAllLines(Paths.get("C:\\Users\\dns\\IdeaProjects\\taskpp\\SharpLabz_Java\\src\\main\\resources\\input.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Student[] students = new Student[studList.size()];

        String buf = null;
        for (int i = 0; i < studList.size(); i++)
        {
            buf = studList.get(i);
            students[i] = Student.Parse(buf);//Инициализируем студентов
        }

        Arrays.sort(students, Student::compareTo);//Сортируем по убыванию среднего балла

        FileWriter fileWriter = new FileWriter("C:\\Users\\dns\\IdeaProjects\\taskpp\\SharpLabz_Java\\src\\main\\resources\\output.txt");

        for (int i = 0; i < studList.size(); i++)
        {
            fileWriter.write(String.format("%s\n", students[i].toString()));//Выводим отсортированный список
        }

        for (int i = 0; i < studList.size(); i++) {

            fileWriter.write(String.format("%s\n", students[i].Average()));//Выводим среднее аримфетическое для каждого студента
        }

        fileWriter.write(stud.PerfectStud(students, studList.size()).toString() + "\n");//лучшие студенты
        fileWriter.write(String.format("%f\n", stud.AverageInf(students, studList.size()))); //среднее арифметическое всех студентов по инфе
        fileWriter.write(String.format("%f\n",stud.AverageMath(students, studList.size())));// среднее арифм. всех студентов по матану
        fileWriter.write(String.format("%f\n",stud.AveragePhys(students, studList.size())));// среднее арифм всех студентов по физике
        fileWriter.flush();
    }
}

class Student implements Comparable<Student>
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
