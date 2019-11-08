import java.util.ArrayList;
import java.util.List;

/**
 * Simple hash table implementation of Dictionary using linear probing.
 * 
 * @author Stephan Jamieson 
 * @version 24/4/2015
 */

//How are the Entry classes methods supposed to be accessed?
public class SCHashtable implements Dictionary
{
    private final static int DEFAULT_SIZE = 50;
    public static Entry[] table;
    public static int entriesCount = 0;
    //public static String[] words; //
    public static int noOfProbes1; //number of probes for insert
    public static int noOfProbes2; //number of probes for search
    private int entries; //

    public static ChainedEntryImplementation item;
    public static ChainedEntryImplementation linkItem;
    
    public SCHashtable() { this(DEFAULT_SIZE); }
    
    public SCHashtable(int size) { 
        table = new Entry[size];
        //this.words = new String[size];
        this.entries = 0;
        //System.out.println("LPHashtable size updated!");
    }
    
    /**
     * Assume this is the method we will use for determining which HashMap index the given word hashes to
     */
    private int hashFunction(String key) {
        // Your hash function here.
        int hashVal = 0;
        for( int i = 0; i < key.length( ); i++ )
            hashVal = ( hashVal * 128 + key.charAt( i ) )% table.length;
        return hashVal;
        //return -1;
    }
    
    @Override
    public boolean containsWord(String word) {
        // Implement this.
        //if (table[hashFuntion(word)].getWord().equals(word))  ie. condition for comparing
        if (table[hashFunction(word)].getWord().equals(word)){ //ie. if there is a table entry for this word
            return true;
        }
        else{         
            return false;
        }
    }
    
    @Override
    public List<Definition> getDefinitions(String word) {
        int listAppender = 0;
        List<Definition> listAdder;
        listAdder = new ArrayList<>();
        int i = hashFunction(word);
        
        ChainedEntryImplementation temp; //used to iterate through entries in the table
        ChainedEntryImplementation temp2; //used to iterate through linked items in an entry
        temp = (ChainedEntryImplementation) table[i];
        
        //System.out.println(temp.getDefinitions());
        //for (Entry table1: table){ //iterate through the table to find the word
        try{
            if (SCHashtable.table[i]!=null){
                temp2 = temp;
                if (temp.getWord().equals(word)){
                    for (Definition d: temp.getDefinitions()){
                        listAdder.add(d);
                        listAppender++;
                    }
                }
                //System.out.println(i+" "+temp.getWord()+" // "+temp.getDefinitions()+" // "+temp);
                while (temp2.getNext()!=null){
                    if (temp2.getNext().getWord().equals(word)){
                        for (Definition d: temp2.getNext().getDefinitions()){
                            listAdder.add(d);
                            listAppender++;
                        }
                    }
                    //System.out.println(i+" "+temp2.getNext().getWord()+" // "+temp2.getNext().getDefinitions()+" // "+temp2.getNext());
                    temp2 = (ChainedEntryImplementation) temp2.getNext();
                }          
            }
            /*while(temp.getNext()!=null){ //iterate through each entry to find the word
                if (temp.getWord().equals(word)){
                    for (Definition d: temp.getDefinitions()){
                        listAdder.add(d);
                    }                  
                    listAppender++;
                }
                temp = (ChainedEntryImplementation) temp.getNext();
            }*/
        }
        catch(Exception e){
            return null;
        }
        //}           
        if (listAppender>0){
            return listAdder;
        }
        else{
            return null;
        }
    }
    
    @Override
    public void insert(String word, Definition definition) {
        int hash = hashFunction(word);
        if (table[hash]==null){ //for each null index in the table, simply enter the entry
            linkItem = null;
            item = new ChainedEntryImplementation(word, definition, linkItem); //created a new entry          
            table[hash] = (Entry) item; 
            entriesCount++;
            noOfProbes1++;
            
        }
        else{ //where table[hash] contains an entry, we must make the front entry a next link
            linkItem = (ChainedEntryImplementation) table[hash];
            item = new ChainedEntryImplementation(word, definition, linkItem); //created a new entry
            noOfProbes1++;
            table[hash] = (Entry) item;
            entriesCount++;
            
            ChainedEntryImplementation temp;
            temp = (ChainedEntryImplementation) table[hash];
            while(temp.getNext()!=null){
                noOfProbes2++;
                temp = (ChainedEntryImplementation) temp.getNext();
            }
        }
    }
        
    @Override
    public boolean isEmpty() { return entries == 0; }
    
    @Override
    public void empty() { this.table = new Entry[this.table.length]; this.entries=0; }
    
    @Override
    public int size() { return this.entries; }
    
    /* Hash Table Functions */
    
    public boolean isEntryFor(String word){ // this method is probably incorrect
        if (table[hashFunction(word)].getWord().equals(word)){
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Obtain the current load factor (entries / table size).
     * @return loadFactor
     */
    public double loadFactor() { return entries/(double)table.length; }
        
    
    /* DEBUGGING CODE */
    /**
     * Print the contents of the given hashtable.
     * @param hashtable
     */
    public static void debug_print(SCHashtable hashtable) {
        Entry[] table = hashtable.table;
        for(int i=0; i<table.length; i++) {
            System.out.printf("\n%4d : %s", i, table[i]);
        }
    }        
}
