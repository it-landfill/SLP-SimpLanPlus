grammar SVM;

@header {
import java.util.HashMap;
}

@lexer::members {
public int lexicalErrors=0;
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

assembly: (instruction)* ;

instruction : push
            | pop
            | top
            | add
            | sub
            | mult
            | div
            | lt
            | lte
            | gt
            | gte
            | eq
            | neq
            | and
            | or
            | not
            | print
            | halt;


push    : PUSH reg=REG;
pop     : POP reg=REG;
top     : TOP reg=REG;
add     : ADD dest=REG reg1=REG reg2=REG;
sub     : SUB dest=REG reg1=REG reg2=REG;
mult    : MULT dest=REG reg1=REG reg2=REG;
div     : DIV dest=REG reg1=REG reg2=REG;
lt      : LT dest=REG reg1=REG reg2=REG;
lte     : LTE dest=REG reg1=REG reg2=REG;
gt      : GT dest=REG reg1=REG reg2=REG;
gte     : GTE dest=REG reg1=REG reg2=REG;
eq      : EQ dest=REG reg1=REG reg2=REG;
neq     : NEQ dest=REG reg1=REG reg2=REG;
and     : AND dest=REG reg1=REG reg2=REG;
or      : OR dest=REG reg1=REG reg2=REG;
not     : NOT dest=REG reg=REG;
print   : PRINT reg=REG;
halt    : HALT;

/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/

PUSH  	 : 'push' ; 	// pushes constant in the stack
POP	 : 'pop' ; 	// pops from stack
TOP : 'top' ;
ADD	 : 'add' ;  	// add two values from the stack
SUB	 : 'sub' ;	// add two values from the stack
MULT	 : 'mult' ;  	// add two values from the stack
DIV	 : 'div' ;	// add two values from the stack
PRINT	 : 'print' ;	// print top of stack
HALT	 : 'halt' ;	// stop execution
LT        : 'lt' ; // Lower than
LTE       : 'lte' ; // Lower than or equal
GT        : 'gt' ; // Greater than
GTE       : 'gte' ; // Greater than or equal
EQ        : 'eq' ; // Equal
NEQ       : 'neq' ; // Not Equal
AND       : 'and' ;
OR        : 'or' ;
NOT     : 'not' ;
LW      : 'lw';
SW      : 'sw';

fragment DIGIT  : '0'..'9';
REG : '$'('a0'|'t'DIGIT|'ra'|'sp'|'fp');
MEM :   DIGIT+ '(' REG ')';

COL	 : ':' ;
NUMBER	 : '0' | ('-')?(('1'..'9')DIGIT*) ;

WHITESP  : ( '\t' | ' ' | '\r' | '\n' )+   -> skip;

