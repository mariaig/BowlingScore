
package bowlingscore;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;

/**
 *
 * @author Maria
 */
public class InputFileParser {
   
   public ArrayList<Frame> parseFile(String pathToFile){
        BufferedReader br;       
        ArrayList<Frame> frames=new ArrayList<>();
        try{
            br=new BufferedReader(new FileReader(pathToFile));
            String line;
            while((line=br.readLine())!=null){
                frames.add(parseLine(line));
            }
	}catch(IOException io){
            io.printStackTrace();
	}
       return frames;
   }
   
   
    private Frame parseLine(String line){
        
        if(line.equals("X")){
            return new Frame("X");
        }

        String[] parts=line.split(" ");
        
        if(parts.length==2){
            return new Frame(parts[0],parts[1]);
        }
        
        return new Frame(parts[0],parts[1],parts[2]);
    }
}

