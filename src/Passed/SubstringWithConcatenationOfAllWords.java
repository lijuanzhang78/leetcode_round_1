package Passed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {
	public List<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (S == null || S.length() == 0 || L == null || L.length == 0)
            return result;
        int strLen = S.length();
        int wordLen = L[0].length();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < L.length; i++) {
            if (map.containsKey(L[i])) {
                map.put(L[i], map.get(L[i]) + 1);
            } else {
                map.put(L[i], 1);
            }
        }
        for (int i = 0; i < wordLen; i++) {
            HashMap<String, Integer> curMap = new HashMap<String, Integer>();
            int count = 0, left = i;
            for (int j = i; j <= strLen - wordLen; j += wordLen) {
                String curStr = S.substring(j, j + wordLen);
                if (map.containsKey(curStr)) {
                    if (curMap.containsKey(curStr)) {
                        curMap.put(curStr, curMap.get(curStr) + 1);
                    } else {
                        curMap.put(curStr, 1);
                    }
                    if (curMap.get(curStr) <= map.get(curStr)) {
                        count++;
                    } else {
                        while (true) {
                            String tmp = S.substring(left, left + wordLen);
                            curMap.put(tmp, curMap.get(tmp) - 1);
                            left += wordLen;
                            if (curStr.equals(tmp)) {
                                break;
                            } else {
                                count--;
                            }
                        }
                    }
                    if (count == L.length) {
                        result.add(left);
                        String tmp = S.substring(left, left + wordLen);
                        curMap.put(tmp, curMap.get(tmp) - 1);
                        left += wordLen;
                        count--;
                    }
                } else {
                    curMap.clear();
                    count = 0;
                    left = j + wordLen;
                }
            }
        }
        return result;
    }

}
