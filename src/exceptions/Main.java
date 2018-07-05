package exceptions;

import java.io.IOError;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            throw new Exception("O NOOOO!");

        }catch (Error | Exception ex){

            System.out.println(ex.getMessage());
        }

    }
}

class Parent {

    void print() throws Error{

    }
}

class Child extends Parent {
    @Override
    void print() throws Error {

    }
}
