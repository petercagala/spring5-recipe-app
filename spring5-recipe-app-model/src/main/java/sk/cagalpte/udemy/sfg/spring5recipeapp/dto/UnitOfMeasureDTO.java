package sk.cagalpte.udemy.sfg.spring5recipeapp.dto;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "unit_of_measure")
public class UnitOfMeasureDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "UNIT_OF_MEASURE")
    private String unitOfMeasureDescription;

    public UnitOfMeasureDTO() {
    }

    public UnitOfMeasureDTO(UnitOfMeasureDtoBuilder unitOfMeasureDtoBuilder) {
        this.setId(unitOfMeasureDtoBuilder.id);
        this.setUnitOfMeasureDescription(unitOfMeasureDtoBuilder.unitOfMeasure);
    }

    public UnitOfMeasureDtoBuilder createBuilder() {
        return new UnitOfMeasureDTO.UnitOfMeasureDtoBuilder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUnitOfMeasureDescription() {
        return unitOfMeasureDescription;
    }

    public void setUnitOfMeasureDescription(String unitOfMeasureDescription) {
        this.unitOfMeasureDescription = unitOfMeasureDescription;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnitOfMeasureDTO that = (UnitOfMeasureDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(unitOfMeasureDescription, that.unitOfMeasureDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, unitOfMeasureDescription);
    }

    public static class UnitOfMeasureDtoBuilder {
        private Long id;

        private String unitOfMeasure;

        public UnitOfMeasureDtoBuilder() {
        }

        public UnitOfMeasureDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UnitOfMeasureDtoBuilder unitOfMeasure(String unitOfMeasure) {
            this.unitOfMeasure = unitOfMeasure;
            return this;
        }

        public UnitOfMeasureDTO build() {
            return new UnitOfMeasureDTO(this);
        }
    }
}
