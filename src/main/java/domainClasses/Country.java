package domainClasses;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_code")
    private int countryCode;
    @Column(name = "c_name")
    private String countryName;
    @Column(name = "c_capital")
    private String countryCapital;
    @OneToMany(mappedBy = "countryReff",cascade = CascadeType.ALL)
    private List<State> stateList;


    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCapital() {
        return countryCapital;
    }

    public void setCountryCapital(String countryCapital) {
        this.countryCapital = countryCapital;
    }

    public List<State> getStateList() {
        return stateList;
    }

    public void setStateList(List<State> stateList) {
        this.stateList = stateList;
    }

    public void addStates(State st) {
        if (stateList == null){
            stateList = new LinkedList<>();
        }
        stateList.add(st);
        st.setCountryReff(this);
    }


}
