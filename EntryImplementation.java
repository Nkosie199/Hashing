import java.util.ArrayList;
import java.util.List;

/**
 * ADT for Hashtable word entry.
 * 
 * Entry objects are intended for use in a hashtable implementation of the dictionary interface. 
 * 
 * An entry object aggregates a word and its definitions.
 * 
 * @author Nkosi Gumede
 * @version 1/5/2015
 */
public final class EntryImplementation implements Entry {
    //Remember: <entry> ::= <word type> ‘:’ <word> ‘:’ [<description>]
    
    private List<Definition> wordDefs; //a list containing the various defintions of a given word
    private final String word;
    //private Definition definitions;
    //public Entry[] entry;
    
    public EntryImplementation(String word, Definition definition){
        this.word = word;
        wordDefs = new ArrayList<>();
        //this.definitions = definition;
        //if (!wordDefs.contains(definition)){
            //System.out.println("Definition about to be added...");
            try{
                addDefinition(definition);
                //System.out.println("Definition geting added...");
            }
            catch(Exception e){
                //System.out.println("Failed to add definition!");
            }           
        //}    
    }
    
    @Override
    public String getWord(){
        return word;
    }
    
    @Override
    public List<Definition> getDefinitions(){
        return wordDefs;
    }
    
    @Override
    public void addDefinition(WordType wordType, String description){     
        wordDefs.add(new Definition(wordType, description));
    }
    
    @Override
    public void addDefinition(Definition definition){
        wordDefs.add(definition);
    }
    //this doesn't work
    @Override
    public boolean isEntryFor(String word){
        if (word.equals(getWord())){
            return true;
        }else{
            return false;
        }
    }
}
