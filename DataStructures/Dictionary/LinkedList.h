//
// Created by dimmy on 1/7/2019.
//

#ifndef DICTIONARY_LINKEDLIST_H
#define DICTIONARY_LINKEDLIST_H

#include <string>
#include "LNode.h"
using namespace std;
class LinkedList {
public:
    int length;
    LNode * head;
    LinkedList();
    ~LinkedList();
    void add(string data1,string data2);
    void print();
    void search(string word);
};

#endif //DICTIONARY_LINKEDLIST_H
