
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package playfaircipher;

/**
 *
 * @author NISH
 */
public class Location implements Comparable<Location> {

    private int x;
    private int y;

    public Location() {
        x = 0;
        y = 0;
    }

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int compareTo(Location o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}