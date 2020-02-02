package by.it._tasks_.jd01_06;

public class TaskB1 {
    private static String [] words = new String[0];

    public static void main(String[] args) {
        String text = new String(Poem.text);
 //       char [] isVowel = new char [] {'а','у','е','ы','о','э','я','и','ю'};
        String [] redText = text.split(" ");
        redText = text.split(",");
        redText = text.split("-");
        redText = text.split(".");
        redText = text.split("...");
        redText = text.split(":");
        for (int i = 0; i <redText.length ; i++) {
            if (redText[i].equals(redText[i+1]))
                System.out.println(redText[i]);
                return;
        }
    }
}
