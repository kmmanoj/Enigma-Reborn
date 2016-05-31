# Enigma-Reborn
New Encryption and Decryption format.

-----------------------------
INTRODUCTION:
_____________________________

	Enigma is an encoding (Encryption-decryption) machine used by Germans during the Second World war.
	The Encrytion code was broken, by the father of Computer Science 'Alan Turing'
	
The project (closely) mimics the encryption-decryption format used by German's During Second world war.

------------------------------
ABOUT:
______________________________

The Encryption-decryption format is closely related to the format used in rotor machine such as Engima.
It is a variable length encryption format, wherein  a character is substituted by 1-3 characters.

The Map has 128-32=96 columns, each column representing an ascii character.
		And 6 rows, where the first row represents the ascii character, 
			and other five rows for a column represents the possible ascii values that the actual ascii character can be replaced with.
	The five rows are generated randomly, which contains every ascii character of values between 32 and 128, in any order.
	The five rows are also decided by the key used in encryption-decryption.
	
Encryption format:
	Given a String, 
	The i th  character is substituted those many number of characters determined by the function of i+1 th character,
		where function the function returns a value between 1-3;
	Initially, the ascii character pertaining to the character to be substituted is searched, in the first row of the map.
		That column is selected. The algorithm uses the value of the function(i+1 th character) say n.
		n: represents the number of characters that particular character will be substituted by,
			represents the starting point on the column from where the substituion occurs.
	Each character undergoes the same procedure.
	For simplicity, the last character in the string, is substituted by 2 characters.
	
Decryption format:
	Decryption begins from the end.
	The last 2 characters are selected and the map is traversed along the 3rd row =(2*2-1) to search for the character equal to the first character of the selected substring.
	Once the character is found, the corresponding ascii character on the first row is found.
	Now that we have the valence character we can find the pen-ultimate character by using the map, function value of the valence character.
	Say, the function value is 1 then one character before the decrypted string is selected and used in decryption traversal.
	(2*1-1)=1st row is traversed to search for the character in encrypted string.
	The process is repeated until the first character is found.
	
------------------------------
FILES:
______________________________
Node.java:
	The basic unit
	
Map.java:
	A multilist of nodes:
		Singly Linked List Horizontally
		Doubly Linked List Vertically
		
Sequence.java:
	File that contains information about key/value pairs of charcacter: sequence
		
Seqc.java:
	File that holds the object of Sequence class
	
Algorithm.java:
	File that contains the algorithm to encrypt and decrypt data

Generate.java:
	A file that is used to generate random sequence, of all printable ascii characters:(32-128)
	It infact Generates a new Sequence.java on its own

MainFrame.java:
	Contains the GUI for users to interact with the software
		
Main.java:
	The Main class file that contains the main() method

ADD-ONS:
EncryptFile.java:
	Encrypts a file having extension *.txt to generate a *x.txt file
DecryptFile.java:
	Decrypts a file having extension *x.txt to generate a *xx.txt file
Tester.java:
	A command-line interface class file which allows encryption and decryption of a file

	

	
