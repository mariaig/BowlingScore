
package bowlingscore;

import java.util.ArrayList;

/**
 *
 * @author Maria
 */
public class BowlingScore {

    public int getTotalScore(ArrayList<Frame> frames){
        
        
        int nrOfStrikes=0;
        /*Searching for a perfect game*/
        for(Frame f:frames){
            if(f.isStrike()){
                nrOfStrikes++;
            }
        }
        if(nrOfStrikes==10 && frames.get(9).secondScore==10 && frames.get(9).thirdScore==10){
            //a perfect game is rearded with 300 
            return 300;
        }
        
        nrOfStrikes=0;
        int totalScore=0;
        int i=0;
        boolean flag=false;
        
        while(i<frames.size()){
            if(nrOfStrikes==3){
                //3 strikes one after another
                nrOfStrikes=0;
                frames.get(i-3).partialFrameScore=totalScore+30;
                totalScore+=30;
                i=i-2;
                continue;
            }
            if(flag){
                //strikes near frame 10
                if(nrOfStrikes==2){
                    frames.get(8).partialFrameScore=totalScore+20+frames.get(9).secondScore;
                    totalScore+=20+frames.get(9).secondScore;
                    frames.get(9).partialFrameScore=totalScore+10+frames.get(9).secondScore+frames.get(9).thirdScore;
                    totalScore+=10+frames.get(i).secondScore+frames.get(i).thirdScore;
                    break;
                }
            }
            if(frames.get(i).isStrike()){
                if(i==9){
                    System.out.println("Here");
                    //strike at the last frame
                    if(nrOfStrikes==0){
                        frames.get(i).partialFrameScore=totalScore+10+frames.get(i).secondScore+frames.get(i).thirdScore;
                        totalScore+=10+frames.get(i).secondScore+frames.get(i).thirdScore;
                        break;
                    }else{
                        nrOfStrikes++;
                        flag=true;
                        continue;
                    }
                }
                else{
                    //if it's not the last frame, then we should look at the next rolls
                    nrOfStrikes++;
                    i++;
                    continue;
                }
            }else{
                //check number of strike's because we want to finish with their partial score first
                if(nrOfStrikes>0){
                    if(nrOfStrikes==1){
                        // Strike +  Normal roll (not a strike or a spare) 
                        frames.get(i-1).partialFrameScore=totalScore+10+frames.get(i).firstScore+frames.get(i).secondScore;
                        totalScore+=10+frames.get(i).firstScore+frames.get(i).secondScore;
                        nrOfStrikes=0;
                        continue;
                    }
                    else if(nrOfStrikes==2){
                        // Strike+Strike+Normal roll
                        frames.get(i-2).partialFrameScore=totalScore+20+frames.get(i).firstScore;
                        totalScore+=20+frames.get(i).firstScore;
                        nrOfStrikes=0;
                        i=i-1;
                        continue;
                    }
                }
                
                /*Check if it's a spare*/
                if(frames.get(i).isSpare()){
                    if(i==9){
                        //Spare at the last frame = 10+extraball(third)
                        frames.get(i).partialFrameScore=totalScore+10+frames.get(i).thirdScore;
                        totalScore+=10+frames.get(i).thirdScore;
                        break;
                    }
                    if(i+1<10){
                        //Spare = 10+next ball
                        frames.get(i).partialFrameScore=totalScore+10+frames.get(i+1).firstScore;
                        totalScore+=10+frames.get(i+1).firstScore;
                        i++;
                        continue;
                    }
                    
                }
                
                //without spare or strike is ball1+ball2;
                frames.get(i).partialFrameScore=totalScore+frames.get(i).firstScore+frames.get(i).secondScore;
                totalScore+=frames.get(i).firstScore+frames.get(i).secondScore;
                i++;
            }
            
        }
    return totalScore;
    }
    
}
