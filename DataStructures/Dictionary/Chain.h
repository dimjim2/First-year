//
// Created by dimmy on 3/7/2019.
//

#ifndef DICTIONARY_CHAIN_H
#define DICTIONARY_CHAIN_H
#include "ChainNode.h"

class Chain {
public:
    int length;
    ChainNode * first;
    Chain();
    void add(char e);
    int find(char e);
    void all();
    int count();
};


#endif //DICTIONARY_CHAIN_H
