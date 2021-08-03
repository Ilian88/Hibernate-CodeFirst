package entities;

import javax.annotation.processing.Generated;
import javax.persistence.*;

@MappedSuperclass
public class BaseEntity {

    private long id;

    public BaseEntity() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
