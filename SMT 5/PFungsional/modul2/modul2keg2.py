# NIM Genap
# def prime(n):
#     for num in range(2, n+1):
#         if all(num%i!=0 for i in range(2, num)):
#             yield num
# a = prime(100)
# while True:
#     try:print(next(a), end=" ")
#     except StopIteration:break

# NIM Ganjil
# def fib(n):
#     a,b=0,1
#     for i in range(n):
#         yield a
#         a, b = b, a+b # operasi sebelah kanan selesai terlebih dahulu
# a = fib(input("Masukkan Jumlah Deret Fibonacci: "))
# while True:
#     try:print(next(a))
#     except StopIteration:break  
