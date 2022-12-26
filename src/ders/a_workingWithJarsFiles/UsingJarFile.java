package ders.a_workingWithJarsFiles;

import main.RationalNumber;

public class UsingJarFile {
    public static void main(String[] args) {
        RationalNumber sayi1=new RationalNumber(8,10);
        RationalNumber sayi2=new RationalNumber(220,7);

        RationalNumber toplam=sayi1.add(sayi2);
        System.out.println(toplam);
    }
}
