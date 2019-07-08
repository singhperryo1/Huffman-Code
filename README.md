# Huffman Code
Implementation of the algorithm (building the code and encoding the input) that is used in lossless data compression.
* Huffman Code is an interactive program that is used to build a variable length code to different input character(s) with time complexity of O(n*log(n)).
* This time complexity significantly reduces to O(1) for input of same character(s).
* The length of code is related to how frequently characters are used.
* Due to the use of Hash function to store generated codes in array and count the number of characters in message, both the encoding and analyzing the message is consistent at O(n) where n is the number of characters in the input.

## Data Structure used
* Min priority Queue Using Binary Heap.
* Binary Tree.
* Hash Maps using array.
## Programming Language Used
* Java
## Future Enhancements 
* Add the functionality to encode big data files with more than 2147483646 characters(Maximum number of characters a String can hold) in reasonable time.

