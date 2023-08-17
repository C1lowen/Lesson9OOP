package lesson9_task3;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file = new File ("D:\\One\\naaa.txt");

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            StringBuilder sb = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            List<LetterReadFromFile> list= countSymbols(sb.toString());
            list.sort(Comparator.comparingInt(LetterReadFromFile::getNumber).reversed());

            for(LetterReadFromFile lrf : list){
                System.out.println(lrf.getCharacter() + " ==> " + lrf.getNumber());
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static List<LetterReadFromFile> countSymbols(String str){
        int[] letterCount = new int[26];

        for(char c : str.toCharArray()){
            if(Character.isLetter(c)){
                int index = Character.toLowerCase(c) - 'a';
                letterCount[index]++;
            }
        }

        List<LetterReadFromFile> list = new ArrayList<>();
        for(int i =0 ;i < letterCount.length; i++){
            if(letterCount[i] > 0){
                char character = (char) (i + 'a');
                int count = letterCount[i];
                list.add(new LetterReadFromFile(character, count));
            }
        }
        return list;
    }
}
