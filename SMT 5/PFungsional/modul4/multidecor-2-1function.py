def title_decorator(function):
    print("\n")
    def wrapper():
        func = function()
        make_title = func.title()
        print(make_title + " --> Data is converted to title case")
        return make_title
    return wrapper

def split_string(function):
    def wrapper():
        func = function()
        splitted_string = func.split()
        print(str(splitted_string) + " --> Data is splitted")
        return splitted_string
    return wrapper

@split_string
@title_decorator
def say_hi():
    return 'hello there'

print(say_hi())