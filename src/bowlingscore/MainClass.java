/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        //int i=5;
        for(int i=1;i<10;i++){
            allFrames=ifp.parseFile("rolls"+i+".txt");
            score=bs.getTotalScore(allFrames);
            for(Frame f:allFrames){
                System.out.print(f.partialFrameScore+" ");
            }
            System.out.print("\n");
            if(score==300){
               System.out.println("rolls"+i+".txt PERFECT GAME!!! SCORE: "+score);
            }else{
                System.out.println("rolls"+i+".txt  Total score: "+score);
            }
            allFrames.clear();
       }
    }
}
