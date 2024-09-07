class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        Video video = new Video(video_len, pos, op_start, op_end);
        
        for (String command : commands) {
            video.move(command);
        }
        
        return video.toString();
    }
}

class Video {
    int vdTime;
    int curTime;
    int opStart;
    int opEnd;
    
    public Video(String video_len, String pos, String op_start, String op_end) {
        this.vdTime = Integer.parseInt(video_len.split(":")[0]) * 60 + 
                        Integer.parseInt(video_len.split(":")[1]);
        
        this.curTime = Integer.parseInt(pos.split(":")[0]) * 60 + 
                        Integer.parseInt(pos.split(":")[1]);
        
        this.opStart = Integer.parseInt(op_start.split(":")[0]) * 60 + 
                        Integer.parseInt(op_start.split(":")[1]);
        
        this.opEnd = Integer.parseInt(op_end.split(":")[0]) * 60 + 
                        Integer.parseInt(op_end.split(":")[1]);
        
        opSkip();
    }
    
    void opSkip() {
        if (opStart <= curTime && curTime < opEnd)
            curTime = opEnd;
    }
    
    void move(String command) {
        if (command.equals("next"))
            curTime += 10;
        else
            curTime -= 10;
        
        timeSet();
    }
    
    void timeSet() {
        if (curTime < 0)
            curTime = 0;
        else if (curTime > vdTime)
            curTime = vdTime;
        
        opSkip();
    }
    
    @Override
    public String toString() {
        String mm = "" + curTime / 60;
        String ss = "" + curTime % 60;
        
        if (mm.length() == 1)
            mm = "0" + mm;
        if (ss.length() == 1)
            ss = "0" + ss;
        
        return mm + ":" + ss;
    }
}