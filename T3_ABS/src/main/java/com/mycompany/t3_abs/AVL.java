/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.t3_abs;

/**
 *
 * @author PC GAMER
 */
public class AVL {

    Element head;
    int heigth;
    AVL left;
    AVL right;
    AVL father;

    public AVL() {
        head = null;
        left = null;
        right = null;
        father = null;
    }

    public void insert(int key, String data) {
        Element a = new Element(key, data);
        if (head == null) {
            head = a;
            return;
        }
        if (head.key > a.key) {
            if (left == null) {
                left = new AVL();
            }
            left.insert(key, data);
            left.father = this;
        } else {
            if (right == null) {
                right = new AVL();
            }

            right.insert(key, data);
            right.father = this;
        }

        if (left != null && right != null && left.heigth > right.heigth) {
            heigth = left.heigth + 1;
        }
        if (left != null && right != null && left.heigth <= right.heigth) {
            heigth = right.heigth + 1;
        } else if (left != null) {
            heigth = left.heigth + 1;
        } else if (right != null) {
            heigth = right.heigth + 1;
        }
        checkBalance();
    }

    public void checkBalance() {
        int r;
        int l;
        if (right == null) {
            r = -1;
        } else {
            r = right.heigth;
        }
        if (left == null) {
            l = -1;
        } else {
            l = left.heigth;
        }
        if (r - l > 1 || r - l < -1) {
            Balance(r, l);

        }
    }

    public void Balance(int r, int l) {
        int r2;
        int l2;
        if (r - l > 1) {
            if (right.right == null) {
                r2 = -1;
            } else {
                r2 = right.right.heigth;
            }
            if (right.left == null) {
                l2 = -1;
            } else {
                l2 = right.left.heigth;
            }

            if (r2 > l2) {
                LR();
            } else {
                RLR();
            }
        } else {
            if (left.right == null) {
                r2 = -1;
            } else {
                r2 = left.right.heigth;
            }
            if (left.left == null) {
                l2 = -1;
            } else {
                l2 = left.left.heigth;
            }

            if (r2 < l2) {

                RR();
            } else {

                LRR();
            }
        }
    }

    public void LR() {
        int l1, r1, l2, r2;
        if (left == null) {
            l1 = -1;
        } else {
            l1 = left.heigth;
        }
        if (right.left == null) {
            r1 = -1;
        } else {
            r1 = right.left.heigth;
        }
        if (right.right.left == null) {
            l2 = -1;
        } else {
            l2 = right.right.left.heigth;
        }
        if (right.right.right == null) {
            r2 = -1;
        } else {
            r2 = right.right.right.heigth;
        }
        int aux = this.head.key;
        String aux2 = this.head.data;
        this.head.key = right.head.key;
        this.head.data = right.head.data;
        right.head.key = aux;
        right.head.data = aux2;
        AVL aux3 = left;
        left = right;
        right = left.right;
        right.father = this;
        left.right = left.left;
        left.left = aux3;
        if (l1 > r1) {
            left.heigth = l1 + 1;
        } else {
            left.heigth = r1 + 1;
        }
        if (l2 > r2) {
            right.heigth = l2 + 1;
        } else {
            right.heigth = r2 + 1;
        }
        if (left.heigth > right.heigth) {
            this.heigth = left.heigth + 1;
        } else {
            this.heigth = right.heigth + 1;
        }

    }

    public void RLR() {

        int l1, l2, r2;
        if (right.left.left == null) {
            l1 = -1;
        } else {
            l1 = right.left.left.heigth;
        }
        if (right.left.right == null) {
            l2 = -1;
        } else {
            l2 = right.left.right.heigth;
        }
        if (right.right == null) {
            r2 = -1;
        } else {
            r2 = right.right.heigth;
        }

        int aux = this.right.head.key;
        String aux2 = this.right.head.data;
        this.right.head.key = right.left.head.key;
        this.right.head.data = right.left.head.data;
        right.left.head.key = aux;
        right.left.head.data = aux2;
        AVL aux3 = right.right;
        right.right = right.left;
        right.right.right = aux3;
        right.right.left = right.left.right;
        if (right.right.left!= null) {
            right.right.left.father = right.right;
        }
        right.left = right.left.left;
        if (right.left != null) {
            right.left.father = right;
        }       
        if (l2 > r2) {
            right.right.heigth = l2 + 1;
        } else {
            right.right.heigth = r2 + 1;
        }
        if (right.right.heigth > l1) {
            right.heigth = right.right.heigth;
        } else {
            right.heigth = l1;
        }
        LR();

    }

    public void RR() {
        int l1, r1, l2, r2;
        if (right == null) {
            l1 = -1;
        } else {
            l1 = right.heigth;
        }
        if (left.right == null) {
            r1 = -1;
        } else {
            r1 = left.right.heigth;
        }
        if (left.left.right == null) {
            l2 = -1;
        } else {
            l2 = left.left.right.heigth;
        }
        if (left.left.left == null) {
            r2 = -1;
        } else {
            r2 = left.left.left.heigth;
        }
        int aux = this.head.key;
        String aux2 = this.head.data;
        this.head.key = left.head.key;
        this.head.data = left.head.data;
        left.head.key = aux;
        left.head.data = aux2;
        AVL aux3 = right;
        right = left;
        left = right.left;
        left.father = this;
        right.left = right.right;
        right.right = aux3;
        if (l1 > r1) {
            right.heigth = l1 + 1;
        } else {
            right.heigth = r1 + 1;
        }
        if (l2 > r2) {
            left.heigth = l2 + 1;
        } else {
            left.heigth = r2 + 1;
        }
        if (right.heigth > left.heigth) {
            this.heigth = right.heigth + 1;
        } else {
            this.heigth = left.heigth + 1;
        }
    }

    public void LRR() {
        int l1, l2, r2;
        if (left.right.right == null) {
            l1 = -1;
        } else {
            l1 = left.right.right.heigth;
        }
        if (left.right.left == null) {
            l2 = -1;
        } else {
            l2 = left.right.left.heigth;
        }
        if (left.left == null) {
            r2 = -1;
        } else {
            r2 = left.left.heigth;
        }
        int aux = this.left.head.key;
        String aux2 = this.left.head.data;
        this.left.head.key = left.right.head.key;
        this.left.head.data = left.right.head.data;
        left.right.head.key = aux;
        left.right.head.data = aux2;
        
        AVL aux3 = left.left;
        left.left = left.right;
        left.left.left = aux3;
        left.left.right = left.right.left;
        
        if (left.left.right != null) {
            left.left.right.father = left.left;
        }
        left.right = left.right.right;
        if (left.right != null) {
            left.right.father = left;
        }

        if (l2 > r2) {
            left.left.heigth = l2 + 1;
        } else {
            left.left.heigth = r2 + 1;
        }
        if (left.left.heigth > l1) {
            left.heigth = left.left.heigth;
        } else {
            left.heigth = l1;
        }
        RR();
    }

    public AVL find(int x) {
        if (head.key == x) {
            return this;
        } else {
            if (head.key < x) {
                if (right != null) {
                    return right.find(x);
                } else {
                    return null;
                }

            } else {
                if (left != null) {
                    return left.find(x);
                } else {
                    return null;
                }

            }
        }
    }
    public void findRange(int str,int end){
        AVL[] ar = new AVL[end-str+1];
        System.out.println("encontrados:");
        for (int i = str,j=0; i <= end; i++ ,j++) {
            ar[j] = find(i);
            if (ar[j] != null) {
                System.out.println(ar[i].head.key);
            }
        }
    }
    public void remove(int x) {
        if (head.key == x) {
            if (right == null && left == null) {
                if (father != null) {
                    if (father.left.head.key == head.key) {
                        father.left = null;
                    }else{
                        father.right = null;
                    }
                }else{
                    head = null; 
                }
                
            }
            else if (right == null) {
                head.key = left.head.key;
                head.data = left.head.data;
                right = left.right;
                left = left.left;
            } else if (left == null) {
                head.key = right.head.key;
                head.data = right.head.data;
                left = right.left;
                right = right.right;
            } else {
                AVL aux = left;
                while (aux.right != null) {
                    aux = aux.right;
                }
                head.key = aux.head.key;
                head.data = aux.head.data;
                aux.remove(aux.head.key);
            }
        }
        else if (head.key > x) {
            if (left != null) {
                if (left.left == null && left.right == null) {
                    left = null;
                } else {
                    left.remove(x);
                }
            }
        } else {
            if (right != null) {
                if (right.left == null && right.right == null) {
                    right = null;
                } else {
                    right.remove(x);
                }
            }

        }
        checkBalance();
    }
    public void heigth(int key){
        if (find(key) == null) {
            System.out.println("No existe");
        }else{
            System.out.println(find(key).heigth);
        }
        
    }
    
    public String toStriing(){
        String word = "";
        if (left == null && right == null) {
            word = "key: "+head.key+" item: "+head.data+" altura: "+heigth+"\n";
            return word;
        }
        if (left != null) {
            word = word + left.toStriing();
        }
        if (right != null) {
            word = word +right.toStriing();
        }
        word = word + "key: "+head.key+" item: "+head.data+" altura: "+heigth+"\n";
        return word;
    }
}
