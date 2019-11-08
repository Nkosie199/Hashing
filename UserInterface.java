import java.util.List;
import java.util.Scanner;
/**
 * Simple electronic dictionary program.
 * 
 * @author Stephan Jamieson
 * @version 23/4/2015
 */
public class UserInterface {
    //private static PerformanceTester PerformanceTester;
    private static boolean performanceTesting = false; //to see whethet or not performance testing is underway 
    
    private UserInterface() {}
    
    public static void main(String[] args) throws java.io.FileNotFoundException, java.io.IOException {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Choose a hash table implementation:");
        System.out.println("1. Linear Probing.");
        System.out.println("2. Quadratic Probing.");
        System.out.println("3. Separate Chaining.");
        System.out.println("4. Load Performance Testing.");
        System.out.println("5. Search Performance Testing.");
        int selection = input.nextInt();

        Dictionary dictionary = null;
  
        switch (selection) {
            case 1:
                dictionary = new LPHashtable(7481);
                break;
            case 2:
                dictionary = new QPHashtable(7481);
                 break;
             case 3:
                 dictionary = new SCHashtable(3739);
                 break;
             case 4:
                 new LoadPerformanceTester();
                 performanceTesting = true;
                 break;
             case 5:
                 new SearchPerformanceTester();
                 performanceTesting = true;
                 break;
                 
                                            
          default: 
                System.out.println("Selection not recognised.");
                System.exit(-1);
        }
        
        if (performanceTesting==true){
            quitPerformanceTesting();
        }
        
        FileUtil.load(dictionary, "lexicon.txt");
        //
        
        //
        System.out.println("Enter a word (or '#quit'):");
        String word = input.next().toLowerCase();
        while (!word.equals("#quit")) {
            List<Definition> definitions = dictionary.getDefinitions(word);
            if (definitions==null) {
                System.out.println("No entry for this word.");
            }
            else {
                System.out.println(definitions);
            }  
            ///
            
            ///
            System.out.println("Enter a word (or '#quit'):");
            word = input.next().toLowerCase();
        }        
        
        
     }
    public static void quitPerformanceTesting(){
          System.exit(-1);  
    }
}
