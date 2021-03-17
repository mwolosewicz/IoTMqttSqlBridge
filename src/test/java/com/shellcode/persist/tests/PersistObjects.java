package com.shellcode.persist.tests;

import com.shellcode.db.HibernateUtil;
import com.shellcode.db.Measurement;
import com.shellcode.db.Unit;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.Assert.*;

public class PersistObjects {

    Session session = null;

    @Before
    public void prepareConnectionToDb() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @After
    public void closeConnection(){
        session.close();
        session = null;
    }

    @Test
    public void persistUnit() {
        Unit celsius = new Unit("C", "Temperature is a physical quantity that expresses hot " +
                "and cold. It is the manifestation of thermal energy, present in all matter, which is the source " +
                "of the occurrence of heat, a flow of energy, when a body is in contact with another that is " +
                "colder or hotter.");

        Transaction transaction = session.beginTransaction();

        session.save(celsius);
        transaction.commit();

        List< Unit > units = session.createQuery("from Unit", Unit.class).list();
        assertEquals(units.get(0), celsius);
    }

    @Test
    public void persistMeasure() {
        try {
            Unit celsius = new Unit("C", "Temperature is a physical quantity that expresses hot " +
                    "and cold. It is the manifestation of thermal energy, present in all matter, which is the source " +
                    "of the occurrence of heat, a flow of energy, when a body is in contact with another that is " +
                    "colder or hotter.");

            Measurement measurement = new Measurement(new Timestamp(System.currentTimeMillis()), 23.4, celsius);

            Transaction transaction = session.beginTransaction();
            session.save(celsius);
            session.save(measurement);
            transaction.commit();
        } catch (Exception e) {
            fail("Can't persist measure. Exception: " + e.getMessage());
        }

    }

}
