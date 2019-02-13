package com.is.dev.assessment;

import com.is.dev.assessment.util.*;
import com.is.dev.assessment.domain.*;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
 


public class Main {

    public static void main(String[] args) throws IOException {

        // This is the starting point for this assessment

        // Read the README to learn how to begin

        // Before starting, I'd recommend to run the following commands in the root project directory :
        // mvn package
        // java -jar target/dev-assessment-1.0.jar
        // After running the second command it should ouput : "Test successful" from below
        System.out.println("Test successful");
        //this can be deleted once confirmed
        
        File input = new File("products.csv");
        File output = new File("output.json");
 
       
        
        CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true).build();
        CsvMapper csvMapper = new CsvMapper();
 
        // Read data from CSV file
        List<Object> readAll = csvMapper.readerFor(Map.class).with(csvSchema).readValues(input).readAll();
 
        for(Object o: readAll){
            System.out.println(o);
            
        }
        Iterator itr = readAll.iterator();
        LinkedHashMap<String,String> finallhm= new LinkedHashMap<String,String>();
        while(itr.hasNext()){
            
  LinkedHashMap<String,String> lhm= new LinkedHashMap<String,String>();
            lhm=(LinkedHashMap)itr.next();
           String s= lhm.get("sku");
           if(!finallhm.containsValue(lhm.get("sku"))){
 //take it into string              finallhm.
           }
            System.out.println(s);
//            System.out.print(me.getKey() + ": ");
//         System.out.println(me.getValue());
        }
        
        
        ObjectMapper mapper = new ObjectMapper();
 
        // Write JSON formated data to output.json file
        mapper.writerWithDefaultPrettyPrinter().writeValue(output, readAll);
 
        // Write JSON formated data to stdout
        //System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(readAll));
    }

}
