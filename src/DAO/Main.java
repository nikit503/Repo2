package DAO;

public class Main {
    public static void main(String[] args) {

        MyDAO dao = MyDaoFactory.getDAO("Property");
        if (dao != null) {
            dao.loadData();
        }

    }
}

interface MyDAO{
    void loadData();
}
class PropertyLoader implements MyDAO{

    @Override
    public void loadData() {
        System.out.println("Load from property file");
    }
}
class JsonLoader implements MyDAO{

    @Override
    public void loadData() {
        System.out.println("Load from JSON file");
    }
    public void test(){
        System.out.println("Make some tests");
    }
}
class MyDaoFactory{
    static MyDAO getDAO(String type){
        switch (type) {
            case "Property":
                return new PropertyLoader();
            case "JSON":
                return new JsonLoader();
        }
        return null;
    }
}