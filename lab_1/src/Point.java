public class Point {
    private int x;
    private int y;

    // Write a method quadrant that returns the quadrant of the x/y plane this Point
    // object falls in. Quadrant 1 contains all points whose x and y values are both
    // positive. Quadrant 2 contains all points with negative x but positive y.
    // Quadrant 3 contains all points with negative x and y values. Quadrant 4
    // contains all points with positive x but negative y. If the point lies
    // directly on the x and/or y axis, return 0

    private static int quadrant(int x, int y) {
        if (x > 0 && y > 0) {
            return 1;
        } else if (x < 0 && y > 0) {
            return 2;
        } else if (x < 0 && y < 0) {
            return 3;
        } else if (x > 0 && y < 0) {
            return 4;
        } else {
            return 0;
        }
    }

    // Write a method flip that negates and swaps the x/y coordinates of the Point
    // object. For example, if the object initially represents the point (5, -3),
    // after a call to flip, the object should represent (3, -5). If the object
    // initially represents the point (4, 17), after a call to flip, the object
    // should represent (-17, -4).

    public void flip() {
        int temp = this.x;
        this.x = -this.y;
        this.y = -temp;
    }

    // Write a method manhattanDistance that accepts another Point object and
    // returns the "Manhattan distance" between the current Point object and the
    // given other Point object. The Manhattan distance refers to how far apart two
    // places are if the person can only travel straight horizontally or vertically,
    // as though driving on the streets of Manhattan. In our case, the Manhattan
    // distance is the sum of the absolute values of the differences in their
    // coordinates; in other words, the difference in x plus the difference in y
    // between the points.

    public int manhattanDistance(Point obj) {
        return (this.x + this.y) + (obj.x + obj.y);
    }

    // Write a method isVertical that accepts another Point object and returns true
    // if the given Point lines up vertically with this Point; that is, if their x
    // coordinates are the same.

    public boolean isVertical(Point obj) {
        if (this.x == obj.x) {
            return true;
        }
        return false;
    }

    // Write a method slope that accepts another Point object and returns the slope
    // of the line drawn between this Point and the given other Point. Use the
    // formula (y2 - y1) / (x2 - x1) to determine the slope between two points (x1,
    // y1) and (x2, y2). Note that this formula fails for points with identical
    // x-coordinates, so throw an IllegalArgumentException in this case.
    

    public double slope(Point obj) throws IllegalArgumentException {
        double value = (obj.y - this.y)/(obj.x - this.x);
        return value;
    }

    // Write a method isCollinear that accepts two Point objects and returns whether
    // this Point is collinear with the given two other points. Points are collinear
    // if a straight line can be drawn that connects them. Two basic examples are
    // three points that have the same x- or y-coordinate. The more general case can
    // be determined by calculating the slope of the line between each pair of
    // points and checking whether this slope is the same for all pairs of points.
    // Use the formula (y2 - y1) / (x2 - x1) to determine the slope between two
    // points (x1, y1) and (x2, y2). (Note that this formula fails for points with
    // identical x-coordinates so this will have to be special-cased in your code.)
    // Note: since Java's double type is imprecise, round all slope values to a
    // reasonable accuracy such as four digits past the decimal point before you
    // compare them.

    public boolean isCollinear(Point objOne, Point objTwo) {
        double slopeOne = this.slope(objOne);
        double slopeTwo = this.slope(objTwo);
        double slopeThree = (objTwo.y - objOne.y)/(objTwo.x - objOne.x);

        if (slopeOne == slopeTwo && slopeTwo == slopeThree && slopeThree == slopeOne) {
            return true;
        }
        return false;
    }
}