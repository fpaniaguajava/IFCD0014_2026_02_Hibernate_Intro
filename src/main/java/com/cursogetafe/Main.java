package com.cursogetafe;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        //Iniciar sesión
        AvePersistenceManager.startSession();

        //create
        read();

        //Finalizar sesión
        AvePersistenceManager.finishSession();
    }
    static void create(){
        Ave ave1 = new Ave("Milano", "Pardo", 2.3, true);
        AvePersistenceManager.create(ave1);
    }
    static void read(){
        Ave ave = AvePersistenceManager.read("Milano");
        System.out.println(ave);
    }
}
