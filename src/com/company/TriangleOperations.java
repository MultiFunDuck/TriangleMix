package com.company;

import java.util.Scanner;

class TriangleOperations{
    PointOperations PointOper = new PointOperations();
    Scanner scan = new Scanner(System.in);
    public void RotateTriangle(Triangle ABC){
        System.out.println("Введите координаты точки О, относительно которой будем вращать треугольник:");
        Scanner scan = new Scanner(System.in);
        double Ocoordx,Ocoordy;
        Ocoordx = scan.nextDouble();
        Ocoordy = scan.nextDouble();
        Point O = new Point();
        O.SetPoint(Ocoordx,Ocoordy);
        System.out.println("Введите угол, на который нужно повернуть треугольник (В градусах):");
        double angle = scan.nextDouble();
        angle = (angle*Math.PI)/180;
        PointOperations PointOper = new PointOperations();
        PointOper.RotatePoint(ABC.A,O,angle);
        PointOper.RotatePoint(ABC.B,O,angle);
        PointOper.RotatePoint(ABC.C,O,angle);
    }
    public void ChangeTrianglePoint(Triangle ABC) {
        System.out.println("Какую точку нужно изменить, A,B или C?(Введите 1,2 или 3 соответсвтенно");
        Scanner scan = new Scanner(System.in);
        int Pntchoose = scan.nextInt();
        System.out.println("Нужно повернуть точку, применить к ней вектор, или задать новые координаты?\n" +
                "Введите 1,2 или 3 соответсвенно :");
        int OptionChoose = scan.nextInt();
        Point BufPnt = new Point();
        switch (Pntchoose) {
            case (1):
                BufPnt = ABC.A;
            case (2):
                BufPnt = ABC.B;
            case (3):
                BufPnt = ABC.C;
        }
        switch (OptionChoose) {
            case (1):
                System.out.println("Введите координаты точки, относительно которо нужно вращать:");
                Point O = new Point();
                O.SetPoint();
                System.out.printf("Введите угол, на который нужно повернуть точку (В градусах):");
                double angle = (Math.PI / 180) * scan.nextDouble();
                PointOper.RotatePoint(BufPnt, O, angle);
                break;
            case (2):
                System.out.printf("Введите координаты вектора для преобразования: P = (");
                double xcoord = scan.nextDouble();
                System.out.printf(",");
                double ycoord = scan.nextDouble();
                System.out.printf(")");
                BufPnt.xcoord = xcoord + BufPnt.xcoord;
                BufPnt.ycoord = ycoord + BufPnt.ycoord;
                break;
            case (3):
                BufPnt.SetPoint();
                break;
        }
    }
    public void MoveTriangle(Triangle ABC) {
        System.out.println("Введите вектор, который нужно применить к треугольнику");
        System.out.println("Введите координаты вектора для преобразования: P = (");
        Scanner scan = new Scanner(System.in);
        double xcoord = scan.nextDouble();
        System.out.println(",");
        double ycoord = scan.nextDouble();
        System.out.println(")");
        PointOper.MovePointByVector(ABC.A, xcoord, ycoord);
        PointOper.MovePointByVector(ABC.B, xcoord, ycoord);
        PointOper.MovePointByVector(ABC.C, xcoord, ycoord);
    }
}
