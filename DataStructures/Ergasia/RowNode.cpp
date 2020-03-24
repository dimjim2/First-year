//
// Created by dimmy on 1/5/2019.
//
#include <iostream>
#include <string>
#include <iomanip>
#include "RowNode.h"
using namespace std;
//Constructor RowNode
RowNode::RowNode(int rowNo){
    this->row_number = rowNo;
    nextRow = NULL;
    colHead = NULL;
    colTail = NULL;
}
//αποδομητής
RowNode::~RowNode(){
    while (colHead != NULL){ //while loop για να διαγράψουμε τους εναπομείναντες κόμβους
        deleteFirstCol();
    }
}
void RowNode::deleteFirstCol(){
ColumnNode *cur = colHead;
colHead = colHead->nextColumn;
delete cur;
if (colHead == NULL){
colTail = NULL;
}
}
void RowNode::overwriteColumn(ColumnNode *curr, int val){
    cout << "A value already exists in row no. " << row_number << " and col no. " << curr->column_number << endl << "Would you like to change this value? (Y/N) ";
    string answ;
    cin >> answ;
    if (answ=="Y"){
        curr->data = val;
        cout << "Value has been overwritten." << endl;
    }
    else{
        cout << "Value has not been overwritten." << endl;
    }
}
void RowNode::insertColumn(int colIndex, int val){
        if (colHead == NULL || (colTail != NULL && colIndex > colTail->column_number)){ //Αν η λίστα είναι άδεια ή ο αριθμός της στήλης είναι μεγαλύτερος από τον τελευταίο αριθμό στήλης στην τρέχουσα λίστα
            ColumnNode *newNode = new ColumnNode(colIndex, val);
            if (colHead == NULL){ //Η λίστα είναι άδεια
                colHead = colTail = newNode;
            }
            else{
                colTail->nextColumn = newNode;
                colTail = newNode;
            }
            column_size++;
            return;
        }
    if (colIndex < colHead->column_number){//Εισαγωγή στην αρχή
        ColumnNode *newCol = new ColumnNode(colIndex, val);
        newCol->nextColumn = colHead;
        colHead = newCol;
        column_size++;
        return;
    }
    ColumnNode *curr = colHead;
    for (int i = 0; i < column_size; i++){
        if (curr->column_number == colIndex){ //Αν ο κόμβος βρεθεί τότε επιχειρεί overwrite
            overwriteColumn(curr, val);
            break;
        }
        else if (curr->nextColumn != NULL){
            if (curr->column_number < colIndex && curr->nextColumn->column_number > colIndex){//Ενδιάμεση εισαγωγή
                ColumnNode *newCol = new ColumnNode(colIndex, val);
                newCol->nextColumn = curr->nextColumn;
                curr->nextColumn = newCol;
                column_size++;
                break;
            }
            else{
                curr = curr->nextColumn;
            }
        }
    }
}
void RowNode::printCol(int mSize){
    int counter = 0;
    ColumnNode *curr = colHead;
    while (counter < mSize){
        /*
        iterates χρησιμοποιώντας έναν μετρητή counter ο οποίος θα υποδείξει το μέγεθος της στήλης
         Αν ο μετρητής counter είναι ίσος με το column number τότε εκτυπώνει το data και δείχνει στον επόμενο κόμβο
        αλλιώς δεν θα υπάρχει,οπότε θα εκτυπώνει μηδενικά
         Αν η τρέχων στήλη είναι null και ο counter είναι ακόμα μικρότερος ίσος από το column size
         απλά θα εκτυπώνει μηδενικά για τις υπόλοιπες διασχίσεις
        */
        if (curr != NULL){
            if (counter == curr->column_number){
                cout << right << setw(5) << curr->data;
                curr = curr->nextColumn;
            }
            else{
                cout << setw(5) << right << "0";
            }
        }
        else{
            cout << setw(5) << right << "0";
        }
        counter++;
    }
}