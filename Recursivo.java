import java.util.Scanner;

public class Recursivo{
    Scanner sc=new Scanner(System.in);
    private int area;
    private char[][] mat;
    private int areaAux;
    private boolean bob;

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
                System.out.print("ingrese una combinacion de '-'s y '#'s de largo "+(mat[i].length - 2*i )+" ---> ");
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
    }
    //public void setAreaR(int i, int j){//prueba de corrección
        //setMaxAreaR( i, j);
    //}

    //calcula el area del triangulo mas grande que encuentre
    public void setMaxAreaR( int i, int j){
        areaAux=0;//resetea el valor al momento de entrar otra vez

        //caso base si esta en el ultimo elemento de la fila actual
        if( j== mat[i].length - (2*i) -1){

            //si en el ultimo elemento de la ultima fila calcula el ultimo area y pregunta si es mayor que la actual
            if( i==mat.length -1){
                parR( i, j, 0);
                if(areaAux > this.area){
                    this.area = areaAux;//termina la recursión
                }

            //si no es la ultima fila calcula un area
            }else{
                parR( i, j, 0);
                if(areaAux > this.area){//pregunta si el area calculada es mayor que la actual
                    this.area = areaAux;
                }
                setMaxAreaR( i+1, 0);// avanza a la siguiente fila
            }
        }else{

            //revisa si j es par o impar para entrar a su respectivo metodo("par()" o "impar()")
            if( j%2==0){//si es par
                parR( i, j, 0);
                System.out.println("salio de parR");////////////
                if(areaAux > this.area){//pregunta si el area calculada es mayor que la actual
                    this.area= areaAux;
                }
                setMaxAreaR( i, j+1); //avanza al siguiente elemento
            }else{
                imparR( i, j , 0);//si es impar
                if(areaAux > area){//pregunta si el area calculada es mayor a la actual
                    this.area= areaAux;
                }
                setMaxAreaR( i, j+1); //avanza al siguiente elemento
            }
        }
    }
    public int getAreaR(){
        return this.area;
    }

    //metodo si el elemento actual es par, va sumando area hacia arriba si se cumplen las condiciones
    public void parR( int i, int j, int c){
        this.bob=true;//booleano("bob") para revisar si entra o no a la siguiente recurción
        if(i==0){//si esta en la primera fila no seguirá sumando hacia arriba
            if(c==0){//si contador("c") es 0 significa que empezó a revisar en la primera fila
                if(mat[i][j]=='-'){//reemplaza areaAux con 1 o 0 si el elemento es "-" o "#" respectivamente
                    areaAux=1;
                }else{
                    areaAux=0;
                }
            }else{//si c no es 0 significa que empezó a contar desde una fila superior
                pop(i,j,c,0);//llama al metodo que revisa si hay que agregar area o no
            }
        }else{
            if(mat[i][j]=='-'){//revisa si el elemento actual es "-" o "#" , si es "#" terminara el metodo
                pop( i, j, c, 0);
                if( bob ==true){//si bob sigue siendo true para ver si entra a la siguiente recurción
                    parR( i-1, j+1, c+1);
                }
            }
        }
    }
    public void imparR( int i, int j, int c){
        this.bob=true;
        if( j-c==1 || j+c==mat[i].length - (2*i) -2){
            if( c==0){
                if(mat[i][j]=='-'){
                    areaAux=1;
                }else{
                    areaAux=0;
                }
            }else{
                pop( i, j, c, 0);
            }
        }else{
            if(mat[i][j]=='-'){
                pop( i, j, c, 0);
                if(bob==true){
                    imparR( i+1, j-1, c+1);
                }
            }
        }
    }

    public void pop( int i, int j, int c, int v){
        System.out.println("si entro"+(c+1)+"veces");/////////////////////////////
        if(v== 2*c ){
            if(mat[i][j]=='_'){
                areaAux=areaAux + 2*c +1 ;
            }else{
                this.bob=false;
            }
        }else{
            if(mat[i][j-c]=='-'){
                pop( i, j+1, c, v+1);
            }else{
                this.bob=false;
            }
        }
    }
}
