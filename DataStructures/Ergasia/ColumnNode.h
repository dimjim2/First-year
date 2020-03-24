//
// Created by dimmy on 1/5/2019.
//
#ifndef ERGASIA_COLUMNNODE_H
#define ERGASIA_COLUMNNODE_H

/*Ορίζουμε την κλάση ColumnNode η οποία είναι φίλη της κλάσης RowNode και της SM.(Επομένως αυτές θα έχουν πρόσβαση στα ιδιωτικά της μέλη)
//Το πεδίο data περιλαμβάνει τα δεδομένα του προγράμματος,το πεδίο column_number τον αριθμό της στήλης και το nextColumn τον επόμενο κόμβο
Ορίζουμε στα public μέλη τον constructor ColumnNode*/
class ColumnNode {
    friend class RowNode;
    friend class SM;
private:
    ColumnNode *nextColumn;
    int data;
    int column_number;
public:
    ColumnNode(int colNo, int val);
};

#endif //ERGASIA_COLUMNNODE_H
