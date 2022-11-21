G = 9.8
m1 = 5
m2 = 4
r = 2

def multiply(x, y):
    return x * y

def divide(x):
    def operator(y):
        return x/y
    return operator

def square(x):
    return x * x

def formulae(G, m1, m2, r):
    def f():
        m1m2g = multiply(multiply(m1, m2), G)
        r_square = square(r)
        res = divide(m1m2g)(r_square)
        return res
    return f

F = formulae(G, m1, m2, r)
print("Gravity force between two masses is: ", round(F(),2))