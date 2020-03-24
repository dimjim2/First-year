//
// Created by dimmy on 28/6/2019.
//
#include "BST.h"
#include<iostream>
#include "LinkedList.h"
#include "Chain.h"
#include <queue>
#include <algorithm>
#include<bits/stdc++.h>
//Είσαγωγή στο δυαδικό δένδρο αναζήτησης
Node* BST::insert(Node *leaf, string key, string key2) {
    if(leaf == NULL)
    {
        leaf = new Node;
        leaf->english=key;
        leaf->greek=key2;
        leaf->rightChild = NULL;
        leaf->leftChild=NULL;
    }
    else if(key < leaf->english)
        leaf->leftChild = insert(leaf->leftChild,key,key2);
    else if(key> leaf->english)
        leaf->rightChild = insert(leaf->rightChild,key,key2);
    return leaf;
}
void BST::Insert(string e1,string e2)
{
    root=insert(root,e1,e2);
}
void BST::Delete(string e1) {
   root=deleteNode(root,e1);
    }
 //Ανάζητηση σύμφωνα με πρώτα γράμματα της λέξης στα αγγλικά
 //και αν ισχύει προσθήκη της λέξης στην λίστα τύπου LinkedList
LinkedList * BST::Search() {
    int n;
    int count ;
    string beginning;
    std::cout << "Give me the numbers of the first letters you want to insert";
    cin >> n;
    while (cin.fail()) {
        cout << "ERROR:WRONG CHOICE" << endl;
        cin.clear();
        cin.ignore(INT_MAX, '\n');
        cout << "Give me the numbers of the first letters you want to insert";
        cin >> n;
    }
    std::cout << "Give me the  first letters of the word you want to search";
    cin >> beginning;
    char words[n];
    strncpy(words, beginning.c_str(), n);
    for (int i = 0; i < n; i++)
        cout << words[i]<<endl;
    Node *p = root;
    LinkedList *l = new LinkedList;
    while (p) {
        count=0;
        for (int i = 0; i < n; i++) {
            if (words[i] == p->english[i]) {
                count += 1;
            }
         }
        if (count == n) {
            l->add(p->english,p->greek);
            cout<<"Congrats"<<endl;
        }
        if ((string(words)).compare(p->english) < 0) {
            p = p->leftChild;
        } else if ((string(words)).compare(p->english) > 0) {
            p = p->rightChild;
        }
    }
    return l ;
}
//Βρίσκουμε τον αριστερότερο κόμβο που θα έχει το ελάχιστο στοιχείο
Node* BST::findMin(Node *p) {
    while (p->leftChild != NULL)
        p = p->leftChild;
    return p;
}
//Ενδοδιάταξη με αναδρομή
void BST:: inorder(Node* t)
{
    if(t == NULL)
        return;
    inorder(t->leftChild);
    cout << t->english << " ";
    cout << t->greek << " ";
    inorder(t->rightChild);
}
//Εκτύπωση με αναδρομή
void BST::Display() {
    inorder(root);
}
//Διαγραφή μέσω αναδρομής
Node* BST::deleteNode(Node *p, string data) {
    {
        if (p == NULL)
            return root;
        else if (data < p->english)
            p->leftChild = deleteNode(p->leftChild, data);
        else if (data > p->english)
            p->rightChild = deleteNode(p->rightChild, data);
        else {
            if (p->leftChild == NULL && p->rightChild == NULL) {
                delete p;
                p = NULL;
            } else if (p->leftChild == NULL) {
                Node *temp = p;
                p = p->rightChild;
                delete temp;
            } else if (p->rightChild == NULL) {
                Node *temp = p;
                p = p->leftChild;
                delete temp;
            } else {
                Node *min = findMin(p->rightChild);
                p->english = min->english;
                p->rightChild = deleteNode(p->rightChild, min->english);
            }
        }
        return p;
    }
}
void BST::print(Node *p,int depth) {
    if (p == NULL) return;

    // Δημιουργούμε μια άδεια ουρά τύπου Node*
    queue<Node*> q;

    // Τοπόθετησε την ρίζα στην ουρά
    q.push(p);
    Chain *c=inorder2(root);
    c->all();
    int count=c->count();
    //Θέση που βρίσκεται το στοιχείο στην ενδοδίαταξη
    int a;
    while (q.empty() == false)
    {
        // nodeCount (queue size) αναπαρίστα των αριθμό κόμβων
        // ανά κάθε επίπεδο
        int nodeCount = q.size();
        int prev=0;
        //Αν ο nodeCount είναι 0 τερμάτισε
        if(nodeCount == 0)
            break;
        while (nodeCount > 0)
        {
            Node *node = q.front();
            a=(*c).find(node->english[0]);
            for (int i = 0; i < a-prev-1; ++i)
            {
                cout << " X " ;
            }
            cout<<" "<<node->english[0]<<" ";
            q.pop();
            prev=a;
            if (node->leftChild != NULL)
                q.push(node->leftChild);
            if (node->rightChild != NULL)
                q.push(node->rightChild);
            nodeCount--;
        }
        for (int i = 0; i <count-a; ++i)
        {
            cout << " X " ;
        }
        depth--;
        cout << endl;
    }
}
void BST::levelOrder() {
    int d=depth(root,1);
    print(root,d);
}
//Εύρεση του ύψους του δένδρου(μέγιστο μονοπάτι απο την ρίζα στα φύλλα)
int BST::depth(Node *p, int d) {
    if(!p) {
        return d;
    }
    int left = d;
    int right = d;
    if (p->leftChild){
        left=depth(p->leftChild,d+1);
    }
    if(p->rightChild) {
        right = depth(p->rightChild, d+1);
    }
    return max(left, right);
}
Chain* BST::inorder2(Node *t) {
    stack<Node *> s;
    Node *curr = t;
    Chain *P=new Chain;
    while (curr != NULL || s.empty() == false)
    {
        /*Βρες τον αριστερότερο κόβο του
           curr Node */
        while (curr !=  NULL)
        {
            s.push(curr);
            curr = curr->leftChild;
        }
        /* Current πρέπει να είναι NULL τώρα */
        curr = s.top();
        s.pop();
        P->add(curr->english[0]);
        //Τώρα ελέγχουμε το δεξί υποδένδρο
        curr = curr->rightChild;
    }
    return P;
}
