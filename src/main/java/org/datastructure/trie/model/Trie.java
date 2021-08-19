package org.datastructure.trie.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Trie {
    public TrieNode root;
    public Trie(){
        this.root = new TrieNode();
    }
    public int getIndex(char c){
        return c - 'a';
    }
    public char getChar(int index){
        return (char) ( 'a' + index);
    }

    public String insert(String word){
        TrieNode current = this.root;
        for(int i=0;i<word.length();i++){
            int index = this.getIndex(word.charAt(i));
            if( current.getChildren()[index]==null) {
                current.getChildren()[index] = new TrieNode();
             }
            current = current.getChildren()[index];
        }
        current.setEndLeaf(true);
        return this.printTrieStack(this.root);
    }

    public int countWords(TrieNode node){
        int value = 0;
        TrieNode[] currentNode = node.getChildren();
        for(int i=0;i<currentNode.length;i++){
            if(currentNode[i]!= null) {
                if(currentNode[i].isEndLeaf())
                    value++;
                value =  value + this.countWords(currentNode[i]) ;
            }
        }
        return value;
    }
    public void findWords(TrieNode node, List resultArray, String prevTrieValueresult){
        TrieNode[] currentNode = node.getChildren();
        for(int i=0;i<currentNode.length;i++){
            if(currentNode[i]!= null) {
                if(currentNode[i].isEndLeaf())
                    resultArray.add(prevTrieValueresult + getChar(i));
                this.findWords(currentNode[i], resultArray, prevTrieValueresult + getChar(i)) ;
            }
        }
    }
    public boolean isWord(TrieNode node, String stringInput, String prevTrieValueresult){
        TrieNode[] currentNode = node.getChildren();

        for(int i=0;i<stringInput.length();i++){
            int index = getIndex(stringInput.charAt(i));
            if(currentNode[index]!= null) {
                if(currentNode[index].isEndLeaf() && (prevTrieValueresult+ getChar(index)).equals(prevTrieValueresult))
                    return true;
                return this.isWord(currentNode[index], stringInput, prevTrieValueresult + getChar(index));
            }
            if(stringInput.equals(prevTrieValueresult))
                return true;
        }
        return false;
    }


    public String printTrieStack(TrieNode node){
        TrieNode[] currentNode = node.getChildren();
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<currentNode.length;i++){
            if(currentNode[i]!= null) {
                builder.append(getChar(i));
                builder.append(this.printTrieStack(currentNode[i]));
            }
        }
        return builder.toString();
    }

    public Boolean isWord(String inputString){
        for(int i=0;i < inputString.length();i++){
            boolean value = this.isWord(this.root, inputString.substring(0, i), "");
            boolean value2 = this.isWord(this.root, inputString.substring(i,inputString.length() ), "");
            if(value && value2)
                return true;
        }
        return false;
    }
}
