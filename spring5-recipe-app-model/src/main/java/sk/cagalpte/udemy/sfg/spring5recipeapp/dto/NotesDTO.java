package sk.cagalpte.udemy.sfg.spring5recipeapp.dto;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "notes")
public class NotesDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "RECIPE_NOTES")
    @Lob
//    @Lob saves the data in BLOB or CLOB. Let�s understand what is BLOB and CLOB
//
//    CLOB(Character Large Object): If data is text and is not enough to save in VARCHAR, then that data should be saved in CLOB.
//
//            BLOB(Binary Large Object): In case of double byte character large data is saved in BLOB data type.
    private String recipeNotes;

    @OneToOne
    @JoinColumn(name = "RECIPE_ID", foreignKey = @ForeignKey(name = "FK_notes_RECIPE_ID"))
    private RecipeDTO recipeDTO;

    public NotesDTO() {
    }

    public NotesDTO(NotesDTOBuilder notesDTOBuilder) {
        this.setId(notesDTOBuilder.id);
        this.setRecipeNotes(notesDTOBuilder.recipeNotes);
        this.setRecipeDTO(notesDTOBuilder.recipeDTO);
    }

    public RecipeDTO.RecipeDTOBuilder createBuilder() {
        return new RecipeDTO.RecipeDTOBuilder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipeNotes() {
        return recipeNotes;
    }

    public void setRecipeNotes(String recipeNotes) {
        this.recipeNotes = recipeNotes;
    }

    public RecipeDTO getRecipeDTO() {
        return recipeDTO;
    }

    public void setRecipeDTO(RecipeDTO recipeDTO) {
        this.recipeDTO = recipeDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotesDTO notesDTO = (NotesDTO) o;
        return Objects.equals(id, notesDTO.id) &&
                Objects.equals(recipeNotes, notesDTO.recipeNotes) &&
                Objects.equals(recipeDTO, notesDTO.recipeDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, recipeNotes, recipeDTO);
    }

    public static class NotesDTOBuilder {
        private Long id;

        private String recipeNotes;

        private RecipeDTO recipeDTO;

        public NotesDTOBuilder() {
        }

        public NotesDTOBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public NotesDTOBuilder recipeNotes(String recipeNotes) {
            this.recipeNotes = recipeNotes;
            return this;
        }

        public NotesDTOBuilder recipeDTO(RecipeDTO recipeDTO) {
            this.recipeDTO = recipeDTO;
            return this;
        }

        public NotesDTO build() {
            return new NotesDTO(this);
        }
    }
}
