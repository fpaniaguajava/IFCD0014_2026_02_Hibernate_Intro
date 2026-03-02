package com.cursogetafe;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        //Iniciar sesión
        AvePersistenceManager.startSession();

        //create

        // ave = read();
        // System.out.prinltn(ave);

        //update();

        //delete();

        //deleteByEspecie("Milano");

        //create();

        //deleteByEspecie("Milano");

        create();
        List<Ave> aves = readAll();
        aves.forEach(ave -> {
            System.out.println(ave);
        });

        //Finalizar sesión
        AvePersistenceManager.finishSession();
    }
    static void create(){
        Ave ave1 = new Ave("Milano", "Pardo", 2.3, true);
        AvePersistenceManager.create(ave1);
    }
    static Ave read(){
        Ave ave = AvePersistenceManager.read("Milano");
        return ave;
    }
    static List<Ave> readAll(){
        List<Ave> aves = AvePersistenceManager.readAll();
        return aves;
    }
    static void update(){
        Ave aveModificada = AvePersistenceManager.update(new Ave("Milano", "Verde", 3, true));
        System.out.println(aveModificada);
    }
    static void delete(){
        Ave ave = AvePersistenceManager.read("Milano");
        AvePersistenceManager.delete(ave);
    }
    static void deleteByEspecie(String especie) {
        try {
            AvePersistenceManager.delete(especie);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

}
