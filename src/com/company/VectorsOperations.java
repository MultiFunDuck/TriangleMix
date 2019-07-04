package com.company;
import com.company.Vector;
import java.lang.*;
import java.util.Scanner;

class VectorsOperations{
    public Vector SumOfVectors(Vector A, Vector B){
        Vector C = new Vector();
        C.xcoord = A.xcoord + B.xcoord;
        C.ycoord = A.ycoord + B.ycoord;
        return C;
    }
    public Vector DifOfVectors(Vector A,Vector B){
        Vector C = new Vector();
        C.xcoord = A.xcoord - B.xcoord;
        C.ycoord = A.ycoord - B.ycoord;
        return C;
    }
    public void MultiplyByR(Vector A, double num){
        A.xcoord = A.xcoord*num;
        A.ycoord = A.ycoord*num;
    }
    public double Normal(Vector A){
        double normal = Math.sqrt(A.xcoord*A.xcoord + A.ycoord*A.ycoord);
        return normal;
    }
    public double ScalarMultiply(Vector A, Vector B){
        double scalar = A.xcoord*B.xcoord +A.ycoord*B.ycoord;
        return scalar;
    }
    public double CosinOfAngle(Vector A,Vector B){
        com.company.VectorsOperations Operator = new com.company.VectorsOperations();
        double line1 = Operator.Normal(A);
        double line2 = Operator.Normal(B);
        double cosalfa;
        double scalar;
        if(line1*line2!=0) {
            scalar = ScalarMultiply(A, B);
            cosalfa = (scalar) / (line1 * line2);
        }
        else {
            System.out.println("Один из векторон нулевой 0\nДля таких случаем косинус угла равен 1");
            cosalfa = 1;
        }
        return cosalfa;
    }
}