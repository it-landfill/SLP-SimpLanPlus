; Begin environment
pushw $fp
subi $sp $sp 4
mov $fp $sp
; End environment header
jal block_1
; Begin function
a_0:
mov $fp $sp
pushw $ra
; End function header
; Print 
; Begin load variable b
mov $t1 $fp
lw $t0 1($t1)
; End load variable b
printw $t0
; Begin ITE
; Begin load variable b
mov $t1 $fp
lw $t0 1($t1)
; End load variable b
pushw $t0
li $t0 0
popw $t1
eq $t0 $t1 $t0
li $t1 0
beq $t0 $t1 ifEnd_4
; Begin Return
jal a_0_footer
; End Return
ifEnd_4:
; End ITE
; Begin assignment variable b
; Begin load variable b
mov $t1 $fp
lw $t0 1($t1)
; End load variable b
pushw $t0
li $t0 1
popw $t1
sub $t0 $t1 $t0
mov $t1 $fp
sw $t0 1($t1)
; End assignment variable b
; Begin function call a
pushw $fp
; Saving actual parameter b
; Begin load variable b
mov $t1 $fp
lw $t0 1($t1)
; End load variable b
pushw $t0
jal a_0
; End function call a
; Begin function footer
a_0_footer:
popw $ra
addi $sp $sp 4
popw $fp
jr $ra
; End function
block_1:
; Begin decl-assignment variable c
li $t0 4
sw $t0 1($fp)
; End decl-assignment variable c
; Begin function call a
pushw $fp
; Saving actual parameter b
; Begin load variable c
mov $t1 $fp
lw $t0 1($t1)
; End load variable c
pushw $t0
jal a_0
; End function call a
; Begin environment footer
addi $sp $sp 4
popw $fp
; End environment
halt
