package utils;

public class StringUtils {
    /**
     * Método para eliminar todos los espacios de una cadena.
     *
     * @param input La cadena de entrada de la cual se eliminarán los espacios.
     * @return Una nueva cadena sin espacios.
     */
    public static String removeSpaces(String input) {
        if (input == null) {
            return null;
        }
        return input.replaceAll("\\s+", "");
    }
}
