/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package playfaircipher;

import java.util.ArrayList;

/**
 *
 * @author NISH
 */
public class PolybusSq {

    static ArrayList<ArrayList<Integer>> square;
    private String key;
    private int y;
    private int x;

    public PolybusSq() {
        square = new ArrayList<ArrayList<Integer>>(7);
        this.y = 0;
        this.x = 0;
        square.add(new ArrayList<Integer>(7));
        completeSquare();
    }

    /**
     *
     * @param key
     */
    public PolybusSq(String key) {
        square = new ArrayList<ArrayList<Integer>>(7);
        this.y = 0;
        this.x = 0;
        setKey(key);
    }

    /**
     *
     * @param key
     */
    public void setKey(String key) {
        this.key = removeWhitespace(key.toUpperCase());
        square.add(new ArrayList<Integer>(7));
        for (int z = 0; z < this.key.length(); z++) {
            boolean contains = false;
            for (ArrayList<Integer> ints : square) {
                if (ints.contains(new Integer(this.key.charAt(z)))) {
                    contains = true;
                }
            }
            if (contains) {
                continue;
            }
            if (this.x < 7) {
                square.get(y).add(new Integer(this.key.charAt(z)));
                this.x++;
            } else {
                square.add(new ArrayList<Integer>(7));
                this.y++;
                this.x = 0;
                z--;
            }
        }
        completeSquare();
    }

    /**
     *
     * @param y
     * @param x
     */
    private void completeSquare() {
        int codePoint = 65;
        while (this.y < 7) {
            boolean contains = false;
            if (codePoint > 90) {
                codePoint = 33;
            } else if (codePoint == 74) {
                codePoint = 75;
            } else if (codePoint == 38) {
                codePoint = 39;
            } else if (codePoint == 42) {
                codePoint = 44;
            } else if (codePoint == 58) {
                codePoint = 61;
            } else if (codePoint == 62) {
                codePoint = 63;
            }
            for (ArrayList<Integer> ints : square) {
                if (ints.contains(new Integer(codePoint))) {
                    contains = true;
                }
            }
            if (contains) {
                codePoint++;
                continue;
            }
            if (this.x < 7) {
                square.get(this.y).add(new Integer(codePoint));
                this.x++;
            } else {
                square.add(new ArrayList<Integer>(7));
                this.y++;
                this.x = 0;
            }
        }
    }

    /**
     *
     * @param loc
     * @return
     */
    public char getCharAt(Location loc) {
        return (char) square.get(loc.getY()).get(loc.getY()).intValue();
    }

    /**
     *
     * @param c
     * @return the Location of c
     */
    public Location getLocationOf(char c) {
        c = Character.toUpperCase(c);
        if (c == 'J') {
            c = 'I';
        }
        for (int r = 0; r < 7; r++) {
            if (square.get(r).contains(new Integer(c))) {
                return new Location(square.get(r).indexOf(new Integer(c)), r);
            }
        }
        return null;
    }

    /**
     *
     * @param str
     * @return
     */
    private String removeWhitespace(String str) {
        //TODO: remove whitespace
        String noWhite = "";
        for (int x = 0; x < str.length(); x++) {
            if (!Character.isWhitespace(str.charAt(x))) {
                noWhite += str.charAt(x);
            }
        }
        return noWhite;
    }

    public void reset() {
        square.clear();
        this.x = 0;
        this.y = 0;
    }

    /**
     * 
     * @return
     */
    static String print() {
        String output = "";
        for (ArrayList<Integer> rows : square) {
            for (Integer i : rows) {
                output += (char) i.intValue();
                output += ' ';
            }
            output += '\n';
        }
        return output;
    }
}