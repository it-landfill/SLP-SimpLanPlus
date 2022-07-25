; Begin environment
pushw $fp
subi $sp $sp 4
mov $fp $sp
jal block_1
; Begin function
a_0:
mov $fp $sp
pushw $ra
; End function header
; Begin ITE
li $t0 4
pushw $t0
li $t0 5
popw $t1
lt $t0 $t1 $t0
li $t1 0
beq $t0 $t1 ifElse_3
; Begin environment
pushw $fp
; subi $sp $sp 0 (Not needed since value is 0)
mov $fp $sp
; Begin Return
li $t0 4
jal a_0_footer
; End Return
; addi $sp $sp 0 (Not needed since value is 0)
popw $fp
; End environment
jal ifEnd_4
ifElse_3:
; Begin environment
pushw $fp
; subi $sp $sp 0 (Not needed since value is 0)
mov $fp $sp
; Begin Return
li $t0 5
jal a_0_footer
; End Return
; addi $sp $sp 0 (Not needed since value is 0)
popw $fp
; End environment
ifEnd_4:
; End ITE
; Begin Return
li $t0 6
jal a_0_footer
; End Return
; Begin function footer
a_0_footer:
popw $ra
; addi $sp $sp 0 (Not needed since value is 0)
popw $fp
jr $ra
; End function
block_1:
; Begin decl-assignment variable b
; Begin function call with return a
pushw $fp
jal a_0
; End function call with return a
sw $t0 1($fp)
; End decl-assignment variable b
; Print 
; Begin load variable b
mov $t1 $fp
lw $t0 1($t1)
; End load variable b
printw $t0
addi $sp $sp 4
popw $fp
; End environment
halt
