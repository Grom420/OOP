import java.io.*;

public class FitnessLogger {
    public void writer(StringBuilder stringBuilder){

        File file = new File("D://444.txt");
            try(FileOutputStream fos=new FileOutputStream("D://444.txt", true);
                PrintStream printStream = new PrintStream(fos))
            {
                printStream.println(stringBuilder.toString());
                System.out.println("Запись в файл произведена");
            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }
    }
}
