package hello.core.singleton;

public class StatefulService {
//    private int price; //공유

    public int order(String name, int price) { //해결법
//    public void order(String name, int price) { //공유
        System.out.println("name = " + name + " price = " + price);
//        this.price = price; /공유
        return price; //해결법
    }

   /* public int getPrice() {
        return price;
    }*/ //공유
}
