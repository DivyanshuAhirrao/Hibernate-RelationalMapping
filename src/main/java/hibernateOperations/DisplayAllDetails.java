package hibernateOperations;

import domainClasses.Country;
import domainClasses.District;
import domainClasses.State;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import sun.plugin.dom.css.Counter;

import java.util.List;

public class DisplayAllDetails {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg = new Configuration();
        cfg = cfg.configure();
        cfg.addAnnotatedClass(Counter.class);
        cfg.addAnnotatedClass(State.class);
        cfg.addAnnotatedClass(District.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Criteria crt = ses.createCriteria(Country.class);

        List<Country> countryList = crt.list();

        System.out.println("---Country Info---");
        for (Country c : countryList) {

            System.out.println("Country Name : " +c.getCountryName());
            System.out.println("Country Capital : "+c.getCountryCapital());

            List<State> stateList = c.getStateList();

            System.out.println("===================================");
            System.out.println();
            System.out.println("---State Info---");

            for (State s : stateList) {

                System.out.println("-----------------------------------");
                System.out.println("State Name    : "+s.getStateName());
                System.out.println("State Capital : "+s.getStateCapital());
                System.out.println("-----------------------------------");
                System.out.println();
                System.out.println("District-info");
                List<District> districtList = s.getDistrictList();
                for (District d : districtList) {
                    System.out.println("District Name :- "+d.getDistrictName());
                    System.out.println();
                }

            }
        }

    }
}
