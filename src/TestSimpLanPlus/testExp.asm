li $t0 5
li $t1 6
li $t2 1
li $t3 0

print $t0
print $t1
print $t2
print $t3

add $t4 $t0 $t1
print $t4
sub $t4 $t0 $t1
print $t4
mult $t4 $t0 $t1
print $t4
div $t4 $t0 $t1
print $t4

lt $t4 $t0 $t1
print $t4
lte $t4 $t0 $t1
print $t4
gt $t4 $t0 $t1
print $t4
gte $t4 $t0 $t1
print $t4

eq $t4 $t0 $t1
print $t4
neq $t4 $t0 $t1
print $t4

and $t4 $t2 $t3
print $t4
or $t4 $t2 $t3
print $t4
not $t4 $t2
print $t4

halt