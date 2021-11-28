package Interface;

public class Main {
    public static void main(String[] args) {
        moveable m = new tank();
        fireable f = new pistol();

        m.move();
        f.shot();
        f = (fireable) m;
        f.shot();
    }
}
