#include <iostream>
#include <limits>
#include <cmath>
#include "BST.h"
#include<bits/stdc++.h>
#include "LinkedList.h"
using namespace std;
int choice;
//Συνάρτηση για έλεγχο ότι θα δοθεί ακέραιος αριθμός
int input(string a) {
    cout << " Enter a number " + a;
    cin >> choice;
        while (cin.fail()) {
            cout << "ERROR:WRONG CHOICE" << endl;
            cin.clear();
            cin.ignore(INT_MAX, '\n');
            cout << " Enter a number " + a;
            cin >> choice;
        }
        return choice;
    }
int main() {
    BST dictionary;
    int cCh;
    string word1,word2;
    string sW,sav1,sav2,ws;
    LinkedList *l;
    //Δημιουργία μενού επιλογής
    do {
        cout << "\n\n";
        cout << "1)Insert into the dictionary\n";
        cout << "2)Delete a word from Dictionary\n";
        cout << "3)Search a word from Dictionary\n";
        cout << "4)Display the tree\n";
        cout << "5)Level order of  the tree\n";
        cout<<"\n\nEnter your Choice : ";
       do {
           choice =(int) input("1-5");
       }while(choice<1 || choice>5);
       switch (choice){
           case 1:
                cout<<"Give me the word you want to insert in english"<<endl;
                cin>>word1;
                cout<<"Give me the word you want to insert in greek (translation)"<<endl;
                cin>>word2;
                dictionary.Insert(word1,word2);
                break;
            case 2:
                cout<<"enter word to delete : ";
                cin>>sW;
                dictionary.Delete(sW);//sav1,sav2);
                break;
            case 3:
                l= dictionary.Search();
                l->print();
                if (l->length==0){
                    cout<<"Nothing found according your search.Sorry";
                    break;
                }
                cout<<"Give me the word of the above you want to translate";
                cin>>ws;
                l->search(ws);
                break;
            case 4:
                dictionary.Display();
                break;
            case 5:
                dictionary.levelOrder();
        }
        do {
            cCh=input("\n press 0 for main and 1 to exit");
        }while(choice<0 || choice>1);
    }while(cCh==0);
}
