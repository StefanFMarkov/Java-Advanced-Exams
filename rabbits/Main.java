package rabbits;

public class Main {
    public static void main(String[] args) {

        Rabbit rabbit = new Rabbit("Az","Homan");

        Cage cage = new Cage("cell",1);

        cage.add(rabbit);
    }
}
