#include "LinkedList.h"

//
// Created by dimmy on 1/7/2019.
//
#include <iostream>
using namespace std;
LinkedList::LinkedList(){
    this->length = 0;
    this->head = NULL;
}
//Διαγραφή όλων των κόμβων
LinkedList::~LinkedList(){
    LNode *next;
    while(head){
        next=head->link;
        delete head;
        head=next;
    }
    std::cout << "LIST DELETED";
}
//Προσθέτει τα δεδομένα στην αλυσίδα διατηρώντας την ταξινόμηση
void LinkedList::add(string data1,string data2) {
    LNode *newnode = new LNode();
    LNode *p;
    LNode *f=head;
    newnode->data1=data1;
    newnode->data2=data2;
    newnode->link=NULL;
    length++;
    if(head==NULL)
    {
        //Αν η λίστα είναι άδεια
        newnode->link=NULL;
        head=newnode;
        return;
    }

    if(data1<head->data1)
    {
        //Αν τα δεδομένα ειναι μικρότερα από τα δεδομένα του πρώτου κόμβου
        newnode->link=head;
        head=newnode;
        return;
    }
    else
    {
        while(f!=NULL)
        {
            if(data1>f->data1)
            {
                //Όσο τα δεδομένα είναι μεγαλύτερα από τα δεδομένα του f data1
                p=f;
                f=f->link;
                continue;
            }
            else
            {
                //Εισαγώγη του κόμβου
                p->link=newnode;
                newnode->link=f;
                return;
            }
        }
        p->link=newnode;
        //Εισαγωγή στο τέλος
    }
}
//Εκτύπωση όλων των κόμβων
void LinkedList::print(){
    LNode* head = this->head;
    int i = 1;
    while(head){
        std::cout << i << ": " << head->data1 << std::endl;
        head = head->link;
        i++;
    }
}
//Αναζήτηση μια λέξης στην λίστα
void LinkedList::search(string word) {
    LNode *current;
    current= head;
    while (current && current->data1 !=word) {
        current = current->link;
    }
    if (current->data1==word&&current){
        cout<<"Found word translation into greek "+current->data2;
    }
    else{
        cout<<"Something went wrong";
    }
}
#include "LinkedList.h"
