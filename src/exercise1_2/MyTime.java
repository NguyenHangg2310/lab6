package exercise1_2;

public class MyTime {
    private int hour;
    private int minute;
    private int second;

    public MyTime() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public MyTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void setTime(int hour, int minute, int second) {
        try {
            if ((hour >= 0 && hour <= 23) && (minute >= 0 && minute <= 59)
                    && (second >= 0 && second <= 59)) {
                this.hour = hour;
                this.minute = minute;
                this.second = second;
            } else {
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e) {
            System.out.println("Invalid hour, minute, or second!");
        }
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if (this.hour >= 0 && this.hour <= 23) {
            this.hour = hour;
        }
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        if (this.minute >= 0 && this.minute <= 59) {
            this.minute = minute;
        }
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        if (this.second >= 0 && this.second <= 59) {
            this.second = second;
        }
    }

    public String toString() {
        String hour = Integer.toString(this.hour);
        String minute = Integer.toString(this.minute);
        String second = Integer.toString(this.second);
        if (getHour() <= 9) {
            hour = "0" + getHour();
        }
        if (getMinute() <= 9) {
            minute = "0" + getMinute();
        }
        if (getSecond() <= 9) {
            second = "0" + getSecond();
        }
        return hour + ":" + minute + ":" + second;

    }

    public MyTime nextSecond() {
        if (this.second != 59) {
            setSecond(this.second + 1);
        } else {
            setSecond(0);
            if (this.minute != 59) {
                setMinute(this.minute + 1);
            } else {
                setMinute(0);
                if (this.hour != 23) {
                    setHour(this.hour + 1);
                } else {
                    setHour(0);
                }

            }
        }
        return this;
    }

    public MyTime nextMinute() {
        if (this.minute != 59) {
            setMinute(this.minute + 1);
        } else {
            setMinute(0);
            if (this.hour != 23) {
                setHour(this.hour + 1);
            }else {
                setHour(0);
            }
        }
        return this;
    }

    public MyTime nextHour() {
        if (this.hour != 23) {
            setHour(this.hour + 1);
        } else {
            setHour(0);
        }
        return this;
    }

    public MyTime previousSecond() {
        if (this.second != 0) {
            setSecond(this.second - 1);
        } else {
            setSecond(59);
            if (this.minute != 0) {
                setMinute(this.minute - 1);
            }else {
                setMinute(59);
                if (this.hour !=0) {
                    setHour(this.hour - 1);
                }else {
                    setHour(23);
                }
            }
        }
        return this;
    }

    public MyTime previousMinute() {
        if (this.minute != 0) {
            setMinute(this.minute - 1);
        } else {
            setMinute(59);
            if (this.hour != 0) {
                setHour(this.hour - 1);
            }else {
                setHour(23);
            }
        }
        return this;
    }

    public MyTime previousHour() {
        if (this.hour != 0) {
            setHour(this.hour - 1);
        }else {
            setHour(23);
        }
        return this;
    }

}