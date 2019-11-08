
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gmdnko003
 */
public final class ChainedEntryImplementation implements ChainedEntry {
    
    private List<Definition> wordDefs; //a list containing the various defintions of a given word
    private final String word;
    //private Definition definitions;
    //public Entry[] entry;
    public final ChainedEntry linkItem;
    
    public ChainedEntryImplementation(String word, Definition definition, ChainedEntryImplementation linkItem){
        this.word = word;
        this.linkItem = linkItem;
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
    
    @Override
    public ChainedEntry getNext(){
        return linkItem;
    }

    
}
