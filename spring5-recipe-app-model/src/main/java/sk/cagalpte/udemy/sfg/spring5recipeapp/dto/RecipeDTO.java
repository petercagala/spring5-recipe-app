package sk.cagalpte.udemy.sfg.spring5recipeapp.dto;

import sk.cagalpte.udemy.sfg.spring5recipeapp.enums.Difficulty;
import sk.cagalpte.udemy.sfg.spring5recipeapp.mappers.enum_converters.DifficultyConverter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity(name = "recipe")
public class RecipeDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PREP_TIME")
    private Integer prepTime;

    @Column(name = "COOK_TIME")
    private Integer cookTime;

    @Column(name = "SERVINGS")
    private Integer servings;

    @Column(name = "SOURCE")
    private String source;

    @Column(name = "URL")
    private String url;

    @Column(name = "DIRECTIONS")
    private String directions;

    //TODO add
    //private Difficulty difficulty;

    @Column(name = "IMAGES")
    @Lob
    //    @Lob saves the data in BLOB or CLOB. Let�s understand what is BLOB and CLOB
//
//    CLOB(Character Large Object): If data is text and is not enough to save in VARCHAR, then that data should be saved in CLOB.
//
//            BLOB(Binary Large Object): In case of double byte character large data is saved in BLOB data type.
    private Byte[] images;

    //@Enumerated(EnumType.ORDINAL) //1. option (cele cisla podla poradia, default)
//    @Enumerated(EnumType.STRING) //2. option
    @Convert(converter = DifficultyConverter.class) // 3. option (nastavenie skratiek podla jednotlivych enumov)
    private Difficulty difficulty;

    @OneToOne(mappedBy = "recipeDTO", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private NotesDTO notesDTO;

    @OneToMany(mappedBy = "recipeDTO", orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<IngredientDTO> ingredientDTOS = new ArrayList<>();

    public RecipeDTO() {
    }

    public RecipeDTO(RecipeDTOBuilder recipeDTOBuilder) {
        this.setId(recipeDTOBuilder.id);
        this.setDescription(recipeDTOBuilder.description);
        this.setPrepTime(recipeDTOBuilder.prepTime);
        this.setCookTime(recipeDTOBuilder.cookTime);
        this.setServings(recipeDTOBuilder.servings);
        this.setSource(recipeDTOBuilder.source);
        this.setUrl(recipeDTOBuilder.url);
        this.setDirections(recipeDTOBuilder.directions);
        this.setImages(recipeDTOBuilder.images);
        this.setDifficulty(recipeDTOBuilder.difficulty);
    }

    public RecipeDTOBuilder createBuilder() {
        return new RecipeDTO.RecipeDTOBuilder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public Byte[] getImages() {
        return images;
    }

    public void setImages(Byte[] images) {
        this.images = images;
    }

    public NotesDTO getNotesDTO() {
        return notesDTO;
    }

    public void setNotesDTO(NotesDTO notesDTO) {
        this.notesDTO = notesDTO;
    }

    public List<IngredientDTO> getIngredientDTOS() {
        return ingredientDTOS;
    }

    public void setIngredientDTOS(List<IngredientDTO> ingredientDTOS) {
        this.ingredientDTOS = ingredientDTOS;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeDTO recipeDTO = (RecipeDTO) o;
        return Objects.equals(id, recipeDTO.id) &&
                Objects.equals(description, recipeDTO.description) &&
                Objects.equals(prepTime, recipeDTO.prepTime) &&
                Objects.equals(cookTime, recipeDTO.cookTime) &&
                Objects.equals(servings, recipeDTO.servings) &&
                Objects.equals(source, recipeDTO.source) &&
                Objects.equals(url, recipeDTO.url) &&
                Objects.equals(directions, recipeDTO.directions) &&
                Arrays.equals(images, recipeDTO.images) &&
                difficulty == recipeDTO.difficulty &&
                Objects.equals(notesDTO, recipeDTO.notesDTO) &&
                Objects.equals(ingredientDTOS, recipeDTO.ingredientDTOS);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, description, prepTime, cookTime, servings, source, url, directions, difficulty, notesDTO, ingredientDTOS);
        result = 31 * result + Arrays.hashCode(images);
        return result;
    }

    public static class RecipeDTOBuilder {
        private Long id;

        private String description;

        private Integer prepTime;

        private Integer cookTime;

        private Integer servings;

        private String source;

        private String url;

        private String directions;

        private Byte[] images;

        private Difficulty difficulty;

        public RecipeDTOBuilder() {
        }

        public RecipeDTOBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public RecipeDTOBuilder description(String description) {
            this.description = description;
            return this;
        }

        public RecipeDTOBuilder prepTime(Integer prepTime) {
            this.prepTime = prepTime;
            return this;
        }

        public RecipeDTOBuilder cookTime(Integer cookTime) {
            this.cookTime = cookTime;
            return this;
        }

        public RecipeDTOBuilder servings(Integer servings) {
            this.servings = servings;
            return this;
        }

        public RecipeDTOBuilder source(String source) {
            this.source = source;
            return this;
        }

        public RecipeDTOBuilder url(String url) {
            this.url = url;
            return this;
        }

        public RecipeDTOBuilder directions(String directions) {
            this.directions = directions;
            return this;
        }

        public RecipeDTOBuilder images(Byte[] images) {
            this.images = images;
            return this;
        }

        public RecipeDTOBuilder difficulty(Difficulty difficulty) {
            this.difficulty = difficulty;
            return this;
        }

        public RecipeDTO build() {
            return new RecipeDTO(this);
        }
    }
}
