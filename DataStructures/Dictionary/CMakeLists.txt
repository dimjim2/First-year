cmake_minimum_required(VERSION 3.14)
project(Dictionary)

set(CMAKE_CXX_STANDARD 14)

add_executable(Dictionary main.cpp Node.h Node.cpp BST.h BST.cpp LNode.h LinkedList.cpp LinkedList.h Chain.cpp Chain.h ChainNode.h)