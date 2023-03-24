package it.codicelezione.lezione01.procedural;

public class Procedural {

    private int myNum;
    public Procedural(int n){
        this.myNum = n;
    }
    

    public void run(){
        try {
            Thread.sleep((int) Math.random()*100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Procedural a = new Procedural(1);
        Procedural b = new Procedural(2);
        a.run();
        b.run();
        
        Thread.sleep((int) (Math.random()*100));
			System.out.println("In main");
			Thread.sleep((int) (Math.random()*100));
			System.out.println("In main");
    }
}
