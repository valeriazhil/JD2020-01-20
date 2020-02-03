package by.it.degtyaryov.jd01_06;

public class TaskB2 {

    public static void main(String[] args) {
        // костыль - заменяем многоточие "..." на "---", если это не конец предложения, и на "--.", если конец
        String text = replaceElipsis(Poem.text);
        String[] sentences = text.split("[.!?]");
        replaceNonLiterals(sentences);
        sortByLength(sentences);
        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }

    /**
     * @param text строка для замены
     * @return строка, в которой многоточие "..." заменено на "---", если это не конец предложения,
     * и на "--.", если конец
     * @author DEA
     */
    private static String replaceElipsis(String text) {
        text = text.replaceAll("\\.\\.\\.(?= *[а-яё])", "---");
        text = text.replaceAll("\\.\\.\\.((?=( *[А-ЯЁ])|(\\Z)))", "--.");
        return text;
    }

    /**
     * Заменяет все небуквенные символы на пробел и удаляет все лишние пробелы в начале и конце строки
     *
     * @param sentences массив строк для замены
     * @author DEA
     */
    private static void replaceNonLiterals(String[] sentences) {
        for (int i = 0; i < sentences.length; i++) {
            sentences[i] = sentences[i].replaceAll("[^а-яА-ЯёЁ]+", " ").trim();
        }
    }

    /**
     * Сортируем массив строк по возрастанию размера строки
     *
     * @param array массив для сортировки
     * @author DEA
     */
    private static void sortByLength(String[] array) {
        boolean wasChanged = true;
        int tillIndex = array.length - 1;
        while (wasChanged) {
            wasChanged = false;
            for (int j = 0; j < tillIndex; j++) {
                if (array[j].length() > array[j + 1].length()) {
                    wasChanged = true;
                    String buffer = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = buffer;
                }
            }
        }
    }
}
