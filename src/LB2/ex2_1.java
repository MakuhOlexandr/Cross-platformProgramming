package LB2;

public class ex2_1 {
    public static void main(String[] args){
        try{
        System.out.println("0");
        throw new RuntimeException("Неперевірена помилка");}
    catch(RuntimeException e){
        System.out.println("1" + e);
    }
        System.out.println("2");
    }

}
