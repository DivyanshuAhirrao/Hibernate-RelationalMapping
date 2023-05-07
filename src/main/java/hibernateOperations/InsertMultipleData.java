package hibernateOperations;

import domainClasses.Country;
import domainClasses.District;
import domainClasses.State;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class InsertMultipleData {
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

        System.out.println("Enter the Country Name");
        String countryName = sc.next();
        System.out.println("Enter Country's Capital");
        String countryCapital = sc.next();

        Country c = new Country();
        c.setCountryName(countryName);
        c.setCountryCapital(countryCapital);


        System.out.println("Enter number of States Details you want to Insert");
        int numStates = sc.nextInt();

        for (int i =1;i<=numStates;i++) {
            System.out.println("Enter the State Name");
            String stateName = sc.next();
            System.out.println("Enter the State Capital");
            String stateCapital = sc.next();

            State s = new State();
            s.setStateName(stateName);
            s.setStateCapital(stateCapital);

            c.addStates(s);


            System.out.println("Enter number of Districts Details to be Added for State");
            int numDist = sc.nextInt();

            for (int j = 1; j<=numDist;j++) {
                System.out.println("Enter the District Name");
                String districtName = sc.next();

                District d = new District();
                d.setDistrictName(districtName);

                s.addDistrict(d);

            }

        }

        tx = ses.beginTransaction();
        ses.save(c);
        tx.commit();

        System.out.println("Data Inserted Successfully...");
    }
}
