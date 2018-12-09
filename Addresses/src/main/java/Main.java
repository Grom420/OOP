import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader fp = new BufferedReader(new FileReader("C:\\Users\\Admin\\IdeaProjects\\taskpp\\Addresses\\src\\main\\resources\\Addr.csv"));
        String hdr;
        while ((hdr = fp.readLine()) != null){
            treatment(hdr.split(","));
        }
    }

    static void treatment(String[] line) throws IOException {

        StringBuilder sb = new StringBuilder();

        Pattern region = Pattern.compile(".*обл[.]?");
        Pattern area = Pattern.compile("(.*р-н)|(^$)");
        Pattern town = Pattern.compile("([√г]\\..*)|([—с]\\..*)|([ѕп][—с][ к].*)");
        Pattern urbanArea = Pattern.compile("(.*р-н.*)|(^$)");
        Pattern quarter = Pattern.compile("(.*[ к][¬в](ј–“-Ћ)?\\..*)|(^$)");
        Pattern street = Pattern.compile("([”у]л+.*)|(.*б-р.*)|(.+пр[.])|(.*пр.*[дт]*.*)|(^(.*)а€.*)|(.+ш[.]?(оссе)*$)|(.+пер[.])");
        Pattern house = Pattern.compile("(.*[ƒд](ом)?.*)|(.*[«з]дание.*)");
        int count = 0;
        for (int i = 0; i < line.length; i++) {

            if(street.matcher(line[i]).matches() ||
                    region.matcher(line[i]).matches() ||
                    town.matcher(line[i]).matches() ||
                    area.matcher(line[i]).matches() ||
                    quarter.matcher(line[i]).matches() ||
                    house.matcher(line[i]).matches() || urbanArea.matcher(line[i]).matches())
                count++;
        }
        if (count == 7) {

            for (int i = 0; i < line.length; i++) {

                if(region.matcher(line[i]).matches())
                    sb.append(line[i]).append(",");
                else if(area.matcher(line[i]).matches())
                    sb.append(line[i]).append(",");
                else if(town.matcher(line[i]).matches())
                    sb.append(line[i]).append(",");
                else if(urbanArea.matcher(line[i]).matches())
                    sb.append(line[i]).append(",");
                else if(quarter.matcher(line[i]).matches())
                    sb.append(line[i]).append(",");
                else if(street.matcher(line[i]).matches())
                    sb.append(line[i]).append(",");
                else
                    sb.append(line[i]);

            }
            FileWriter writer = new FileWriter("C:\\Users\\Admin\\IdeaProjects\\taskpp\\Addresses\\src\\main\\resources\\Valid.csv", true);
            writer.append(sb.toString()).append("\n");
            sb.delete(0, sb.length());
            writer.flush();
        }
    }

    static void Vivod(String[] line){

        for (int i = 0; i < line.length; i++) {
            System.out.println(line[i]);
        }
        System.out.println();
    }
}
