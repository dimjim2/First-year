#include "Node.h"

//
// Created by dimmy on 28/6/2019.
//
Node::Node() {
    leftChild=0;
    rightChild=0;
}
Node::Node(const string &e1, const string &e2) {
    english=e1;
    greek=e2;
    leftChild=rightChild=0;
}
Node::Node(const string &e1, const string &e2, Node *l, Node *r) {
    english=e1;
    greek=e2;
    leftChild=l;
    rightChild=r;
}
