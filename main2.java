import java.util.Scanner;

public class main2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        /*TIte tri1=new TIte();
        tri1.printMatI();
        System.out.println("el area del triangulo mas grande sin pintar es "+tri1.getAreaI() );

        System.out.print("introducir largo del triangulo ---> ");
        int n = sc.nextInt();
        TIte tri3=new TIte(n);
        tri3.printMatI();
        System.out.println("el area del triangulo mas grande sin pintar es "+tri3.getAreaI() );*/
        System.out.print("ingrese la cantidad de filas ---> ");
        int n=sc.nextInt();
        Recursivo tri4=new Recursivo(n);
        tri4.armarR(0,0,"noSeLlama");
        tri4.printR(0,0);
        tri4.setAreaR(0,0);
        System.out.println("El triangulo mas grande es de Area "+tri4.getAreaR());
    }
}