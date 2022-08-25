; Begin environment
pushw $fp
subi $sp $sp 8
mov $fp $sp
; End environment header
jal block_0
; Begin function
isPrimeAux_0:
mov $fp $sp
pushw $ra
; End function header
; Begin ITE
; Begin load variable n
mov $t1 $fp
lw $t0 1($t1)
; End load variable n
pushw $t0
; Begin load variable i
mov $t1 $fp
lw $t0 5($t1)
; End load variable i
popw $t1
eq $t0 $t1 $t0
pushb $t0
; Begin load variable n
mov $t1 $fp
lw $t0 1($t1)
; End load variable n
pushw $t0
li $t0 1
popw $t1
eq $t0 $t1 $t0
popb $t1
or $t0 $t1 $t0
li $t1 0
beq $t0 $t1 ifEnd_0
; Begin Return
li $t0 1
; Set the return register to true
li $ret 1
jal isPrimeAux_0_footer
; End Return
ifEnd_0:
; End ITE
; Begin ITE
; Begin load variable n
mov $t1 $fp
lw $t0 1($t1)
; End load variable n
pushw $t0
; Begin load variable i
mov $t1 $fp
lw $t0 5($t1)
; End load variable i
popw $t1
mod $t0 $t1 $t0
pushw $t0
li $t0 0
popw $t1
eq $t0 $t1 $t0
pushb $t0
; Begin load variable n
mov $t1 $fp
lw $t0 1($t1)
; End load variable n
pushw $t0
; Begin load variable i
mov $t1 $fp
lw $t0 5($t1)
; End load variable i
popw $t1
lt $t0 $t1 $t0
popb $t1
or $t0 $t1 $t0
li $t1 0
beq $t0 $t1 ifEnd_1
; Begin Return
li $t0 0
; Set the return register to true
li $ret 1
jal isPrimeAux_0_footer
; End Return
ifEnd_1:
; End ITE
; Begin Return
; Begin function call with return isPrimeAux
pushw $fp
; Saving actual parameter i
; Begin load variable i
mov $t1 $fp
lw $t0 5($t1)
; End load variable i
pushw $t0
li $t0 1
popw $t1
add $t0 $t1 $t0
pushw $t0
; Saving actual parameter n
; Begin load variable n
mov $t1 $fp
lw $t0 1($t1)
; End load variable n
pushw $t0
jal isPrimeAux_0
; End function call with return isPrimeAux
; Set the return register to true
li $ret 1
jal isPrimeAux_0_footer
; End Return
; Begin function footer
isPrimeAux_0_footer:
popw $ra
addi $sp $sp 8
popw $fp
li $ret 0
jr $ra
; End function
; Begin function
isPrime_0:
mov $fp $sp
pushw $ra
; End function header
; Begin Return
; Begin function call with return isPrimeAux
pushw $fp
; Saving actual parameter i
li $t0 2
pushw $t0
; Saving actual parameter n
; Begin load variable n
mov $t1 $fp
lw $t0 1($t1)
; End load variable n
pushw $t0
jal isPrimeAux_0
; End function call with return isPrimeAux
; Set the return register to true
li $ret 1
jal isPrime_0_footer
; End Return
; Begin function footer
isPrime_0_footer:
popw $ra
addi $sp $sp 4
popw $fp
li $ret 0
jr $ra
; End function
; Begin function
goldbachAux_0:
mov $fp $sp
pushw $ra
; End function header
; Begin ITE
; Begin load variable i
mov $t1 $fp
lw $t0 5($t1)
; End load variable i
pushw $t0
; Begin load variable n
mov $t1 $fp
lw $t0 1($t1)
; End load variable n
popw $t1
gte $t0 $t1 $t0
li $t1 0
beq $t0 $t1 ifEnd_2
; Begin Return
li $t0 0
; Set the return register to true
li $ret 1
jal goldbachAux_0_footer
; End Return
ifEnd_2:
; End ITE
; Begin ITE
; Begin function call with return isPrime
pushw $fp
; Saving actual parameter n
; Begin load variable i
mov $t1 $fp
lw $t0 5($t1)
; End load variable i
pushw $t0
jal isPrime_0
; End function call with return isPrime
li $t1 0
beq $t0 $t1 ifEnd_3
; Begin environment
pushw $fp
; subi $sp $sp 0 (Not needed since value is 0)
mov $fp $sp
; End environment header
; Begin ITE
; Begin function call with return isPrime
pushw $fp
; Saving actual parameter n
; Begin load variable n
mov $t1 $fp
lw $t1 1($t1)
lw $t0 1($t1)
; End load variable n
pushw $t0
; Begin load variable i
mov $t1 $fp
lw $t1 1($t1)
lw $t0 5($t1)
; End load variable i
popw $t1
sub $t0 $t1 $t0
pushw $t0
jal isPrime_0
; End function call with return isPrime
li $t1 0
beq $t0 $t1 ifEnd_4
; Begin environment
pushw $fp
; subi $sp $sp 0 (Not needed since value is 0)
mov $fp $sp
; End environment header
; Begin Return
; Begin load variable i
mov $t1 $fp
lw $t1 1($t1)
lw $t1 1($t1)
lw $t0 5($t1)
; End load variable i
; Set the return register to true
li $ret 1
jal block_5_footer
; End Return
; Begin environment footer
block_5_footer:
; addi $sp $sp 0 (Not needed since value is 0)
popw $fp
li $t1 0
beq $ret $t1 block_5_ret
jal block_4_footer
block_5_ret:
; End environment
ifEnd_4:
; End ITE
; Begin environment footer
block_4_footer:
; addi $sp $sp 0 (Not needed since value is 0)
popw $fp
li $t1 0
beq $ret $t1 block_4_ret
jal goldbachAux_0_footer
block_4_ret:
; End environment
ifEnd_3:
; End ITE
; Begin Return
; Begin function call with return goldbachAux
pushw $fp
; Saving actual parameter i
; Begin load variable i
mov $t1 $fp
lw $t0 5($t1)
; End load variable i
pushw $t0
li $t0 1
popw $t1
add $t0 $t1 $t0
pushw $t0
; Saving actual parameter n
; Begin load variable n
mov $t1 $fp
lw $t0 1($t1)
; End load variable n
pushw $t0
jal goldbachAux_0
; End function call with return goldbachAux
; Set the return register to true
li $ret 1
jal goldbachAux_0_footer
; End Return
; Begin function footer
goldbachAux_0_footer:
popw $ra
addi $sp $sp 8
popw $fp
li $ret 0
jr $ra
; End function
; Begin function
goldbach_0:
mov $fp $sp
pushw $ra
; End function header
; Begin ITE
; Begin load variable n
mov $t1 $fp
lw $t0 1($t1)
; End load variable n
pushw $t0
li $t0 2
popw $t1
lte $t0 $t1 $t0
pushb $t0
; Begin load variable n
mov $t1 $fp
lw $t0 1($t1)
; End load variable n
pushw $t0
li $t0 2
popw $t1
mod $t0 $t1 $t0
pushw $t0
li $t0 0
popw $t1
neq $t0 $t1 $t0
popb $t1
or $t0 $t1 $t0
li $t1 0
beq $t0 $t1 ifEnd_5
; Begin Return
li $t0 0
; Set the return register to true
li $ret 1
jal goldbach_0_footer
; End Return
ifEnd_5:
; End ITE
; Begin Return
; Begin function call with return goldbachAux
pushw $fp
; Saving actual parameter i
li $t0 2
pushw $t0
; Saving actual parameter n
; Begin load variable n
mov $t1 $fp
lw $t0 1($t1)
; End load variable n
pushw $t0
jal goldbachAux_0
; End function call with return goldbachAux
; Set the return register to true
li $ret 1
jal goldbach_0_footer
; End Return
; Begin function footer
goldbach_0_footer:
popw $ra
addi $sp $sp 4
popw $fp
li $ret 0
jr $ra
; End function
block_0:
; Begin decl-assignment variable i
li $t0 14
sw $t0 1($fp)
; End decl-assignment variable i
; Begin decl-assignment variable n
; Begin function call with return goldbach
pushw $fp
; Saving actual parameter n
; Begin load variable i
mov $t1 $fp
lw $t0 1($t1)
; End load variable i
pushw $t0
jal goldbach_0
; End function call with return goldbach
sw $t0 5($fp)
; End decl-assignment variable n
; Print 
; Begin load variable n
mov $t1 $fp
lw $t0 5($t1)
; End load variable n
printw $t0
; Print 
; Begin load variable i
mov $t1 $fp
lw $t0 1($t1)
; End load variable i
pushw $t0
; Begin load variable n
mov $t1 $fp
lw $t0 5($t1)
; End load variable n
popw $t1
sub $t0 $t1 $t0
printw $t0
; Begin environment footer
addi $sp $sp 8
popw $fp
; End environment
halt
