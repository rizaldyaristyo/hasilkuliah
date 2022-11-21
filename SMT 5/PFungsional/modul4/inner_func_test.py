def factorial(number):
    if not isinstance(number, int):
        return "Please provide an integer"
    if number < 0:
        return "Please provide a positive integer"

    # Define inner function
    def inner_factorial(number):
        if number <= 1:
            return 1
        return number * inner_factorial(number - 1)
    # Call inner function and return result
    return inner_factorial(number)


print(factorial(4))
f7 = factorial(4)
print(type(f7), f7)
print(factorial(-7))
print(factorial(3.5))