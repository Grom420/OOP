package Task17;

public class Task17 {

    public static void main(String[] args) throws ExHours, ExMinutes, ExSeconds {

        Time time = new Time(1, 1, 1);
        time.setSeconds(12);//
        time.setMinutes(13);// Устанавливаем новые значения минут, секунд и часов
        time.setHours(12);////
        System.out.printf("%d.%d.%d", time.getSeconds(), time.getMinutes(), time.getHours());
    }
}

    class ExMinutes extends Exception{

        @Override
        public String getMessage() {
            return "Ошибка в изменении минут";
        }
    }

    class ExSeconds extends Exception{

        @Override
        public String getMessage() {
            return "Ошибка в изменении секунд";
        }
    }

    class ExHours extends Exception{

        @Override
        public String getMessage() {
            return "Ошибка в изменении часов";
        }
    }

