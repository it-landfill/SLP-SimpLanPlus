grammar SimpLanPlus;

// THIS IS THE PARSER INPUT

block	    : LCPAR declaration* statement* RCPAR;

statement   : assignment SEMIC
            | print SEMIC
            | ret SEMIC
            | ite
            | call SEMIC
            | block;

declaration : decFun
            | decVar ;

decFun	    : (type | VOID) ID LPAR (arg (COMMA arg)*)? RPAR block ;

decVar      : type ID (ASSIGN exp)? SEMIC ;

type        : INTEGER
            | BOOLEAN;

arg         : (VAR)? type ID;

assignment  : ID ASSIGN exp ;

print	    : PRINT exp;

ret	    : RETURN (exp)?;

ite         : IF LPAR exp RPAR statement (ELSE statement)?;

call        : ID LPAR (exp(COMMA exp)*)? RPAR;

exp	    : LPAR exp RPAR				                        #baseExp
	    | MINUS exp					                        #negExp
	    | NOT exp                                           #notExp
	    | ID						                        #derExp
	    | left=exp op=(PROD | DIV)              right=exp   #arithmExp
	    | left=exp op=(PLUS | MINUS)            right=exp   #arithmExp
	    | left=exp op=(LT | LTE | GT | GTE)     right=exp   #compareExp
	    | left=exp op=(EQ| NEQ)                 right=exp   #equalExp
	    | left=exp op=AND                       right=exp   #logicExp
	    | left=exp op=OR                        right=exp   #logicExp
	    | call                                              #callExp
	    | BOOL                                              #boolExp
	    | NUMBER					                        #valExp;

// THIS IS THE LEXER INPUT
//Keywords
IF: 'if';
ELSE: 'else';
VAR: 'var';
RETURN: 'return';
PRINT: 'print';

//Characters
LPAR: '(';
RPAR: ')';
LCPAR: '{';
RCPAR: '}';
COMMA: ',';
SEMIC: ';';

//Operators
ASSIGN: '=';
NOT: '!';
PROD: '*';
DIV: '/';
PLUS: '+';
MINUS: '-';
LT: '<';
GT: '>';
LTE: '<=';
GTE:  '>=';
EQ: '==';
NEQ: NOT '=';
AND: '&&';
OR: '||';

//Types
INTEGER    : 'int' ;
BOOLEAN   : 'bool' ;
VOID: 'void';

//Booleans
BOOL        : 'true'|'false';

//IDs
fragment CHAR 	    : 'a'..'z' |'A'..'Z' ;
ID          : CHAR (CHAR | DIGIT)* ;

//Numbers
fragment DIGIT	    : '0'..'9';
NUMBER      : DIGIT+;

//ESCAPE SEQUENCES
WS              : (' '|'\t'|'\n'|'\r')-> skip;
LINECOMMENTS 	: '//' (~('\n'|'\r'))* -> skip;
BLOCKCOMMENTS   : '/*'( ~('/'|'*')|'/'~'*'|'*'~'/'|BLOCKCOMMENTS)* '*/' -> skip;
