package LB1;
import  java.util.Scanner;
class Lakec {
    String name, location;
    double square;}
public class Task2 {
    //Введення масиву
    public  static Lakec[] setLakeArrey(int n){
        Scanner sc = new Scanner(System.in, "cp1251");
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
        return lakes;
    }
    //Інформація про озера
    public static void showLakes(Lakec[] lakes){
        for(Lakec lk:lakes){
            System.out.println(" "+lk.name+"\t"+" "+lk.location+"\t"+" "+lk.square+"кв. км");
        }
    }
    //Інформація про озеро
    public static void showLake(Lakec lk){
        System.out.println(" "+lk.name+"\t"+" "+lk.location+"\t"+" "+lk.square+"кв. км");
    }
    //Номер озера з найбільшою площею
    public static int numMaxElement(Lakec[] lakes){
        int numberMaxElement=0;
        double maxLake=lakes[numberMaxElement].square;
        for (int i = 0; i < lakes.length; i++) if (lakes[i].square>maxLake) {
            maxLake = lakes[i].square;
            numberMaxElement=i;
        }
        return numberMaxElement;
    }
    //Кількість озер менших за середню площу
    public static int smaller(Lakec[] lakes){
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
        return numberOfLakes;
    }
    //Інформація про озера
    public static void sortByName(Lakec[] lakes){
        for (int i = 0; i < lakes.length-1; i++)
            for (int j = 0; j < lakes.length-i-1; j++)
                if(lakes [j].name.compareTo(lakes[i+1].name)>0) {
                    Lakec rab = lakes[j];    //rab – робоча змінна для перестановки
                    lakes[j] = lakes[j + 1];
                    lakes[j + 1] = rab;
                }
    }
    // Пошук за назвою
    public static int findForName(Lakec[] lakes, String name){
        int n=-1;
        for (int i = 0; i < lakes.length; i++)
            if (name.equals(lakes[i].name)) n=i;
        if (n!= -1) { return n;}
        else return -1;
    }
    public static Lakec[] editLake(Lakec[] lakes, int numberLake){
        Scanner sc = new Scanner(System.in, "cp1251");
        sc.nextLine();
        System.out.print("Назва озера => ");
        lakes[numberLake].name= sc.nextLine();
        System.out.print("Розташування озера => ");
        lakes[numberLake].location= sc.nextLine();
        System.out.print("Площа озера => ");
        lakes[numberLake].square= sc.nextDouble();
        System.out.print("Назву змінено!!!");
        return lakes;
    }
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in, "cp1251");
        // Введення інформації про озера
        System.out.println("Введіть кількість озер => ");
        int n=sc.nextInt();// кількість озер
        Lakec lakes[]=new Lakec[n];
        lakes=setLakeArrey(n);
        //Виведення інформації про озера
        showLakes(lakes);
        //Найбільше озеро
        showLake(lakes[numMaxElement(lakes)]);
        //Кількість озер менших за середню площу
        System.out.println("Кількість озер із площею меншою за середню ="+smaller(lakes));
        // Сортування озер за назвою
        sortByName(lakes);
        showLakes(lakes);
        //
        String lakeName=sc.nextLine();
        if(findForName(lakes,lakeName)!=-1){
            showLakes(editLake(lakes,findForName(lakes,lakeName)));
        }

    }
}
