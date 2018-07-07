# Triple Step: 

A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time. Implement a method to count how many possible ways the child can run up the stairs.

### To execute run -

`python triplestep.py 8`


### Logic

x = []
0 -> 1


1 -> 11	2
2 -> 111	21 12 3
x [3] -> 1111 211 121 31 112 22 13
x[4] -> 11111 2111 1211 311 1121 221 131	1112 212 122 32		113 23


step(n)

if(n<1)
	return 1;

return step(n-1)+step(n-2)+step(n-3);