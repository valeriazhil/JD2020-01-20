package by.it.gerasimov.jd01_15;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

class TaskB {

    // (s=“//так не бывает”) и внутри комментария тоже
/* Многострочный
комментрий
 */
    /*В программе создайте хотя бы 5 разных комментариев:
 с тем же местоположением и именем,
 но с расширением txt, а не java.  Считайте, что комментарии внутри строки невозможны
*/
    public static void main(String[] args) {
        String code = readOwnCleanCode(TaskB.class);
        System.out.println(code); //???
        saveToTxtFile(code, TaskB.class);
    }
    /*kljkljl
    lkjkljkl
    l;lk;l
     */

    /**
     * @param aClass class
     * @return code in String format
     */
    private static String readOwnCleanCode(Class<?> aClass) {
        StringBuilder code = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
            new FileReader(Helper.getPath(aClass, aClass.getSimpleName() + ".java")))) {
            int symbol;
            boolean preSkip = false;
            boolean preContinue = false;
            boolean commentLine = false;
            boolean commentLines = false;
            boolean skip;
            while ((symbol = br.read()) != -1) {
                skip = commentLine || commentLines;
                if (!skip) {
                    if ((char) symbol == '/' && !preSkip) {
                        preSkip = true;
                    } else if (preSkip) {
                        switch ((char) symbol) {
                            case '*':
                                commentLines = true;
                                skip = true;
                                break;
                            case '/':
                                commentLine = true;
                                skip = true;
                                break;
                            default:
                                code.append('/');
                        }
                        preSkip = false;
                    }
                    if (!preSkip && !skip) {
                        code.append((char) symbol);
                    }
                } else { //возврат после комментария
                    if ((char) symbol == '*' && !commentLine) {
                        preContinue = true;
                    } else if ((char) symbol == '/' && preContinue) {
                        preContinue = false;
                        commentLines = false;
                    } else if ((char) symbol == '\n' && commentLine) {
                        commentLine = false;
                        code.append('\n');
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return code.toString();
    }

    private static void saveToTxtFile(String text, Class<?> aClass) {
        try (PrintWriter printWriter = new PrintWriter(
            Helper.getPath(aClass, aClass.getSimpleName() + ".txt"))) {
            printWriter.print(text);
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    }
}
