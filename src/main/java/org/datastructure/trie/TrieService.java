package org.datastructure.trie;

import org.datastructure.trie.model.Trie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrieService {

    private Trie trie;

    @Autowired
    public TrieService(Trie trie){
        this.trie = trie;
    }
    public String getPrintStackTrace(){
        return this.trie.printTrieStack(this.trie.root);
    }

    public String insertIntoTrie(String input){
        return this.trie.insert(input);
    }
    public Integer words(){
        return this.trie.countWords(this.trie.root);
    }
    public List<String> findWords(){
        List<String> resultArray = new ArrayList<>();
        this.trie.findWords(this.trie.root, resultArray, "");
        return resultArray;
    }
}
