import java.util.HashMap;
import java.util.TreeMap;

public class s92341 {
    public static void main(String[] args) {
        s92341 problem = new s92341();
        System.out.println(problem.solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}));
    }

    class CarInfo {
        String status;
        int time;
        int stackTime;

        CarInfo(int stackTime, String timeString, String status) {
            String[] timeArray = timeString.split(":");
            this.stackTime = stackTime;
            this.time = Integer.parseInt(timeArray[0]) * 60 + Integer.parseInt(timeArray[1]);
            this.status = status;
        }
    }

    public int[] solution(int[] fees, String[] records) {
        /**
         * answerMap은 차량번호로 정렬하기위해 TreeMap으로 선언
         */
        HashMap<String, CarInfo> parkingMap = new HashMap<>();
        TreeMap<String, CarInfo> answerMap = new TreeMap<>();

        for(int i=0; i<records.length; i++) {
            String[] recordArray = records[i].split(" ");
            if(recordArray[2].equals("IN")) {
                boolean isInAnswer = answerMap.containsKey(recordArray[1]);
                if(isInAnswer) {
                    parkingMap.put(recordArray[1],new CarInfo(answerMap.get(recordArray[1]).stackTime,recordArray[0],recordArray[2]));
                    answerMap.remove(recordArray[1]);
                } else {
                    parkingMap.put(recordArray[1], new CarInfo(0, recordArray[0], recordArray[2]));
                }
            } else {
                CarInfo parkCarInfo = parkingMap.get(recordArray[1]);
                parkingMap.remove(recordArray[1]);
                String[] timeArray = recordArray[0].split(":");
                int stackTime = parkCarInfo.stackTime + Integer.parseInt(timeArray[0]) * 60 + Integer.parseInt(timeArray[1]) - parkCarInfo.time;
                parkCarInfo.stackTime = stackTime;
                parkCarInfo.time = 0;
                parkCarInfo.status = "OUT";
                answerMap.put(recordArray[1], parkCarInfo);
            }
        }

        /**
         * 입차만된 차량들 23:59(1439분)기준으로 출차처리
         */
        for(String key : parkingMap.keySet()){
            CarInfo carInfo = parkingMap.get(key);
            carInfo.stackTime = carInfo.stackTime + 1439 - carInfo.time;
            carInfo.time = 0;
            carInfo.status = "OUT";
            answerMap.put(key,carInfo);
        }

        int defaultTime = fees[0];
        int defaultPay = fees[1];
        int customMinuate = fees[2];
        int customPay = fees[3];

        int[] answer = new int[answerMap.size()];
        int answerCount = 0;
        for(String key : answerMap.keySet()){
            CarInfo carInfo = answerMap.get(key);
            int stackTime = carInfo.stackTime;
            if(stackTime < defaultTime) {
                answer[answerCount++] = defaultPay;
            } else {
                int answerFee = defaultPay + (int) Math.ceil((double) (stackTime - defaultTime) / customMinuate) * customPay;
                answer[answerCount++] = answerFee;
            }
        }


        return answer;
    }
}
