package jcode.com.lambdas;

public class ScopingRule {

    Runnable r1 = () -> {System.out.println(this);};

    public String toString(){
        return "Hello World";
    }

    public static void main(String... args){
        new ScopingRule().r1.run();
    }
}
