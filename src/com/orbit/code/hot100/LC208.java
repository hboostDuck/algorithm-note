package com.orbit.code.hot100;

import lombok.val;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: orbit
 * @Date: 2022/08/30/23:39
 * @Description:
 */
public class LC208 {
}
class Trie {
    final static int R = 256;
    static class TrieNode{
        int val = 0 ;
        TrieNode[] children = new TrieNode[R];

    }
    TrieNode root = null;
    public Trie() {
        root = null;
    }

    public void insert(String word) {
        root = put(root,word,0);
    }

    private TrieNode put(TrieNode node, String word, int i) {
        if (node == null){
            node = new TrieNode();
        }
        if (i == word.length()){
            node.val = 1;
            return node;
        }
        char c = word.charAt(i);
        node.children[c] = put(node.children[c],word,i+1);
        return node;
    }

    public boolean search(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            if (p == null){
                return false;
            }
            char c = word.charAt(i);
            p = p.children[c];
        }
        if (p == null || p.val == 0) return false;
        return true;
    }

    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (p == null){
                return false;
            }
            char c = prefix.charAt(i);
            p = p.children[c];
        }
        return p != null;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");
        trie.search("apple");
        trie.search("apple");
        trie.search("apple");
        trie.search("apple");
        trie.search("apple");
    }
}
class TrieMap<V> {
    // ASCII 码个数
    private static final int R = 256;
    // 当前存在 Map 中的键值对个数
    private int size = 0;

    private static class TrieNode<V> {
        V val = null;
        TrieNode<V>[] children = new TrieNode[R];
    }
    // Trie 树的根节点
    private TrieNode<V> root = null;


    /***** 增/改 *****/

    // 在 Map 中添加 key
    public void put(String key, V val){
        if (!containsKey(key)){
            size++;
        }
        root = put(root,key,val,0);
    }

    private TrieNode<V> put(TrieNode<V> node, String key, V val, int i) {
        if (node == null){
            node = new TrieNode<>();
        }
        if (i == key.length()){
            node.val = val;
            return node;
        }
        char c = key.charAt(i);
        node.children[c] = put(node.children[c],key,val,i+1);
        return node;
    }

    ;

    /***** 删 *****/

    // 删除键 key 以及对应的值
    public void remove(String key){
        if (!containsKey(key)){
            return;
        }
        root = remove(root,key,0);
        size--;
    }

    private TrieNode<V> remove(TrieNode<V> node, String key, int i) {
        if (node == null){
            return null;
        }
        if (i == key.length()){
            node.val = null;
        }else {
            char c = key.charAt(i);
            node.children[c] = remove(node.children[c],key,i+1);
        }
        if (node.val != null){
            return node;
        }
        for (int c = 0; c < R; c++) {
            if (node.children[c] != null){
                return node;
            }
        }
        return null;
    }

    ;

    /***** 查 *****/

    // 搜索 key 对应的值，不存在则返回 null
    // get("the") -> 4
    // get("tha") -> null
    public V get(String key){
        // 从 root 开始搜索 key
        TrieNode<V> x = getNode(root, key);
        if (x == null || x.val == null) {
            // x 为空或 x 的 val 字段为空都说明 key 没有对应的值
            return null;
        }
        return x.val;
    };

    // 判断 key 是否存在在 Map 中
    // containsKey("tea") -> false
    // containsKey("team") -> true
    public boolean containsKey(String key){
        return get(key) != null;
    };

    // 在 Map 的所有键中搜索 query 的最短前缀
    // shortestPrefixOf("themxyz") -> "the"
    public String shortestPrefixOf(String query){
        TrieNode<V> p = root;
        // 从节点 node 开始搜索 key
        for (int i = 0; i < query.length(); i++) {
            if (p == null){
                return "";
            }
            if (p.val != null) {
                // 找到一个键是 query 的前缀
                return query.substring(0, i);
            }
            char c = query.charAt(i);
            p = p.children[c];
        }
        if (p != null && p.val != null) {
            // 如果 query 本身就是一个键
            return query;
        }
        return "";
    };

    // 在 Map 的所有键中搜索 query 的最长前缀
    // longestPrefixOf("themxyz") -> "them"
    public String longestPrefixOf(String query){
        TrieNode<V> p = root;
        int max_len =0;
        for (int i = 0; i < query.length(); i++) {
            if (p == null){
                return "";
            };
            if (p.val != null) {
                // 找到一个键是 query 的前缀，更新前缀的最大长度
                max_len = i;
            }
            p = p.children[query.charAt(i)];
        }
        if (p!= null && p.val != null){
            return query;
        }
        return query.substring(0,max_len);
    };

    // 搜索所有前缀为 prefix 的键
    // keysWithPrefix("th") -> ["that", "the", "them"]
    public List<String> keysWithPrefix(String prefix){
        List<String> res = new LinkedList<>();
        TrieNode<V> x = getNode(root,prefix);
        if (x == null){
            return res;
        }
        traverse(x,new StringBuilder(prefix),res);
        return res;
    }

    private void traverse(TrieNode<V> node, StringBuilder path, List<String> res) {
        if (node == null){
            return;
        }
        if (node.val != null){
            res.add(path.toString());
        }
        for (char c = 0; c < R; c++) {
            path.append(c);
            traverse(node.children[c],path,res);
            path.deleteCharAt(path.length()-1);
        }
    }



    // 判断是和否存在前缀为 prefix 的键
    // hasKeyWithPrefix("tha") -> true
    // hasKeyWithPrefix("apple") -> false
//    public boolean hasKeyWithPrefix(String prefix){
//        // 只要能找到一个节点，就是存在前缀
//        return getNode(root, prefix) != null;
//    };
//
//    // 通配符 . 匹配任意字符，搜索所有匹配的键
//    // keysWithPattern("t.a.") -> ["team", "that"]
//    public List<String> keysWithPattern(String pattern){
//        List<String> res = new LinkedList<>();
//        traverse(root, new StringBuilder(), pattern, 0, res);
//        return res;
//    }
//
//    private void traverse(TrieNode<V> node, StringBuilder path, String pattern, int i, List<String> res) {
//
//    }
//
//
//
//    // 通配符 . 匹配任意字符，判断是否存在匹配的键
//    // hasKeyWithPattern(".ip") -> true
//    // hasKeyWithPattern(".i") -> false
//    public boolean hasKeyWithPattern(String pattern){
//
//    };

    // 返回 Map 中键值对的数量
    public int size(){
        return size;
    };

    // 从节点 node 开始搜索 key，如果存在返回对应节点，否则返回 null
    private TrieNode<V> getNode(TrieNode<V> node, String key) {
        TrieNode<V> p = node;
        for (int i = 0; i < key.length(); i++) {
            if (p == null){
                return null;
            }
            p = p.children[key.charAt(i)];
        }
        return p;
    }
}