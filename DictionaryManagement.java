import java.io.*;
import java.lang.reflect.Array;
import java.util.Scanner;
public class DictionaryManagement {
    public static void insertFromCommandline(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<n; ++i) {
            Word odd = new Word();
            odd.word_target = sc.next();
            odd.word_explain = sc.next();
            Dictionary.word.add(odd);
            ++Dictionary.count;
        }

    }
    public static void insertFromFile() throws FileNotFoundException {
        File file = new File("E:\\19020474_Tudien\\src\\dictionaries.txt");
        Scanner sc = new Scanner(file,"UTF-8");
        while(sc.hasNextLine()) {
            Word odd = new Word();
            String[] div = sc.nextLine().split("\\t");
            odd.word_target = div[0];
            odd.word_type = div[1];
            odd.word_pronounce = div[2];
            odd.word_explain = div[3];
            Dictionary.word.add(odd);
            ++Dictionary.count;
        }
    }
    public static void dictionaryLookup() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String s = sc.next();
            for(int i=0; i<Dictionary.count; ++i) {
                if (s.equals(Dictionary.word.get(i).word_target)) {
                    System.out.println(Dictionary.word.get(i).word_explain);
                }
            }
        }

    }
    public static void add(String w, String explain) {
        Word odd = new Word();
        odd.word_target = w;
        odd.word_explain = explain;
        Dictionary.word.add(odd);
        ++Dictionary.count;
    }
    public static void fix(String w, String explain) {
        int check = 0;
        for(int i = 0; i < Dictionary.count; ++i) {
            if(w == Dictionary.word.get(i).word_target) {
                Dictionary.word.get(i).word_explain = explain;
                ++check;
            }
        }
        if(check == 0 ) {
            add(w,explain);
        }
    }
    public static void delete(String w) {
        for(int i = 0; i < Dictionary.count; ++i) {
            if(w == Dictionary.word.get(i).word_target) {
                Dictionary.word.remove(Dictionary.word.get(i));
            }
        }
    }
    public static void exportToFile() {
        try {
            OutputStream outputStream = new FileOutputStream("dictionaries.txt");
            Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
            for (Word word : Dictionary.word) {
                String s = word.word_target + "\t" + word.word_type + "\t" + word.word_pronounce + "\t" + word.word_explain + "\n";
                writer.write(s);
            }
            writer.close();
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }
}
