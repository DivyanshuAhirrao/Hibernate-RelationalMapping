package hibernateOperations;

import domainClasses.Country;
import domainClasses.District;
import domainClasses.State;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DeleteCountry {
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

        System.out.println("Enter Country code to Delete");
        int country_code = sc.nextInt();

        Country c1 = ses.get(Country.class,country_code);

        if (c1!=null) {
            tx = ses.beginTransaction();
            ses.delete(c1);
            tx.commit();
            System.out.println(country_code+" code Deleted Successfulyy....");
        }
        else {
            System.out.println("Invalid id");
        }


    }
}
