import java.util.Scanner;

public class Iterativo{

    Scanner sc=new Scanner(System.in);

    private int area;
    private char[][] mat;
    private int contador;
    private int pivote;

    public Iterativo(){
        mat=new char[1][1];
        mat[0][0]='-';
        area=1;
    }

    public Iterativo(int n){
        mat=new char[n][2*n - 1];
        for(int i=0; i<mat.length; i++){
            System.out.print("ingrese una combinacion de '-'s y '#'s de largo "+(mat[i].length - 2*i )+" ---> ");
            String letrasI=sc.nextLine();
            for(int j=0; j<mat[i].length - 2*i; j++){
                mat[i][j]=letrasI.charAt(j);
            }
        }
        this.area=0;
        this.contador=0;
        this.pivote=0;
    }
    
    public void printMatI(){
        System.out.println("");//print de orden visual
        for(int i=0; i<mat.length; i++){
            for(int k=0; k<i+1; k++){
                System.out.print(" ");
            }
            for(int j=0; j<mat[i].length; j++){
                System.out.print(mat[i][j]);
            }System.out.println("");
        }
        System.out.println("");//print de orden visual
    }

    public int getArea(){
        par();
        impar();
        return this.area;
    }

    public void par(){
        int areaAuxI=0;
        for(int i=0; i<mat.length; i++){
            this.contador=0;
            for(int j=0; j<mat[i].length - 2*i ; j++){
                if(mat[i][j]=='-' && j%2==0 ){
                    this.pivote=j;
                    int n=i;
                    this.contador=0;
                    while(parCheck(n)){
                        areaAuxI+= 2*this.contador +1;
                        n--;
                        this.contador++;
                    }
                    if(areaAuxI>this.area){
                        this.area=areaAuxI;
                    }
                    areaAuxI=0;
                }
            }
        }
    }

    public void impar(){
        int areaAuxI=0;
        for(int i=0; i<mat.length; i++){
            //this.contador=0;
            for(int j=0; j<mat[i].length - 2*i ; j++){
                if(mat[i][j]=='-' && j%2==1 ){
                    this.pivote=j;
                    int n=i;
                    this.contador=0;
                    while(imparCheck(n)){
                        areaAuxI+= 2*this.contador +1;
                        n++;
                        this.contador++;
                    }
                    if(areaAuxI>this.area){
                        this.area=areaAuxI;
                    }
                    areaAuxI=0;
                }
            }
        }
    }

    public boolean parCheck(int n){
        if(n>=0){
            for(int v=0; v<= 2*this.contador; v++){
                if(mat[n][this.pivote + v]!='-'){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean imparCheck(int n){
        if( (this.pivote<=mat[n].length - 2*n -2) && (this.pivote - 2*this.contador>=1) ){
            for(int v=0; v<= 2*this.contador; v++){
                if(mat[n][this.pivote - v]!='-'){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
