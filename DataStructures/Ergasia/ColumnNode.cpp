//
// Created by dimmy on 1/5/2019.
//
#include <iostream>
#include <string>
#include <iomanip>
using namespace std;
#include "ColumnNode.h"
//Δημιουργούμε constructor για την κλάση ColumnNode
ColumnNode::ColumnNode(int colNo, int val){
    data = val;
    this->column_number = colNo;
    nextColumn = NULL;
}