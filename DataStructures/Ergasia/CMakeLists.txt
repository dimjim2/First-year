cmake_minimum_required(VERSION 3.13)
project(Ergasia)

set(CMAKE_CXX_STANDARD 14)

add_executable(Ergasia main.cpp ColumnNode.cpp ColumnNode.h RowNode.h RowNode.cpp SM.cpp SM.h)