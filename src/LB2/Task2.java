package LB2;
import java.util.*;


public class Task2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Объявляем Scanner
        System.out.println("Enter array length: ");
        int size = input.nextInt(); // Читаем с клавиатуры размер массива и записываем в size
        int array[] = new int[size]; // Создаём массив int размером в size
        System.out.println("Insert array elements:");
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            try{
                array[i] = input.nextInt();
                if ((array[i]%3)==0){
                    list.add(array[i]);
                }
            } catch (InputMismatchException e){ // Обработчик ошыбки
                System.out.println("Input number");
            }
        }
        System.out.print ("Inserted array elements:");
        for (int i = 0; i < size; i++) {
            System.out.print (" " + array[i]); // Выводим на экран, полученный массив
        }
        System.out.println();

        if (list.size()!=0){  // Максимальний елемент
            System.out.print ("The maximum element that is divisible by 3= ");
            System.out.println(Collections.max(list));}
        else {
            System.out.println ("Elements divisible by 3 are missing");
        }



    }
}
