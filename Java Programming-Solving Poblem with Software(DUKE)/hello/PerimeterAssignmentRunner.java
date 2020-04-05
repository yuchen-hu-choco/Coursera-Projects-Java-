import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int i = 0;
        for(Point g : s.getPoints()){i+=1;}
        return i; 
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double totalPerim = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints())
        {
            double currDist = prevPt.distance(currPt);
            totalPerim += currDist;
            prevPt = currPt;
        }
        return totalPerim/getNumPoints(s);
    }

    public double getLargestSide(Shape s) {
        // Put code here
        Point P1 = s.getLastPoint();
        double dist = 0.0;
        for (Point g : s.getPoints())
        {
            if(P1.distance(g) > dist)
            {
                dist = P1.distance(g);
            }
            P1 = g;
        }
        return dist;
    }

    public double getLargestX(Shape s) {
        // Put code here
        int LX = s.getLastPoint().getX();
        for(Point p : s.getPoints())
        {
            if (p.getX() > LX) LX = p.getX();
        }
        return LX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double largest = 0.0;
        double length;
        DirectoryResource f = new DirectoryResource();
        for(File k : f.selectedFiles())
        {
            FileResource j = new FileResource(k);
            Shape s = new Shape(j);
            length = getPerimeter(s);
            if (length > largest) largest = length;
        }
        return largest;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        DirectoryResource f = new DirectoryResource();
        File temp = null;
        double length;
        double Parameter, largest = 0;
        for(File k : f.selectedFiles())
        {
            FileResource j = new FileResource(k);
            Shape s = new Shape(j);
            length = getPerimeter(s);
            if (length > largest) {temp = k; largest = length;}
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        System.out.println("The number of points"+" "+getNumPoints(s));
        System.out.println("The Average Length"+" "+getAverageLength(s));
        System.out.println("The Largest Side"+" "+getLargestSide(s));
        System.out.println("The Largest X"+" "+getLargestX(s));
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double largest = getLargestPerimeterMultipleFiles();
        System.out.println(largest);
        
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String Fn = getFileWithLargestPerimeter();
        System.out.println(Fn);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
