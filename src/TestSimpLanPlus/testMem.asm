li $t0 4
li $t1 5
gt $t2 $t0 $t1
li $t3 1
beq $t2 $t3 end_label
li $t0 16
print $t0
end_label:
li $t0 15
print $t0

halt