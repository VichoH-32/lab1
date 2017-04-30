import java.util.Scanner;

public class Iterativo{

    Scanner sc=new Scanner(System.in);

    private int area;
    private char[][] mat;

    public Iterativo(){
        mat=new char[1][1];
        mat[0][0]='-';
        area=1;
    }

    public Iterativo(int n){
        mat=new char[n][2*n - 1];

        for(int i=0; i<mat.length; i++){
            if(i==0){
                System.out.print("ingrese '#' o '-' para pintarlo o no y luego ENTER: ");
            }else{
                System.out.print("ingrese la siguiente fila: ");
            }

            for(int j=0; j<mat[i].length - 2*i; j++){
                char resp=sc.next().charAt(0);
                if( resp=='#'){
                    mat[i][j]='#';
                }else{
                    mat[i][j]='-';
                }
            }
        }
        area=0;
    }

    public int getAreaI1(){
        return area;
    }

    public void printMatI1(){
        System.out.println("");//print de orden visual
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[i].length; j++){
                System.out.print(mat[i][j]+" ");
            }System.out.println("");
        }
        System.out.println("");//print de orden visual
    }
}
