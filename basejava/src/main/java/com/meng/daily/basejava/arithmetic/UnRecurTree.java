package com.meng.daily.basejava.arithmetic;


import java.util.Stack;

/**
 * 二叉树的非递归遍历
 *
 * @author 梦醉
 * @date 2019/8/28--17:43
 */
public class UnRecurTree {
    /**
     * 前序遍历
     */
    public void preOrderUnRecur(Node head) {
        System.out.println("pre-order");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.value + " ");
                if(head.right!=null){
                    stack.push(head.right);
                }
                if(head.left!=null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println("end");
    }
    public void inOrderUnRecur(Node head){
        System.out.println("in-order");
        if(head != null){
            Stack<Node> stack = new Stack();
            while (!stack.isEmpty()||head==null){
                if(head!=null){
                    stack.push(head.left);
                    head = head.left;
                }else{
                    head = stack.pop();
                    System.out.println(head.value+" ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }
    public void posOrderUnRecer(Node head){
        System.out.println("pos-Order");
        if(head != null){
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();
            s1.push(head);
            while (!s1.isEmpty()){
                head = s1.pop();
                s2.push(head);
                if(head.left!=null){
                    s1.push(head.left);
                }
                if(head.right!=null){
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()){
                System.out.println(s2.pop()+" ");
            }
        }
        System.out.println("end");
    }
}
