public class Triangle {
    //PRIVATE INSTANCE VARIABLES
    private int hSide;
    private int aSide;
    private int bSide;

    //CONSTRUCTORS
    public Triangle() {
        int side1 = getRandomSide();
        int side2 = getRandomSide();
        int side3 = getRandomSide();
        sortSides(side1, side2, side3);
    }

    public Triangle( int side1, int side2 ) {
        int side3 = getRandomSide();
        sortSides(side1, side2, side3);
    }

    public Triangle( int side1, int side2, int side3 ) {
        sortSides(side1, side2, side3);
    }

    //PUBLIC METHODS
    public String toString() {
        return String.format("Triangle with sides: %d, %d, %d", this.aSide, this.bSide, this.hSide); 
    }

    public int getPerimeter() {
        return this.aSide + this.bSide + this.hSide;
    }

    // use Heron's formula to get Area as int (rounded to nearest int)
    public int getArea() {
        //calculate the half perimeter for Heron's formula as a double
        double s = this.getPerimeter() / 2.0;
        //calculate the area using Heron's formula, sqrt() returns a double
        double area = Math.sqrt(
            s * (s - (double)this.aSide) 
                * (s - (double)this.bSide) 
                * (s - (double)this.hSide));
        //use Math to round the double and then cast the long -> int
        return (int)Math.round(area);
    }

    // uses Pythagoras to decide if triangle is RIGHT, ACUTE, or OBTUSE
    public String classifyByAngles() {
        //calculate the square of the hyp and sum of squares of legs
        int hypotenuseSquared = this.hSide^2;
        int legsSquared = this.aSide^2 + this.bSide^2;

        //test the squares for Equal(RIGHT), Less(ACUTE), Greater(OBTUSE)
        if (hypotenuseSquared == legsSquared) {
            return "RIGHT";
        }else if (hypotenuseSquared < legsSquared) {
            return "ACUTE";
        } else {
            return "OBTUSE";
        }
    }

    //PRIVATE METHODS
    //
    private void sortSides( int side1, int side2, int side3 ) {
        //find the largest side and assign to hypotenuse
        int maxSide = Math.max( side1, side2 );
        maxSide = Math.max( maxSide, side3 );
        this.hSide = maxSide;
        
        //set the triangle legs based on which side is the hypotenuse    
        if (this.hSide == side1) {
            //1 is the hyp, so 3/2 are the legs
            this.bSide = Math.max(side2, side3);
            this.aSide = Math.min(side2, side3);
        } else if(hSide == side2) {
            //2 is the hyp, so 1/3 are the legs
            this.bSide = Math.max(side1, side3);
            this.aSide = Math.min(side1, side3);
        } else {
            //3 is the hyp, so 1/2 are the legs
            this.bSide = Math.max(side1, side2);
            this.aSide = Math.min(side1, side2);
        }
    }

    // used to get a random size using default min/max range
    private int getRandomSide() {
        int min = 21;
        int max = 40;
        return getRandomSide(min, max);
    }

    // used to get a random size using ANY min/max range
    private int getRandomSide( int min, int max) {
        int side = min + (int)(Math.random() * ((max - min) +1));
        return side;
    }
}