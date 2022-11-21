def multiplication(x):
    def multiply(y):
        return x * y
    return multiply

op10x = multiplication(10)
op5x = multiplication(5)

print(op10x(3)) # 10*3=30
print(op5x(7)) # 5*7=35
print(op5x(op10x(2))) # 5*(10*2)=100
print(multiplication(10)(3)) # 10*3=30

