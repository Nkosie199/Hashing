import java.util.ArrayList;
import java.util.List;

/**
 * Simple hash table implementation of Dictionary using linear probing.
 * 
 * @author Stephan Jamieson 
 * @version 24/4/2015
 */

//How are the Entry classes methods supposed to be accessed?
public class LPHashtable implements Dictionary
{
    private final static int DEFAULT_SIZE = 50;
    //public Map<String, Definition> map = new HashMap<String, Definition>(); //hashmap containing indexes according to
    public static Entry entry; //
    public static Entry[] table;
    //public static String[] words; //
    public static int noOfProbes1; //number of probes for insert
    public static int noOfProbes2; //number of probes for search
    public static int probes; //variable needed to perform wraparound
    private int entries; //
    int j; //variable acting as switch to indicate whether or not linear probong should be implemented
    int i; // variable to implement linear probing should current node not be null
    
    public LPHashtable() { this(DEFAULT_SIZE); }
    
    public LPHashtable(int size) { 
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
        if (table[hashFunction(word)].getWord().equals(word)){ //ie. if there is no table entry for this word
            return true;
        }
        else{         
            return false;
        }
    }
    
    @Override
    public List<Definition> getDefinitions(String word) {  
        // Implement this.
        int listAppender = 0;
        List<Definition> listAdder = new ArrayList<>(); //a list containing the various defintions of a given word
        for (Entry table1 : table){ //for each entry in the table
            try{ //in the case of the entry not being null -->
                //if (containsWord(word)){
                    //System.out.println("Word is in dictionary!");
                    listAppender++;
                    for(Definition d : table1.getDefinitions()) {
                        if (table1.getWord().equals(word)){
                            //System.out.println(d);
                            listAdder.add(d);
                        }
                        
                    }
                //}  
            }
            catch(Exception e){
                //System.out.println("This entry is null!");
            }            
        }
        //Could return a new table which is a summation of all wordDefs arrays for the given word
        if (listAdder.isEmpty()){
            return null;
        }
        if (listAppender>0){
            return listAdder;
        }
        else{
            System.out.println("Word is not in dictionary!");
            return null;
        }
           
    }
    
    @Override
    public void insert(String word, Definition definition) {
        // Implement this.
        //this.currentWord = word;
        //table[hashFunction(word)] = entry ie. the table needs to store entries  
        //hashVal = hashFunction(word);
        int tmp = hashFunction(word);
        int i = tmp;

        do{
            if (table[i] == null){
                entry = new EntryImplementation(word, definition);
                table[i] = entry;
                //System.out.println("Entry has been inserted bot!");
                //System.out.println("Entry was: "+table[i].getWord());
                //words[i] = word;
                noOfProbes1++;
                noOfProbes2++;
                return;
            }
            if(table[i].getWord().equals(word)){
                table[i].addDefinition(definition);
                //noOfProbes2++;
                return;
            }
            noOfProbes1++;
            noOfProbes2++;
            i = (i + 1) % table.length; 
            if (i>table.length){
                i = 0;
            }
            //System.out.println("Entry almost inserted! (2)");
        }
        while (i != tmp);        
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
    public static void debug_print(LPHashtable hashtable) {
        Entry[] table = hashtable.table;
        for(int i=0; i<table.length; i++) {
            System.out.printf("\n%4d : %s", i, table[i]);
        }
    }        
}
