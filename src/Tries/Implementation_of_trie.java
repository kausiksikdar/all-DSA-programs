package Tries;
public class Implementation_of_trie {
    static class TrieNode
    {
        boolean isEndOfWord;
        TrieNode[] child;
        TrieNode()
        {
            isEndOfWord = false;
            child = new TrieNode[26];
        }
    }

    static class Trie
    {
        TrieNode root;
        Trie()
        {
            root = new TrieNode();
        }
        void insert(String word)
        {
            TrieNode node = root;

            for(int i=0;i<word.length();i++)
            {
                int index = word.charAt(i)-'a';

                if(node.child[index] == null)
                    node.child[index] = new TrieNode();

                node = node.child[index];
            }
            node.isEndOfWord = true;
        }
        boolean search(String word)
        {
            TrieNode node = root;

            for(int i=0;i<word.length();i++)
            {
                int index = word.charAt(i) - 'a';

                if(node.child[index] == null)
                    return false;

                node = node.child[index];
            }
            return node.isEndOfWord;
        }
        boolean isEmpty(TrieNode node)
        {
            for (int i=0;i<26;i++)
                if (node.child[i] == null)
                    return false;

            return true;
        }
        boolean deleteWord(TrieNode node, int index, String word)
        {
            if(index == word.length())
            {
                if(!node.isEndOfWord)
                    return false;

                node.isEndOfWord = false;
                return isEmpty(node);
            }

            int idx = word.charAt(index)-'a';

            if (node.child[idx] == null)
                return  false;

            boolean shouldDeleteChild = deleteWord(node.child[idx], index+1, word);

            if (shouldDeleteChild)
            {
                node.child[idx] = null;

                return !node.isEndOfWord && isEmpty(node);
            }

            return false;

        }
        void delete(String word)
        {
            TrieNode node = root;
            if(!deleteWord(node,0,word))
                System.out.println("Word " + word + " deleted from Trie Successfully");
            else
                System.out.println("Word " + word + " can,t deleted");
        }
    }
    public static void main(String[] args) {
        String[] words = {"apple","appex","almond","money","mon"};
        Trie tree = new Trie();

        for(String word:words)
        {
            tree.insert(word);
        }

        System.out.println(tree.search("app"));
        System.out.println(tree.search("applo"));
        System.out.println(tree.search("appex"));
        System.out.println(tree.search("mon"));
        tree.delete("mon");
        System.out.println(tree.search("mon"));
        System.out.println(tree.search("money"));

    }
}
