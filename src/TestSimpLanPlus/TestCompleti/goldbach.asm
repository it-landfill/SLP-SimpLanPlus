; Begin environment
pushw $fp
; subi $sp $sp 0 (Not needed since value is 0)
mov $fp $sp
; End environment header
jal block_0
; Begin function
goldbach_0:
mov $fp $sp
pushw $ra
; End function header
; Begin environment
pushw $fp
; subi $sp $sp 0 (Not needed since value is 0)
mov $fp $sp
; End environment header
; Begin environment
pushw $fp
; subi $sp $sp 0 (Not needed since value is 0)
mov $fp $sp
; End environment header
; Begin Return
li $t0 0
jal block_3_footer
; End Return
; Begin environment footer
block_3_footer:
; addi $sp $sp 0 (Not needed since value is 0)
popw $fp
jal goldbach_0_footer
; End environment
; Begin environment footer
; addi $sp $sp 0 (Not needed since value is 0)
popw $fp
; End environment
; Begin function footer
goldbach_0_footer:
popw $ra
; addi $sp $sp 0 (Not needed since value is 0)
popw $fp
jr $ra
; End function
block_0:
; Begin function call goldbach
pushw $fp
jal goldbach_0
; End function call goldbach
; Begin environment footer
; addi $sp $sp 0 (Not needed since value is 0)
popw $fp
; End environment
halt
