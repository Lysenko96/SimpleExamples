package net.pack.leetproblems.decodemsg;

import java.util.*;

public class Solution {

    private String[] alphabet = "abcdefghijklmnopqrstuvwxyz".split("");

    public static void main(String[] args) {
        System.out.println(new Solution().decodeMessage("jofvolbmgqi egiqlqaxdihaqstwghmlvvksuateonrxvaqryt fusjjirnbtwnntzutslkmtbvpfivfsrpcnejiellbxlqqc z xmfvhebylgwpdq ekubdlgq", "nonleoypeshkxhjsfixwwbnofihozgn  aebntfxgvikkkp kqefpffzsr uvlirvvzbid becqxegexjudomqrivueascbgdnw chhoobmmwonnjbtkbhdjtzcmasmomleiqtxqwyvwfzzcgswpx uf aqgrlnrkfbcktblwlxl esdtcv oiebutsaibygcpvmzewjamlzzej kpwwwpxsreeiqichavptjpddnlynjokupwyokrquuyknoyewrjenrloxlip hrmx dgufpqauahseieluflhiujfepakplt "));
        //System.out.println(new Solution().decodeMessage("aowrzlqeyicbnbdyvfsmbrgbkethbuueraldpqfwkukmvmphuccxjdrczf", "uoeazfvmhiqjnvdverxxglfubcfrnhrsmabdqdaqolvjnilt "));
    }

    public String decodeMessage(String key, String message) {
        key = key.replace(" ", "");
        String[] keyArr = key.split("");
        Set<String> keySet = new LinkedHashSet<>(Arrays.asList(keyArr));
        //System.out.println(keySet);
        List<String> keyList = new ArrayList<>(keySet);
        String[] words = message.split(" ");
        //System.out.println(Arrays.toString(words));
        int count = 0;
        StringBuilder sb = new StringBuilder();
        //System.out.println(keyList);
        for (String word : words) {
            if (word.equals("")){
                continue;
            }
            //System.out.println(word);
                for (String letter : word.split("")) {
                    //System.out.println(letter);
                    //System.out.println(keyList.indexOf(letter));
                    sb.append(alphabet[keyList.indexOf(letter)]);
            }
            count++;
        }
        List<Integer> indexes = new ArrayList<>();
        for(int i = 0; i < message.length(); i++){
            if(message.charAt(i) == ' ')
                indexes.add(i);
        }
        for(Integer i : indexes){
            sb.insert(i, " ");
        }
        return sb.toString();
    }
}
