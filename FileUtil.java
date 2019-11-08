import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Module containing utility methods.
 * 
 * @author Stephan Jamieson
 * @version 24/4/2015
 */
public class FileUtil {

    private FileUtil() {}
    
    public static int tableSize = 0;
    static int j=0;
    /**
     * Load the dictionary with the word definitions in the given file. <br>
     * 
     * &lt;lexicion&gt; ::= {<entry>} <br>  
     * &lt;entry&gt; ::=  &lt;word type&gt; ‘:’ &lt;word&gt; ‘:’ [&lt;description&gt;] <br> 
     * &lt;word type&gt; ::= ‘ a’|’v’|’n’ <br>
     * &lt;word&gt; ::=  {&lt;letter&gt;}+ <br>
     * &lt;description&gt; ::=  {&lt;character&gt;} <br>
     * <br>
     * The lexicion contains 0 or more entries. <br>
     * An entry consists of word type followed by a colon, followed by the word, followed by a colon, optionally followed by a description. <br> 
     * The word type is represented by a single character; either ‘a’, ‘v’, or ‘n’. <br>
     * A word consists of a sequence of one or more letters. <br>
     * A description consists of 1 or more characters (generally, it’s a word phrase). <br>
     */
    public static void load(Dictionary dictionary, String filename) throws FileNotFoundException, IOException { 
        List<String> lineList;
        //List<Definition> defs = new ArrayList<Definition>();
        
        String path = System.getProperty("user.dir")+"/src/"+filename; //to get working file directory in all use case
        //Eg. "/home/g/gmdnko003/NetBeansProjects/HashingAssignment/src/lexicon.txt"
        //System.out.println(path);
        
        try (FileReader fileReader = new FileReader(path)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String inputLine;
            lineList = new ArrayList<String>(); //each line including the word, word type and defintion is an array element
            while ((inputLine = bufferedReader.readLine()) != null) {
                //System.out.print(inputLine);
                String[] key1 = inputLine.split("\\s*:\\s*"); //key1 is the current line's split according to wordType, word, defintion
                try{ 
                    //System.out.println(" // "+key1[0]+" "+key1[1]+" "+key1[2]);
                    lineList.add(key1[2]); //add word's description(s) to lineList
                    try{
                        dictionary.insert(key1[1],new Definition(WordType.toWordType(key1[0]),key1[2])); //inserts each word with given definition
                        
                    }
                    catch(Exception e){
                        System.out.println("Could not insert "+key1[1]);
                    }
                    /*DON'T KNOW HOW TO MAKE PROGRAM KEEP LOOPING AFTER CALLING THIS METHOD*/
                }
                catch(Exception e){ 
                    //System.out.println(" // "+" "+key1[0]+" "+key1[1]);
                    lineList.add(key1[1]); //add word's descroption(s) to lineList
                    try{
                        dictionary.insert(key1[1],new Definition(WordType.toWordType(key1[0]), "")); //inserts each word with empty string definition
                    }
                    catch(Exception f){
                        f.printStackTrace();
                    }      
                }
                tableSize++;
            }
        }
        catch(Exception e){
            System.out.println("File not found!");
        }
        
        /*for (int i=0; i<LPHashtable.table.length; i++){
            if (LPHashtable.table[i]!=null){
                System.out.println(i+" "+LPHashtable.table[i].getWord()+" // "+LPHashtable.table[i].getDefinitions()+" // "+LPHashtable.table[i]);
                j++;
            }
        }*/
        //LPHashtable.debug_print((LPHashtable)dictionary);
        
        /*for (int i=0; i<QPHashtable.table.length; i++){
            if (QPHashtable.table[i]!=null){
                System.out.println(i+" "+QPHashtable.table[i].getWord()+" // "+QPHashtable.table[i].getDefinitions()+" // "+QPHashtable.table[i]);
                j++;
            }
        }*/
        //QPHashtable.debug_print((QPHashtable)dictionary);
        
        /*ChainedEntryImplementation temp; //used to iterate through entries in the table
        ChainedEntryImplementation temp2; //used to iterate through linked items in an entry
        for (int i=0; i<SCHashtable.table.length; i++){
            temp = (ChainedEntryImplementation) SCHashtable.table[i];
            if (SCHashtable.table[i]!=null){
                temp2 = temp;
                System.out.println(i+" "+temp.getWord()+" // "+temp.getDefinitions()+" // "+temp);
                j++;
                while (temp2.getNext()!=null){
                    System.out.println(i+" "+temp2.getNext().getWord()+" // "+temp2.getNext().getDefinitions()+" // "+temp2.getNext());
                    j++;
                    temp2 = (ChainedEntryImplementation) temp2.getNext();
                }
                          
            }
        }*/
        //SCHashtable.debug_print((SCHashtable)dictionary);
        //System.out.println(SCHashtable.entriesCount);
        //System.out.println(j);
    }
    
}
