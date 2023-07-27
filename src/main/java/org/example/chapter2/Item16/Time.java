package org.example.chapter2.Item16.time;

// 16-3 [불변 필드 노출한 public 클래스]
public final class Time {

    private static final int HOURS_PER_DAY= 24;
    private static final int MINUTES_PER_DAY= 60;

    public final int hour;
    public final int minute;

    public Time(int hour, int minute) {

        if(hour<0 || hour >= HOURS_PER_DAY){
            throw new IllegalArgumentException("시간 : " + hour);
        }if(minute<0 || minute >= MINUTES_PER_DAY){
            throw new IllegalArgumentException("분 : " + minute);
        }
        this.hour = hour;
        this.minute = minute;
    }
}

/*
fianl을 사용한다면 그나마 단점이 조금 줄어든긴 하지만,
결국 public필드는 가변적이기 때문에 어디서 값이 변경될지 모르는 위험이 존재, 부수작업 역시 수행X
*/
