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
            for(int j=0; j<mat[i].length - 2*i -1; j++){
                int areaAuxI=0;
                int c=0;
                int v=0;
                boolean bob=true;
                if(j%2==0){
                    while(bob=true && v<= 2*c ){
                        if(i==0){
                            if(c==0){
                                if(mat[0][j]=='-'){
                                    areaAuxI=1;
                                }else{
                                    areaAuxI=0;
                                }
                            }else{
                                if(v== 2*c){
                                    bob=false;
                                    areaAuxI=areaAuxI + 2*c +1;
                                }else{
                                    j++;
                                    v++;
                                }
                            }
                        }else{
                            if(mat[j][i]!='-'){
                                bob=false;
                            }else{
                                if(v== 2*c){
                                    i--;
                                    j= j - 2*c ;
                                    areaAuxI= areaAuxI + 2*c +1;
                                    c++;
                                    v=0;
                                }else{
                                    j++;
                                    v++;
                                }
                            }
                        }
                    }
                    if(areaAuxI>this.areaI){
                        this.areaI=areaAuxI;
                    }
                }else{
                    while(bob=true && v<= 2*c ){
                        if( j- (2*c) ==1 || j== mat[i].length - 2*i -2 -v ){
                            if(mat[i][j]!='-'){
                                bob=false;
                            }else{
                                if(v== 2*c){
                                    bob=false;
                                    areaAuxI=areaAuxI + 2*c +1;
                                }else{
                                    j--;
                                    v++;
                                }
                            }
                        }else{
                            if(mat[i][j]!='-'){
                                bob=false;
                            }else{
                                if(v== 2*c ){
                                    i++;
                                    j=j + 2*c ;
                                    areaAuxI=areaAuxI + 2*c +1;
                                    c++;
                                    v=0;
                                }
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
                System.out.print(mat[i][j]+" ");
            }System.out.println("");
        }
        System.out.println("");//print de orden visual
    }
}
