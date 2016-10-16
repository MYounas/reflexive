/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reflexive;

import java.util.Scanner;

/**
 *
 * @author MY
 */
public class Reflexive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in=new Scanner(System.in);int row=0,col=0;int i,j,k;
        System.out.println("Enter dimension of matrix(must b square matrix):");
        row=in.nextInt();
        col=in.nextInt();
        int[][] mat=new int[row][col];
        System.out.println("Enter elements in matrix format");
        for(i=0;i<row;i++){
            for(j=0;j<col;j++){
                mat[i][j]=in.nextInt();
            }
        }
        
        //check reflexive
        int reflex=reflexive(mat, row);
        
        if(reflex==1)
            System.out.println("Given matrix is reflexive");
        else
            System.out.println("Given matrix is irreflexive");
        
        //check symmetric
        int symmet=symmteric(mat, row);
        
        if(symmet==0)
            System.out.println("Given matrix is antisymmteric");
        if(symmet==1)
            System.out.println("Given matrix is symmetric");
        
        int trans=transitive(mat, row);
        
        if(trans==1)
            System.out.println("Given matrix is Transitive");
        if(trans==0)
            System.out.println("Given matrix is not Transitive");
        
    }
    
    static int reflexive(int[][] m,int r){
        int ref=1;
        for(int i=0;i<r;i++){
            if(m[i][i]!=1){
                ref=0;
            }
        }
        return ref;
    }
    
    static int symmteric(int[][] m,int r){
        int sym=1;int i,j,k,count1=0,count2=0,count3=0;
        for(i=0;i<r;i++){
            for(j=0;j<r;j++){
                if(m[i][j]==1){
                    count1++;
                    if(m[j][i]!=1){
                        count2++;
                    }
                    else{
                        count3++;
                    }
                }
            }
        }
        if(count1==count2) sym=0;
        if(count1==count3) sym=1;
        return sym;
    }
    
    static int transitive(int[][] m,int r){
        int i,j,k,l,transt=1;
        for(i=0;i<r;i++){
            for(j=0;j<r;j++){
                if(m[i][j]==1){
                    for(k=0;k<r;k++){
                        if(m[j][k]==1){
                            if(m[i][k]==1){
                                transt=1;
                            }
                            else{
                                transt=0;
                                break;
                            }
                        }
                        else{
                            transt=1;
                        }
                    }
                }
                if(transt==0)
                    break;
            }
                if(transt==0)
                    break;
        }
        return transt;
    }
    
    
    
}
