package com.company;
import java.lang.*;
import java.util.Scanner;

class Point{
    double xcoord,ycoord;
    public void SetPoint(){
        System.out.printf("Введите координаты задаваемой точки:");
        Scanner scan = new Scanner(System.in);
        double xcoord,ycoord;
        xcoord = scan.nextDouble();
        ycoord = scan.nextDouble();
        this.xcoord = xcoord;
        this.ycoord = ycoord;
    }
    public void SetPoint(double xcoord, double ycoord){
        this.xcoord = xcoord;
        this.ycoord = ycoord;
    }
}

class PointOperations{
    public void RotatePoint(Point P, Point O,double angle){
        P.xcoord = P.xcoord - O.xcoord;
        P.ycoord = P.ycoord - O.ycoord;
        double Px = P.xcoord;
        double Py = P.ycoord;
        P.xcoord = Px*Math.cos(angle)-Py*Math.sin(angle);
        P.ycoord = Px*Math.sin(angle)+ Py*Math.cos(angle);
        P.xcoord = P.xcoord + O.xcoord;
        P.ycoord = P.ycoord + O.ycoord;
    }
    public void MovePointByVector(Point P,double xcoord, double ycoord){
        P.xcoord = P.xcoord +xcoord;
        P.ycoord = P.ycoord +ycoord;
    }
}

class Vector{
    double xcoord,ycoord;
    public void SetVectorByCoords(double xcoord, double ycoord) {
        Vector A = new Vector();
        A.xcoord = xcoord;
        A.ycoord = ycoord;
    }
    public void SetVectorAsPointDiff(Point a, Point b){
        Vector A = new Vector();
        this.xcoord = b.xcoord - a.xcoord;
        this.ycoord = b.ycoord - a.ycoord;
    }
}

class Triangle{
    Triangle ABC;
    Point A,B,C;
    Vector AB,BC,CA;
    public Triangle(){
        A = new Point();
        B = new Point();
        C = new Point();
        System.out.println("Задать треугольник по умолчанию, или воодом координат?");
        System.out.println("Если по умолчанию введите 1, координатами - 2");
        Scanner scan = new Scanner(System.in);
        int flag = scan.nextInt();
        if(flag == 1){
            A.SetPoint(0,0);
            B.SetPoint(0,1);
            C.SetPoint(1,0);
        }
        else{
            double xcoord,ycoord;
            System.out.println("Введите координаты точки А:");
            xcoord = scan.nextDouble();
            ycoord = scan.nextDouble();
            A.SetPoint(xcoord,ycoord);
            System.out.println("Введите координаты точки B:");
            xcoord = scan.nextDouble();
            ycoord = scan.nextDouble();
            B.SetPoint(xcoord,ycoord);
            System.out.println("Введите координаты точки C:");
            xcoord = scan.nextDouble();
            ycoord = scan.nextDouble();
            C.SetPoint(xcoord,ycoord);
        }
    }
    public Triangle(Point A,Point B,Point C){
        AB = new Vector();
        BC = new Vector();
        CA = new Vector();
        AB.SetVectorAsPointDiff(A,B);
        BC.SetVectorAsPointDiff(B,C);
        CA.SetVectorAsPointDiff(C,A);
    }
    public double FindPerimeter(){
        AB = new Vector();
        BC = new Vector();
        CA = new Vector();
        AB.SetVectorAsPointDiff(A,B);
        BC.SetVectorAsPointDiff(B,C);
        CA.SetVectorAsPointDiff(C,A);
        VectorsOperations Operator = new VectorsOperations();
        double Perimeter = Operator.Normal(AB) + Operator.Normal(BC) + Operator.Normal(CA);
        return Perimeter;
    }
    public double FindArea(){
        AB = new Vector();
        CA = new Vector();
        AB.SetVectorAsPointDiff(this.A,this.B);
        CA.SetVectorAsPointDiff(this.C,this.A);
        VectorsOperations Operator = new VectorsOperations();
        Operator.MultiplyByR(CA,-1);
        Vector AC = CA;
        double Area = Operator.Normal(AB)*Operator.Normal(AC)*
                Math.sqrt(1-(Operator.CosinOfAngle(AB,AC))*(Operator.CosinOfAngle(AB,AC)));
        Operator.MultiplyByR(CA,-1);
        return Area/2;
    }
}

class TrianglePrintOperator{
       public void PrintArea( Triangle ABC){
        System.out.println("Площадь треугольника равна:" + ABC.FindArea());
    }
    public void PrintPerimeter( Triangle ABC){
        System.out.println("Периметр треугольника равен:"+ ABC.FindPerimeter());
    }
    public void PrintCoords( Triangle ABC){
        System.out.println("Координаты точка треуголника равны:");
        System.out.printf("A : %4f %4f\n" , ABC.A.xcoord, ABC.A.ycoord);
        System.out.printf("B : %4f %4f\n" , ABC.B.xcoord, ABC.B.ycoord);
        System.out.printf("C : %4f %4f\n" , ABC.C.xcoord, ABC.C.ycoord);
    }
}

public class main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Triangle ABC = new Triangle();
        TriangleOperations Treop = new TriangleOperations();
        TrianglePrintOperator TrePrint = new TrianglePrintOperator();
        System.out.printf("Если нужно вывести данные о треугольнике, нажмите 1.\n" +
                " Если нужно преобразовать треугольник, нажмите 2.\n" +
                "Если нужно выйти, нажмите 0: ");
        int key = scan.nextInt();
        do{
            int choose;
            switch(key){
                case(1):
                    do {
                        System.out.println("1-Вывести координаты\n2-Вывести площадь\n3-Вывести перимет\n0-Выход");
                        System.out.printf("Введите ваш выбор: ");
                        choose = scan.nextInt();
                        switch(choose){
                            case(0): break;
                            case(1): TrePrint.PrintCoords(ABC); break;
                            case(2): TrePrint.PrintArea(ABC); break;
                            case(3): TrePrint.PrintPerimeter(ABC); break;
                        }
                    }while(choose!=0);
                    break;
                case(2):
                    do {
                        System.out.println("1-Повернуть треугольник\n2-Передвинуть треугольник\n3-Изменить координаты точек\n0-Выход");
                        System.out.printf("Введите ваш выбор: ");
                        choose = scan.nextInt();
                        switch(choose) {
                            case (0):
                                break;
                            case (1):
                                Treop.RotateTriangle(ABC);
                                break;
                            case (2):
                                Treop.MoveTriangle(ABC);
                                break;
                            case (3):
                                Treop.ChangeTrianglePoint(ABC);
                                break;
                        }
                    }while(choose!=0);
                    break;
            }
            System.out.printf("Если нужно вывести данные о треугольнике, нажмите 1.\n" +
                    " Если нужно преобразовать трегольник, нажмите 2.\n" +
                    "Если нужно выйти, нажмите 0 : ");
            key = scan.nextInt();
        }while(key!=0);
    }
}