class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        Video video = new Video(video_len, pos, op_start, op_end);
        
        for (int i = 0; i < commands.length; i++) {
            video.move(commands[i].equals("next"));
        }
        return video.toString();
    }
}

class Video {
    int[] videoLen = new int[2];
    int[] curTime = new int[2];
    int[] opStart = new int[2];
    int[] opEnd = new int[2];
    
    public Video(String videoLen, String pos, String opStart, String opEnd) {
        String[] tmp = videoLen.split(":");
        this.videoLen[0] = Integer.parseInt(tmp[0]);
        this.videoLen[1] = Integer.parseInt(tmp[1]);
        
        tmp = pos.split(":");
        this.curTime[0] = Integer.parseInt(tmp[0]);
        this.curTime[1] = Integer.parseInt(tmp[1]);
        
        tmp = opStart.split(":");
        this.opStart[0] = Integer.parseInt(tmp[0]);
        this.opStart[1] = Integer.parseInt(tmp[1]);
        
        tmp = opEnd.split(":");
        this.opEnd[0] = Integer.parseInt(tmp[0]);
        this.opEnd[1] = Integer.parseInt(tmp[1]);
        
        opSkip();
    }
    
    public void move(boolean next) {
        if (next) {
            curTime[1] += 10;
        } else {
            curTime[1] -= 10;
        }
        timeSet();
    }
    
    public void timeSet() {
        // 시간 포멧 맞추기
        if (curTime[1] >= 60) {
            curTime[1] -= 60;
            curTime[0] += 1;
        } else if (curTime[1] < 0) {
            curTime[0] -= 1;
            curTime[1] += 60;
        }
        // 비디오 길이 초과인지
        int time = getTime(curTime);
        int endTime = getTime(videoLen);
        if (time > endTime) {
            curTime[0] = videoLen[0];
            curTime[1] = videoLen[1];
        }
        else if (time < 0) {
            curTime[0] = 0;
            curTime[1] = 0;
        }
        
        opSkip();   
    }
    
    public void opSkip() {
        int time = getTime(curTime);
        
        int opStartTime = getTime(opStart);
        int opEndTime = getTime(opEnd);
        
        if (opStartTime <= time && time <= opEndTime) {
            curTime[0] = opEnd[0];
            curTime[1] = opEnd[1];
        }
    }
    
    public int getTime(int[] arr) {
        return arr[0] * 100 + arr[1];
    }
    
    @Override
    public String toString() {
        
        String min = "" + curTime[0];
        String sec = "" + curTime[1];
        
        if (min.length() == 1)
            min = "0" + min;
        if (sec.length() == 1)
            sec = "0" + sec;
        
        return min + ":" + sec;
    }
}