//
// Created by dimmy on 1/5/2019.
//
#include <iostream>
#include <string>
#include <iomanip>
using namespace std;
#include "SM.h"
bool checkCommas(string str, int check){ //ελέγχει για τα comma και για έγκυρο έλεγχο
    int counter = 0;
    int number = 0;
    while (counter < str.length()){
        if (str[counter] == ','){
            number++;
        }
        counter++;
    }
    if (number == check){
        return true;
    }
    return false;
}
void SM::insertEntry(int rowIndex, int colIndex, int val){
    if (rowTail == NULL || rowIndex > rowTail->row_number){ //κάνει εισαγωγή στο τέλος αν η λίστα είναι άδεια
        // ή όταν ο αριθμός της γραμμής είναι μεγαλύτερος από τον τελευταίο αριθμό γραμμής
        RowNode *newNode = new RowNode(rowIndex);
        if (rowHead == NULL){ // Αν η λίστα είναι άδεια
            rowHead = rowTail = newNode;
        }
        else{
            rowTail->nextRow = newNode;
            rowTail = newNode;
        }
        row_Size++;
        newNode->insertColumn(colIndex, val);
        return;
    }
    if (rowTail->row_number == rowIndex){ //αν ο αριθμός γραμμής είναι ίσος με τον τελευταίο κάνει insert στο τέλος
        rowTail->insertColumn(colIndex, val);
        return;
    }
    if (rowIndex < rowHead->row_number){ //Εισαγωγή στην αρχή
        RowNode *newRow = new RowNode(rowIndex);
        newRow->nextRow = rowHead;
        rowHead = newRow;
        row_Size++;
        newRow->insertColumn(colIndex, val);
        return;
    }
    RowNode *curr = rowHead;
    for (int i = 0; i < row_Size; i++){
        if (curr->row_number == rowIndex){ //Αν ο κόμβος ήδη προυπάρχει
            curr->insertColumn(colIndex, val);
            break;
        }
        else if (curr->nextRow != NULL){
            if (curr->row_number < rowIndex && curr->nextRow->row_number > rowIndex){//Εισαγωγή ενδιάμεσα
                RowNode *newRow = new RowNode(rowIndex);
                newRow->nextRow = curr->nextRow;
                curr->nextRow = newRow;
                row_Size++;
                newRow->insertColumn(colIndex, val);
                break;
            }
            else{
                curr = curr->nextRow;
            }
        }
    }
}
void SM::deleteFirstRow(){
    RowNode *toBeDeleted = rowHead;
    rowHead = rowHead->nextRow;
    delete toBeDeleted;
    if (rowHead == NULL){
        rowTail = NULL;
    }
}
void SM::printColumnHeader(){
    cout << "-----------------------------------------------------------" << endl;
    cout << "Sparse-matrix " << endl << endl;
    cout << " Row|Column";

    for (int i = 0; i < col_max; i++){
        cout << right << setw(5) << i;
    }
    cout << endl;
    for (int i = 0; i < col_max * 6; i++){
        cout << right << "-";
    }
    cout << endl;
}
void SM::printEmptyRow(int counter){
    for (int i = 0; i < col_max; i++){
        cout << setw(5) << right << "0";
    }
    cout << endl;
}
//consructor
SM::SM(int rows, int columns){
    row_max = rows;
    col_max = columns;
    rowHead = NULL;
    rowTail = NULL;
    row_Size = 0;
    cout << "A zero-based Sparse Matrix has been created with , Row(s) " << row_max << " and Column(s) " << col_max << endl;
}
SM::~SM(){
    while (rowHead != NULL){//Όσο υπάρχουν ακόμα γραμμές να απομένουν(η πρώτη γραμμή της στήλης δεν ειναι null)συνέχισε να διαγράφεις την πρώτη γραμμή
        deleteFirstRow();
    }
    cout<<"successfully deleted";
}
//Για την εισαγωγή των στοιχείων
void SM::inputElements() {
    {
        string input = "";
        cout << "Please input your  elements into the sparse matrix \n";
        cout << "Use the way as shown as row index,column index,value (EXAMPLE 0,1,1)" << endl;
        cout << "Type EXIT to stop inputting" << endl;
        while (1){
            int rowIndex, colIndex, val;
            cout << "Input: ";
            cin >> input;
            string toLower;
            for (int i = 0; i < input.length(); i++){
                toLower += tolower(input[i]);
            }
            if (toLower == "exit"){
                break;
            }
            else{
                try{

                    if (!(checkCommas(input, 2))){
                        throw exception();
                    }
                    rowIndex = stoi(input.substr(0, input.find_first_of(',')));
                    colIndex = stoi(input.substr(input.find_first_of(',') + 1, input.find_last_of(',')));
                    val = stoi(input.substr(input.find_last_of(',') + 1, input.length()));
                    if (colIndex < 0 || colIndex >= col_max || rowIndex < 0 || rowIndex >= row_max){
                        cout << "Out of bound. Maximum Column number entry is " << col_max- 1 << " and Maximum Row number entry is " << row_max - 1 << endl;
                    }
                    else if (val == 0){
                        cout << "Value must be non-zero!" << endl;
                    }
                    else
                        insertEntry(rowIndex, colIndex, val);

                }
                catch (exception e){
                    cout << "Invalid input, please try again" << endl;
                }
            }
        }
    }
}
//Άθροισμα μητρών
SM * SM::addSM(SM &other){
    {
        if ((other.col_max == this->col_max) && (other.row_max== this->row_max)){ // Έλεγχος αν έχουν την ίδια διάσταση
            SM * newSM = new SM(this->row_max, this->col_max); // Δημιουργούμε έναν καινούργιο πίνακα
            RowNode * thisCurrRow = this->rowHead;  // Δείκτης στην  first row node (αυτού) this SM
            RowNode * otherCurrRow = other.rowHead; // Δείκτης στην πρώτη  first row node (του άλλου) other SM
            ColumnNode *otherCurrCol = NULL; // Δεικτης σε έναν κόμβο στήλης  column node (του άλλου)in other SM
            ColumnNode *thisCurrCol = NULL; // Δείκτης σε έναν κόμβο στήλης column node (του ίδιου) in this SM
            while (thisCurrRow != NULL || otherCurrRow != NULL){
                /*Υπάρχουν 3 σενάρια για κάθε SM που πρέπει να αντιμετωπιστούν
                1. Αυτός ο δείκτης σειράς SM είναι NULL, οπότε εισήγαγε όλους τους κόμβους σειράς SM και τους κόμβους της στήλης τής άλλης μήτρας(το ίδιο πρέπει να αναπαραχθεί και για την άλλη περίπτωση)
                2. Αυτός this ο αριθμός δείκτη σειράς SM ταιριάζει με άλλους αριθμούς γραμμής SM, οπότε υπάρχουν διάφορα σενάρια που πρέπει να αντιμετωπιστούν
                2.1. Οι αριθμοί των στηλών ταιριάζουν, οπότε γίνεται εισαγωγή  με το άθροισμα των δύο αυτών αριθμών
                2.2. Αυτός this ο αριθμός στη στήλη SM είναι μικρότερος από τον άλλο other , στη συνέχεια εισάγετε αυτόν τον αριθμό στήλης (ο ίδιος αναπαράγεται για τον άλλον SM)
                2.3. Αυτός ο δείκτης στήλης SM είναι μηδέν, οπότε εισάγετε όλους τους κόμβους στήλης (σημαίνει ότι μπορεί να έχει φτάσει στο τέλος της λίστας στη στήλη για αυτό το SM, αλλά otherSM εξακολουθεί να έχει κόμβους στηλών)
                3. Αυτός ο αριθμός δείκτη σειράς SM είναι μικρότερος από τον άλλο αριθμό σειράς SM, οπότε τοποθετήστε όλες τις σειρές έως ότου δεν είναι πλέον μικρότερος από τον άλλο αριθμό γραμμής SM και δεν είναι NULL (δεν έχει φτάσει στο τέλος της λίστας)
                */
                if (thisCurrRow == NULL && otherCurrRow != NULL){
                    while (otherCurrRow != NULL){
                        otherCurrCol = otherCurrRow->colHead;
                        while (otherCurrCol != NULL){
                            newSM->insertEntry(otherCurrRow->row_number, otherCurrCol->column_number, otherCurrCol->data);
                            otherCurrCol = otherCurrCol->nextColumn;
                        }
                        otherCurrRow = otherCurrRow->nextRow;
                    }
                    break;
                }
                else if (thisCurrRow != NULL && otherCurrRow == NULL){
                    while (thisCurrRow != NULL){
                        thisCurrCol = thisCurrRow->colHead;
                        while (thisCurrCol != NULL){
                            newSM->insertEntry(thisCurrRow->row_number, thisCurrCol->column_number, thisCurrCol->data);
                            thisCurrCol = thisCurrCol->nextColumn;
                        }
                        thisCurrRow = thisCurrRow->nextRow;
                    }
                }
                else if (thisCurrRow->row_number == otherCurrRow->row_number){
                    thisCurrCol = thisCurrRow->colHead;
                    otherCurrCol = otherCurrRow->colHead;
                    while (thisCurrCol != NULL || otherCurrCol != NULL){
                        if (otherCurrCol == NULL){
                            while (thisCurrCol != NULL){
                                newSM->insertEntry(thisCurrRow->row_number, thisCurrCol->column_number, thisCurrCol->data);
                                thisCurrCol = thisCurrCol->nextColumn;
                            }
                        }
                        else if (thisCurrCol == NULL){
                            while (otherCurrCol != NULL){
                                newSM->insertEntry(otherCurrRow->row_number, otherCurrCol->column_number, otherCurrCol->data);
                                otherCurrCol = otherCurrCol->nextColumn;
                            }
                        }
                        else if (thisCurrCol->column_number == otherCurrCol->column_number){
                            int sum = thisCurrCol->data + otherCurrCol->data;
                            newSM->insertEntry(thisCurrRow->row_number, thisCurrCol->column_number, sum);
                            thisCurrCol = thisCurrCol->nextColumn;
                            otherCurrCol = otherCurrCol->nextColumn;
                        }
                        else if (thisCurrCol->column_number < otherCurrCol->column_number){
                            newSM->insertEntry(thisCurrRow->row_number, thisCurrCol->column_number, thisCurrCol->data);
                            thisCurrCol = thisCurrCol->nextColumn;
                        }

                        else if (otherCurrCol->column_number < thisCurrCol->column_number){
                            newSM->insertEntry(otherCurrRow->row_number, otherCurrCol->column_number, otherCurrCol->data);
                            otherCurrCol = otherCurrCol->nextColumn;
                        }
                    }
                    thisCurrRow = thisCurrRow->nextRow;
                    otherCurrRow = otherCurrRow->nextRow;

                }
                else if (thisCurrRow->row_number < otherCurrRow->row_number){
                    while (thisCurrRow != NULL && thisCurrRow->row_number < otherCurrRow->row_number){
                        thisCurrCol = thisCurrRow->colHead;
                        while (thisCurrCol != NULL){
                            newSM->insertEntry(thisCurrRow->row_number, thisCurrCol->column_number, thisCurrCol->data);
                            thisCurrCol = thisCurrCol->nextColumn;
                        }
                        thisCurrRow = thisCurrRow->nextRow;
                    }
                }
                else if (otherCurrRow->row_number < thisCurrRow->row_number){
                    while (otherCurrRow != NULL && otherCurrRow->row_number < thisCurrRow->row_number){
                        otherCurrCol = otherCurrRow->colHead;
                        while (otherCurrCol != NULL){
                            newSM->insertEntry(otherCurrRow->row_number, otherCurrCol->column_number, otherCurrCol->data);
                            otherCurrCol = otherCurrCol->nextColumn;
                        }
                        otherCurrRow = otherCurrRow->nextRow;
                    }
                }

            }
            return newSM;
        }
        else
            cout << "The sparse matrices dimensions are not the same. Aborting...";
        abort();
    }
}
void SM::printMatrix(){
    printColumnHeader();
    int counter = 0;
    RowNode * curr = rowHead;
    while (counter < row_max){
        /*
         * while loop με έναν μετρητή να διασχίζει τον μέγιστο αριθμό την γραμμών
         * Αν ο μετρητής ταιριάζει στον τρέχοντα αριθμό γραμμής τότε εκτυπώνει τις στήλες μέσα από την γραμμή και δείχνει στον επόμενο
         * αλλιώς εκτυπώνει τον άδειο
         * Αν η τρέχων γραμμή είναι null και ο μετρητής δεν έχει φτάσει το τέλος
         * Τότε θα εκτυπώνει τα μηδενικά για τις υπόλοιπες διασχίσεις
         */
        cout << setw(3) << counter << "|";
        if (curr != NULL){
            if (counter == curr->row_number){
                curr->printCol(col_max);
                curr = curr->nextRow;
                cout << endl;
            }
            else
                printEmptyRow(counter);
        }
        else
            printEmptyRow(counter);
        counter++;
    }
    cout << endl << "-----------------------------------------------------------" << endl;
}
