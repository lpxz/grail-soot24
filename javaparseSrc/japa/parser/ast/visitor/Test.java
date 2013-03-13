package japa.parser.ast.visitor;

public class Test {

    public static void main(String[] args) {
        System.out.println("begin here");
        if ("xxx".length() > 2) {
            System.out.println("xxx");
        } else {
            System.out.println("x");
        }
        System.out.println("endhere");
        if ("yyy".length() > 2) {
            System.out.println("yyy");
        } else {
            System.out.println("y");
        }
    }
}
