
package bowlingscore;


import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Maria
 */
public class InputFileParser {
   
    public int[] parseFile(String pathToFile,int rollsLength) throws IOException, InvalidNumberOfRolls, InvalidRepresentationOfRolls{
        int[] rolls=new int[rollsLength];
        int nrOfRolls=0;
        int i=0;
        
        Scanner scan=new Scanner(new FileReader(pathToFile));
        
        while(scan.hasNext()){
           
            try{
                rolls[i++]=scan.nextInt();
            }catch(NoSuchElementException | IllegalStateException  ex){
                throw new InvalidRepresentationOfRolls();
            }
            nrOfRolls++;
            System.out.println(rolls[i-1]);
        }
        
        if(nrOfRolls<20||nrOfRolls>21){
            throw new InvalidNumberOfRolls();
        }
        return rolls;
    }
//    
//   public ArrayList<Frame> parseFile(String pathToFile){
//        BufferedReader br;       
//        ArrayList<Frame> frames=new ArrayList<>();
//        try{
//            br=new BufferedReader(new FileReader(pathToFile));
//            String line;
//            while((line=br.readLine())!=null){
//                frames.add(parseLine(line));
//            }
//	}catch(IOException io){
//            io.printStackTrace();
//	}
//       return frames;
//   }
//   
//   
//    private Frame parseLine(String line){
//        
//        if(line.equals("X")){
//            return new Frame("X");
//        }
//
//        String[] parts=line.split(" ");
//        
//        if(parts.length==2){
//            return new Frame(parts[0],parts[1]);
//        }
//        
//        return new Frame(parts[0],parts[1],parts[2]);
//    }
}

