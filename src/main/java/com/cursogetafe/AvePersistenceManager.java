package com.cursogetafe;

import org.hibernate.Session;

public class AvePersistenceManager {
    static Session session=null;

    public static void startSession() {
        if (AvePersistenceManager.session==null || !AvePersistenceManager.session.isOpen()) {
            AvePersistenceManager.session = HibernateUtil.getSessionFactory().openSession();
        }
    }
    public static void finishSession(){
        if (AvePersistenceManager.session!=null) {
            AvePersistenceManager.session.close();
        }
    }

    public static void create(Ave ave) {
        //Inicializa la sesión (por si acaso)
        AvePersistenceManager.startSession();
        AvePersistenceManager.session.beginTransaction();
        AvePersistenceManager.session.merge(ave);//Llamada al guardar
        AvePersistenceManager.session.getTransaction().commit();
        System.out.println("¡Ave guardada con éxito!");
    }
    public static Ave update(Ave ave) {
        return null;
    }
    public static Ave read(String especie) {
        AvePersistenceManager.startSession();
        Ave aveLeida = AvePersistenceManager.session.find(Ave.class, especie);
        return aveLeida;
    }
    public static void delete(String especie) {

    }
    public static void delete(Ave ave) {

    }
}
