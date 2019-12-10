package sk.cagalpte.udemy.sfg.spring5recipeapp.mappers.enum_converters;

import sk.cagalpte.udemy.sfg.spring5recipeapp.enums.Difficulty;

import javax.persistence.AttributeConverter;

public class DifficultyConverter implements AttributeConverter<Difficulty, Character> {
    @Override
    public Character convertToDatabaseColumn(Difficulty difficulty) {
        if(difficulty == null) {
            return null;
        } else {
            return difficulty.getCode();
        }
    }

    @Override
    public Difficulty convertToEntityAttribute(Character character) {
        if(character == null) {
            return null;
        } else {
            return Difficulty.getEnumFormCode(character);
        }
    }
}
