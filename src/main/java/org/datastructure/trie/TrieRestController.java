package org.datastructure.trie;

import org.datastructure.trie.model.Trie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/trieNode")
public class TrieRestController {

    private TrieService trieService;

    @Autowired
    public TrieRestController(TrieService trieService){
        this.trieService = trieService;
    }

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getTrieNode(){
        try{
            String result = this.trieService.getPrintStackTrace();
            return ResponseEntity.ok().body(result);
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping(path = "/{input}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> insertString(@PathVariable String input){
        try{
         String result = this.trieService.insertIntoTrie(input);
         return ResponseEntity.ok(result);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping(path = "/countWords", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> countWords(){
        try{
            Integer result = this.trieService.words();
            return ResponseEntity.ok(result);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(path = "/findWords", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> findWords(){
        try{
            List<String> result = this.trieService.findWords();
            return ResponseEntity.ok(result);
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(path = "/IsWord/{inputString}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> isWord(@PathVariable String inputString){
        try{

            Boolean result = this.trieService.isWord(inputString);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
