package javaapplication10;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class JavaApplication10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m=0, key, begin, end;
        String opcion="", item;
        while (m!=2) {
            System.out.print("\nOpcion 0: AVL\nOpcion 1: SkipList\nOpcion 2: Salir\nIngrese opcion: ");
            m = sc.nextInt();
            if (m == 0) {

            } else if (m == 1) {
                SkipList sl = new SkipList();
                while (!"e".equals(opcion)) {
                    System.out.print("\nOpcion i: insert\nOpcion d: remove\nOpcion f: find\nOpcion r: findRange\nOpcion h: height\nOpcion s: toStrig\nOpcion e: exit\nIngrese opcion: ");
                    opcion = sc.next(); //cambiar
                    if ("i".equals(opcion)) {
                        System.out.print("Ingrese key: ");
                        key = sc.nextInt();
                        System.out.print("Ingrese item: ");
                        item = sc.next();
                        sl.insert(key, item);
                    } else if ("d".equals(opcion)) {
                        System.out.print("Ingrese key: ");
                        key = sc.nextInt();
                        sl.remove(key);
                    } else if ("f".equals(opcion)) {
                        System.out.print("Ingrese key: ");
                        key = sc.nextInt();
                        if(sl.find(key).key == key){
                            System.out.println(sl.find(key).item);
                        }
                    } else if ("r".equals(opcion)) {
                        System.out.print("Ingrese begin: ");
                        begin = sc.nextInt();
                        System.out.print("Ingrese end: ");
                        end = sc.nextInt();
                        sl.findRange(begin, end);
                    } else if ("h".equals(opcion)) {
                        System.out.print("Ingrese key: ");
                        key = sc.nextInt();
                        System.out.println(sl.height(key));
                    } else if ("s".equals(opcion)) {
                        System.out.println(sl.toString());
                    } else if("e".equals(opcion)){
                    }else{
                        JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                    }
                }
            } else if(m == 2){
            }else{
                JOptionPane.showMessageDialog(null, "Opcion incorrecta");
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
