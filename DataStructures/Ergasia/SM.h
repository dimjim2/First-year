//
// Created by dimmy on 1/5/2019.
//

#ifndef ERGASIA_SM_H
#define ERGASIA_SM_H

#include "RowNode.h"
//Ορίζουμε την κλάση SM(αραίος πίνακας)
class SM{
private:
    int row_max, col_max; // μέγιστος αριθμός από γραμμές και στήλες
    int row_Size; // πραγματικός αριθμός της row_size
    RowNode *rowHead; //δείκτης στην πρώτη γραμμή της λίστας
    RowNode *rowTail; //δείκτης στην τελευταία γραμμή της λίστας
public:
    SM(int rows, int columns);
    ~SM();
    void inputElements();//εισαγωγή στοιχείων
    void printMatrix();//εκτυπώνει την μήτρα
    SM * addSM(SM &other); //πρόσθεση μήτρας
    void insertEntry(int rowIndex, int colIndex, int val); // εισαγωγή ένα νέου στοιχείου μέσα στην γραμμή x στήλης
    void deleteFirstRow();  // διαγράφει τον πρώτο row node στην λίστα and αναθέτει το  next στο head
    void printColumnHeader();// θα εκτυπώνει τους αριθμούς στήλης( ex 1 2 3 4 5 6 7 8 9 10)
    void printEmptyRow(int counter); //θα εκυπώνει μια άδεια γραμμη για το counter number (ex 5| 0 0 0 0 0 0)
};

#endif //ERGASIA_SM_H
