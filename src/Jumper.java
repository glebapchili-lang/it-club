public class Jumper {
    int height;

 public void jump() {
     height += 2;
 }
    public void bigJump() {
        height += 100;
    }
    public double sqr(double x){
      return x*x;
    }
    public static void main(String[] args) {

      Jumper jumper = new Jumper();
      Jumper jumper2 = new Jumper();
      jumper.height = 0;
      jumper.bigJump();
        System.out.println(jumper.height);

    }
}
