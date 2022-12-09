package javaapplication10;

import java.util.Scanner;

public class JavaApplication10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AVL avl = new AVL();
        SkipList sl = new SkipList();
        int type;
        String opcion;
        type = Integer.parseInt(args[0]);
        opcion = args[1];
        if ("s".equals(opcion)) {
//            sc = new Scanner("C:\\Users\\PC GAMER\\Desktop\\A\\"+args[2]);
//            //leer archivo
//            String v = "";
//            if (args.length > 3) {
//                v = args[3];
//            }
//            while (true) {
//                int key;
//                String data, opt;
//                opt = sc.next();
//                key = sc.nextInt();
//                data = "0";
//                if (!opt.equals("d") && !opt.equals("f")) {
//                    data = sc.next();
//                }
//
//                if (opt.charAt(0) == '0' && data.charAt(0) == '0' && key == 0) {
//                    break;
//                }
//
//                if (type == 0) {
//                    switch (opt) {
//                        case "i":
//                            avl.insert(key, data);
//                            if ("v".equals(v)) {
//                                System.out.println("Insertado: " + key);
//                            }
//                            break;
//                        case "d":
//                            avl.remove(key);
//                            if (avl.head == null) {
//                                avl = new AVL();
//                            }
//                            if ("v".equals(v)) {
//                                System.out.println("removido: " + key);
//                            }
//                            break;
//                        case "f":
//                            AVL aux = avl.find(key);
//                            if (aux != null) {
//                                System.out.println(aux.head.data + ", " + aux.head.key);
//                            }
//                            if ("v".equals(v)) {
//                                System.out.println("fin");
//                            }
//                            break;
//                        case "r":
//                            avl.findRange(key, Integer.parseInt(data));
//                            if ("v".equals(v)) {
//                                System.out.println("fin");
//                            }
//                            break;
//                    }
//
//                } else {
//                    switch (opt) {
//                        case "i":
//                            sl.insert(key, data);
//                            if ("v".equals(v)) {
//                                System.out.println("Insertado: " + key);
//                            }
//                            break;
//                        case "d":
//                            sl.remove(key);
//                            if ("v".equals(v)) {
//                                System.out.println("removido: " + key);
//                            }
//                            break;
//                        case "f":
//                            if (sl.find(key).key == key) {
//                                System.out.println(sl.find(key).item);
//                            }
//                            if ("v".equals(v)) {
//                                System.out.println("fin");
//                            }
//                            break;
//                        case "r":
//                            sl.findRange(key, Integer.parseInt(data));
//                            if ("v".equals(v)) {
//                                System.out.println("fin");
//                            }
//                            break;
//                    }
//                }
//
//            }
        }

        if ("i".equals(opcion)) {
            String v = "";
            if (args.length > 2) {
                v = args[2];
            }
            while (true) {
                int key;
                String data, opt;
                opt = sc.next();
                key = sc.nextInt();
                data = "0";
                if (!opt.equals("d") && !opt.equals("f")) {
                    data = sc.next();
                }

                if (opt.charAt(0) == '0' && data.charAt(0) == '0' && key == 0) {
                    break;
                }

                if (type == 0) {
                    switch (opt) {
                        case "i":
                            avl.insert(key, data);
                            if ("v".equals(v)) {
                                System.out.println("Insertado: " + key);
                            }
                            break;
                        case "d":
                            avl.remove(key);
                            if (avl.head == null) {
                                avl = new AVL();
                            }
                            if ("v".equals(v)) {
                                System.out.println("removido: " + key);
                            }
                            break;
                        case "f":
                            AVL aux = avl.find(key);
                            if (aux != null) {
                                System.out.println(aux.head.data + ", " + aux.head.key);
                            }
                            if ("v".equals(v)) {
                                System.out.println("fin");
                            }
                            break;
                        case "r":
                            avl.findRange(key, Integer.parseInt(data));
                            if ("v".equals(v)) {
                                System.out.println("fin");
                            }
                            break;
                    }

                } else {
                    switch (opt) {
                        case "i":
                            sl.insert(key, data);
                            if ("v".equals(v)) {
                                System.out.println("Insertado: " + key);
                            }
                            break;
                        case "d":
                            sl.remove(key);
                            if ("v".equals(v)) {
                                System.out.println("removido: " + key);
                            }
                            break;
                        case "f":
                            if (sl.find(key).key == key) {
                                System.out.println(sl.find(key).item);
                            }
                            if ("v".equals(v)) {
                                System.out.println("fin");
                            }
                            break;
                        case "r":
                            sl.findRange(key, Integer.parseInt(data));
                            if ("v".equals(v)) {
                                System.out.println("fin");
                            }
                            break;
                    }
                }

            }
        }

    }

}
