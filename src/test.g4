grammar test;

init:   token(' 'token)*;
token:  ('b'|'c')a1;
a1:    ('b'|'c')a1
       | 'd'a2;
a2  :   ('a'|'c')a3;
a3  : ('a'|'c')a3 | ;
