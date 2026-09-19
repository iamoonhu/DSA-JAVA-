class Solution {
    public boolean checkOverlap(int r, int xc, int yc, int x1, int y1, int x2, int y2) {
        int cx= Math.max(x1,Math.min(xc,x2));
        int cy=Math.max(y1,Math.min(yc,y2));

        int dx=(xc-cx);
        int dy=(yc-cy);

        return(((dx*dx)+(dy*dy))<=r*r);
    }
}