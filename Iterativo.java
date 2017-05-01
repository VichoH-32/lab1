import java.util.Scanner;

public class Iterativo{

    Scanner sc=new Scanner(System.in);

    private int areaI;
    private char[][] mat;

    public Iterativo(){
        mat=new char[1][1];
        mat[0][0]='-';
        areaI=1;
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
        areaI=0;
    }
    public void setMaxAreaI(){
        for(int i=0; i<mat.length -1; i++){
            System.out.println(i);
            for(int j=0; j<mat[i].length - 2*i -1; j++){
                System.out.println(j);
                int x=i;
                int y=j;
                int areaAuxI=0;
                int c=0;
                int v=0;
                boolean bob=true;
                if( j%2==0){
                    while( (mat[x][y]=='-') && (bob=true) ){
                        if(x!=0){
                            if(v==(2*c)){
                                areaAuxI = areaAuxI + (2*c) +1;
                                y= y - (2*c);
                                x--;
                                c++;
                                v=0;
                            }else{
                                y++;
                                v++;
                            }
                        }else{
                            if(c!=0){
                                if(v== (2*c) ){
                                    areaAuxI= areaAuxI + (2*c) +1;
                                    bob=false;
                                }else{
                                    y++;
                                    v++;
                                }
                            }else{
                                areaAuxI=1;
                                bob=false;
                            }
                        }
                    }
                    if(areaAuxI>this.areaI){
                        this.areaI=areaAuxI;
                    }
                }else{
                    while(mat[x][y]=='-' && bob==true){
                        if(y!=1 && (y+v)!= mat[x].length -(2*c) -2){
                            if(v==(2*c)){
                                areaAuxI= areaAuxI + (2*c) +1;
                                y=y + (2*c);
                                x++;
                                c++;
                                v=0;
                            }else{
                                y--;
                                v++;
                            }
                        }else{
                            if(c!=0){
                                if(v==(2*c)){
                                    areaAuxI=areaAuxI + (2*c) +1;
                                    bob=false;
                                }else{
                                    y--;
                                    v++;
                                }
                            }else{
                                areaAuxI=1;
                                bob=false;
                            }
                        }
                    }
                    if(areaAuxI>this.areaI){
                        this.areaI=areaAuxI;
                    }
                }
            }
        }
    }

    public int getAreaI(){
        return this.areaI;
    }

    public void printMatI(){
        System.out.println("");//print de orden visual
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[i].length; j++){
                System.out.print(mat[i][j]);
            }System.out.println("");
        }
        System.out.println("");//print de orden visual
    }
}
