; Begin environment
pushw $fp
; subi $sp $sp 0 (Not needed since value is 0)
mov $fp $sp
; End environment header
jal block_4
; Begin function
mcm1Aux_0:
mov $fp $sp
pushw $ra
; End function header
; Begin ITE
; Begin load variable i
mov $t1 $fp
lw $t0 9($t1)
; End load variable i
pushw $t0
; Begin load variable n1
mov $t1 $fp
lw $t0 1($t1)
; End load variable n1
popw $t1
gt $t0 $t1 $t0
pushb $t0
; Begin load variable i
mov $t1 $fp
lw $t0 9($t1)
; End load variable i
pushw $t0
; Begin load variable n2
mov $t1 $fp
lw $t0 5($t1)
; End load variable n2
popw $t1
gt $t0 $t1 $t0
popb $t1
or $t0 $t1 $t0
li $t1 0
beq $t0 $t1 ifEnd_7
; Begin Return
jal mcm1Aux_0_footer
; End Return
ifEnd_7:
; End ITE
; Begin ITE
; Begin load variable n1
mov $t1 $fp
lw $t0 1($t1)
; End load variable n1
pushw $t0
; Begin load variable i
mov $t1 $fp
lw $t0 9($t1)
; End load variable i
popw $t1
mod $t0 $t1 $t0
pushw $t0
li $t0 0
popw $t1
eq $t0 $t1 $t0
pushb $t0
; Begin load variable n2
mov $t1 $fp
lw $t0 5($t1)
; End load variable n2
pushw $t0
; Begin load variable i
mov $t1 $fp
lw $t0 9($t1)
; End load variable i
popw $t1
mod $t0 $t1 $t0
pushw $t0
li $t0 0
popw $t1
eq $t0 $t1 $t0
popb $t1
and $t0 $t1 $t0
li $t1 0
beq $t0 $t1 ifEnd_9
; Begin assignment variable gcd
; Begin load variable i
mov $t1 $fp
lw $t0 9($t1)
; End load variable i
mov $t1 $fp
lw $t1 13($t1)
sw $t0 0($t1)
; End assignment variable gcd
ifEnd_9:
; End ITE
; Begin function call mcm1Aux
pushw $fp
; Saving actual parameter by reference gcd
; Begin load variable gcd
mov $t1 $fp
lw $t0 13($t1)
; End load variable gcd
pushw $t0
; Saving actual parameter i
; Begin load variable i
mov $t1 $fp
lw $t0 9($t1)
; End load variable i
pushw $t0
li $t0 1
popw $t1
add $t0 $t1 $t0
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
jal mcm1Aux_0
; End function call mcm1Aux
; Begin function footer
mcm1Aux_0_footer:
popw $ra
addi $sp $sp 16
popw $fp
jr $ra
; End function
; Begin function
mcm1_1:
mov $fp $sp
pushw $ra
; End function header
; Begin decl-assignment variable gcd
li $t0 0
sw $t0 9($fp)
; End decl-assignment variable gcd
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
beq $t0 $t1 ifEnd_12
; Begin Return
; Begin load variable n1
mov $t1 $fp
lw $t0 1($t1)
; End load variable n1
jal mcm1_1_footer
; End Return
ifEnd_12:
; End ITE
; Begin function call mcm1Aux
pushw $fp
; Saving actual parameter by reference gcd
; Begin load variable gcd
mov $t1 $fp
addi $t0 $t1 9
; End load variable gcd
pushw $t0
; Saving actual parameter i
li $t0 1
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
jal mcm1Aux_0
; End function call mcm1Aux
; Begin Return
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
mult $t0 $t1 $t0
pushw $t0
; Begin load variable gcd
mov $t1 $fp
lw $t0 9($t1)
; End load variable gcd
popw $t1
div $t0 $t1 $t0
jal mcm1_1_footer
; End Return
; Begin function footer
mcm1_1_footer:
popw $ra
addi $sp $sp 8
popw $fp
jr $ra
; End function
; Begin function
mcm2Aux_2:
mov $fp $sp
pushw $ra
; End function header
; Begin ITE
; Begin load variable max
mov $t1 $fp
lw $t0 9($t1)
; End load variable max
pushw $t0
; Begin load variable n1
mov $t1 $fp
lw $t0 1($t1)
; End load variable n1
popw $t1
mod $t0 $t1 $t0
pushw $t0
li $t0 0
popw $t1
eq $t0 $t1 $t0
pushb $t0
; Begin load variable max
mov $t1 $fp
lw $t0 9($t1)
; End load variable max
pushw $t0
; Begin load variable n2
mov $t1 $fp
lw $t0 5($t1)
; End load variable n2
popw $t1
mod $t0 $t1 $t0
pushw $t0
li $t0 0
popw $t1
eq $t0 $t1 $t0
popb $t1
and $t0 $t1 $t0
li $t1 0
beq $t0 $t1 ifEnd_15
; Begin Return
; Begin load variable max
mov $t1 $fp
lw $t0 9($t1)
; End load variable max
jal mcm2Aux_2_footer
; End Return
ifEnd_15:
; End ITE
; Begin Return
; Begin function call with return mcm2Aux
pushw $fp
; Saving actual parameter max
; Begin load variable max
mov $t1 $fp
lw $t0 9($t1)
; End load variable max
pushw $t0
li $t0 1
popw $t1
add $t0 $t1 $t0
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
jal mcm2Aux_2
; End function call with return mcm2Aux
jal mcm2Aux_2_footer
; End Return
; Begin function footer
mcm2Aux_2_footer:
popw $ra
addi $sp $sp 12
popw $fp
jr $ra
; End function
; Begin function
mcm2_3:
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
beq $t0 $t1 ifEnd_18
; Begin Return
; Begin load variable n1
mov $t1 $fp
lw $t0 1($t1)
; End load variable n1
jal mcm2_3_footer
; End Return
ifEnd_18:
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
gte $t0 $t1 $t0
li $t1 0
beq $t0 $t1 ifElse_19
; Begin Return
; Begin function call with return mcm2Aux
pushw $fp
; Saving actual parameter max
; Begin load variable n1
mov $t1 $fp
lw $t0 1($t1)
; End load variable n1
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
jal mcm2Aux_2
; End function call with return mcm2Aux
jal mcm2_3_footer
; End Return
jal ifEnd_20
ifElse_19:
; Begin Return
; Begin function call with return mcm2Aux
pushw $fp
; Saving actual parameter max
; Begin load variable n2
mov $t1 $fp
lw $t0 5($t1)
; End load variable n2
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
jal mcm2Aux_2
; End function call with return mcm2Aux
jal mcm2_3_footer
; End Return
ifEnd_20:
; End ITE
; Begin function footer
mcm2_3_footer:
popw $ra
addi $sp $sp 8
popw $fp
jr $ra
; End function
block_4:
; Print 
; Begin function call with return mcm1
pushw $fp
; Saving actual parameter n2
li $t0 120
pushw $t0
; Saving actual parameter n1
li $t0 72
pushw $t0
jal mcm1_1
; End function call with return mcm1
printw $t0
; Print 
; Begin function call with return mcm2
pushw $fp
; Saving actual parameter n2
li $t0 120
pushw $t0
; Saving actual parameter n1
li $t0 72
pushw $t0
jal mcm2_3
; End function call with return mcm2
printw $t0
; Begin environment footer
; addi $sp $sp 0 (Not needed since value is 0)
popw $fp
; End environment
halt
