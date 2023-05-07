package domainClasses;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "state")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id")
    private int stateId;
    @Column(name = "s_name")
    private String stateName;
    @Column(name = "s_capital")
    private String stateCapital;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "c_reff")
    private Country countryReff;
    @OneToMany(mappedBy = "stateReff", cascade = CascadeType.ALL)
    private List<District> districtList;

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateCapital() {
        return stateCapital;
    }

    public void setStateCapital(String stateCapital) {
        this.stateCapital = stateCapital;
    }

    public Country getCountryReff() {
        return countryReff;
    }

    public void setCountryReff(Country countryReff) {
        this.countryReff = countryReff;
    }

    public List<District> getDistrictList() {
        return districtList;
    }

    public void setDistrictList(List<District> districtList) {
        this.districtList = districtList;
    }

    public void addDistrict(District dist) {
        if (districtList == null) {
            districtList = new LinkedList<>();
        }
        districtList.add(dist);
        dist.setStateReff(this);
    }
}
