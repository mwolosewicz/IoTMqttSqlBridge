package com.shellcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App 
{

    static Logger log = LoggerFactory.getLogger(App.class.getName());

    public static void main( String[] args )
    {
        log.info("Info debug");
        log.error("Error debug");
        log.debug("Debug debug");
        log.warn("Warning debug");
        log.trace("Trace debug");

        System.out.println( "Hello World!" +  " class name: " + App.class.getName() );
    }
}
