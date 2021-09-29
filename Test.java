public class Test {
    public static void justAFunction(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Yay! :D");
            justAFunction(n - 1);
        }
    }

    public static void main(String[] args) {
        justAFunction(4);
    }
}