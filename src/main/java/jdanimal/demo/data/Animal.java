package jdanimal.demo.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "animals")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Animal extends BaseEntity{

    @Column(name = "name_of_animal")
    private String nameOfAnimal;

    @Column(name = "type_of_animal")
    private String typeOfAnimal;
    @Column(name = "age_of_animal")
    private Integer ageOfAnimal;
    @Column(name = "games_of_animal")
    private String gamesOfAnimal;
    @Column(name = "food_of_animal")
    private String foodOfAnimal;
    @Column(name = "kilograms_of_animal")
    private Integer kilogramsOfAnimal;
    @Column(name = "available_till")
    private String availableTill;
    @Column(name= "picture_animal")
    private String urlAnimalPhoto;
    @Column(name = "description")
    @Type(type="text")
    private String description;
    @ManyToOne
    private User user;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<User> users;


}
