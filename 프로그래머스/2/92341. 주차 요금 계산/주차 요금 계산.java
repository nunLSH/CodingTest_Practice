import java.util.*;
import java.time.LocalTime;
class Solution {
    
    public int[] solution(int[] fees, String[] records) {
        Map<String, String> parking = new HashMap<>();
        Map<String, Integer> totalTime = new HashMap<>();
        
        for (int i = 0; i < records.length; i++){
            String[] cur = records[i].split(" ");
            String time = cur[0];
            String carNum = cur[1];
            String status = cur[2];
            
            // 입차
            if (status.equals("IN"))
                parking.put(carNum, time);
            // 출차
            else {
                int in = toMinute(parking.get(carNum));
                int out = toMinute(time);
                int duration = out - in;
                
                // 시간 계산
                totalTime.put(carNum, 
                              totalTime.getOrDefault(carNum, 0) + duration);

                parking.remove(carNum);
            }
        }
        
        // 출차 기록이 없는 차
        int end = toMinute("23:59");
        for (String car : parking.keySet()){
            int in = toMinute(parking.get(car));
            totalTime.put(car, totalTime.getOrDefault(car, 0) + (end - in));
        }
        
        // 자동차 번호 별로 금액 계산
        // 키 정렬
        List<String> cars = new ArrayList<>(totalTime.keySet());
        Collections.sort(cars);
        int[] answer = new int[cars.size()];
        for (int i = 0; i < cars.size(); i++){
            String car = cars.get(i);
            answer[i] = calculate(totalTime.get(car), fees);
        }
        

        return answer;
    }

    
    private int toMinute(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
    
    public int calculate(int time, int[] fees) {
        if (time <= fees[0])
            return fees[1];
        else {
            if ((time - fees[0]) % fees[2] != 0)
                return fees[1] + ((time - fees[0]) / fees[2] + 1) * fees[3];
            else 
                return fees[1] + ((time - fees[0]) / fees[2]) * fees[3];
        }
    }
}
