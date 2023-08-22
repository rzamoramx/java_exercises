package com.java.exercises.datastructures;


class BTree {
    private BTreeNode root;
    private int t; // Minimum degree

    BTree(int t) {
        this.t = t;
        this.root = new BTreeNode(t, true);
    }

    static class BTreeNode {
        int[] keys; // Array to store keys
        int t; // Minimum degree (defines the range for number of keys)
        BTreeNode[] children; // Array to store child nodes
        int n; // Current number of keys
        boolean leaf; // Indicates whether the node is a leaf

        BTreeNode(int t, boolean leaf) {
            this.t = t;
            this.leaf = leaf;
            this.keys = new int[2 * t - 1];
            this.children = new BTreeNode[2 * t];
            this.n = 0;
        }
    }

    // Insert a key into the B-tree
    void insert(int key) {
        BTreeNode r = root;
        if (r.n == 2 * t - 1) {
            BTreeNode s = new BTreeNode(t, false);
            s.children[0] = r;
            splitChild(s, 0);
            insertNonFull(s, key);
            root = s;
        } else {
            insertNonFull(r, key);
        }
    }

    // Insert a key into a non-full node
    void insertNonFull(BTreeNode x, int key) {
        int i = x.n - 1;
        if (x.leaf) {
            while (i >= 0 && key < x.keys[i]) {
                x.keys[i + 1] = x.keys[i];
                i--;
            }
            x.keys[i + 1] = key;
            x.n++;
        } else {
            while (i >= 0 && key < x.keys[i]) {
                i--;
            }
            i++;
            if (x.children[i].n == 2 * t - 1) {
                splitChild(x, i);
                if (key > x.keys[i]) {
                    i++;
                }
            }
            insertNonFull(x.children[i], key);
        }
    }

    // Split a child of a node
    void splitChild(BTreeNode x, int i) {
        BTreeNode y = x.children[i];
        BTreeNode z = new BTreeNode(t, y.leaf);
        z.n = t - 1;
        for (int j = 0; j < t - 1; j++) {
            z.keys[j] = y.keys[j + t];
        }
        if (!y.leaf) {
            for (int j = 0; j < t; j++) {
                z.children[j] = y.children[j + t];
            }
        }
        y.n = t - 1;
        for (int j = x.n; j >= i + 1; j--) {
            x.children[j + 1] = x.children[j];
        }
        x.children[i + 1] = z;
        for (int j = x.n - 1; j >= i; j--) {
            x.keys[j + 1] = x.keys[j];
        }
        x.keys[i] = y.keys[t - 1];
        x.n++;
    }

    // Delete a key from the B-tree
    void delete(int key) {
        if (root.n == 1) {
            if (root.leaf) {
                root = null;
            } else {
                root = root.children[0];
            }
        }
        delete(root, key);
    }

    // Delete a key from a node
    void delete(BTreeNode x, int key) {
        int idx = findKeyIndex(x, key);

        if (idx < x.n && x.keys[idx] == key) {
            if (x.leaf) {
                removeFromLeaf(x, idx);
            } else {
                removeFromNonLeaf(x, idx);
            }
        } else {
            if (x.leaf) {
                System.out.println("Key " + key + " not found.");
                return;
            }
            boolean flag = (idx == x.n);
            BTreeNode child = x.children[idx];
            if (child.n < t) {
                fill(x, idx);
            }
            if (flag && idx > x.n) {
                delete(x.children[idx - 1], key);
            } else {
                delete(x.children[idx], key);
            }
        }
    }

    // Find the index of a key in a node
    int findKeyIndex(BTreeNode x, int key) {
        int idx = 0;
        while (idx < x.n && key > x.keys[idx]) {
            idx++;
        }
        return idx;
    }

    // Remove a key from a leaf node
    void removeFromLeaf(BTreeNode x, int idx) {
        for (int i = idx + 1; i < x.n; i++) {
            x.keys[i - 1] = x.keys[i];
        }
        x.n--;
    }

    // Remove a key from a non-leaf node
    void removeFromNonLeaf(BTreeNode x, int idx) {
        int k = x.keys[idx];

        if (x.children[idx].n >= t) {
            int pred = getPred(x, idx);
            x.keys[idx] = pred;
            delete(x.children[idx], pred);
        } else if (x.children[idx + 1].n >= t) {
            int succ = getSucc(x, idx);
            x.keys[idx] = succ;
            delete(x.children[idx + 1], succ);
        } else {
            merge(x, idx);
            delete(x.children[idx], k);
        }
    }

    // Get the predecessor key of a key in a node
    int getPred(BTreeNode x, int idx) {
        BTreeNode curr = x.children[idx];
        while (!curr.leaf) {
            curr = curr.children[curr.n];
        }
        return curr.keys[curr.n - 1];
    }

    // Get the successor key of a key in a node
    int getSucc(BTreeNode x, int idx) {
        BTreeNode curr = x.children[idx + 1];
        while (!curr.leaf) {
            curr = curr.children[0];
        }
        return curr.keys[0];
    }

    // Fill a node that has fewer keys by borrowing from siblings
    void fill(BTreeNode x, int idx) {
        if (idx != 0 && x.children[idx - 1].n >= t) {
            borrowFromPrev(x, idx);
        } else if (idx != x.n && x.children[idx + 1].n >= t) {
            borrowFromNext(x, idx);
        } else {
            if (idx != x.n) {
                merge(x, idx);
            } else {
                merge(x, idx - 1);
            }
        }
    }

    // Borrow a key from the previous sibling of a node
    void borrowFromPrev(BTreeNode x, int idx) {
        BTreeNode child = x.children[idx];
        BTreeNode sibling = x.children[idx - 1];

        for (int i = child.n - 1; i >= 0; i--) {
            child.keys[i + 1] = child.keys[i];
        }

        if (!child.leaf) {
            for (int i = child.n; i >= 0; i--) {
                child.children[i + 1] = child.children[i];
            }
        }

        child.keys[0] = x.keys[idx - 1];

        if (!x.leaf) {
            child.children[0] = sibling.children[sibling.n];
        }

        x.keys[idx - 1] = sibling.keys[sibling.n - 1];

        child.n++;
        sibling.n--;
    }

    // Borrow a key from the next sibling of a node
    void borrowFromNext(BTreeNode x, int idx) {
        BTreeNode child = x.children[idx];
        BTreeNode sibling = x.children[idx + 1];

        child.keys[child.n] = x.keys[idx];

        if (!child.leaf) {
            child.children[child.n + 1] = sibling.children[0];
        }

        x.keys[idx] = sibling.keys[0];

        for (int i = 1; i < sibling.n; i++) {
            sibling.keys[i - 1] = sibling.keys[i];
        }

        if (!sibling.leaf) {
            for (int i = 1; i <= sibling.n; i++) {
                sibling.children[i - 1] = sibling.children[i];
            }
        }

        child.n++;
        sibling.n--;
    }

    // Merge a node with a sibling
    void merge(BTreeNode x, int idx) {
        BTreeNode child = x.children[idx];
        BTreeNode sibling = x.children[idx + 1];

        child.keys[t - 1] = x.keys[idx];

        for (int i = 0; i < sibling.n; i++) {
            child.keys[i + t] = sibling.keys[i];
        }

        if (!child.leaf) {
            for (int i = 0; i <= sibling.n; i++) {
                child.children[i + t] = sibling.children[i];
            }
        }

        for (int i = idx + 1; i < x.n; i++) {
            x.keys[i - 1] = x.keys[i];
        }

        for (int i = idx + 2; i <= x.n; i++) {
            x.children[i - 1] = x.children[i];
        }

        child.n += sibling.n + 1;
        x.n--;
    }

    // Search for a key in the B-tree
    boolean search(int key) {
        return search(root, key);
    }

    // Recursive search in a node
    boolean search(BTreeNode x, int key) {
        int i = 0;
        while (i < x.n && key > x.keys[i]) {
            i++;
        }
        if (i < x.n && key == x.keys[i]) {
            return true;
        }
        if (x.leaf) {
            return false;
        }
        return search(x.children[i], key);
    }
}
