package sk.cagalpte.udemy.sfg.spring5recipeapp.enums;

public enum Difficulty {
    EASY('E'),
    MODERATE('M'),
    HARD('H');

    private char code;

    Difficulty(char code) {
        this.code = code;
    }


    public static Difficulty getEnumFormCode(Character code)
            throws UnsupportedOperationException {
        if (code.equals('E') || code.equals('e')) {
            return Difficulty.EASY;
        } else if (code.equals('M') || code.equals('m')) {
            return Difficulty.MODERATE;
        } else if (code.equals('H') || code.equals('h')) {
            return Difficulty.HARD;
        } else {
            throw new UnsupportedOperationException("Pre dany kod " + code + " neexistuje enum typ Difficulty");
        }

    }


    public char getCode() {
        return code;
    }

    //Ak chceme do databazy namapovat enum typy, je potrebne oznacit takyto field pomocou anotacie @Enumerated
//Pouzivaju sa 3 strategie

//1.
//@Enumerated(EnumType.ORDINAL)
//V databaze bude v type reprezentujuci cele cisla (respektue poradie atributov enumu)

//2.
//@Enumerated(EnumType.STRING)
//V databaze bude cely string

//
//@Convert(converter = TriedaImplementujucaAtributConverter<X,Y>.class)
//AtributConverter<X,Y>
// Mozem si nastavit skratky podla jednotlivych enumov
//@Convert(converter = GenderConverter.class)
}
