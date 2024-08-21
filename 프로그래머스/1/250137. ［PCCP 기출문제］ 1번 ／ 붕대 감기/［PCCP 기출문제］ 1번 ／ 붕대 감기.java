class Solution {
    
    static int playerHealingTime = 0;
    static int maxHp;
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        int currentTime = 0;
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        
        maxHp = health;
        
        
        for (int[] attack : attacks) {
            currentTime++;
            int nextTime = attack[0];
            int damage = attack[1];
            
            while (currentTime < nextTime) {
                currentTime++;
                health = playerHealing(t,x,y,health);
            }
            health -= damage;
            playerHealingTime = 0;
            if (health <= 0) return -1;
        }
        
        return health;
    }
    
    public static int playerHealing(int t, int x, int y, int health) {
        int result = health;
        playerHealingTime++;
        
        if (health + x <= maxHp) result += x;
        else result = maxHp;
        
        if (playerHealingTime == t) {
            playerHealingTime = 0;
            if (result + y <= maxHp) result += y;
            else result = maxHp;
        } 
        
        return result;
    }
}