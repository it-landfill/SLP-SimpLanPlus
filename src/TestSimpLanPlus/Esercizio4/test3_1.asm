; Begin environment
push $fp
subi $sp $sp 0
mov $fp $sp
; Begin function
f_0:
mov $fp $sp
push $ra
; Begin ITE
; Begin load variable m
move $t1 $fp
lw $t0 1($t1)
; End load variable m
push $t0
; Begin load variable n
move $t1 $fp
lw $t0 5($t1)
; End load variable n
pop $t1
gt $t0 $t0 $t1
li $t1 0
beq $t0 $t1 ifElse_1
; Begin environment
push $fp
subi $sp $sp 0
mov $fp $sp
; Print
; Begin load variable m
move $t1 $fp
lw $t1 4($t1)
lw $t0 1($t1)
; End load variable m
push $t0
; Begin load variable n
move $t1 $fp
lw $t1 4($t1)
lw $t0 5($t1)
; End load variable n
pop $t1
add $t0 $t0 $t1
print $t0
addi $sp $sp 0
pop $fp
; End environment
jal ifEnd_2
ifElse_1:
; Begin environment
push $fp
subi $sp $sp 4
mov $fp $sp
; Begin decl-assignment variable x
li $t0 1
sw $t0 1($fp)
; End decl-assignment variable x
; Begin function call f
push $fp
; Begin load variable n
move $t1 $fp
lw $t1 4($t1)
lw $t0 5($t1)
; End load variable n
push $t0
li $t0 1
pop $t1
add $t0 $t0 $t1
push $t0
; Begin load variable m
move $t1 $fp
lw $t1 4($t1)
lw $t0 1($t1)
; End load variable m
push $t0
li $t0 1
pop $t1
add $t0 $t0 $t1
push $t0
jal f_0
; End function call f
addi $sp $sp 4
pop $fp
; End environment
ifEnd_2:
; End ITE
top $ra
addi $sp $sp 12
pop $fp
jr $ra
; End function
; Begin function call f
push $fp
li $t0 4
push $t0
li $t0 5
push $t0
jal f_0
; End function call f
addi $sp $sp 0
pop $fp
; End environment
