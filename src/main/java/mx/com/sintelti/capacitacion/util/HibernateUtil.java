package mx.com.sintelti.capacitacion.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Author: Benek
 * Date: 05/10/13
 * Time: 14:04
 * www.javamexico.org
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory
            = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        try{
            //Se crea la SessionFactory basada en hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        } catch(Throwable ex){
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
