package bowlingscore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maria
 */
public class MainClass {

    private static final String testResults = "result";
    private static final String testResultsExtension = ".txt";
    private static final String tests = "game";
    private static final String testsExtension = ".txt";
    private static final int nrOfTests = 17;
    
    private static final int maxRollsLength = 40;

    public static void main(String[] args) {
        InputFileParser ifp = new InputFileParser();
        //ArrayList<Frame> allFrames;
        
        int[] rolls = new int[maxRollsLength];
        BowlingScore bs = new BowlingScore();
        int score;
        int correctResult;
        
        for (int i = 1; i <= nrOfTests; i++) {
            try {
                rolls = ifp.parseTests(tests + i + testsExtension, maxRollsLength);
                score = bs.computeScoreFor(rolls);
                correctResult = ifp.getResult(testResults + i + testResultsExtension);
                System.out.print("Test" + i);
                if (correctResult == score) {
                    System.out.print(" passed");
                } else {
                    System.out.print(" failed");
                }
                System.out.println(" Total score: " + score);
            } catch (IOException ex) {
                ex.printStackTrace();
                System.err.println("Test" + i + " failed!");
            } catch (InvalidNumberOfRolls ex) {
                InvalidNumberOfRolls.showMessage();
                System.err.println("Test" + i + " failed!");
            } catch (InvalidRepresentationOfRolls ex) {
                InvalidRepresentationOfRolls.showMessage();
                ex.printStackTrace();
                System.err.println("Test" + i + " failed!");
            }catch(CannotFindInt ex){
               CannotFindInt.showMessage();
               System.err.println("Test" + i + " failed!");
            }
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
