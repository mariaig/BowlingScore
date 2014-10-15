package bowlingscore;

import java.util.ArrayList;

/**
 *
 * @author Maria
 */
public class MainClass {
    
    public static void main(String[] args) {
        InputFileParser ifp=new InputFileParser();
        ArrayList<Frame> allFrames;
        BowlingScore bs=new BowlingScore();
        int score;
        for(int i=1;i<14;i++){
            allFrames=ifp.parseFile("rolls"+i+".txt");
            score=bs.getTotalScore(allFrames);
            if(score==300){
               System.out.println("rolls"+i+".txt  PERFECT GAME!!! SCORE: "+score);
            }else{
                System.out.println("rolls"+i+".txt  Total score: "+score);
            }
            allFrames.clear();
       }
    }
}
