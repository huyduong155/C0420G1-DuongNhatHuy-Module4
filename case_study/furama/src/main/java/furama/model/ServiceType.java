package furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameServiceType;

    @OneToMany
    private List<Service> services;

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameServiceType() {
        return nameServiceType;
    }

    public void setNameServiceType(String nameServiceType) {
        this.nameServiceType = nameServiceType;
    }
}
