; Begin environment
pushw $fp
; subi $sp $sp 0 (Not needed since value is 0)
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
block_0:
; Print 
; Begin function call with return isPrime
pushw $fp
; Saving actual parameter n
li $t0 619
pushw $t0
jal isPrime_0
; End function call with return isPrime
printb $t0
; Begin environment footer
; addi $sp $sp 0 (Not needed since value is 0)
popw $fp
; End environment
halt
