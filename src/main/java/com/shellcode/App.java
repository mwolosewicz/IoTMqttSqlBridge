package com.shellcode;

import com.shellcode.db.HibernateUtil;
import com.shellcode.db.Unit;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{

    static Logger log = LoggerFactory.getLogger(App.class.getName());

    public static void main( String[] args )
    {
        log.info("Info debug");
        log.error("Error debug");
        log.debug("Debug debug");
        log.warn("Warning debug");
        log.trace("Trace debug");

        Unit celsius = new Unit("C", "Temperature is a physical quantity that expresses hot " +
                "and cold. It is the manifestation of thermal energy, present in all matter, which is the source " +
                "of the occurrence of heat, a flow of energy, when a body is in contact with another that is " +
                "colder or hotter.");
        Unit pascal = new Unit("Pa", "The unit, named after Blaise Pascal, is defined as one newton " +
                "per square metre[1] and is equivalent to 10 barye (Ba) in the CGS system.");

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student objects
            session.save(celsius);
            session.save(pascal);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List< Unit > units = session.createQuery("from Unit", Unit.class).list();
            units.forEach(s -> log.info("Unit: " + s.getUnit() + " desc: " + s.getDescription() + ", id: " + s.getId()));
        } catch (Exception e) {
            log.error("Can't get data: " + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }


    }
}
