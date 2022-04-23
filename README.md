<p align="center">
  <img src="https://www.unibo.it/it/immagini/1_UNIBO_Ateneo_vert_pos.jpg/@@images/51c830e4-97ca-4516-bdf8-64ea327bdab3.jpeg" alt="Logo Università degli Studi di Bologna"/>
</p>

# SimpLanPlus
Benetton Alessandro [0001038887]

Crespan Lorenzo [0001038888]

Zhiguang Li [0001029938]

## Progetto per il corso di Compilatori e Interpreti A.A 2021/2022
## Risorse
[Jira](https://aleben.atlassian.net/jira/software/projects/PCEI/boards/5)

[Overleaf](https://www.overleaf.com/project/625310dd16f686f54fcb6837)

## Testo Progetto

SimpLanPlus è un semplice linguaggio imperativo, in cui i parametri delle
funzioni possono essere passati anche per variabile, le funzioni non sono annidate
(una funzione non può essere definita nel corpo di un'altra), ed ammette
la RICORSIONE (ma non la MUTUA RICORSIONE). 

Progetto Completo: Sviluppo di un Compilatore per SimpLanPlus + report in cui si 
spiegano le scelte progettuali

### Prima Consegna: 24/04/2022

##### Esercizio 1
L'analizzatore lessicale deve ritornare la lista degli errori lessicali in un file 
di output. Il report deve contenere la discussione di tre esempi e degli errori segnalati

#### Esercizio 2
Sviluppare la tabella dei simboli del programma. Decidere se implementarlo come 
lista di hash-table o come hash-table di liste.
Il codice sviluppato deve controllare

* variabili/funzioni non dichiarate
* variabili/funzioni dichiarate più volte nello stesso ambiente 

### Seconda Consegna

#### Esercizio 3
Sviluppare un'analisi semantica che verifica 
* la correttezza dei tipi (in particolare numero e tipo dei parametri attuali 
  se conformi al numero e tipo dei parametri formali)
* uso di variabili non inizializzate
* dichiarazione di variabili non utilizzate

Il report deve contenere TUTTE le regole semantiche utilizzate e relativa discussione.
Si faccia attenzione all'aliasing.

Codici da verificare/discutere:

1) 
```
{
	int a; 
	int b; 
	int c = 1;
	if (c > 1) { 
		b = c ; 
	} else { 
		a = b ; 
	}
}
```

2) 
```
{
	int a; 
	int b; 
	int c;
	void f(int n, var int x){ 
		x = n;
	} 
	}
	f(1,a);
	f(2,b);
	f(3,c);
}
```

3)
```
{
	int a;
	int b;
	int c = 1;
	void h(int n, var int x, var int y, var int z){ 
		if (n==0) return ; 
		else {
			x = y;
			h(n-1,y,z,x);
		} 
	}
	h(5,a,b,c);
}
```

#### Esercizio 4
Definire un linguaggio bytecode per eseguire programmi in SimpLanPlus
e implementare l'interprete. In particolare:

*  Il bytecode deve avere istruzioni per una macchina a pila che memorizza in un 
   apposito registro il valore dell'ultima istruzione calcolata [vedi slide delle lezioni]
*  Implementare l'interprete per il bytecode.
*  Compilare ed eseguire i programmi del linguaggio ad alto livello.


Codici da verificare:
```
{
	int x = 1;
	void f(int n){ 
		if (n == 0) {
			print(x);
		}
		else {
			x = x * n;
			f(n-1);
		}	
	}
	f(10);
}
```
=====
```
{
	int u = 1 ;
	void f(var int x, int n){ 
		if (n == 0) {
			print(x);
		}
		else {
			int y = x * n;
			f(y,n-1);
		}	
	}
	f(u,6);
}
```
=====
```
{
	void f(int m, int n){
		if (m>n) {
			print(m+n);
		}
		else {
			int x = 1;
			f(m+1,n+1);
		}
	}
	f(5,4);
}
```
cosa succede se la invoco con f(4,5)?

=====
