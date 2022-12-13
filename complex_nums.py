import cmath

a = complex(2, 7)
b = complex(3,-4)
c = complex(9, 3)
d = complex(0,-6)
e = complex(-2,0)

rnd = lambda x : complex(round(x.real, 3), round(x.imag, 3))

print("a: " + str(a))
print("b: " + str(b))
print("c: " + str(c))
print("d: " + str(d))
print("e: " + str(e) + "\n\nAdding")

# add
print("a+b: " + str(a+b))
print("c+e: " + str(c+e))
print("d+a: " + str(d+a))
print("d+e: " + str(d+e) + "\n\nSubtracting")

# sub
print("a-b: " + str(a-b))
print("c-e: " + str(c-e))
print("d-a: " + str(d-a))
print("d-e: " + str(d-e) + "\n\nMultiplying")

# mul
print("a*b: " + str(a*b))
print("c*e: " + str(c*e))
print("d*a: " + str(d*a))
print("d*e: " + str(d*e) + "\n\nDividing")

# div
print("a/b: " + str(a/b))
print("c/e: " + str(c/e))
print("d/a: " + str(d/a))
print("d/e: " + str(d/e) + "\n\nExponent")

# pow
print("a^b: " + str(rnd(a**b)))
print("c^e: " + str(rnd(c**e)))
print("d^a: " + str(rnd(d**a)))
print("d^e: " + str(rnd(d**e)))