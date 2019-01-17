import java.util.ArrayDeque;
import java.util.ArrayList;

public class BFS_Way {

    public static void main(String[] args) {

        int[][] matrix = {
                {0, 1, 0, 0, 1},
                {1, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0}
        };
        int n = 5;
        int start = 3;
        int finish = 5;
        bfs(matrix, n, start, finish);
    }

    public static void bfs(int[][] matrix, int n, int start, int finish){

       ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
       ArrayList<Integer> vertex = new ArrayList<>();//лист всех вершин, через которые будет пролегать путь
       vertex.add(start);//добавляем вершину, с которой начинаем путь
       start--;
       finish--;
       int buf;
       int buf2;
       int[] d = new int[n]; //массив, в каждый элемент которого будет заноситься промежуточная длина
        for (int i = 0; i < n; i++) {
            d[i] = 1000000000;//дохуя большое число
        }
        d[start] = 0;//на начальном этапе 0, затем будет прибавляться +1 (т.к в матрице смежности нет веса больше 1)
        arrayDeque.addFirst(start);
        while (!arrayDeque.isEmpty()){
            buf = arrayDeque.pollFirst();
            for (int i = 0; i < n; i++) {
                if((matrix[buf][i] != 0) && (d[i]) > d[buf]+1){
                    d[i] = d[buf]+1;
                    buf2 = i;
                    buf2++;
                    vertex.add(buf2);//добавляем вершину, через которую двигаемся к конечному пункту
                    arrayDeque.addFirst(i);
                }
            }
        }
        if(d[finish]<1000000000) {
            System.out.println(d[finish]);
            System.out.println(vertex);
        }
        else
            System.out.println(-1);
    }
}
