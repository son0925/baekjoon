class Solution {
    public int solution(int storey) {
        int result = 0;
        
        while (storey > 0) {
			int floor = storey % 10; 
			storey /= 10;

			if (floor > 5) {
				result += 10 - floor;
				storey++;
			} else if (floor < 5){
				result += floor;
			} 
            // 5일 때
            else { 
				result += floor;
				if (storey % 10 >= 5) {
                    storey ++;
                }
			} 
		}
        
        return result;
    }
}