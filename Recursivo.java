import java.util.Scanner;

public class Recursivo{
    Scanner sc=new Scanner(System.in);
    private int area;
    private char[][] mat;
    private int areaAux;

    //Crea una matriz vacia de n * 2n-1
    public Recursivo(int n){
        area=0;
        mat=new char[n][2*n -1];
    }

    //va llenado la matriz con los valores( '-' o '#' ) entregados fila por fila
    public void armarR(int i, int j, String letras){

        //si esta en la ultima fila va a pedir solo el ultimo valor
        if(i== mat.length -1){
            System.out.print("ingrese una combinacion de '-'s y '#'s de largo "+(mat[i].length - 2*i)+" ---> ");
            letras=sc.nextLine();
            mat[i][j]=letras.charAt(j);
        }else{

            //pide nuevos datos y llena el primer elemento de la fila actual
            if(j==0){
                System.out.print("ingrese una combinacion de '-'s y '#'s de largo "+(mat[i].length- 2*i )+" ---> ");
                letras=sc.nextLine();
                mat[i][j]=letras.charAt(j);
                armarR(i, j+1, letras);

            //llena el ultimo espacio de la fila actual para que en la siguiente recursión pida nuevos valores
            }else if(j==mat[i].length - 2*i -1){
                mat[i][j]=letras.charAt(j);
                armarR( i+1, 0, letras);

            //sigue llenando la matriz con los valores entregados en la recursión anterior
            }else{
                mat[i][j]=letras.charAt(j);
                armarR( i, j+1, letras );
            }
        }
    }

    //le da forma a la matriz al momento de printear
    public void printR(int i, int j){

        //si esta en la ultima fila va a printear el ultimo caracter
        if(i==mat.length -1){
            asistentePrintR(i);
            System.out.println(mat[i][j]);
        }else{

            //imprime el primer elemento de la fila actual
            if(j==0){
                asistentePrintR(i);
                System.out.print(mat[i][j]);
                printR( i, j+1);

            //imprime el ultimo elemento de la fila y avanza a la siguiente fila
            }else if(j==mat[i].length - 2*i -1){
                System.out.println(mat[i][j]);
                printR( i+1, 0);

            //imprime el elemento actual de la fila
            }else{
                System.out.print(mat[i][j]);
                printR( i, j+1);
            }
        }
    }

    //da orden al momento de imprimir por pantalla, es usado por el metodo "printR"
    public void asistentePrintR(int i){
        if(i==0){
            System.out.print("");
        }else{
            System.out.print(" ");
            asistentePrintR(i-1);
        }
    }public void setAreaR(int i, int j){//prueba de corrección
        setMaxAreaR( i, j);
    }

    //calcula el area del triangulo mas grande que encuentre
    public void setMaxAreaR( int i, int j){
        areaAux=0;//resetea el valor al momento de entrar otra vez

        //caso base si esta en el ultimo elemento de la fila actual
        if( j== mat[i].length - (2*i) -1){

            //si en el ultimo elemento de la ultima fila calcula el ultimo area y pregunta si es mayor que la actual
            if( i==mat.length -1){
                parR( i, j, 0);
                if(areaAux > this.area){
                    this.area = areaAux;
                }

            //si no es la ultima fila calcula un area, pregunta si es mayor que el actual y avanza en la siguiente recursión
            }else{
                parR( i, j, 0);
                if(areaAux > this.area){
                    this.area = areaAux;
                }
                setMaxAreaR( i+1, 0);
            }

        //
        }else{
            if( j%2==0){
                //areaAux=0;
                parR( i, j, 0);
                if(areaAux > this.area){
                    this.area= areaAux;
                }
                setMaxAreaR( i, j+1);
            }else{
                imparR( i, j , 0);
                if(areaAux > area){
                    this.area= areaAux;
                }
                setMaxAreaR( i, j+1);
            }
        }
    }
    public int getAreaR(){
        return this.area;
    }

    public void parR( int i, int j, int c){
        if(i==0){
            if(c==0){
                if(mat[i][j]!='-'){
                    this.areaAux=0;
                }else{
                    this.areaAux=1;
                }
            }else{
                this.areaAux= this.areaAux + pop(i,j,c,0);
            }
        }else{
            if(mat[i][j]!='-'){
                this.areaAux=0;
            }else{
                this.areaAux= this.areaAux + pop(i,j,c,0);
                parR( i-1, j+1, c+1);
            }
        }
    }
    public void imparR( int i, int j, int c){
        if( j-c==1 || j+c==mat[i].length - (2*i) -2){
            if( c==0){
                if(mat[i][j]!='-'){
                    areaAux=0;
                }else{
                    areaAux=1;
                }
            }else{
                areaAux= areaAux + pop( i, j, c, 0);
            }
        }else{
            if(mat[i][j]!=0){
                areaAux=0;
            }else{
                areaAux= areaAux + pop( i, j, c, 0);
                imparR( i+1, j-1, c+1);
            }
        }
    }

    public static int pop( int i, int j, int c, int v){
        if(v== 2*c ){
            if(mat[i][j]!='_'){
                return 0;
            }else{
                return (2*c +1);
            }
        }else{
            if(mat[i][j-c]!='-'){
                return 0;
            }else{
                return pop(i, j+1, c, v+1);
            }
        }
    }
}
