
/**
bandage[0] t : 시전시간
bandage[1] x : 초당 회복량
bandage[2] y : 추가 회복량
t 초동안 붕대를 감으면서 1초마다 x만큼 회복이 되고 t초 동안 붕대를 감는데 성공하면 y만큼 추가적으로 체력 회복

health : 최대 체력(이 이상 회복이 되지 않음을 의미)

attacks[i][0] : 공격시간
attacks[i][1] : 피해량

공격을 받으면 다시 처음부터 붕대를 감아야한다
공격에 소요되는 시간에 대해 오름차순으로 정렬되어 있다
공격에 소요되는 시간은 모두 다른다

전투 후 남은 체력을 return한다
이때 공격을 받은 후 player의 hp가 0이하라면 즉시 -1을 리턴한다
*/
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        Player player = new Player(bandage, health);
        
        
        // 현재 attacks배열의 index
        int time = 0;
        for (int[] attack : attacks) {
            time++;
            int nextTime = attack[0];
            int damage = attack[1];
            
            while (time < nextTime) {
                time++;
                player.timePass();
            }
            player.attack(damage);
        }
        
        return player.getHp();
    }
}

class Player {
    private int healingTime = 0;
    private int maxHp;
    private int hp;   // 현재 hp
    private int t;    // 붕대 감는 시간
    private int x;    // 초당 회복 시간
    private int y;    // 붕대 감기 회복량

    Player(int[] bandage, int health) {
        t = bandage[0];
        x = bandage[1];
        y = bandage[2];
        hp = health;
        maxHp = health;
    }

    // 1초 메소드
    // 시간은 + 1 증가하고 체력 회복
    void timePass() {
        healingTime++;
        recovery(x);

        if (healingTime == t) {
            recovery(y);
            healingTime = 0;
        }
    }

    void recovery(int n) {
        
        if (hp == -1) return;
        
        if (n + hp <= maxHp) hp += n;
        else hp = maxHp;
    }
    
    void attack(int damage) {
        hp -= damage;
        
        if (hp <= 0) hp = -1;
        healingTime = 0;
    }
    
    int getHp() {
        return hp;
    }
    
    @Override
    public String toString() {
        return "현재 hp : " + hp;
    }
}
