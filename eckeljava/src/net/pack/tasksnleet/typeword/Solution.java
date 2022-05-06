package net.pack.tasksnleet.typeword;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().canBeTypedWords("veikxddtjgpixjrux srxiqrczp cxaldqsvsxpzn xrlxovsjy ervh cdtxwnahcvj xazmhniydmzsseuhq htrsuiabtzcjglilehrpxqcadk ynls r pjkiwtcmvldcr t urevy fjmeutye gjnyd wv fueploq eol zofra xnwaxnwh lpckcgzfcslugpmu judahwebqnwtk gfttojiqcffstkcq nfxbw ugnviyeincmuzoosfy kdazdudaztlnj rqg umaohfgtvk i vfhdvuvbih falmmrke rv zsaqn oswdlfq eapt mnr swcoa jhmui t vkm tumfqvj ehcycfgzxjkhxhdbymmwxy xnsxxerahbrr silb rqmhfbyopev fstlsvpblocrvrheghvgiuqftknewskmhbk nchoj bo cxovzradanq fofsrtmnytq brcixelmzvdxmm"
                ,"wqchprenozi"));
    }

    public int canBeTypedWords(String text, String brokenLetters) {
        Set<String> set = new HashSet<>();
        List<String> set1 = new ArrayList<>();
        int result = 0;
        if(brokenLetters.isEmpty()){
            Collections.addAll(set, text.split(" "));
            result = text.split(" ").length;
        } else {
            String[] letters = brokenLetters.split("");
            for (String word : text.split(" ")) {
                for (String letter : letters) {
                    if (word.contains(letter)) {
                        set.add(word);
                    }
                }
            }
            for(String word : text.split(" ")){
                if(!set.contains(word)){
                    set1.add(word);
                }
            }
           // System.out.println(set1);
            result = set1.size();
        }
        return result;
    }
}
