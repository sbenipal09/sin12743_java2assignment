package sheridan.sin12743.assignment2.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Pet {
    //petclass
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Pet name is mandatory")
    private String name;
    private String kind;
    private String sex;
    private Boolean isVaccinated;
    private String imageUrl;

    // No-args constructor
    public Pet() {
    }

    // Constructor with arguments
    public Pet(String name, String kind, String sex, Boolean isVaccinated) {
        this.name = name;
        this.kind = kind;
        this.sex = sex;
        this.isVaccinated = isVaccinated;
    }

    // Getters and Setters

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getKind() {

        return kind;
    }

    public void setKind(String kind) {

        this.kind = kind;
    }

    public String getSex() {

        return sex;
    }

    public void setSex(String sex) {

        this.sex = sex;
    }

    public Boolean getIsVaccinated() {

        return isVaccinated;
    }

    public void setIsVaccinated(Boolean isVaccinated) {

        this.isVaccinated = isVaccinated;
    }

    public String getImageUrl() {

        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {

        this.imageUrl = imageUrl;
    }

}
