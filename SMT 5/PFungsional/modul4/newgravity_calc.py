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

def new_g(function):
    G = 1.49
    def wrapper():
        func = function()
        res = divide(func)(G)
        return res
    return wrapper

def new_r(function):
    r = 0.75
    def wrapper():
        func = function()
        res = multiply(func, square(r))
        return res
    return wrapper

@new_g
@new_r
def new_f():
    F = formulae(9.8, 5, 4, 2)
    new_f = F()
    return new_f

print("Gravity force between two masses is: ", round(new_f(),2))