import java.util.ArrayList;
import java.util.List;

public class s77485 {
    int[][] table;
    public static void main(String[] args) {
        s77485 problem = new s77485();
        System.out.println(problem.solution(97,100,new int[][]{{1,1,97,100}}));
    }

    public int[] solution(int rows, int columns, int[][] queries) {
        int count = 1;
        List<Integer> answerList = new ArrayList<>();
        table = new int [rows][columns];
        for(int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                table[i][j] = count++;
            }
        }

        for(int i=0; i<queries.length; i++) {
            answerList.add(changeTable(queries[i]));
        }
        return answerList.stream().mapToInt(i -> i).toArray();
    }

    public int changeTable(int[] query) {
        int min = Integer.MAX_VALUE;
        int[][] tempTable = new int[table.length][table[0].length];
        for(int i=0; i<table.length; i++) {
            for (int j=0; j<table[i].length; j++) {
                tempTable[i][j] = table[i][j];
            }
        }
        int firstX = query[0] - 1;
        int firstY = query[1] - 1;
        int lastX = query[2] - 1;
        int lastY = query[3] - 1;

        for(int i=firstX; i<=lastX; i++) {
            for(int j=firstY; j<=lastY; j++) {
                if(i == firstX) {
                    if(j == lastY) {
                        table[i+1][j] = tempTable[i][j];
                    } else {
                        table[i][j+1] = tempTable[i][j];
                    }
                    min = Math.min(min,tempTable[i][j]);
                }
                else if(i == lastX) {
                    if(j == firstY) {
                        table[i-1][j] = tempTable[i][j];
                    } else {
                        table[i][j-1] = tempTable[i][j];
                    }
                    min = Math.min(min,tempTable[i][j]);
                } else {
                    if(j == firstY || j == lastY) {
                        if(j == firstY) {
                            table[i-1][j] = tempTable[i][j];
                        } else {
                            table[i+1][j] = tempTable[i][j];
                        }
                        min = Math.min(min,tempTable[i][j]);
                    }
                }
            }
        }

        return min;
    }
}
