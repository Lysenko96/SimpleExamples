package hw6.bst;

import hw6.OrderedMap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Map implemented as an AVL Tree.
 *
 * @param <K> Type for keys.
 * @param <V> Type for values.
 */
public class AvlTreeMap<K extends Comparable<K>, V> implements OrderedMap<K, V> {

  /*** Do not change variable name of 'root'. ***/
  private Node<K, V> root;
  private int size;

  /**
   * To insert a node into the AVL Tree and keep the tree balanced.
   * @param k The key.
   * @param v The value to be associated with k.
   * @throws IllegalArgumentException thrown when k is null or duplicate.
   */

  @Override
  public void insert(K k, V v) throws IllegalArgumentException {
    if (k == null) {
      throw new IllegalArgumentException("null key error.");
    }
    root = insertHelper(root, k, v);
    size++;
  }

  /**
   * Helper function to insert node and return modified tree.
   * @param node root of the tree/subtree (if called in recursion).
   * @param k key of node to be inserted.
   * @param v value of node to be inserted.
   * @return
   */

  private Node<K,V> insertHelper(Node<K,V> node, K k, V v) {
    if (node == null) {
      return new Node<>(k, v, 0);
    }
    if (k.compareTo(node.key) < 0) {
      node.left = insertHelper(node.left, k, v);
    } else if (k.compareTo(node.key) > 0) {
      node.right = insertHelper(node.right, k, v);
    } else {
      throw new IllegalArgumentException("duplicate key" + k);
    }
    if (node.left == null || node.right == null) {
      node.height++;
    }
    int rootBF = balanceFactor(node);
    if (rootBF == 2 || rootBF == -2) {
      node = reBalance(node, rootBF);
    }
    return node;
  }

  /**
   * remove a node from the tree.
   * @param k The key.
   * @return value of removed node.
   * @throws IllegalArgumentException if the key does not exist.
   */

  @Override
  public V remove(K k) throws IllegalArgumentException {
    Node<K, V> n = findForSure(k);
    root = remove(root, n);
    size--;
    return n.value;
  }

  /**
   * helper function to remove the node from a narrowed subtree.
   * @param node root of subtree.
   * @param toRemove node to remove.
   * @return modified subtree.
   */
  private Node<K, V> remove(Node<K, V> node, Node<K, V> toRemove) {
    int cmp = toRemove.key.compareTo(node.key);
    if (cmp == 0) {
      return remove(node);
    } else if (cmp < 0) {
      node.left = remove(node.left, toRemove);
    } else {
      node.right = remove(node.right, toRemove);
    }
    int bf = balanceFactor(node);
    if (bf == 2 || bf == -2) {
      node = reBalance(node, bf);
    }
    return node;
  }

  /**
   * remove a node based on cases of its child.
   * @param node node to remove.
   * @return the subtree after removing the node.
   */

  private Node<K, V> remove(Node<K, V> node) {
    if (node.left == null) {
      node.height--;
      return node.right;
    } else if (node.right == null) {
      node.height--;
      return node.left;
    }
    Node<K, V> toReplaceWith = min(node.right);
    node.key = toReplaceWith.key;
    node.value = toReplaceWith.value;
    node.right = remove(node.right, toReplaceWith);

    // update heights
    updateRightSubtreeHeights(node.right);
    node.height = larger(node.left.height, node.right.height) + 1;
    int bf = balanceFactor(node);
    if (bf == -2 || bf == 2) {
      reBalance(node, bf);
    }
    return node;
  }

  /**
   * find out which child has larger height.
   * @param height1 left node height.
   * @param height2 right node height.
   * @return the larger height.
   */

  private int larger(int height1, int height2) {
    if (height1 >= height2) {
      return height1;
    } else {
      return height2;
    }
  }

  /**
   * find the minimum node of the right subtree.
   * @param node the root of the right subtree.
   * @return the minimum node of the right subtree.
   */
  private Node<K, V> min(Node<K, V> node) {
    Node<K, V> cur = node;
    while (cur.left != null) {
      cur = cur.left;
    }
    return cur;
  }

  /**
   * update the right subtree's height.
   * @param node of right node.
   */

  private void updateRightSubtreeHeights(Node<K,V> node) {
    if (node.left != null) {
      updateRightSubtreeHeights(node.left);
    }
    // base case: parent node of the removed node
    if (node.left == null) {
      if (node.right == null) {
        node.height = 0;
      } else {
        node.height = node.right.height + 1;
      }
    } else {
      node.height = larger(node.left.height, node.right.height) + 1;
    }
    // check if BF = 2 or -2 for rotation
    int bf = balanceFactor(node);
    if (bf == 2 || bf == -2) {
      reBalance(node, bf);
    }
  }

  /**
   * calculate balance factor of nodes.
   * @param cur node to be calculated.
   * @return balance factor.
   */

  private int balanceFactor(Node<K,V> cur) {
    int leftFactor;
    int rightFactor;
    if (cur.left == null) {
      leftFactor = -1;
    } else {
      leftFactor = cur.left.height;
    }
    if (cur.right == null) {
      rightFactor = -1;
    } else {
      rightFactor = cur.right.height;
    }
    return leftFactor - rightFactor;
  }

  /**
   * rebalance subtrees.
   * @param node root of subtree.
   * @param rootBF root's balance factor.
   * @return modified subtree.
   */

  private Node<K, V> reBalance(Node<K,V> node, int rootBF) {
    if (rootBF == 2) {
      if (balanceFactor(node.left) == -1) {
        return leftRightRotation(node);
      } else {
        return rightRotation(node);
      }
    } else if (rootBF == -2) { // right heavy
      if (balanceFactor(node.right) == 1) {
        return rightLeftRotation(node);
      } else {
        node = leftRotation(node);
      }
    }
    return node;
  }

  /**
   * left then right rotation.
   * @param node root of subtree.
   * @return modified subtree.
   */
  private Node<K,V> leftRightRotation(Node<K,V> node) {
    // first left rotation
    Node<K, V> leftChild = node.left;
    Node<K, V> grandchild = leftChild.right;
    leftChild.right = grandchild.left;
    grandchild.left = leftChild;
    node.left = grandchild;
    // update heights
    grandchild.height++;
    leftChild.height--;
    return rightRotation(node);
  }

  /**
   * right rotation.
   * @param node root of subtree.
   * @return modified subtree.
   */

  private Node<K,V> rightRotation(Node<K,V> node) {
    Node<K, V> leftChild = node.left;
    node.left = leftChild.right;
    leftChild.right = node;
    //update height
    node.height -= 2;
    return leftChild;
  }

  /**
   * right the left rotation.
   * @param node root of subtree.
   * @return modified subtree.
   */

  private Node<K, V> rightLeftRotation(Node<K,V> node) {
    Node<K, V> rightChild = node.right;
    Node<K, V> grandchild = rightChild.left;
    rightChild.left = grandchild.right;
    grandchild.right = rightChild;
    node.right = grandchild;
    // update heights
    grandchild.height++;
    rightChild.height--;
    return leftRotation(node);
  }

  /**
   * left rotation.
   * @param node root of subtree.
   * @return modified subtree.
   */
  private Node<K, V> leftRotation(Node<K,V> node) {
    Node<K,V> rightChild = node.right;
    node.right = rightChild.left;
    rightChild.left = node;
    //update height
    node.height -= 2;
    return rightChild;
  }

  /**
   * put a value into a node with a certain key.
   * @param k The key.
   * @param v The value to be associated with k.
   * @throws IllegalArgumentException thrown when the key does not exist.
   */

  @Override
  public void put(K k, V v) throws IllegalArgumentException {
    Node<K, V> n = findForSure(k);
    n.value = v;
  }

  /**
   * get value of a node with given key.
   * @param k The key.
   * @return value of node with the key.
   * @throws IllegalArgumentException thrown when key does not exist.
   */

  @Override
  public V get(K k) throws IllegalArgumentException {
    Node<K, V> n = findForSure(k);
    return n.value;
  }

  /**
   * find a node with a key or return an error if the key does not exist.
   * @param k key to be searched.
   * @return node found.
   */

  private Node<K,V> findForSure(K k) {
    Node<K, V> n = find(k);
    if (n == null) {
      throw new IllegalArgumentException("cannot find key " + k);
    }
    return n;
  }

  /**
   * check if a key exists in the tree.
   * @param k The key.
   * @return boolean value of if a key exists.
   */

  @Override
  public boolean has(K k) {
    if (k == null) {
      return false;
    }
    Node<K, V> n = find(k);
    return n != null;
  }

  /**
   * find a node with a key, return null if not found.
   * @param k key to be searched.
   * @return the node found, can be null.
   */
  private Node<K,V> find(K k) {
    if (k == null) {
      throw new IllegalArgumentException("cannot handle null key");
    }
    Node<K, V> n = root;
    while (n != null) {
      int cmp = k.compareTo(n.key);
      if (cmp < 0) {
        n = n.left;
      } else if (cmp > 0) {
        n = n.right;
      } else {
        return n;
      }
    }
    return null;
  }


  /**
   * return size of tree.
   * @return size.
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * set up an iterator for in-order traversal.
   * @return an iterator of a ArrayList object with all nodes.
   */
  @Override
  public Iterator<K> iterator() {
    List<K> keys = new ArrayList<>();
    iteratorHelper(root, keys);
    return keys.iterator();
  }

  /**
   * put nodes into array list by in-order traversal.
   * @param n root.
   * @param keys list to be put in.
   */

  private void iteratorHelper(Node<K,V> n, List<K> keys) {
    if (n == null) {
      return;
    }
    iteratorHelper(n.left, keys);
    keys.add(n.key);
    iteratorHelper(n.right, keys);
  }

  /*** Do not change this function's name or modify its code. ***/
  @Override
  public String toString() {
    return BinaryTreePrinter.printBinaryTree(root);
  }

  /**
   * Feel free to add whatever you want to the Node class (e.g. new fields).
   * Just avoid changing any existing names, deleting any existing variables,
   * or modifying the overriding methods.
   *
   * <p>Inner node class, each holds a key (which is what we sort the
   * BST by) as well as a value. We don't need a parent pointer as
   * long as we use recursive insert/remove helpers.</p>
   **/
  private static class Node<K, V> implements BinaryTreeNode {
    Node<K, V> left;
    Node<K, V> right;
    K key;
    V value;

    int height;

    // Constructor to make node creation easier to read.
    Node(K k, V v) {
      // left and right default to null
      key = k;
      value = v;
    }

    public Node(K key, V value, int height) {
      this.key = key;
      this.value = value;
      this.height = height;
    }

    @Override
    public String toString() {
      return key + ":" + value;
    }

    @Override
    public BinaryTreeNode getLeftChild() {
      return left;
    }

    @Override
    public BinaryTreeNode getRightChild() {
      return right;
    }
  }

}
