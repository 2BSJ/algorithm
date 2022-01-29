import java.util.ArrayList;
import java.util.Arrays;

public class s72412 {
    /**
     * https://programmers.co.kr/learn/courses/30/lessons/72412?language=java
     */
    public static void main(String[] args) {

    }

    public int[] solution(String[] info, String[] query) {
        ArrayList[] infoListArray = new ArrayList[info.length];
        ArrayList[] queryListArray = new ArrayList[query.length];
        String[] infoSplitArray;
        String[] querySplitArray = new String[5];

        for(int i=0; i<info.length; i++) {
            infoSplitArray = info[i].split(" ");
            for(int j=0; j<infoSplitArray.length; j++) {
                infoListArray[i] = new ArrayList<String>(Arrays.asList(infoSplitArray));
            }
        }

        for(int i=0; i<query.length; i++) {
            String[] firstQuery = query[i].split(" and ");
            String[] lastQuery = firstQuery[firstQuery.length-1].split(" ");
            querySplitArray[0] = firstQuery[0];
            querySplitArray[1] = firstQuery[1];
            querySplitArray[2] = firstQuery[2];
            querySplitArray[3] = lastQuery[0];
            querySplitArray[4] = lastQuery[1];
            for(int j=0; j<querySplitArray.length; j++) {
                queryListArray[i] = new ArrayList<String>(Arrays.asList(querySplitArray));
            }
        }

        int[] answer = new int[query.length];
        int count;
        for(int i=0; i<queryListArray.length; i++) {
            count = 0;
            ArrayList<String> queryList = queryListArray[i];
            for(int j=0; j<infoListArray.length; j++) {
                ArrayList<String> infoList = infoListArray[j];
                if(Integer.parseInt(infoList.get(4)) < Integer.parseInt(queryList.get(4))) {
                    continue;
                }
                for(int k=0; k<infoList.size(); k++) {
                    if(k == infoList.size()-1) {
                        count++;
                    }
                    if(queryList.get(k).equals("-")) {
                        continue;
                    } else if(queryList.get(k).equals(infoList.get(k))) {
                        continue;
                    } else {
                        break;
                    }
                }
            }
            answer[i] = count;
        }


        return answer;
    }
}
