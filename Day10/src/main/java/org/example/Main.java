package org.example;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Good morning!");
        ostrich o=new ostrich();
        o.move();
        parrot p= new parrot();
        p.move();
        Penguin pe=new Penguin();
        pe.move();
    }
}
class Bird
{
    public void move()  {
        System.out.println("its moving");
    }

}
class ostrich extends Bird{
    public void move()  {
        System.out.println("Moving......");
    }
}
class parrot extends Bird{
    public void move(){
        System.out.println("Flying.......");
    }
}
class Penguin extends Bird{
    public void move()
    {
        System.out.println("Walking.........");
    }
}
