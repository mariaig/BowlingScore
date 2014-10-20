package bowlingscore;

/**
 *
 * @author Maria
 */
public class Frame { 
    public int firstScore=0;
    public int secondScore=0;
    public int thirdScore=0; //used only for frame10
    
    //public int partialFrameScore=0;
    Frame(int firstScore,int secondScore){
        this.firstScore=firstScore;
        this.secondScore=secondScore;
    }
    
    Frame(String first){
       if(first.equals("-")){
           this.firstScore=0;
       }else if(first.equals("X")){
            this.firstScore=10;
       }else{
            this.firstScore=Integer.parseInt(first);
       }
    }
    Frame(String first,String second){
        this(first);
        if(second.equals("-")){
           this.secondScore=0;
        }else if(second.equals("X")){
            this.secondScore=10;
        }else if(second.equals("/")){
            this.secondScore=10-this.firstScore;
        }else{
            this.secondScore=Integer.parseInt(second);
        }
        
    }
    Frame(String first,String second,String third){
        this(first,second);
        if(third.equals("-")){
           this.thirdScore=0;
       }else if(third.equals("X")){
            this.thirdScore=10;
        }else if(third.equals("/")){
            this.thirdScore=10-this.secondScore;
        }else{
            this.thirdScore=Integer.parseInt(third);
        }
    }
 
  
    public boolean isStrike(){
        return this.firstScore==10;
    }
    
    public boolean isSpare(){
        return this.firstScore+this.secondScore==10;
    }
   
    public void setThirdScore(int thirdScore){
        this.thirdScore=thirdScore;
    }
    
    
    @Override
    public String toString(){
        return "("+firstScore+" "+secondScore+" "+thirdScore+")";
    }
}
