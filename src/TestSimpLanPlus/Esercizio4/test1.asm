li $t1 0
beq $t0 $t1 ifElse_0
move $t1 $fp
lw $t1 0($t1)
sw $t0 0($t1)
jal ifEnd_1
ifElse_0:
move $t1 $fp
sw $t0 0($t1)
ifEnd_1:
