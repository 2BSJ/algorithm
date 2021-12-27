import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;

public class sol17680 {
    public static void main(String[] args) {
        sol17680 problem = new sol17680();
        int cacheSize = 3;
        String[] cities = new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println(problem.solution(cacheSize, cities));
    }

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> cityList = new LinkedList<>();
        if(cacheSize == 0) {
            return cities.length * 5;
        }

        for(int i=0; i<cities.length; i++) {
            String city = cities[i].toUpperCase();
            boolean contain = cityList.contains(city);
            if(contain) {
                cityList.remove(city);
                cityList.add(city);
                answer += 1;
            } else {
                if(cityList.size() == cacheSize) {
                    cityList.remove(0);
                }
                cityList.add(city);
                answer += 5;
            }
        }
        return answer;
    }
}
