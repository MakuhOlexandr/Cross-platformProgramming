package LB1;
import java.util.Scanner;
class Lake{
    String name, location;
    double square;
}
public class Task1 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in, "cp1251");

        // Введення інформації про озера
        System.out.println("Введіть кількість озер => ");
        int n=sc.nextInt();// кількість озер
        Lakec lakes[]=new Lakec[n];
        System.out.println("Введіть інформацію про озера: ");
        for(int i = 0; i < lakes.length; i++) {
            sc.nextLine();
            lakes[i]=new Lakec();
            System.out.print("Назва "+(i+1)+"-го озера => ");
            lakes[i].name= sc.nextLine();
            System.out.print("Розташування "+(i+1)+"-го озера => ");
            lakes[i].location= sc.nextLine();
            System.out.print("Площа "+(i+1)+"-го озера => ");
            lakes[i].square= sc.nextDouble();
        }
        // Виведення інформації про озера
        System.out.println("\nХарактеристики озер:");
        for(Lakec lk:lakes){
            System.out.println(" "+lk.name+"/t"+" "+lk.location+"/t"+" "+lk.square+"кв. км");
        }
        //Найбільше озеро
        int numberMaxElement=0;
        double maxLake=lakes[numberMaxElement].square;
        for (int i = 0; i < lakes.length; i++)
            if (lakes[i].square>maxLake) {
                maxLake = lakes[i].square;
                numberMaxElement=i;
            }
        System.out.println("\nКраїна з максимальною площею :");
        System.out.println(""+lakes[numberMaxElement].name+"\t"+lakes[numberMaxElement].location+"\t"+lakes[numberMaxElement].square + "кв. км");
        //Кількість озер більших за середню площу
        double summarySquare=0;	//сумарна площа
        for (int i = 0; i < lakes.length; i++)
            summarySquare+=lakes[i].square;
        double averegeSquare=summarySquare/lakes.length;
        System.out.println("Середня площа ="+averegeSquare);
        int numberOfLakes=0;
        for (int i = 0; i < lakes.length; i++){
            if (lakes[i].square<averegeSquare){
                numberOfLakes++;
            }
        }
        System.out.println("Кількість озер із площею меншою за середню ="+numberOfLakes);
        // Сортування озер за назвою
        for (int i = 0; i < lakes.length-1; i++)
            for (int j = 0; j < lakes.length-i-1; j++)
                if(lakes [j].name.compareTo(lakes[i+1].name)>0){
                    Lakec rab=lakes[j];	//rab – робоча змінна для перестановки
                    lakes [j] = lakes [j + 1];
                    lakes [j + 1] = rab;
                }
        System.out.println("\nВідсортований список за назвою:");
        for(Lakec lk:lakes){
            System.out.println(" "+lk.name+"/t"+" "+lk.location+"/t"+" "+lk.square+"кв. км");
        }
        // Пошук за назвою
        sc.nextLine();			 // очищення буфера
        System.out.println("Введіть назву шуканого озера=>");
        String name=sc.nextLine();
        int nom = -1;//−1 – озеро з шуканою назвою відсутнє

        for (int i = 0; i < lakes.length; i++){
            if (name.equalsIgnoreCase(lakes[i].name)) nom=i;

            if (nom!= -1) {
                System.out.println("Таке озеро є у списку. Це " +lakes[nom].name+" "+lakes[nom].location+" "+lakes[nom].square+" кв. км\n" +
                        "Бажаєте редагувати(y-так, n-ні)");
                String answer=sc.nextLine();
                if (answer=="y"){
                    sc.nextLine();
                    System.out.print("Назва озера => ");
                    lakes[nom].name= sc.nextLine();
                    System.out.print("Розташування озера => ");
                    lakes[nom].location= sc.nextLine();
                    System.out.print("Площа озера => ");
                    lakes[nom].square= sc.nextDouble();
                    System.out.print("Назву змінено!!!");
                }
            }
            else
                System.out.println("Такого озера немає в списку");
        }


    }
}
