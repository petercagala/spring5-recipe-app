package sk.cagalpte.udemy.sfg.spring5recipeapp.dto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity(name = "ingredient")
public class IngredientDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    // V triede UnitOfMeasureDTO abslutne ziadnu asociaciu nedavame v tomto pripade, nechteme totiz absolutne ziadnu kaskadu medzi nimi
    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasureDTO unitOfMeasureDTO;

    @ManyToOne
    @JoinColumn(name = "RECIPE_ID", foreignKey = @ForeignKey(name = "FK_ingredient_RECIPE_ID"))
    private RecipeDTO recipeDTO;

    public IngredientDTO() {
    }

    public IngredientDTO(IngredientDTOBuilder ingredientDTOBuilder) {
        this.setId(ingredientDTOBuilder.id);
        this.setDescription(ingredientDTOBuilder.description);
        this.setAmount(ingredientDTOBuilder.amount);
        this.setRecipeDTO(ingredientDTOBuilder.recipeDTO);
        this.setUnitOfMeasureDTO(ingredientDTOBuilder.unitOfMeasureDTO);
    }

    public IngredientDTOBuilder createBuilder() {
        return new IngredientDTO.IngredientDTOBuilder();
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public RecipeDTO getRecipeDTO() {
        return recipeDTO;
    }

    public void setRecipeDTO(RecipeDTO recipeDTO) {
        this.recipeDTO = recipeDTO;
    }

    public UnitOfMeasureDTO getUnitOfMeasureDTO() {
        return unitOfMeasureDTO;
    }

    public void setUnitOfMeasureDTO(UnitOfMeasureDTO unitOfMeasureDTO) {
        this.unitOfMeasureDTO = unitOfMeasureDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IngredientDTO that = (IngredientDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(description, that.description) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(recipeDTO, that.recipeDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, amount, recipeDTO);
    }

    public static class IngredientDTOBuilder {
        private Long id;

        private String description;

        private BigDecimal amount;

         private UnitOfMeasureDTO unitOfMeasureDTO;

        private RecipeDTO recipeDTO;

        public IngredientDTOBuilder() {
        }

        public IngredientDTOBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public IngredientDTOBuilder description(String description) {
            this.description = description;
            return this;
        }

        public IngredientDTOBuilder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public IngredientDTOBuilder unitOfMeasureDTO(UnitOfMeasureDTO unitOfMeasureDTO) {
            this.unitOfMeasureDTO = unitOfMeasureDTO;
            return this;
        }

        public IngredientDTO build() {
            return new IngredientDTO(this);
        }
    }


}
