package patterns.builder;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Builder");

        Tank tank = new Tank.TankBuilder("Mark1")
                .setHeight(2000)
                .setLenhgt(1000)
//                .setWeight(20)
                .build();

        tank.printAll();
    }
}

class Tank{
    private String mark;
    private int weight;
    private int lenhgt;
    private int height;

    Tank(TankBuilder tankBuilder){
        this.mark = tankBuilder.mark;
        this.height = tankBuilder.height;
        this.lenhgt = tankBuilder.lenhgt;
        this.weight = tankBuilder.weight;
    }
    public void printAll(){
        System.out.println("Mark: "+mark);
        System.out.println("weight: "+weight);
        System.out.println("lenhgt: "+lenhgt);
        System.out.println("height: "+height);
    }
    static class TankBuilder{
        private String mark;
        private int weight = 10;
        private int lenhgt;
        private int height;

        TankBuilder(String mark){
            this.mark = mark;
        }
        public TankBuilder setHeight(int height) {
            this.height = height;
            return this;
        }
        public TankBuilder setLenhgt(int lenhgt) {
            this.lenhgt = lenhgt;
            return this;
        }
        public TankBuilder setMark(String mark) {
            this.mark = mark;
            return this;
        }
        public TankBuilder setWeight(int weight) {
            this.weight = weight;
            return this;
        }
        public Tank build(){
            return new Tank(this);
        }
    }
}