//
// Created by dimmy on 28/6/2019.
//
#include <wtypes.h>
#include <string>
using namespace std;
#ifndef DICTIONARY_NODE_H
#define DICTIONARY_NODE_H

#endif //DICTIONARY_NODE_H
class Node{
private:
    string greek;
    string english;
    Node *leftChild,*rightChild;
    //Πρόσβαση στα ιδιωτικά της μέλη από την BST
    friend class BST;

public:
    //Overload constructors
    Node();
    Node(const string &e1, const string & e2);
    Node(const string &e1, const string & e2,Node *l,Node*r);
};