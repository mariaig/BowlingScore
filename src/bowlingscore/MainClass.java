package bowlingscore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maria
 */
public class MainClass {
    
    public static void main(String[] args) {
        InputFileParser ifp=new InputFileParser();
        //ArrayList<Frame> allFrames;
        int rollsLength=40;
        int[] rolls=new int[rollsLength];
        BowlingScore bs=new BowlingScore();
        int score;
        try {
            rolls=ifp.parseFile("game5.txt",rollsLength);
            score=bs.computeScoreFor(rolls);
            System.out.println("Total score: "+score);
        } catch (IOException ex) {
           ex.printStackTrace();
        } catch (InvalidNumberOfRolls ex) {
            InvalidNumberOfRolls.showMessage();
        } catch (InvalidRepresentationOfRolls ex) {
            InvalidRepresentationOfRolls.showMessage();
        }
        
        
//        for(int i=1;i<14;i++){
//            allFrames=ifp.parseFile("rolls"+i+".txt");
//            score=bs.getTotalScore(allFrames);
//            if(score==300){
//               System.out.println("rolls"+i+".txt  PERFECT GAME!!! SCORE: "+score);
//            }else{
//                System.out.println("rolls"+i+".txt  Total score: "+score);
//            }
//            allFrames.clear();
//       }
    }
}
