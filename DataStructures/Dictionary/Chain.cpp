#include "Chain.h"
#include <iostream>
using namespace std;
//
// Created by dimmy on 3/7/2019.
//
Chain::Chain() {
    this->length = 0;
    this->first = 0;
}
//Πρόσθεση στην λίστα
void Chain::add(char e) {
    ChainNode *y=new ChainNode();
    y->data1=e;
    ChainNode *k=first;
    if (!first){
        y->link=first;
        first=y;
    }
    else{
        while (k->link){
            k=k->link;
        }
        y->link=NULL;
        k->link=y;
    }
}
//Εύρεση ενός στοιχείου και επιστροφή της θέσης
int Chain::find(char e) {
    ChainNode *current=first;
    int index=1;
    while(current && current->data1!=e){
        current=current->link;
        index++;
    }
    if (current){
        return index;
    }
    return 0;

}
//Εκτύπωση όλων των δεδομένων
void Chain::all() {
    ChainNode *current=first;
    while (current){
        cout<<current->data1<<endl;
        current=current->link;
    }
}
//Συνάρτηση που επιστρέφει το πλήθος των στοιχείων
int Chain::count() {
    ChainNode *current=first;
    int count=0;
    while(current){
        count+=1;
        current=current->link;

    }
    return count;
}