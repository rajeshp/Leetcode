
package com.ideserve.questions.nilesh;

import java.util.LinkedList;

/**
 * <b>IDeserve <br>
 * <a href="https://www.youtube.com/c/IDeserve">https://www.youtube.com/c/IDeserve</a>
 * AVL Tree insertion algorithm with required rotations for balancing.
 * @author Nilesh
 */

public class AVLTree
{
    private class QueueNode
    {
        AVLTreeNode treeNode;
        int level;

        QueueNode(AVLTreeNode treeNode, int level)
        {
            this.treeNode = treeNode;
            this.level = level;
        }
    }

    private class AVLTreeNode
    {
        int data;
        AVLTreeNode left;
        AVLTreeNode right;
        int height;

        AVLTreeNode(int data)
        {
            this.data = data;
            this.height = 1;
        }
    }

    AVLTreeNode root;

    // default value for root node is 9
    AVLTree()
    {
        this.root = new AVLTreeNode(9);
    }

    AVLTree(int rootValue)
    {
        this.root = new AVLTreeNode(rootValue);
    }

    int getHeight(AVLTreeNode node)
    {
        if (node == null)
            return 0;

        return node.height;
    }

    void updateHeight(AVLTreeNode node)
    {
        if (node == null) return;

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }


    AVLTreeNode rotateRight(AVLTreeNode node)
    {
        if (node == null) return node;

        AVLTreeNode beta  = node.left;

        AVLTreeNode t2  = beta.right;

        beta.right = node;
        node.left = t2;

        // we first need to update the height of node because height of beta uses height of node
        updateHeight(node);

        // now we update height of beta
        updateHeight(beta);

        return beta;
    }


    AVLTreeNode rotateLeft(AVLTreeNode node)
    {
        if (node == null) return node;

        AVLTreeNode beta  = node.right;
        AVLTreeNode t2  = beta.left;

        beta.left = node;
        node.right = t2;

        // we first need to update the height of node because height of beta uses height of node
        updateHeight(node);

        // now we update height of beta
        updateHeight(beta);

        return beta;
    }


    int getBalance(AVLTreeNode node)
    {
        if (node == null)
        {
            return 0;
        }
        int balance;

        balance = getHeight(node.left) - getHeight(node.right);

        return balance;
    }


    int getMinValue(AVLTreeNode node)
    {
        // though this case should not be hit ever for the usecase this function is employed for
        if (node == null) return Integer.MIN_VALUE;

        // if this is the left-most node
        if (node.left == null) return node.data;

        return getMinValue(node.left);
    }



    private AVLTreeNode insert(AVLTreeNode node, int key)
    {
        // do usual BST insertion first
        if (node == null)
        {
            return new AVLTreeNode(key);
        }

        if (key < node.data)
        {
            node.left = insert(node.left, key);
        }
        else if (key > node.data)
        {
            node.right = insert(node.right, key);
        }
        else
        {
            return node;
        }

        // now update the height of the node
        updateHeight(node);

        // check the balance at this node and perform rotations accordingly
        int balance = getBalance(node);

        if (balance > 1) // indicates either left-left or left-right case
        {
            if (key < node.left.data) // confirms left-left case
            {
                node = rotateRight(node);
            }
            else // confirms left-right case
            {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        }

        else if (balance < -1) // indicates either right-right or right-left case
        {
            if (key > node.right.data) // confirms right-right case
            {
                node = rotateLeft(node);
            }
            else // confirms right-left case
            {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }
        return node;
    }


    public void insert(int key)
    {
        root = insert(this.root, key);
        return;
    }


    public void printTreeLevelOrder()
    {
        if (root == null) return;

        LinkedList queue = new LinkedList();
        queue.add(new QueueNode(root, 0));

        int maxLevelVisited = -1;

        while (!queue.isEmpty())
        {
            QueueNode currentNode = (QueueNode) queue.remove();

            if (currentNode.level > maxLevelVisited)
            {
                maxLevelVisited = currentNode.level;
                System.out.print("\nlevel-" + currentNode.level + " nodes: ");
            }
            System.out.print(" " + currentNode.treeNode.data);

            if (currentNode.treeNode.left != null)
            {
                queue.add(new QueueNode(currentNode.treeNode.left, currentNode.level + 1));
            }

            if (currentNode.treeNode.right != null)
            {
                queue.add(new QueueNode(currentNode.treeNode.right, currentNode.level + 1));
            }
        }
    }


    public static void main(String[] args)
    {
        AVLTree tree = new AVLTree(0);

        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(6);
        tree.insert(5);

        tree.printTreeLevelOrder();
    }
}
