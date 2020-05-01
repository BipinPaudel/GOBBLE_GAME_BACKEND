//package org.bipin.gobble.lib;
//
//import javax.enterprise.context.ApplicationScoped;
//import javax.inject.Named;
//import javax.ws.rs.Produces;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * @author bipin on 2020-05-01 15:11
// */
//public class DictionaryFactoryProvider {
//
//
//  @Produces
//  @ApplicationScoped
//  @DictionaryQ
//  public Dictionary produce() throws Exception {
//    Set<String> words = new HashSet<>();
//    File file = new File(getClass()
//        .getClassLoader()
//        .getResource("words.txt").getFile());
//
//    BufferedReader br = new BufferedReader(new FileReader(file));
//    String st;
//    while ((st = br.readLine()) != null) {
//      words.add(st);
//    }
//
//    return new Dictionary(words);
//
//
//  }
//}
