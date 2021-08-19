package org.datastructure.trie.model;

import org.springframework.stereotype.Component;

import javax.swing.tree.TreeNode;
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
             }  current = current.getChildren()[index];

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

}
