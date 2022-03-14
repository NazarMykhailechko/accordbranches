package app;

public class Test {

    public static void main(String[] args) {
        String target = new String(new char[2]).replace('\0', '0'); //Create a string with difficulty * "0"
        System.out.println(target);
    }

}
