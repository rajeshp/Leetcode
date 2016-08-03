/**
 * Created by prajesh on 6/24/16.
 */
public class RectangleArea {

    public static void main(String[] args) {

    }

    static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        int area1 = Math.abs((C-A) * (D-B));

        int area2 = Math.abs((G-E)*(H-F));

        int l = (min(C,G) > max(A, E)) ? (min(C,G) - max(A, E)) : 0;
        int h = (min(D, H) > max(B,F)) ?(min(D, H) - max(B,F)) : 0 ;



        return area1+area2 - (l*h);

    }

    static int max(int a, int b){
        return (a>b)? a : b;
    }

    static int min(int a, int b){
        return (a<b)? a: b;
    }
}


