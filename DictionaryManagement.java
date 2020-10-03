import java.util.Scanner;
public class DictionaryManagement {
    public static void insertFromCommandline(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<n; ++i) {
            Dictionary.word[i] = new Word();
            Dictionary.word[i].word_target = sc.next();
            Dictionary.word[i].word_explain = sc.next();
        }
        Dictionary.count += n;

    }
}
