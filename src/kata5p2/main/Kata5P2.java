/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5p2.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import kata5p2.model.Histogram;
import kata5p2.view.HistogramDisplay;
import kata5p2.view.MailHistogramBuilder;
import kata5p2.view.MailListReader;

/**
 *
 * @author adrir
 */
public class Kata5P2 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String fileName = "C:\\Users\\adrir\\OneDrive\\Escritorio\\email.txt";
        output(process(input(fileName)));
    }
    
    private static List<String> input(String fileName) throws FileNotFoundException, IOException{
        return MailListReader.read(fileName);
    }
    
    private static Histogram<String> process(List<String>mailList){
        return MailHistogramBuilder.build(mailList);
    }
    
    private static void output(Histogram<String> histogram){
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    } 
}
