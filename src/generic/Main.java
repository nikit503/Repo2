package generic;

public class Main {


    public static void main(String[] args) {
        String s = "awdw";
        test(5);

//        GenBin<String> stringGenBin = new GenBin<>();
//        stringGenBin.setVar("Vacy");
//
//        GenBin<Integer> integerGenBin = new GenBin<>();
//        integerGenBin.setVar(123);

        GenBin<DbLoader> genBin = new GenBin<>();

        genBin.setVar(new DbLoader());
        genBin.load();
        genBin.upd();
//        GenBin[] genBins = new GenBin[2];
//
//        genBins[0] = stringGenBin;
//        genBins[1] = integerGenBin;
//
//        printAll(genBins);

    }

    private static void printAll(GenBin[] genBins){
        System.out.println("Start printing");
        for(GenBin genBin:genBins){
            System.out.println(genBin.toString());
        }
    }

    static <T> void test(T t){
        System.out.println(t.toString());
    }

}
class Functor {
    void loadData(){
        System.out.println("Data loaded!");
    }
}

class DbLoader extends Functor{

    @Override
    void loadData() {
        System.out.println("Db data loaded!");
    }

    void updateDb(){
        System.out.println("Db updated!");
    }
}
class Updater extends Functor {
    void updateData(){
        System.out.println("Data updated!");
    }
}
class GenBin<Y extends DbLoader> {
    private Y var;

    public Y getVar() {
        return var;
    }

    public void setVar(Y var) {
        this.var = var;
    }

    @Override
    public String toString() {
        return "GenBin{" +
                "var=" + var +
                '}';
    }

    void load(){
        var.loadData();
    }

    void upd(){
        var.updateDb();
    }

}

