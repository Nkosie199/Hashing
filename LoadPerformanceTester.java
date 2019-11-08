
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gmdnko003
 */
public class LoadPerformanceTester {
    public LoadPerformanceTester() throws IOException{
        System.out.println("Load Performance Testing...\n");
        Dictionary dictionary;
        
        dictionary = new LPHashtable(7481);        
        FileUtil.load(dictionary, "lexicon.txt");
        System.out.println("Number of probes in LPHashtable where load factor is 0.5: "+LPHashtable.noOfProbes1);
        
        dictionary = new QPHashtable(7481);        
        FileUtil.load(dictionary, "lexicon.txt");
        System.out.println("Number of probes in QPHashtable where load factor is 0.5: "+QPHashtable.noOfProbes1);
        
        dictionary = new SCHashtable(4783);        
        FileUtil.load(dictionary, "lexicon.txt");
        System.out.println("Number of probes in SCHashtable where load factor is 0.5: "+SCHashtable.noOfProbes1);
        
        System.out.println("----------------------------------------------------");
        
        System.out.println("% difference between QP and LP hash tables where load factor is 0.5: "+((double) (QPHashtable.noOfProbes1-LPHashtable.noOfProbes1)/QPHashtable.noOfProbes1)*100+"%");
        System.out.println("% difference between SC and LP hash tables where load factor is 0.5: "+((double) (SCHashtable.noOfProbes1-LPHashtable.noOfProbes1)/SCHashtable.noOfProbes1)*100+"%");
        System.out.println("% difference between SC and QP hash tables where load factor is 0.5: "+((double) (SCHashtable.noOfProbes1-QPHashtable.noOfProbes1)/SCHashtable.noOfProbes1)*100+"%");
        
        System.out.println("");
        ///
        dictionary = new LPHashtable(4987);        
        FileUtil.load(dictionary, "lexicon.txt");
        System.out.println("Number of probes in LPHashtable where load factor is 0.75: "+LPHashtable.noOfProbes1);
        
        dictionary = new QPHashtable(4987);        
        FileUtil.load(dictionary, "lexicon.txt");
        System.out.println("Number of probes in QPHashtable where load factor is 0.75: "+QPHashtable.noOfProbes1);
        
        dictionary = new SCHashtable(3181);        
        FileUtil.load(dictionary, "lexicon.txt");
        System.out.println("Number of probes in SCHashtable where load factor is 0.75: "+SCHashtable.noOfProbes1);
        
        System.out.println("----------------------------------------------------");
        
        System.out.println("% difference between QP and LP hash tables where load factor is 0.75: "+((double) (QPHashtable.noOfProbes1-LPHashtable.noOfProbes1)/QPHashtable.noOfProbes1)*100+"%");
        System.out.println("% difference between SC and LP hash tables where load factor is 0.75: "+((double) (SCHashtable.noOfProbes1-LPHashtable.noOfProbes1)/SCHashtable.noOfProbes1)*100+"%");
        System.out.println("% difference between SC and QP hash tables where load factor is 0.75: "+((double) (SCHashtable.noOfProbes1-QPHashtable.noOfProbes1)/SCHashtable.noOfProbes1)*100+"%");
        
        System.out.println("");
        ///
        dictionary = new LPHashtable(3739);        
        FileUtil.load(dictionary, "lexicon.txt");
        System.out.println("Number of probes in LPHashtable where load factor is 1: "+LPHashtable.noOfProbes1);
        
        dictionary = new QPHashtable(3739);        
        FileUtil.load(dictionary, "lexicon.txt");
        System.out.println("Number of probes in QPHashtable where load factor is 1: "+QPHashtable.noOfProbes1);
        
        dictionary = new SCHashtable(2389);        
        FileUtil.load(dictionary, "lexicon.txt");
        System.out.println("Number of probes in SCHashtable where load factor is 1: "+SCHashtable.noOfProbes1);
        
        System.out.println("----------------------------------------------------");
        
        System.out.println("% difference between QP and LP hash tables where load factor is 1: "+((double) (QPHashtable.noOfProbes1-LPHashtable.noOfProbes1)/QPHashtable.noOfProbes1)*100+"%");
        System.out.println("% difference between SC and LP hash tables where load factor is 1: "+((double) (SCHashtable.noOfProbes1-LPHashtable.noOfProbes1)/SCHashtable.noOfProbes1)*100+"%");
        System.out.println("% difference between SC and QP hash tables where load factor is 1: "+((double) (SCHashtable.noOfProbes1-QPHashtable.noOfProbes1)/SCHashtable.noOfProbes1)*100+"%");
        System.out.println("");
        ///
        System.out.println("* These load measurements were using the lexicon.txt text file and can be repeated by importing another text file *");
    }
}
