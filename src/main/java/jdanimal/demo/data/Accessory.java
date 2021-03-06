package jdanimal.demo.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "accessories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Accessory extends BaseEntity{

    @Column(name = "accessory_name")
    private String accessoryName;
    @Column(name = "available_till")
    private String availableTill;
    @Column(name = "days_used")
    private int daysUsed;
    @Column(name = "accessory_price")
    private BigDecimal accessoryPrice;
    @Column(name= "picture_accessory")
    private String urlAccessoryPhoto;
    @Column(name = "description")
    @Type(type="text")
    private String description;
    @ManyToOne
    private User user;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<User> users;

}
