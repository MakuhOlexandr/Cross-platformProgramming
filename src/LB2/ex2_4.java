package LB2;

public class ex2_4 {
    public static void main(String[] args) {
        try{
            System.out.println("0");
            throw new RuntimeException("Помилка");
        } catch (NullPointerException e) {
            System.out.println("1" );
        } catch (Exception e) {
            System.out.println("2" );
        } catch (Error e) {
            System.out.println("3" );
        }
        System.out.println("4");
    }

}
