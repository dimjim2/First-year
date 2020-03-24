#include <iostream>
#include <iostream>
#include <string>
#include <iomanip>
#include "SM.h"

using namespace std;
bool checkCommas1(string str, int check){ // to find number of occurences of comma (USED FOR ENTRY VALIDATION)
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
int main() {
    int row1, column1, row2, column2,c;
    string in;
    cout << "Please enter the dimensions for the first sparse matrix  form row,column" << endl
         << "For example 3,4 for 3 rows and 4 columns" << endl;
    cout << "Input: ";
    cin >> in;
        try {
            if (!checkCommas1(in, 1)) {
                cout << "Invalid input" << endl;
                return 0;
            }
            row1 = stoi(in.substr(0, in.find_first_of(',')));
            column1 = stoi(in.substr(in.find_first_of(',') + 1, in.length()));
            while (!(row1 > 0 && column1 > 0)) {
                cout << " Row and Column dimensions must both be greater than 0!" << endl;
                abort();
            }

        SM *s = new SM(row1, column1);
        s->inputElements();
        s->printMatrix();
        cout << "Please enter the Sparse Matrix 2 dimensions in the form row,column" << endl
             << "For example 5,10 for 5 rows and 10 columns" << endl;
        cout << "Input: ";
        cin >> in;
        if (!checkCommas1(in, 1)){
            cout << "Invalid input" << endl;
            return 0;
        }
        row2 = stoi(in.substr(0, in.find_first_of(',')));
        column2 = stoi(in.substr(in.find_first_of(',') + 1, in.length()));
        while (!(row2 > 0 && column2 > 0)){
            cout << " Row and Column dimensions must both be greater than 0!" << endl;
            abort();
        }
        SM *d = new SM(row2, column2);
        d->inputElements();
        d->printMatrix();
        cout << "Sparse Matrix 1." << endl;
        s->printMatrix();
        cout << "Sparse Matrix 2." << endl;
        d->printMatrix();
        SM *f = s->addSM(*d);
        cout << "Sum of Matrix 1 & 2" << endl;
        f->printMatrix();
        delete d;
        delete f;
    }
    catch (exception ex){
        cout << "Invalid input, aborting." << endl;
        abort();
    }
    return 0;
    }