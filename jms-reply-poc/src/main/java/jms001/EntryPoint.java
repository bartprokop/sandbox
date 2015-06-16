/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jms001;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Bart
 */
public class EntryPoint {

    public static ApplicationContext applicationContext;

    public static void main(String... args) {
        System.out.println("Hello world");
        applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
    }
}
