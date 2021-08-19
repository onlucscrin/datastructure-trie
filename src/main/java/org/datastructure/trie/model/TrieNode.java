package org.datastructure.trie.model;

public class TrieNode {
    private TrieNode children[];

    public TrieNode[] getChildren() {
        return children;
    }

    public void setChildren(TrieNode[] children) {
        this.children = children;
    }

    public boolean isEndLeaf() {
        return isEndLeaf;
    }

    public void setEndLeaf(boolean endLeaf) {
        isEndLeaf = endLeaf;
    }

    private boolean isEndLeaf;
    public TrieNode(){
        this.children = new TrieNode[26];
    }

}
