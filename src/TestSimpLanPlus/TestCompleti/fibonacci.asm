; Begin environment
pushw $fp
subi $sp $sp 16
mov $fp $sp
; End environment header
jal block_1
; Begin function
fib_0:
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
lte $t0 $t1 $t0
li $t1 0
beq $t0 $t1 ifElse_3
; Begin Return
; Begin load variable n
mov $t1 $fp
lw $t0 1($t1)
; End load variable n
jal fib_0_footer
; End Return
jal ifEnd_4
ifElse_3:
; Begin Return
; Begin function call with return fib
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
jal fib_0
; End function call with return fib
pushw $t0
; Begin function call with return fib
pushw $fp
; Saving actual parameter n
; Begin load variable n
mov $t1 $fp
lw $t0 1($t1)
; End load variable n
pushw $t0
li $t0 2
popw $t1
sub $t0 $t1 $t0
pushw $t0
jal fib_0
; End function call with return fib
popw $t1
add $t0 $t1 $t0
jal fib_0_footer
; End Return
ifEnd_4:
; End ITE
; Begin function footer
fib_0_footer:
popw $ra
addi $sp $sp 4
popw $fp
jr $ra
; End function
block_1:
; Begin decl-assignment variable errorCount
li $t0 0
sw $t0 13($fp)
; End decl-assignment variable errorCount
; Begin assignment variable val
li $t0 5
mov $t1 $fp
sw $t0 5($t1)
; End assignment variable val
; Begin assignment variable correct
li $t0 5
mov $t1 $fp
sw $t0 9($t1)
; End assignment variable correct
; Begin assignment variable res
; Begin function call with return fib
pushw $fp
; Saving actual parameter n
; Begin load variable val
mov $t1 $fp
lw $t0 5($t1)
; End load variable val
pushw $t0
jal fib_0
; End function call with return fib
mov $t1 $fp
sw $t0 1($t1)
; End assignment variable res
; Begin ITE
; Begin load variable res
mov $t1 $fp
lw $t0 1($t1)
; End load variable res
pushw $t0
; Begin load variable correct
mov $t1 $fp
lw $t0 9($t1)
; End load variable correct
popw $t1
neq $t0 $t1 $t0
li $t1 0
beq $t0 $t1 ifEnd_6
; Begin environment
pushw $fp
; subi $sp $sp 0 (Not needed since value is 0)
mov $fp $sp
; End environment header
; Print 
; Begin load variable val
mov $t1 $fp
lw $t1 1($t1)
lw $t0 5($t1)
; End load variable val
printw $t0
; Print 
; Begin load variable correct
mov $t1 $fp
lw $t1 1($t1)
lw $t0 9($t1)
; End load variable correct
printw $t0
; Print 
; Begin load variable res
mov $t1 $fp
lw $t1 1($t1)
lw $t0 1($t1)
; End load variable res
printw $t0
; Begin assignment variable errorCount
; Begin load variable errorCount
mov $t1 $fp
lw $t1 1($t1)
lw $t0 13($t1)
; End load variable errorCount
pushw $t0
li $t0 1
popw $t1
add $t0 $t1 $t0
mov $t1 $fp
lw $t1 1($t1)
sw $t0 13($t1)
; End assignment variable errorCount
; Begin environment footer
; addi $sp $sp 0 (Not needed since value is 0)
popw $fp
; End environment
ifEnd_6:
; End ITE
; Begin assignment variable val
li $t0 12
mov $t1 $fp
sw $t0 5($t1)
; End assignment variable val
; Begin assignment variable correct
li $t0 144
mov $t1 $fp
sw $t0 9($t1)
; End assignment variable correct
; Begin assignment variable res
; Begin function call with return fib
pushw $fp
; Saving actual parameter n
; Begin load variable val
mov $t1 $fp
lw $t0 5($t1)
; End load variable val
pushw $t0
jal fib_0
; End function call with return fib
mov $t1 $fp
sw $t0 1($t1)
; End assignment variable res
; Begin ITE
; Begin load variable res
mov $t1 $fp
lw $t0 1($t1)
; End load variable res
pushw $t0
; Begin load variable correct
mov $t1 $fp
lw $t0 9($t1)
; End load variable correct
popw $t1
neq $t0 $t1 $t0
li $t1 0
beq $t0 $t1 ifEnd_9
; Begin environment
pushw $fp
; subi $sp $sp 0 (Not needed since value is 0)
mov $fp $sp
; End environment header
; Print 
; Begin load variable val
mov $t1 $fp
lw $t1 1($t1)
lw $t0 5($t1)
; End load variable val
printw $t0
; Print 
; Begin load variable correct
mov $t1 $fp
lw $t1 1($t1)
lw $t0 9($t1)
; End load variable correct
printw $t0
; Print 
; Begin load variable res
mov $t1 $fp
lw $t1 1($t1)
lw $t0 1($t1)
; End load variable res
printw $t0
; Begin assignment variable errorCount
; Begin load variable errorCount
mov $t1 $fp
lw $t1 1($t1)
lw $t0 13($t1)
; End load variable errorCount
pushw $t0
li $t0 1
popw $t1
add $t0 $t1 $t0
mov $t1 $fp
lw $t1 1($t1)
sw $t0 13($t1)
; End assignment variable errorCount
; Begin environment footer
; addi $sp $sp 0 (Not needed since value is 0)
popw $fp
; End environment
ifEnd_9:
; End ITE
; Begin assignment variable val
li $t0 24
mov $t1 $fp
sw $t0 5($t1)
; End assignment variable val
; Begin assignment variable correct
li $t0 46368
mov $t1 $fp
sw $t0 9($t1)
; End assignment variable correct
; Begin assignment variable res
; Begin function call with return fib
pushw $fp
; Saving actual parameter n
; Begin load variable val
mov $t1 $fp
lw $t0 5($t1)
; End load variable val
pushw $t0
jal fib_0
; End function call with return fib
mov $t1 $fp
sw $t0 1($t1)
; End assignment variable res
; Begin ITE
; Begin load variable res
mov $t1 $fp
lw $t0 1($t1)
; End load variable res
pushw $t0
; Begin load variable correct
mov $t1 $fp
lw $t0 9($t1)
; End load variable correct
popw $t1
neq $t0 $t1 $t0
li $t1 0
beq $t0 $t1 ifEnd_12
; Begin environment
pushw $fp
; subi $sp $sp 0 (Not needed since value is 0)
mov $fp $sp
; End environment header
; Print 
; Begin load variable val
mov $t1 $fp
lw $t1 1($t1)
lw $t0 5($t1)
; End load variable val
printw $t0
; Print 
; Begin load variable correct
mov $t1 $fp
lw $t1 1($t1)
lw $t0 9($t1)
; End load variable correct
printw $t0
; Print 
; Begin load variable res
mov $t1 $fp
lw $t1 1($t1)
lw $t0 1($t1)
; End load variable res
printw $t0
; Begin assignment variable errorCount
; Begin load variable errorCount
mov $t1 $fp
lw $t1 1($t1)
lw $t0 13($t1)
; End load variable errorCount
pushw $t0
li $t0 1
popw $t1
add $t0 $t1 $t0
mov $t1 $fp
lw $t1 1($t1)
sw $t0 13($t1)
; End assignment variable errorCount
; Begin environment footer
; addi $sp $sp 0 (Not needed since value is 0)
popw $fp
; End environment
ifEnd_12:
; End ITE
; Begin assignment variable val
li $t0 25
mov $t1 $fp
sw $t0 5($t1)
; End assignment variable val
; Begin assignment variable correct
li $t0 75025
mov $t1 $fp
sw $t0 9($t1)
; End assignment variable correct
; Begin assignment variable res
; Begin function call with return fib
pushw $fp
; Saving actual parameter n
; Begin load variable val
mov $t1 $fp
lw $t0 5($t1)
; End load variable val
pushw $t0
jal fib_0
; End function call with return fib
mov $t1 $fp
sw $t0 1($t1)
; End assignment variable res
; Begin ITE
; Begin load variable res
mov $t1 $fp
lw $t0 1($t1)
; End load variable res
pushw $t0
; Begin load variable correct
mov $t1 $fp
lw $t0 9($t1)
; End load variable correct
popw $t1
neq $t0 $t1 $t0
li $t1 0
beq $t0 $t1 ifEnd_15
; Begin environment
pushw $fp
; subi $sp $sp 0 (Not needed since value is 0)
mov $fp $sp
; End environment header
; Print 
; Begin load variable val
mov $t1 $fp
lw $t1 1($t1)
lw $t0 5($t1)
; End load variable val
printw $t0
; Print 
; Begin load variable correct
mov $t1 $fp
lw $t1 1($t1)
lw $t0 9($t1)
; End load variable correct
printw $t0
; Print 
; Begin load variable res
mov $t1 $fp
lw $t1 1($t1)
lw $t0 1($t1)
; End load variable res
printw $t0
; Begin assignment variable errorCount
; Begin load variable errorCount
mov $t1 $fp
lw $t1 1($t1)
lw $t0 13($t1)
; End load variable errorCount
pushw $t0
li $t0 1
popw $t1
add $t0 $t1 $t0
mov $t1 $fp
lw $t1 1($t1)
sw $t0 13($t1)
; End assignment variable errorCount
; Begin environment footer
; addi $sp $sp 0 (Not needed since value is 0)
popw $fp
; End environment
ifEnd_15:
; End ITE
; Begin ITE
; Begin load variable errorCount
mov $t1 $fp
lw $t0 13($t1)
; End load variable errorCount
pushw $t0
li $t0 0
popw $t1
eq $t0 $t1 $t0
li $t1 0
beq $t0 $t1 ifElse_17
; Print 
li $t0 1
printb $t0
jal ifEnd_18
ifElse_17:
; Print 
li $t0 0
printb $t0
ifEnd_18:
; End ITE
; Begin environment footer
addi $sp $sp 16
popw $fp
; End environment
halt
