class Solution {
    public long[] solution(long[] numbers) {
        long[] result = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            result[i] = getNextBinary(numbers[i]);
        }
        
        return result;
    }
    
    public long getNextBinary(long num) {
        // 짝수일 경우
        if (num % 2 == 0) {
            return num + 1;
        }
        
        // 홀수일 경우
        long bit = 1;
        
        // 가장 오른쪽에서 0이 나올 때까지 이동
        while ((num & bit) != 0) {
            bit <<= 1;
        }
        
        // 가장 오른쪽의 0을 1로 바꾸고, 그 바로 오른쪽 비트를 0으로 바꿈
        return num + bit - (bit >> 1);
    }
}
