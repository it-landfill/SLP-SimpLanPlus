; Begin environment
pushw $fp
; subi $sp $sp 0 (Not needed since value is 0)
mov $fp $sp
; End environment header
jal block_2
; Begin function
a_0:
mov $fp $sp
pushw $ra
; End function header
; Print 
li $t0 1
printw $t0
; Begin function footer
a_0_footer:
popw $ra
; addi $sp $sp 0 (Not needed since value is 0)
popw $fp
jr $ra
; End function
; Begin function
b_1:
mov $fp $sp
pushw $ra
; End function header
; Print 
li $t0 2
printw $t0
; Begin function call a
pushw $fp
jal a_0
; End function call a
; Begin function footer
b_1_footer:
popw $ra
; addi $sp $sp 0 (Not needed since value is 0)
popw $fp
jr $ra
; End function
block_2:
; Begin function call b
pushw $fp
jal b_1
; End function call b
; Begin environment footer
; addi $sp $sp 0 (Not needed since value is 0)
popw $fp
; End environment
halt
