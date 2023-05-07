package hibernateOperations;

import domainClasses.Country;
import domainClasses.District;
import domainClasses.State;
import net.bytebuddy.description.annotation.AnnotationValue;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class InsertData {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Country.class);
        cfg = cfg.addAnnotatedClass(State.class);
        cfg = cfg.addAnnotatedClass(District.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Country c = new Country();
        c.setCountryName("America");
        c.setCountryCapital("Washington DC");
//             -------------

        State s = new State();
        s.setStateName("Taxes");
        s.setStateCapital("San-fransisco");

        District d = new District();
        d.setDistrictName("Dukes");


        c.addStates(s);
        s.addDistrict(d);

        tx = ses.beginTransaction();
        ses.save(c);
        ses.save(s);
        tx.commit();

        System.out.println("Data Inserted Successfully...");
    }
}
