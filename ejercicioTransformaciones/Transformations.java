/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioTransformaciones;

import examenTransformaciones.*;
import transformaciones.*;

/**
 *
 * @author shikami
 */
public class Transformations {
    
    
    //Identificadores de matrices
    private static double[][] mscale;
    private static double[][] mtranslate;
    private static double[][] mrotate;

    //Genera una matriz de Escalacion y es mulitplicada por el vector
    public static int[] transformScale(int vector[],int sx,int sy){

        //Init the scale matrix
        mscale = new double[3][3];
        mscale[0][0] = sx;
        mscale[1][1] = sy;
        mscale[2][2] = 1;

        return mmult(mscale, vector);

    }
    
    //Genera una matriz de traslacion y es mulitplicada por el vector
    public static int[] transformTranslate(int vector[], int tx, int ty){

        //Init the translate matrix
        mtranslate = new double[3][3];
        mtranslate[0][0] = 1;
        mtranslate[0][2] = tx;
        mtranslate[1][1] = 1;
        mtranslate[1][2] = ty;
        mtranslate[2][2] = 1;
        return mmult(mtranslate, vector);
    }
    
    //Genera una matriz de rotacion y es mulitplicada por el vector
    public static int[] transformRotate(int vector[], double angle){

        double ainr = Math.toRadians(angle);
        
        //Init the rotate matrix
        mrotate = new double[3][3];
        
        mrotate[0][0] = Math.cos(ainr);
        mrotate[0][1] = -Math.sin(ainr);
        mrotate[0][2] = 1;
        mrotate[1][0] = Math.sin(ainr);
        mrotate[1][1] = Math.cos(ainr);
        mrotate[1][2] = 1;
        mrotate[2][2] = 1;

        return mmult(mrotate,vector);
    }
    
    //Metodo para multiplicar una matriz por un vector
    public static int[] mmult(double matrix[][], int vector[]){
        
        int nvector[] = new int[vector.length];
        int res;
        
        for(int row=0;row<3;row++){
            res = 0;
            for(int column=0;column<3;column++){
                res += matrix[row][column] * vector[column];
            }
            nvector[row] = res;
        }
        
        return nvector;
    }
    
    //Metodo para imprimir una matriz en consola
    public static void printMatrix(int matrix[][]){
        for(int[] row : matrix){
            for(int i : row){
                System.out.print(i+"  |  ");
            }
            System.out.println("");
        }
        System.out.println("");   
    }
    
    //metodo para imprimir un vector en consola
    public static void printVector(int vector[]){
        for(int i : vector){
            System.out.print(i+"  |  ");
        }
        System.out.println("");   
    }
    
}



