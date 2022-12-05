package javaapplication10;

import java.util.Scanner;

public class JavaApplication10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, key, begin, end;
        String opcion, item;
        while (true) {
            System.out.print("\nOpcion 0: AVL\nOpcion 1: SkipList\nIngrese opcion: ");
            m = sc.nextInt();
            if (m == 0) {

            } else if (m == 1) {
                SkipList sl = new SkipList();
                while (true) {
                    System.out.print("\nOpcion i: insert\nOpcion d: remove\nOpcion f: find\nOpcion r: findRange\nOpcion h: height\nOpcion s: toStrig\nIngrese opcion: ");
                    opcion = sc.next(); //cambiar
                    if (opcion == "i\n") {
                        System.out.print("Ingrese key: ");
                        key = sc.nextInt();
                        System.out.print("Ingrese item: ");
                        item = sc.next();
                        sl.insert(key, item);
                    } else if (opcion == "d") {
                        System.out.print("Ingrese key: ");
                        key = sc.nextInt();
                        sl.remove(key);
                    } else if (opcion == "f") {
                        System.out.print("Ingrese key: ");
                        key = sc.nextInt();
                        if(sl.find(key).key == key){
                            System.out.println(sl.find(key).item);
                        }
                    } else if (opcion == "r") {
                        System.out.print("Ingrese begin: ");
                        begin = sc.nextInt();
                        System.out.print("Ingrese end: ");
                        end = sc.nextInt();
                        sl.findRange(begin, end);
                    } else if (opcion == "h") {
                        System.out.print("Ingrese key: ");
                        key = sc.nextInt();
                        System.out.println(sl.height(key));
                    } else if (opcion == "s") {
                        System.out.println(sl.toString());
                    } else {
                        break;
                    }
                }
            } else {
                break;
            }
        }

//        SkipList sl = new SkipList();
//        
//        sl.insert(6, "");
//        sl.insert(15, "");
//        sl.insert(4, "");
//        
//        System.out.println(sl.toString());
//        
//        sl.remove(4);
//        System.out.println(sl.toString());
    }

}
