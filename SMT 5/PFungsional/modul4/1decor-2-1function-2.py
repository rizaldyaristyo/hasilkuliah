def absolute_val_decorator(function):
    def wrapper(num):
        func = function(num)
        absolute_val = abs(func)
        print("before:",func)
        return absolute_val
    return wrapper

@absolute_val_decorator
def integers_only(num):
    if not isinstance(num, int):
        raise TypeError("Only integers are allowed")
    return num

print("after:",integers_only(-2048))