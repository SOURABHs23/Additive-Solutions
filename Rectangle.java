class Rectangle {
    int tlx, tly, brx, bry;  
    // Constructor
    public Rectangle(int x1, int y1, int x2, int y2) {
        this.tlx = x1;  // Top-left x
        this.tly = y1;  // Top-left y
        this.brx = x2;  // Bottom-right x
        this.bry = y2;  // Bottom-right y
    }

    // Function to check intersection with separate conditions
    public static boolean isIntersecting(Rectangle r1, Rectangle r2) {
 
        if (r1.brx < r2.tlx || r1.tlx > r2.brx) {
            System.out.println("One rectangle is completely to the left or right of the other.");
            return false;
        }

        if (r1.bry > r2.tly || r1.tly < r2.bry) {
            System.out.println("One rectangle is completely above or below the other.");
            return false;
        }

        // If none of the conditions hold, rectangles intersect
        return true;
    }

    public static void main(String[] args) {
        // Corrected rectangle coordinates (tlx, tly, brx, bry)
        Rectangle rect1 = new Rectangle(0, 4, 4, 0);  // Standard coordinate format
        Rectangle rect2 = new Rectangle(2, 6, 6, 2);  // Adjusted to make (2,6) top-left
        Rectangle rect3 = new Rectangle(5, 8, 8, 5);  // Non-intersecting
        Rectangle rect4 = new Rectangle(-3, 5, -1, 1);  // Non-intersecting

        System.out.println("Rect1 and Rect2 Intersect: " + isIntersecting(rect1, rect2));  // true
        System.out.println("Rect1 and Rect3 Intersect: " + isIntersecting(rect1, rect3));  // false
        System.out.println("Rect1 and Rect4 Intersect: " + isIntersecting(rect1, rect4));  // false (left)
    }
}
