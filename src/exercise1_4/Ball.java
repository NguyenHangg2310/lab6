package exercise1_4;

public class Ball {
    private float x;
    private float y;
    private int radius;
    private float xDelta;
    private float yDelta;

    public Ball(float x, float y, int radius, int speed, int direction) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.xDelta = speed * (float) Math.cos(direction);
        this.yDelta = speed * (float) Math.sin(direction);

    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public float getXDelta() {
        return xDelta;
    }

    public void setXDelta(float xDelta) {
        this.xDelta = xDelta;
    }

    public float getYDelta() {
        return yDelta;
    }

    public void setYDelta(float yDelta) {
        this.yDelta = yDelta;
    }

    public void move() {
        setX(x + xDelta);
        setY(y + yDelta);
    }

    public void reflectHorizontal() {
        setXDelta(-xDelta);
    }

    public void reflectVertical() {
        setYDelta(-yDelta);
    }

    public String toString() {
        return "Ball[(" + this.x + "," + this.y + "," + "speed=(" + this.xDelta + "," + this.yDelta + ")]";
    }
}
