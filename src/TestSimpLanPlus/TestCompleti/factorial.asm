; Begin environment
pushw $fp
; subi $sp $sp 0 (Not needed since value is 0)
mov $fp $sp
; End environment header
jal block_1
; Begin function
fact_0:
mov $fp $sp
pushw $ra
; End function header
; Begin ITE
; Begin load variable n
mov $t1 $fp
lw $t0 1($t1)
; End load variable n
pushw $t0
li $t0 1
popw $t1
eq $t0 $t1 $t0
li $t1 0
beq $t0 $t1 ifElse_3
; Begin Return
li $t0 1
jal fact_0_footer
; End Return
jal ifEnd_4
ifElse_3:
; Begin Return
; Begin load variable n
mov $t1 $fp
lw $t0 1($t1)
; End load variable n
pushw $t0
; Begin function call with return fact
pushw $fp
; Saving actual parameter n
; Begin load variable n
mov $t1 $fp
lw $t0 1($t1)
; End load variable n
pushw $t0
li $t0 1
popw $t1
sub $t0 $t1 $t0
pushw $t0
jal fact_0
; End function call with return fact
popw $t1
mult $t0 $t1 $t0
jal fact_0_footer
; End Return
ifEnd_4:
; End ITE
; Begin function footer
fact_0_footer:
popw $ra
addi $sp $sp 4
popw $fp
jr $ra
; End function
block_1:
; Print 
li $t0 1
printw $t0
; Print 
; Begin function call with return fact
pushw $fp
; Saving actual parameter n
li $t0 1
pushw $t0
jal fact_0
; End function call with return fact
printw $t0
; Print 
li $t0 2
printw $t0
; Print 
; Begin function call with return fact
pushw $fp
; Saving actual parameter n
li $t0 2
pushw $t0
jal fact_0
; End function call with return fact
printw $t0
; Print 
li $t0 6
printw $t0
; Print 
; Begin function call with return fact
pushw $fp
; Saving actual parameter n
li $t0 3
pushw $t0
jal fact_0
; End function call with return fact
printw $t0
; Print 
li $t0 24
printw $t0
; Print 
; Begin function call with return fact
pushw $fp
; Saving actual parameter n
li $t0 4
pushw $t0
jal fact_0
; End function call with return fact
printw $t0
; Print 
li $t0 120
printw $t0
; Print 
; Begin function call with return fact
pushw $fp
; Saving actual parameter n
li $t0 5
pushw $t0
jal fact_0
; End function call with return fact
printw $t0
; Begin environment footer
; addi $sp $sp 0 (Not needed since value is 0)
popw $fp
; End environment
halt
