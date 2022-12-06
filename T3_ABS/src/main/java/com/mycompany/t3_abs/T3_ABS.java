/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.t3_abs;

/**
 *
 * @author PC GAMER
 */
public class T3_ABS {

    public static void main(String[] args) {
        AVL nw = new AVL();
//        nw.insert(4, "key3");
        nw.insert(3, "key");
        nw.insert(4, "idk");
        nw.insert(1, "key1");
        nw.insert(2, "key2");
        nw.insert(0, "nada");
//        nw.insert(5, "key4");
//        nw.insert(7, "idk");
//        nw.insert(6, "desbalance");
//        System.out.println(nw.left.heigth);

        //buscar
        if (nw.find(6)!= null) {
            System.out.println(nw.find(6).head.key);
        }else{
            System.out.println("no esta");
        }
        
        
        //remover
        nw.remove(3);
        if (nw.head == null) {
            nw = new AVL();
        }else{
            System.out.println(nw.head.key);
        }
        
    }
}
