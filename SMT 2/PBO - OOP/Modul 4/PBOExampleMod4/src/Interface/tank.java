package Interface;

public class tank implements fireable, moveable{

    @Override
    public void shot(){
        System.out.println("tank menembak");
    }

    @Override
    public void move(){
        System.out.println("tank bergerak menyerang");
    }

}