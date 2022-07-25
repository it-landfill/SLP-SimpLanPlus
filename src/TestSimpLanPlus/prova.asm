; Begin environment
pushw $fp
; subi $sp $sp 0 (Not needed since value is 0)
mov $fp $sp
; End environment header
jal block_1
; Begin function
a_0:
mov $fp $sp
pushw $ra
; End function header
; Begin ITE
; Begin load variable val
mov $t1 $fp
lw $t0 1($t1)
; End load variable val
pushw $t0
li $t0 0
popw $t1
gt $t0 $t1 $t0
li $t1 0
beq $t0 $t1 ifElse_3
; Begin environment
pushw $fp
; subi $sp $sp 0 (Not needed since value is 0)
mov $fp $sp
; End environment header
; Begin Return
li $t0 1
jal block_5_footer
; End Return
; Begin environment footer
block_5_footer:
; addi $sp $sp 0 (Not needed since value is 0)
popw $fp
jal a_0_footer
; End environment
jal ifEnd_4
ifElse_3:
; Begin ITE
; Begin load variable val
mov $t1 $fp
lw $t0 1($t1)
; End load variable val
pushw $t0
li $t0 0
popw $t1
lt $t0 $t1 $t0
li $t1 0
beq $t0 $t1 ifElse_6
; Begin environment
pushw $fp
; subi $sp $sp 0 (Not needed since value is 0)
mov $fp $sp
; End environment header
; Begin Return
li $t0 1
neg $t0 $t0
jal block_8_footer
; End Return
; Begin environment footer
block_8_footer:
; addi $sp $sp 0 (Not needed since value is 0)
popw $fp
jal a_0_footer
; End environment
jal ifEnd_7
ifElse_6:
; Begin environment
pushw $fp
; subi $sp $sp 0 (Not needed since value is 0)
mov $fp $sp
; End environment header
; Begin Return
li $t0 0
jal block_9_footer
; End Return
; Begin environment footer
block_9_footer:
; addi $sp $sp 0 (Not needed since value is 0)
popw $fp
jal a_0_footer
; End environment
ifEnd_7:
; End ITE
ifEnd_4:
; End ITE
; Begin Return
li $t0 3
jal a_0_footer
; End Return
; Begin function footer
a_0_footer:
popw $ra
addi $sp $sp 4
popw $fp
jr $ra
; End function
block_1:
; Print 
; Begin function call with return a
pushw $fp
; Saving actual parameter val
li $t0 1
neg $t0 $t0
pushw $t0
jal a_0
; End function call with return a
printw $t0
; Begin environment footer
; addi $sp $sp 0 (Not needed since value is 0)
popw $fp
; End environment
halt
