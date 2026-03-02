package com.cursogetafe;



import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

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
        AvePersistenceManager.startSession();
        AvePersistenceManager.session.beginTransaction();
        AvePersistenceManager.session.persist(ave);
        AvePersistenceManager.session.getTransaction().commit();
        System.out.println("¡Ave creada con éxito!");
    }
    public static Ave update(Ave ave) {
        AvePersistenceManager.startSession();
        AvePersistenceManager.session.beginTransaction();
        AvePersistenceManager.session.merge(ave);
        AvePersistenceManager.session.getTransaction().commit();
        System.out.println("¡Ave modificada con éxito!");
        return ave;
    }
    public static Ave read(String especie) {
        AvePersistenceManager.startSession();
        Ave aveLeida = AvePersistenceManager.session.find(Ave.class, especie);
        return aveLeida;
    }
    public static List<Ave> readAll(){
        AvePersistenceManager.startSession();
        Query query = session.createQuery("FROM Ave");
        List<Ave> aves = query.getResultList();
        return aves;
    }
    public static void delete(String especie) throws Exception {
        AvePersistenceManager.startSession();
        Ave aveBorrable = AvePersistenceManager.session.find(Ave.class, especie);
        if (aveBorrable==null) {
            throw new Exception("Ave no encontrada");
        }
        AvePersistenceManager.session.beginTransaction();
        AvePersistenceManager.session.remove(aveBorrable);
        AvePersistenceManager.session.getTransaction().commit();
        System.out.println("¡Ave eliminada con éxito!");
    }
    public static void delete(Ave ave) {
        AvePersistenceManager.startSession();
        AvePersistenceManager.session.beginTransaction();
        AvePersistenceManager.session.remove(ave);
        AvePersistenceManager.session.getTransaction().commit();
        System.out.println("¡Ave eliminada con éxito!");
    }
}
