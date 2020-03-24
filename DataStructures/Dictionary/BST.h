//
// Created by dimmy on 28/6/2019.
//

#ifndef DICTIONARY_BST_H
#define DICTIONARY_BST_H
#include "LinkedList.h"
#include "Node.h"
#include "Chain.h"
#include <string>
#include <queue>
using namespace std;
class BST{
    friend Node;
private:
    Node *root;
public:
    BST(){root=0;}
    void Delete(string e1);
    LinkedList * Search();
    Node*findMin(Node*t);
    void inorder(Node*t);
    Chain *inorder2(Node *t);
    void Display();
    Node *deleteNode(Node *root, string data);
    void Insert(string e1,string e2);
    Node* insert(Node* leaf,string key,string key2);
    void print(Node*p,int depth);
    void levelOrder();
    int depth(Node *p,int d);
};
#endif //DICTIONARY_BST_H
