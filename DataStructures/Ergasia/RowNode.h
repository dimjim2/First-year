//
// Created by dimmy on 1/5/2019.
//

#ifndef ERGASIA_ROWNODE_H
#define ERGASIA_ROWNODE_H


#include "ColumnNode.h"

//Ορίζουμε την κλάση RowNode η οποία είναι φίλη και της SM.(Επομένως η SM θα έχει πρόσβαση στα ιδιωτικά της μέλη)

class RowNode {
    friend class SM;
public:
    RowNode(){} //constructor
    RowNode(int rowNo); //constructor με όρισμα overload
    ~RowNode(); //αποδομητής
    void deleteFirstCol(); //διαγράφει τον πρώτο column node(κόμβο στήλης)and αναθέτει την τιμή του next στο head
    void overwriteColumn(ColumnNode *curr, int val); //αν υπάρχει ο column node(κόμβος στήλης) αλλάζει το περειεχόμενο του
    void insertColumn(int colIndex, int val); //κάνει εισαγωγή ενός κόμβου στήλης σε έναν κόμβο γραμμής
    void printCol(int mSize); // εκτυπώνει τους κόμβους στήλης μέσα στον κόμβο γραμμής
private:
    int row_number, column_size; //αριθμός γραμμών & πραγματικό αριθμός των κόμβων στήλης μέσα στον rowNode
    ColumnNode *colHead, *colTail; // δείκτης στην πρώτη and τελευταία στήλη μέσα σε αυτήν την γραμμή(κόμβο γραμμής)
    RowNode *nextRow; // δείκτης στον  next επόμενο κόμβο γραμμής
};
#endif //ERGASIA_ROWNODE_H
