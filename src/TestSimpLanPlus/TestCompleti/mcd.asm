; Begin environment
pushw $fp
subi $sp $sp 4
mov $fp $sp
; End environment header
jal block_0
; Begin function
mcd1_0:
mov $fp $sp
pushw $ra
; End function header
; Begin ITE
; Begin load variable n1
mov $t1 $fp
lw $t0 1($t1)
; End load variable n1
pushw $t0
; Begin load variable n2
mov $t1 $fp
lw $t0 5($t1)
; End load variable n2
popw $t1
eq $t0 $t1 $t0
li $t1 0
beq $t0 $t1 ifEnd_0
; Begin Return
; Begin load variable n1
mov $t1 $fp
lw $t0 1($t1)
; End load variable n1
jal mcd1_0_footer
; End Return
ifEnd_0:
; End ITE
; Begin ITE
; Begin load variable n1
mov $t1 $fp
lw $t0 1($t1)
; End load variable n1
pushw $t0
; Begin load variable n2
mov $t1 $fp
lw $t0 5($t1)
; End load variable n2
popw $t1
lt $t0 $t1 $t0
li $t1 0
beq $t0 $t1 ifElse_1
; Begin Return
; Begin function call with return mcd1
pushw $fp
; Saving actual parameter n2
; Begin load variable n2
mov $t1 $fp
lw $t0 5($t1)
; End load variable n2
pushw $t0
; Begin load variable n1
mov $t1 $fp
lw $t0 1($t1)
; End load variable n1
popw $t1
sub $t0 $t1 $t0
pushw $t0
; Saving actual parameter n1
; Begin load variable n1
mov $t1 $fp
lw $t0 1($t1)
; End load variable n1
pushw $t0
jal mcd1_0
; End function call with return mcd1
jal mcd1_0_footer
; End Return
jal ifEnd_1
ifElse_1:
; Begin Return
; Begin function call with return mcd1
pushw $fp
; Saving actual parameter n2
; Begin load variable n2
mov $t1 $fp
lw $t0 5($t1)
; End load variable n2
pushw $t0
; Saving actual parameter n1
; Begin load variable n1
mov $t1 $fp
lw $t0 1($t1)
; End load variable n1
pushw $t0
; Begin load variable n2
mov $t1 $fp
lw $t0 5($t1)
; End load variable n2
popw $t1
sub $t0 $t1 $t0
pushw $t0
jal mcd1_0
; End function call with return mcd1
jal mcd1_0_footer
; End Return
ifEnd_1:
; End ITE
; Begin function footer
mcd1_0_footer:
popw $ra
addi $sp $sp 8
popw $fp
jr $ra
; End function
; Begin function
mcd2_0:
mov $fp $sp
pushw $ra
; End function header
; Begin ITE
; Begin load variable n1
mov $t1 $fp
lw $t0 1($t1)
; End load variable n1
pushw $t0
; Begin load variable n2
mov $t1 $fp
lw $t0 5($t1)
; End load variable n2
popw $t1
eq $t0 $t1 $t0
li $t1 0
beq $t0 $t1 ifElse_2
; Begin environment
pushw $fp
; subi $sp $sp 0 (Not needed since value is 0)
mov $fp $sp
; End environment header
; Begin assignment variable res
; Begin load variable n1
mov $t1 $fp
lw $t1 1($t1)
lw $t0 1($t1)
; End load variable n1
mov $t1 $fp
lw $t1 1($t1)
lw $t1 9($t1)
sw $t0 0($t1)
; End assignment variable res
; Begin Return
jal block_3_footer
; End Return
; Begin environment footer
block_3_footer:
; addi $sp $sp 0 (Not needed since value is 0)
popw $fp
jal mcd2_0_footer
; End environment
jal ifEnd_2
ifElse_2:
; Begin ITE
; Begin load variable n1
mov $t1 $fp
lw $t0 1($t1)
; End load variable n1
pushw $t0
; Begin load variable n2
mov $t1 $fp
lw $t0 5($t1)
; End load variable n2
popw $t1
lt $t0 $t1 $t0
li $t1 0
beq $t0 $t1 ifElse_3
; Begin function call mcd2
pushw $fp
; Saving actual parameter by reference res
; Begin load variable res
mov $t1 $fp
lw $t0 9($t1)
; End load variable res
pushw $t0
; Saving actual parameter n2
; Begin load variable n2
mov $t1 $fp
lw $t0 5($t1)
; End load variable n2
pushw $t0
; Begin load variable n1
mov $t1 $fp
lw $t0 1($t1)
; End load variable n1
popw $t1
sub $t0 $t1 $t0
pushw $t0
; Saving actual parameter n1
; Begin load variable n1
mov $t1 $fp
lw $t0 1($t1)
; End load variable n1
pushw $t0
jal mcd2_0
; End function call mcd2
jal ifEnd_3
ifElse_3:
; Begin function call mcd2
pushw $fp
; Saving actual parameter by reference res
; Begin load variable res
mov $t1 $fp
lw $t0 9($t1)
; End load variable res
pushw $t0
; Saving actual parameter n2
; Begin load variable n2
mov $t1 $fp
lw $t0 5($t1)
; End load variable n2
pushw $t0
; Saving actual parameter n1
; Begin load variable n1
mov $t1 $fp
lw $t0 1($t1)
; End load variable n1
pushw $t0
; Begin load variable n2
mov $t1 $fp
lw $t0 5($t1)
; End load variable n2
popw $t1
sub $t0 $t1 $t0
pushw $t0
jal mcd2_0
; End function call mcd2
ifEnd_3:
; End ITE
ifEnd_2:
; End ITE
; Begin function footer
mcd2_0_footer:
popw $ra
addi $sp $sp 12
popw $fp
jr $ra
; End function
block_0:
; Begin decl-assignment variable res
li $t0 1
neg $t0 $t0
sw $t0 1($fp)
; End decl-assignment variable res
; Print 
; Begin function call with return mcd1
pushw $fp
; Saving actual parameter n2
li $t0 30
pushw $t0
; Saving actual parameter n1
li $t0 24
pushw $t0
jal mcd1_0
; End function call with return mcd1
printw $t0
; Begin function call mcd2
pushw $fp
; Saving actual parameter by reference res
; Begin load variable res
mov $t1 $fp
addi $t0 $t1 1
; End load variable res
pushw $t0
; Saving actual parameter n2
li $t0 31
pushw $t0
; Saving actual parameter n1
li $t0 24
pushw $t0
jal mcd2_0
; End function call mcd2
; Print 
; Begin load variable res
mov $t1 $fp
lw $t0 1($t1)
; End load variable res
printw $t0
; Begin environment footer
addi $sp $sp 4
popw $fp
; End environment
halt
