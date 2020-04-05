import edu.duke.*;

public class perimeter {

    public double getPerimeter (Shape s){
        double totalPerim = 0;
        Point prevPt = s.getLastPoint();
        for(Point currPt: s.getPoints())
            {
                double currDist = prevPt.distance(currPt);
                totalPerim += currDist;
                prevPt = currPt;
            }
        return totalPerim;
    }
}
