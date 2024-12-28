package markovAPI.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import markovAPI.services.Main;

/**
 * @author Amoghavarsha
 */
@RestController
public class MarkovController {

    //generate text
    @GetMapping(path= "/generate",  produces = "application/json" )
    @CrossOrigin(origins = "*")
    public Object getWelcome(@RequestParam (required = true) int postfixSize,
                             @RequestParam (required = true) int prefixSize,
                             @RequestParam (required = true) int outputSize ,
                             @RequestParam (required = true) String input

    ) throws Exception {
        try {
            return Main.processInput(input,prefixSize,postfixSize,outputSize);

            /* If we want to return JSON:
            return Collections.singletonMap("response", markovModel.generateText(outputSize) );
            */
        }catch (Exception e){
         return "** Server error:"+ e.toString();
        }
    }
}